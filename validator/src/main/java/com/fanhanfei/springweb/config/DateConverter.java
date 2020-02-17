package com.fanhanfei.springweb.config;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        if (NumberUtils.isNumber(source)) {
            return new Date(Long.valueOf(source));
        }
        try {
            return DateConverter.parse(source);
        } catch (Exception e) {
            throw new IllegalArgumentException(source);
        }
    }

    public static Date parse(String str) throws ParseException {
        String[] parsePatterns = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyyMMdd", "yyyyMMddHHmmss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss"};
        return parseDateWithLeniency(str, parsePatterns, false);
    }

    private static Date parseDateWithLeniency(String str, String[] parsePatterns, boolean lenient) throws ParseException {
        if (str != null && parsePatterns != null) {
            SimpleDateFormat parser = new SimpleDateFormat();
            parser.setLenient(lenient);
            setTimeZone(parser, str);
            ParsePosition pos = new ParsePosition(0);
            String[] var5 = parsePatterns;
            int var6 = parsePatterns.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String parsePattern = var5[var7];
                String pattern = parsePattern;
                if (parsePattern.endsWith("ZZ")) {
                    pattern = parsePattern.substring(0, parsePattern.length() - 1);
                }

                parser.applyPattern(pattern);
                pos.setIndex(0);
                String str2 = str;
                if (parsePattern.endsWith("ZZ")) {
                    str2 = str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2");
                }

                Date date = parser.parse(str2, pos);
                if (date != null && pos.getIndex() == str2.length()) {
                    return date;
                }
            }

            throw new ParseException("Unable to parse the date: " + str, -1);
        } else {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
    }

    private static void setTimeZone(SimpleDateFormat parser, String dateString) {
        if (dateString.endsWith("Z")) {
            parser.setTimeZone(TimeZone.getTimeZone("GMT"));
        } else {
            parser.setTimeZone(TimeZone.getDefault());
        }

    }
}
