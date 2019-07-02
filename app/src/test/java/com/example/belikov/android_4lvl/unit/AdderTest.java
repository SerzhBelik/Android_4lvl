package com.example.belikov.android_4lvl.unit;

import com.example.belikov.android_4lvl.homework7.unit.Adder;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdderTest {

    private static Adder adder;

    @BeforeClass
    public static void beforeClass(){
        adder = new Adder();
    }

    @Test
    public void summ_whenSome_isCorrect() {
        int a = 5;
        int b = 8;
        long c = adder.summ(a, b);
        Assert.assertEquals(c, 13);
    }

    @Test
    public void summ_whenSome_isIncorrect() {
        int a = 5;
        int b = 8;
        long c = adder.summ(a, b);
        Assert.assertNotEquals(c, 12);
    }
}
