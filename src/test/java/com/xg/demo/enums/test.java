package com.xg.demo.enums;


import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        StringBuffer user= new StringBuffer();
        user.append("454545"+",");
        user.append("cc"+",");
        user.append("xx"+",");
        user.append("yy"+",");
        user.append("yy"+",");
        user.append("yy"+",");
        user.append("yy"+",");
        user.append("yy"+",");
        user.append("yy"+",");

        System.out.println(user.substring(0,user.lastIndexOf(",")));
        Object[] sss={};
        sss= new Object[]{"werer"};
        System.out.println(sss.length);


    }
}
