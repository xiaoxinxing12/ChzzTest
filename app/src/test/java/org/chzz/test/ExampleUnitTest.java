package org.chzz.test;

import android.os.Environment;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        copy(path, path, 1000);

    }


    public void copy(String from, String to, int bufferSize) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(new File(from + "/1.txt"));
            out = new FileOutputStream(new File(to + "/2.txt"));
            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(len);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}