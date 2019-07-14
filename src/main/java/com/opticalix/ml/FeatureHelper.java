package com.opticalix.ml;

import com.opticalix.lib.Utils;
import com.opticalix.ml.fft.Complex;
import com.opticalix.ml.fft.FFT;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * todo
 */
public class FeatureHelper {
    public static float max(List<Float> values) {
        return Collections.max(values);
    }
    public static float min(List<Float> values) {
        return Collections.min(values);
    }
    public static float avg(List<Float> values) {
        return 0;
    }
    public static float std(List<Float> values) {
        return 0;
    }
    public static float var(List<Float> values) {
        return 0;
    }
    public static float mode(List<Float> values) {
        return 0;
    }

    /**
     * 直流分量：模值/n
     * @param values
     * @return
     */
    public static double fft_dc(List<Float> values) {
        Complex[] fft = FFT.fft(toComplex(values));
        return fft[0].abs() / (float) values.size();
    }

    /**
     * values长度要是2的指数
     * 得到的fft序列，第一位是直流分量，第2 ~ (n/2) + 1 这n/2个数代表了频率信息，magnitude：该点的模，amplitude：模除以n/2。后面和前面对称
     * @param values
     * @return
     */
    public static double fft_top_freq(List<Float> values) {
        Complex[] fft = FFT.fft(toComplex(values));
        Complex[] useful = Arrays.copyOfRange(fft, 1, (fft.length / 2) + 1);
        //desc
        Arrays.sort(useful, (o1, o2) -> Double.compare(o2.re(), o1.re()));
        return useful[0].abs() / (float) (values.size() / 2);
    }

    /**
     * 假设信号采样频率为fs，任一点k（k=0~N-1)代表的频率就是k*fs/N
     * @param values
     * @return
     */
    public static float fft_top_index(List<Float> values) {
        return 0;
    }

    private static Complex[] toComplex(List<Float> values) {
        return values.stream().map(v -> new Complex(v, 0)).toArray(Complex[]::new);
    }

    private static List<Complex> toComplexList(List<Float> values) {
        return values.stream().map(v -> new Complex(v, 0)).collect(Collectors.toList());
    }

    private static Stream<Complex> toComplexStream(List<Float> values) {
        return values.stream().map(v -> new Complex(v, 0));
    }
}
