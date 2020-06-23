package com.xg.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nService {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        I18nService.messageSource = messageSource;
    }

    public String getMessage(String msgKey, Object[] args) {
        return messageSource.getMessage(msgKey, args, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String msgKey) {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            msgKey = messageSource.getMessage(msgKey, null, locale);
        } catch (Exception ignored) {
        }
        return msgKey;
    }


}
