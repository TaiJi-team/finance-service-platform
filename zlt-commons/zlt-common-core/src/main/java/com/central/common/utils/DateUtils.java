package com.central.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期公用类
 */
@Slf4j
public class DateUtils {

    public static final String DATE_SATISFY_FORMAT = "yyyyMM-dd";

    public static final String DATE_SHORT_FORMAT = "yyyy-MM-dd";

    public static final String DATE_SHORT_FORMAT_NYR = "yyyy年MM月dd日";

    public static final String DATE_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FULL_FORMAT_FILE = "yyyy年MM月dd日HH时mm分ss秒";

    public static final String DEFAULT_DATE_FORMAT = DATE_SHORT_FORMAT;

    /**
     * 生成当前日期
     */
    public static Date getNowDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime()));
    }

    /**
     * 字符串按默认格式转日期
     *
     * @param strDate 日期字符串
     * @return 日期
     * @throws ParseException
     */
    public static Date parse(String strDate) throws ParseException {
        return parse(strDate, DEFAULT_DATE_FORMAT);
    }

    /**
     * 字符串按指定格式转日期
     *
     * @param strDate 日期字符串
     * @param pattern 指定的日期转换格式
     * @return 日期
     * @throws ParseException
     */
    public static Date parse(String strDate, String pattern) throws ParseException {
        return createDateFormat(pattern).parse(strDate);
    }

    /**
     * 日期按默认格式转字符串
     *
     * @param date 这个日期值将格式化为一个日期字符串
     * @return 日期字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 日期按默认格式(yyyy年MM月dd日)转字符串
     *
     * @param date
     * @return
     */
    public static String formatNyr(Date date) {
        return format(date, DATE_SHORT_FORMAT_NYR);
    }

    /**
     * 日期按默认格式(yyyy年MM月dd日 时：分：秒)转字符串
     *
     * @param date
     * @return
     */
    public static String formatSfm(Date date) {
        return format(date, DATE_FULL_FORMAT);
    }

    /**
     * 日期按默认格式(yyyy年MM月dd日 时：分：秒)转字符串，用于标识文件名
     *
     * @param date
     * @return
     */
    public static String formatSfmFile(Date date) {
        return format(date, DATE_FULL_FORMAT_FILE);
    }

    /**
     * 日期按指定格式转字符串
     *
     * @param date    这个日期值将格式化为一个日期字符串
     * @param pattern 指定的日期转换格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            return createDateFormat(pattern).format(date);
        }
    }

    /**
     * 创建日期格式化实现类
     *
     * @param pattern 指定的日期转换格式
     * @return 日期格式化实现类
     */
    private static DateFormat createDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 指定日期增加（年）
     *
     * @param date   指定的一个原始日期
     * @param amount 数值增量
     * @return 新日期
     */
    public static Date addYear(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * 指定日期增加（月）
     *
     * @param date   指定的一个原始日期
     * @param amount 数值增量
     * @return 新日期
     */
    public static Date addMonth(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 指定日期增加（周）
     *
     * @param date   指定的一个原始日期
     * @param amount 数值增量
     * @return 新日期
     */
    public static Date addWeek(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 指定日期增加（天）
     *
     * @param date   指定的一个原始日期
     * @param amount 数值增量
     * @return 新日期
     */
    public static Date addDay(Date date, int amount) {
        return add(date, Calendar.DATE, amount);
    }

    /**
     * 指定日期减少（天）
     *
     * @param date   指定的一个原始日期
     * @param amount 数值减量
     * @return 新日期
     */
    public static Date reduceDay(Date date, int amount) {
        return add(date, Calendar.DATE, -amount);
    }

    /**
     * 指定日期增加数量（年，月，日，小时，分钟，秒，毫秒）
     *
     * @param date   指定的一个原始日期
     * @param field  日历类Calendar字段
     * @param amount 数值增量
     * @return
     */
    private static Date add(Date date, int field, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = createCalendar(date);
            c.add(field, amount);
            return c.getTime();
        }
    }

    /**
     * 获取日期是一年中的第几周
     *
     * @param date 指定的一个原始日期
     * @return
     */
    public static int getWeekOfYear(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar calendar = createCalendar(date);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            return calendar.get(Calendar.WEEK_OF_YEAR);
        }
    }

    /**
     * 获取日期是星期几(0~6,0为星期日)
     *
     * @param date 指定的一个原始日期
     * @return
     */
    public static int getWeekOfDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            return createCalendar(date).get(Calendar.DAY_OF_WEEK) - 1;
        }
    }

    /**
     * 根据当前日期及生日,计算年龄,返回”*岁*个月*天”
     *
     * @param birthday 生日日期
     * @param desDay   目标日期
     * @return
     */
    public static Age getAge(Date birthday, Date desDay) {
        if (birthday == null || desDay == null) {
            throw new IllegalArgumentException("The birthday and desDay must not be null");
        }
        Calendar bCalendar = createCalendar(birthday);
        Calendar dCalender = createCalendar(desDay);
        int day = dCalender.get(Calendar.DAY_OF_MONTH) - bCalendar.get(Calendar.DAY_OF_MONTH);
        int month = dCalender.get(Calendar.MONTH) - bCalendar.get(Calendar.MONTH);
        int year = dCalender.get(Calendar.YEAR) - bCalendar.get(Calendar.YEAR);
        // 按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
        if (day < 0) {
            month--;
            // 得到上一个月，用来得到上个月的天数。
            dCalender.add(Calendar.MONTH, -1);
            day = day + dCalender.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (month < 0) {
            year--;
            month = (month + 12) % 12;
        }
        return new Age(year, month, day);
    }

    /**
     * 创建日历类
     *
     * @param date 指定日期
     * @return
     */
    private static Calendar createCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * 年龄类
     */
    public static final class Age {
        private int year;
        private int month;
        private int day;

        public Age(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        @Override
        public String toString() {
            return new StringBuilder().append(year).append("岁").append(month).append("个月").append(day).append("天")
                    .toString();
        }
    }

    /**
     * Description: 返回两个时间相隔的天数
     *
     * @param preDatetime
     * @param afterDatetime
     * @param hasFloat
     * @return
     * @author 潘深练
     * @Version 1.0 2014-4-18下午01:47:36
     */
    public static float getDaysByCompare(String preDatetime, String afterDatetime, Boolean hasFloat) {
        return getByCompare(preDatetime, afterDatetime, 1, hasFloat);
    }

    public static float getDaysByCompare(String preDatetime, String afterDatetime) {
        return getByCompare(preDatetime, afterDatetime, 1, true);
    }

    /**
     * Description: 返回两个日期相隔的月数
     *
     * @param preDate
     * @param afterDate
     * @return
     * @author 潘深练
     */
    public static double getMonthsByCompare(String preDate, String afterDate) {
        String compareDate = preDate;
        double passMonths = 0.0d;
        while (compareDate(compareDate, afterDate) > 0) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date compareD = df.parse(compareDate);
                compareD = DateUtils.addMonth(compareD, 1);
                compareDate = df.format(compareD);
            } catch (ParseException e) {

            }
            passMonths++;
        }
        return passMonths;
    }

    /**
     * Description: 返回两个日期相隔的月数
     *
     * @param preDate
     * @param afterDate
     * @return
     * @author 潘深练
     */
    public static double getMonthsByCompare(Date preDate, Date afterDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return getMonthsByCompare(df.format(preDate), df.format(afterDate));
    }

    public static int compareDate(String pre, String after) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preD = df.parse(pre);
            Date afterD = df.parse(after);
            if (preD.getTime() < afterD.getTime()) {
                return 1;
            } else if (preD.getTime() > afterD.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
        }
        return 0;
    }

    /**
     * Description: 返回两个时间相隔的小时数
     *
     * @param preDatetime
     * @param afterDatetime
     * @param hasFloat
     * @return
     * @author 潘深练
     * @Version 1.0 2014-4-18下午01:47:47
     */
    public static float getHoursByCompare(String preDatetime, String afterDatetime, Boolean hasFloat) {
        return getByCompare(preDatetime, afterDatetime, 2, hasFloat);
    }

    public static float getHoursByCompare(String preDatetime, String afterDatetime) {
        return getByCompare(preDatetime, afterDatetime, 2, true);
    }

    /**
     * Description: 返回两个时间相隔的分钟数
     *
     * @param preDatetime
     * @param afterDatetime
     * @param hasFloat
     * @return
     * @author 潘深练
     * @Version 1.0 2014-4-18下午01:47:56
     */
    public static float getMinutesByCompare(String preDatetime, String afterDatetime, Boolean hasFloat) {
        return getByCompare(preDatetime, afterDatetime, 3, hasFloat);
    }

    public static float getMinutesByCompare(String preDatetime, String afterDatetime) {
        return getByCompare(preDatetime, afterDatetime, 3, true);
    }

    public static int getMinutesByIntCompare(Date preDatetime, Date afterDatetime) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Float f = new Float(getByCompare(sf.format(preDatetime), sf.format(afterDatetime), 3, false));
        return f.intValue();
    }

    /**
     * Description: 返回两个时间相隔的秒数
     *
     * @param preDatetime
     * @param afterDatetime
     * @param hasFloat
     * @return
     * @author 潘深练
     * @Version 1.0 2014-4-18下午01:48:02
     */
    public static float getSecondsByCompare(String preDatetime, String afterDatetime, Boolean hasFloat) {
        return getByCompare(preDatetime, afterDatetime, 4, hasFloat);
    }

    public static Integer getIntSecondsByCompare(String preDatetime, String afterDatetime) {
        Float f = new Float(getByCompare(preDatetime, afterDatetime, 4, false));
        return f.intValue();
    }

    public static float getSecondsByCompare(Date preDatetime, Date afterDatetime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String _preDatetime = df.format(preDatetime);
        String _afterDatetime = df.format(afterDatetime);
        return getSecondsByCompare(_preDatetime, _afterDatetime);
    }

    public static float getSecondsByCompare(String preDatetime, String afterDatetime) {
        return getByCompare(preDatetime, afterDatetime, 4, true);
    }

    public static float getByCompare(String preDatetime, String afterDatetime,
                                     Integer type, Boolean hasFloat) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date preD = null;
        Date afterD = null;
        try {
            preD = df.parse(preDatetime);
            afterD = df.parse(afterDatetime);
        } catch (Exception e) {
        }
        return getTypeByCompare(preD, afterD, type, hasFloat);
    }

    public static float getTypeByCompare(Date preDate, Date afterDate, Integer type, Boolean hasFloat) {
        if (preDate == null || afterDate == null) {
            return 0l;
        }
        long diff = 0l;
        diff = afterDate.getTime() - preDate.getTime();
        long l = 1l;
        switch (type) {
            case 1:
                l = 1000 * 60 * 60 * 24;
                break;
            case 2:
                l = 1000 * 60 * 60;
                break;
            case 3:
                l = 1000 * 60;
                break;
            case 4:
                l = 1000;
                break;
        }
        if (hasFloat) {
            float a = diff;
            float b = l;
            return a / b;
        } else {
            return diff / l;
        }
    }

    /**
     * 获取系统时间
     */
    public static String getSysDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取系统日期"yyyy-MM-dd"（cyz于20100319增加）
     */
    public static String getSysDay() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 取得当前日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        } catch (Exception e) {
            log.info("getSpecifiedDayBefore:" + e.toString());
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }

    /**
     * 获取当天之前days天的日期 （零时零分零秒） 如果当前时间为 2011-09-25 10:10:10 则 dayBeforeToday(5)
     * 结果为2011-09-20 00:00:00
     */
    public static String dayBeforeToday(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);// 24小时制，而calendar.set(Calendar.HOUR,0);则是12小时制
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.HOUR, -24 * days);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 指定日期增加（月）
     *
     * @param date   指定的一个原始日期
     * @param amount 数值增量
     * @return 新日期
     */
    public static Date setDays(Date date, int amount) {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }

    private static Date set(final Date date, final int calendarField, final int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        // getInstance() returns a new object, so this method is thread safe.
        final Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(calendarField, amount);
        return c.getTime();
    }

    /**
     * @Description 通过年月获取第一天和最后一天
     * @Date 2019/1/22 14:44
     * @Param day 例如:201801
     * @Return
     */
    public static Map<String, Object> getFirstAndLastDay(String day) {
        int year = Integer.parseInt(day.substring(0, day.length() - 2));
        int month = Integer.parseInt(day.substring(4, day.length()));
        String sta = getFirstDayOfMonth1(year, month);
        String end = getLastDayOfMonth1(year, month);
        Map<String, Object> map = new HashMap<>();
        map.put("startDate", sta + " 00:00:00");
        map.put("endDate", end + " 23:59:59");
        return map;
    }


    /**
     * 获取指定年月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定年月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

}
