package com.opticalix.ml;

import com.opticalix.lib.Utils;
import com.opticalix.ml.fft.Complex;
import com.opticalix.ml.svm.svm_predict;
import com.opticalix.ml.svm.svm_train;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.cnblogs.com/bnuvincent/p/6442778.html
//https://stackoverflow.com/questions/10792576/libsvm-java-implementation
public class MLTest {

    public static void main(String[] args) throws IOException {
        toLibsvmFmt("/Users/admin/Documents/Felix/tmp/acc-ride-1014585524-1560937490.txt",
                "/Users/admin/Documents/Felix/tmp/acc-ride-1014585524-1560937490-libsvm_fmt.txt",
                64, 5);
//        testTrain();
        testPredict();
    }

    //todo -w
    private static void testTrain() throws IOException {
        String[] args = {
        };
        svm_train.main(args);
    }

    //todo -b
    private static void testPredict() throws IOException {
        String[] predictArgs = {
                "/Users/admin/Documents/Felix/tmp/acc-ride-1014585524-1560937490-libsvm_fmt.txt",//test file
                "/Users/admin/Documents/Felix/tmp/acc-to-state-model-6ft-64-per-seg",//model
                "/Users/admin/Documents/Felix/tmp/acc-ride-1014585524-1560937490-predict.txt" //result file
        };
        svm_predict.main(predictArgs);
    }

    private static void testFeatureHelper() {
        List<Double> values = Arrays.asList(1d, 12d, 31d, 10d, 5d, 43d, 6d, 99d);
        Complex[] complexes = FeatureHelper.fft_useful(values);
        Utils.pArr(complexes);
        double dc = FeatureHelper.fft_dc(values);
        double topFreq = FeatureHelper.fft_top_freq(values);
        int topIndex = FeatureHelper.fft_top_index(values);
        Utils.p("dc=" + dc + ", topFreq=" + topFreq + ", topIndex=" + topIndex);
    }

    /**
     * label idx1:val1 idx2:val2 ...
     * @param srcPath
     * @param destPath
     * @param label
     * @throws IOException
     */
    private static void toLibsvmFmt(String srcPath, String destPath, int linesPerWindow, int label) throws IOException {
        File src = new File(srcPath);
        if (!src.exists()) {
            return;
        }
        File dest = new File(destPath);
        if (!dest.exists() && !dest.createNewFile()) {
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath, false));
        String line;
        int cnt = 0;
        List<Double> cbAccTemp = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            //label
            if (cnt % linesPerWindow == 0) {
                bw.write(label + " ");
            }
            AccData acc = new AccData(line);
            cbAccTemp.add(AccData.combinedAcc(acc));
            if (++cnt % linesPerWindow == 0) {
                FeatureHelper.normalization(cbAccTemp);
                List<Double> features = FeatureHelper.getFeatures(cbAccTemp);
                for (int i = 0; i < features.size(); i++) {
                    bw.write(i + ":");
                    bw.write(features.get(i) + "");
                    if (i + 1 != features.size()) {
                        bw.write(" ");
                    }
                }
                bw.newLine();
                cbAccTemp.clear();
            }
        }
        IOUtils.closeSilent(br);
        IOUtils.closeSilent(bw);
    }
}
