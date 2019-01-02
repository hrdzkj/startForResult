package com.hrdzkj.startforresultsample;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        SimpleDateFormat df = new SimpleDateFormat("H:mm:ss");
        System.out.println(24*60*60);
        System.out.println(df.format(new Date()));
    }
}