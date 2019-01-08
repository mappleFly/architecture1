package com.sishuok.util.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatHelper {
    private DateFormatHelper(){}
    private final static String FORMT_STR="yyyy-MM-dd HH:mm:ss";

    public static String long2str(long time){
        Date d = new Date(time);
        DateFormat df = new SimpleDateFormat(FORMT_STR);
        return df.format(d);
    }

    public static Date str2long(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat(FORMT_STR);
        return df.parse(str);
    }

}
