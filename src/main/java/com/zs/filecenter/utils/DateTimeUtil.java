package com.zs.filecenter.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期函数
 */
public class DateTimeUtil {
    private static SimpleDateFormat sdf_ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    private static SimpleDateFormat sdf_ymdhms_special = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置日期格式
    private static SimpleDateFormat sdf_ymd = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

    private static final int YESTERDY = -1;
    private static final int TODAY = 0;
    private static final int TOMORROWDAT = 1;
    private static final int OTHER_DAY = 10000;

    /**
     * 假设传入的日期格式是yyyy-MM-dd HH:mm:ss, 也可以传入yyyy-MM-dd，如2018-1-1或者2018-01-01格式
     *
     * @param strDate
     * @return
     */
    public static boolean isValidDate(String strDate) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(strDate);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 假设传入的日期格式是yyyy-MM-dd, 也可以传入yyyy-MM-dd
     *
     * @param dayStr
     * @return
     */
    public static boolean isValidDay(String dayStr) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.setLenient(false);
            format.parse(dayStr);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }


    //    public static boolean isValidDate(String strDate) {
    //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //        try {
    //            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2018/02/29会被接受，并转换成2018/03/01
    //            format.setLenient(false);
    //            Date date = format.parse(strDate);
    //            //判断传入的yyyy年-MM月-dd日 字符串是否为数字
    //            String[] sArray = strDate.split("-");
    //            for (String s : sArray) {
    //                boolean isNum = s.matches("[0-9]+");
    //                //+表示1个或多个（如"3"或"225"），*表示0个或多个（[0-9]*）（如""或"1"或"22"），?表示0个或1个([0-9]?)(如""或"7")
    //                if (!isNum) {
    //                    return false;
    //                }
    //            }
    //        } catch (Exception e) {
    //            // e.printStackTrace();
    //            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
    //            return false;
    //        }
    //        return true;
    //    }


    /**
     * 获取当前时间字符串_special 格式
     */
    public static String getSpecialDTStr() {
        return sdf_ymdhms_special.format(new Date());
    }

    /**
     * 获取当前时间字符串
     */
    public static String getNowTimeStr() {
        return sdf_ymdhms.format(new Date());
    }

    /**
     * Timestamp --> Date
     */
    public static String Timestamp2DateStr(Date date) {
        return sdf_ymdhms.format(date);
    }

    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 得到精确到秒的干吧时间字符串
     *
     * @return
     */
    public static String getNowTimeStrTickSS() {
        String tmp = sdf_ymdhms.format(new Date());
        tmp = tmp.replace(":", "").replace("-", "").replace(" ", "");
        return tmp;
    }

    /**
     * 得到精确到分钟的干吧时间字符串
     *
     * @return
     */
    public static String getNowTimeStrTickMM() {
        String tmp = sdf_ymdhms.format(new Date());
        tmp = tmp.replace(":", "").replace("-", "").replace(" ", "");
        return tmp.substring(0, tmp.length() - 2);
    }


    public static String getToday8() {
        String day10 = sdf_ymd.format(new Date());
        day10 = day10.replace("-", "");
        return day10;
    }

    public static String getTodayd10() {
        String day10 = sdf_ymd.format(new Date());
        return day10;
    }

    /**
     * 得到 yyyy-MM 前7位
     *
     * @return
     */
    public static String getYM() {
        String day7 = sdf_ymd.format(new Date());
        return day7.substring(0, 7);
    }


    public static String getLastDayOfMonth(String yyyyMM) {
        if (!yyyyMM.contains("-")) {
            return "";
        }
        String[] tmp = yyyyMM.split("-");
        if (tmp.length < 2) {
            return "";
        }
        int year = Integer.valueOf(String.valueOf(tmp[0]));
        int month = Integer.valueOf(String.valueOf(tmp[1]));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    public static String getFirstDayOfMonth(String yyyyMM) {
        if (!yyyyMM.contains("-")) {
            return "";
        }
        String[] tmp = yyyyMM.split("-");
        if (tmp.length < 2) {
            return "";
        }
        int year = Integer.valueOf(String.valueOf(tmp[0]));
        int month = Integer.valueOf(String.valueOf(tmp[1]));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    public static String getDifDays(int dayNumber) {
        Date date = new Date();
        Date newdate = DateUtils.addDays(date, dayNumber);
        String dayDiffs = sdf_ymd.format(newdate);
        return dayDiffs;
    }

    /**
     * 得到秒差之后的日期时间
     *
     * @param seconds
     * @return
     */
    public static String getDifSeconds(int seconds) {
        Date date = new Date();
        Date newdate = DateUtils.addSeconds(date, seconds);
        String dayDiffs = sdf_ymdhms.format(newdate);
        return dayDiffs;
    }

    /**
     * 秒速差异时间
     *
     * @param seconds
     * @return
     */
    public static String getDateTimeByDifSeconds(int seconds) {
        Date date = new Date();
        Date newdate = DateUtils.addSeconds(date, seconds);
        String daySecondsDateTime = sdf_ymdhms.format(newdate);
        return daySecondsDateTime;
    }

    public static String getDifDays10(int dayNumber) {
        Date date = new Date();
        Date newdate = DateUtils.addDays(date, dayNumber);
        String dayDiffs = sdf_ymd.format(newdate);
        return dayDiffs;
    }


    /**
     * 获取两个日期之间的时间差（秒）
     *
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    public static long getDifSeconds(String dateTime1, String dateTime2) {
        long rlt_mi_cnt = 0;
        try {
            Date date1 = sdf_ymdhms.parse(dateTime1);
            Date date2 = sdf_ymdhms.parse(dateTime2);

            long t1 = date1.getTime();// milliseconds
            long t2 = date2.getTime();// milliseconds

            // 获取时间差:(秒)
            rlt_mi_cnt = (t2 - t1) / 1000;

        } catch (ParseException e) {
            e.printStackTrace();
            rlt_mi_cnt = 0;
        }
        return rlt_mi_cnt;
    }


    /**
     * 获取两个日期之间的时间差（分钟）
     *
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    public static long getDifMinutes(String dateTime1, String dateTime2) {
        long rlt_mi_cnt = 0;
        try {
            Date date1 = sdf_ymdhms.parse(dateTime1);
            Date date2 = sdf_ymdhms.parse(dateTime2);

            long t1 = date1.getTime();// milliseconds
            long t2 = date2.getTime();// milliseconds

            // 获取时间差:(秒)
            rlt_mi_cnt = (t2 - t1) / (1000 * 60);

        } catch (ParseException e) {
            e.printStackTrace();
            rlt_mi_cnt = 0;
        }
        return rlt_mi_cnt;
    }

    /**
     * 获取两个日期之间的日期差（天数）
     *
     * @param smallDateTime
     * @param bigDateTime
     * @return
     */
    public static int getDifDays(String smallDateTime, String bigDateTime) {
        int difDays = 0;
        try {
            Date date1 = sdf_ymdhms.parse(smallDateTime);
            Date date2 = sdf_ymdhms.parse(bigDateTime);
            long t1 = date1.getTime();// milliseconds
            long t2 = date2.getTime();// milliseconds
            // // 获取时间差:(秒)
            // rlt_mi_cnt = (t2 - t1) / 1000;
            // 天数;
            difDays = (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
            difDays = 0;
        }
        return difDays;
    }

    /**
     * 获取两个日期之间的日期差（小时）
     *
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    public static int getDifHours(String dateTime1, String dateTime2) {
        int difHours = 0;
        try {
            Date date1 = sdf_ymdhms.parse(dateTime1);
            Date date2 = sdf_ymdhms.parse(dateTime2);
            long t1 = date1.getTime();// milliseconds
            long t2 = date2.getTime();// milliseconds
            //小时
            difHours = (int) ((t2 - t1) / (1000 * 60 * 60));
        } catch (ParseException e) {
            e.printStackTrace();
            difHours = 0;
        }
        return difHours;
    }

    /**
     * 指定日期加上天数后的日期
     *
     * @param nowDate 创建时间
     * @param num     为增加的天数
     * @return
     * @throws ParseException
     */
    public static String plusDay(String nowDate, int num) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currdate = format.parse(nowDate);
        // System.out.println("现在的日期是：" + currdate);
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);// 设置日期;
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        // System.out.println("增加天数以后的日期：" + enddate);
        return enddate;
    }


    /**
     * 得到指定分钟数间隔的下一个日期时间值
     */
    public static String getTimeDifMM(int dif_minutes) {
        String rtnStr = "";
        try {
            if (dif_minutes < 3) {
                dif_minutes = 3;
            }
            long curren = System.currentTimeMillis();
            curren += dif_minutes * 60 * 1000;
            Date da = new Date(curren);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rtnStr = dateFormat.format(da);
        } catch (Exception e) {
        }
        return rtnStr;
    }

    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getTimeDifMM(String nowDate, int dif_minutes) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currdate = format.parse(nowDate);
            // System.out.println("现在的日期是：" + currdate);
            Calendar ca = Calendar.getInstance();
            ca.setTime(currdate);// 设置日期;
            ca.add(Calendar.MINUTE, dif_minutes);// dif_minutes 为增加的分钟数，可以改变的
            currdate = ca.getTime();
            String enddate = format.format(currdate);
            return enddate;
        } catch (ParseException e) {
            return "";
        }
    }


    /**
     * 指定时间距离当前时间的差额(秒)
     *
     * @param dateTime1
     * @return
     */
    public static long getDifSeconds(String dateTime1) {
        String dateTime_now = sdf_ymdhms.format(new Date());
        long rlt_mi_cnt = 0;
        try {
            Date date1 = sdf_ymdhms.parse(dateTime1);
            Date date2 = sdf_ymdhms.parse(dateTime_now);
            long t1 = date1.getTime();// milliseconds
            long t2 = date2.getTime();// milliseconds
            // 获取时间差:(秒)
            rlt_mi_cnt = (t2 - t1) / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            rlt_mi_cnt = 0;
        }
        return rlt_mi_cnt;
    }

    /**
     * 判断是否为昨天
     * 参数格式:yyyy-MM-dd或者完整到秒的
     */
    public static boolean isYesterday(String day) {
        try {
            Calendar pre = Calendar.getInstance();
            Date predate = new Date(System.currentTimeMillis());
            pre.setTime(predate);
            Calendar cal = Calendar.getInstance();
            Date date = sdf_ymd.parse(day);
            cal.setTime(date);
            if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
                int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                        - pre.get(Calendar.DAY_OF_YEAR);
                if (diffDay == YESTERDY) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否为今天
     * 参数格式:yyyy-MM-dd或者完整到秒的
     */
    public static boolean isToday(String day) {
        try {
            Calendar pre = Calendar.getInstance();
            Date predate = new Date(System.currentTimeMillis());
            pre.setTime(predate);

            Calendar cal = Calendar.getInstance();
            Date date = sdf_ymd.parse(day);
            cal.setTime(date);

            if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
                int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                        - pre.get(Calendar.DAY_OF_YEAR);

                if (diffDay == TODAY) {
                    return true;
                }
            }
            return false;
        } catch (ParseException e) {
            return false;
        }
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    /**
     * todo 获取两个时间之间的差异秒数
     */
    public static int getDifSecond(String date1Str, String date2Str) {
        int mmCnt = 0;
        try {
            Date date1 = sdf.parse(date1Str);
            Date date2 = sdf.parse(date2Str);
            mmCnt = (int) ((date2.getTime() - date1.getTime()) / (1000)); // * 3600 * 24
        } catch (ParseException e) {
            mmCnt = 0;
        }
        return mmCnt;
    }

}
