package com.example.ziyulibrary.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ziyu on 2016/10/30.
 */

public class DateUtil {



    /**
     * 判断当前传入时间相对于今天
     * @param date
     * @return 0 今天 -1 昨天
     */
    public static int isYesterday(String date){
        int day =0;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date d1  = new Date();//当前时间

            Date d2 = sdf.parse(date);//传进的时间

            long cha = d2.getTime() - d1.getTime();

            day = new Long(cha/(1000*60*60*24)).intValue();

        } catch (ParseException e) {


            e.printStackTrace();

        }

        return day;

    }

    public static String getDay(String date){
        String month = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        month = (c.get(Calendar.DAY_OF_MONTH) + 1) +  "";
        return month;
    }

    public static String getMonth(String date){
        String month = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        month = (c.get(Calendar.MONTH) + 1) +  "";
        return month;
    }

    /**
     * 判断当前日期是星期几*
     * @param  pTime     设置的需要判断的时间  //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */

//  String pTime = "2012-03-12";
    public static String getWeek(String pTime) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "六";
        }

        return Week;
    }


}
