package com.opticalix.ml;

import com.opticalix.lib.Utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MLTest {

    //todo -b怎么用
    public static void main(String[] args) throws IOException {
        String[] predictArgs = {
//                "-b 1" ?
                "",//test file
                "D:\\Workspace\\Python\\data\\acc_tag_data\\acc-to-state-model",//model
                "" //result file
        };
//        svm_predict.main(predictArgs);
        List<Float> values = Arrays.asList(1f, 12f, 31f, 10f, 5f, 43f, 6f, 99f);
        double dc = FeatureHelper.fft_dc(values);
        double topFreq = FeatureHelper.fft_top_freq(values);
        Utils.p(dc +", " +topFreq);
    }
}
