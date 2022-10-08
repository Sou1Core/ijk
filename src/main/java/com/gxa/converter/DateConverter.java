package com.gxa.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            // 把字符串转换为日期类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(source);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
            // 如果转换异常则返回空
            return null;
    }
}

