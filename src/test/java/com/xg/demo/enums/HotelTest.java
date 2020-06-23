package com.xg.demo.enums;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    private static MessageSource messageSource;

    public static void main(String[] args) {

        System.out.println(messageSource);
        Locale locale = LocaleContextHolder.getLocale();
        messageSource.getMessage("system.error",null,locale);
        System.out.println(messageSource);
        System.out.println(locale);
        /*String country = locale.getCountry();
        String displayCountry = locale.getDisplayCountry();
        String displayLanguage = locale.getDisplayLanguage();
        System.out.println(country);
        System.out.println(displayCountry);
        System.out.println(displayLanguage);*/


    }
}