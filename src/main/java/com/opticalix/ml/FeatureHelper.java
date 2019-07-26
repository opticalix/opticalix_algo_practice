package com.opticalix.ml;

import com.opticalix.ml.fft.Complex;
import com.opticalix.ml.fft.FFT;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 特征提取工具类
 */
public class FeatureHelper {

    private static Stream<Double> supplyStream(List<Double> values) {
        Supplier<Stream<Double>> s = values::stream;
        return s.get();
    }

    private static Complex[] toComplex(List<Double> values) {
        return supplyStream(values).map(v -> new Complex(v, 0)).toArray(Complex[]::new);
    }

    private static List<Complex> toComplexList(List<Double> values) {
        return supplyStream(values).map(v -> new Complex(v, 0)).collect(Collectors.toList());
    }

    private static Stream<Complex> toComplexStream(List<Double> values) {
        return supplyStream(values).map(v -> new Complex(v, 0));
    }

    public static double max(List<Double> values) {
        return Collections.max(values);
    }

    public static double min(List<Double> values) {
        return Collections.min(values);
    }

    public static double avg(List<Double> values) {
        return supplyStream(values).mapToDouble(d -> d).average().orElse(0.0);
    }

    public static double std(List<Double> values) {
        double avg = supplyStream(values).mapToDouble(d -> d).average().orElse(0.0);
        double var = supplyStream(values).mapToDouble(d -> d).map(d -> (d - avg) * (d - avg)).sum() / (double) values.size();
        return Math.sqrt(var);
    }

    public static double var(List<Double> values) {
        double avg = supplyStream(values).mapToDouble(d -> d).average().orElse(0.0);
        return supplyStream(values).mapToDouble(d -> d).map(d -> (d - avg) * (d - avg)).sum() / (double) values.size();
    }

    public static Complex[] fft_useful(List<Double> values) {
        Complex[] fft = FFT.fft(toComplex(values));
        return Arrays.copyOfRange(fft, 1, (fft.length / 2) + 1);
    }

    /**
     * 直流分量：模值/n
     *
     * @param values
     * @return
     */
    public static double fft_dc(List<Double> values) {
        Complex[] fft = FFT.fft(toComplex(values));
        return fft[0].abs() / (double) values.size();
    }

    /**
     * values长度要是2的指数
     * 得到的fft序列，第一位是直流分量，第2 ~ (n/2) + 1 这n/2个数代表了频率信息，magnitude：该点的模，amplitude：模除以n/2。后面和前面对称
     *
     * @param values
     * @return amplitude
     */
    public static double fft_top_freq(List<Double> values) {
        Complex[] fft = FFT.fft(toComplex(values));
        Complex[] useful = Arrays.copyOfRange(fft, 1, (fft.length / 2) + 1);
        //desc
        Arrays.sort(useful, (o1, o2) -> Double.compare(o2.re(), o1.re()));
        return useful[0].abs() / (double) (values.size() / 2);
    }

    /**
     * 假设信号采样频率为fs，任一点k（k=0~N-1)代表的频率就是k*fs/N
     *
     * @param values
     * @return top index
     */
    public static int fft_top_index(List<Double> values) {
        Complex[] fft = FFT.fft(toComplex(values));
        Complex[] useful = Arrays.copyOfRange(fft, 1, (fft.length / 2) + 1);
        int topIdx = -1; double topRe = 0;
        for (int i = 0; i < useful.length; i++) {
            Complex c = useful[i];
            if (c.re() > topRe) {
                topIdx = i;
                topRe = c.re();
            }
        }
        return topIdx;
    }

    public static void normalization(List<Double> data) {
        final int size = data.size();
        for (int i = 0; i < size; i++) {
            data.set(i, data.get(i) / (float) size);
        }
    }

    /**
     * 获取所有特征，先时域后频域
     * 是否考虑double和int混用
     * @param windowedData
     * @return all features
     */
    public static List<Double> getFeatures(List<Double> windowedData) {
        List<Double> features = Arrays.asList(
                //time
                avg(windowedData),
                var(windowedData),
                std(windowedData),
                max(windowedData),
                min(windowedData),
                //freq
                fft_dc(windowedData),
                fft_top_freq(windowedData),
                (double) fft_top_index(windowedData),
                //hand
                (double) Hand.LEFT.getVal()
        );
        return features;
    }
}
