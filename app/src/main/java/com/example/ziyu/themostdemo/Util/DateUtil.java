package com.example.ziyu.themostdemo.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ziyu on 2016/11/3.
 */

public class DateUtil {

    public static String  getTime(long date){
        long time =System.currentTimeMillis() -date;
        long hour = time/1000/60/60;
        if (hour<1){
            return "刚刚";
        }
        if(hour < 24){
            return hour+"小时之前";
        }else if(hour>=24 && hour<48){
            return "昨天" + getTimeWithM(date);
        }else{
            return getTimeWithD(date);
        }
    }

    public static String getTimeWithM(long date){

        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        Date time = new Date(date);
        return sdf.format(time);
    }

    public static String getTimeWithD(long date){

        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
        Date time = new Date(date);
        return sdf.format(time);
    }

    /**
     * 判断当前传入时间相对于今天
     * @param date 毫秒数
     * @return 0 今天 -1 昨天
     */
    public static int isYesterday(String date){
        int day =0;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat sdf2=new SimpleDateFormat("MM-dd");
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

}
