package com.xebia.jetter.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by gurinder on 22/4/16.
 */
@Component
public class DateUtil {
    static public Date getCurrentDate() {
        Date date = new Date();
        return date;
    }

}
