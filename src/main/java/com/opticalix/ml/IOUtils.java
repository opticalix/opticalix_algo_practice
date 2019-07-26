package com.opticalix.ml;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Felix
 * @date 26/07/2019 5:05 PM
 * @email opticalix@gmail.com
 */
public class IOUtils {
    public static void closeSilent(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
