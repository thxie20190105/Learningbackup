package org.xigua.study.javabase.date;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author org.xigua
 */
public class Tdate {
    public static void main(String[] args) throws InterruptedException, ParseException {
        Tdate.compareTo();
        Tdate.jdk8NewDate();
        Tdate.testdate();
        Tdate.simpleDateFormat();
        Tdate.testSqlDate();
        Tdate.testSqlTime();
        Tdate.testCalendar();
        Tdate.testJdk8New();
        Tdate.tNextdate();

    }

    private static void tNextdate() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -80);
        date = calendar.getTime();
        System.out.println("80天前"+sdf.format(date));

    }

    private static void compareTo() throws InterruptedException {
        //比较时间戳
        Date date = new Date();
        Thread.sleep(1000);
        Date date1 = new Date();

        System.out.println(date1.getTime() - date.getTime());
        System.out.println(date1.compareTo(date));
        System.out.println(date.compareTo(date));

    }

    private static void jdk8NewDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("本地日期" + localDate);

        int dayOfMonth = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        LocalDate localDate1 = localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate localDate2 = localDate.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    private static void testJdk8New() {
        //jdk8的新方法，它是不可变且线程安全的
        LocalDate localDate = LocalDate.now();

    }

    private static void testCalendar() {
        //主要用于获取某个时间对象的年月日，日期等。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        System.out.println("使用calendar获得年份"+year);

    }

    private static void testSqlTime() {
        //包含时分秒，为了sql里面的time类型而出现的
        Time time = new Time(System.currentTimeMillis());
        System.out.println(time);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("纳秒级别时间戳"+timestamp);
    }

    private static void testSqlDate() {
        //为了适应sql的时间类型的date类，包含年月日，时分秒都被设置为0，
        //初始化时需要一个long类型的参数，这个参数代表从1970开始到现在某个时间的毫秒数
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
        System.out.println("sql类型时间"+date1);
        System.out.println("sql类型时间"+date1.getTime());
    }

    private static void simpleDateFormat() throws ParseException {

        //作用：将各种时间串转换为date类型，或者把date类型转换成时间串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //将date类型格式化输出
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println("date类型时间"+dateStr);
        //将字符转换成date类型
        Date date = simpleDateFormat.parse("2020-08-20");
        System.out.println("格式化字符型时间以毫秒输出"+date.getTime());

    }

    private static void testdate() {
        //常规的date使用
        //精确到毫秒级别
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

    }
}
