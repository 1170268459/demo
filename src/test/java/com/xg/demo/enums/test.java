package com.xg.demo.enums;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
       long m=1;

        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String format = decimalFormat.format(m);
        System.out.println(format);


    }
}
