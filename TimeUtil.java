package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 对时间处理相关方法进行二次封装的工具类
 * 将对时间的操作进行封装
 */
public class TimeUtil {

    private static final Calendar calendar = Calendar.getInstance();
    private static final SimpleDateFormat formatL=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat formatS=new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取传入时间字符串当天的零点
     * @param time 时间
     * @return 当天零点的Date对象
     * @throws ParseException 格式转换异常
     */
    public static Date getBegin(String time) throws ParseException {
        calendar.setTime(getDate(time));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取传入时间字符串当天的23：59：59
     * @param time 时间
     * @return 当天半夜零点的Date对象
     * @throws ParseException 格式转换异常
     */
    public static Date getEnd(String time) throws ParseException {
        calendar.setTime(getDate(time));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 判断两个时间是否为同一天
     * @param timeCompare 比较时间
     * @param timeZone 时间标
     * @return boolean
     * @throws ParseException 格式转换异常
     */
    public static boolean isToday(String timeCompare,String timeZone) throws ParseException {
        Date date = getDate(timeCompare);
        return date.after(TimeUtil.getBegin(timeZone)) && date.before(TimeUtil.getEnd(timeZone));
    }

    /**
     * 将Date对象转换为 yyyy-MM-dd HH:mm:ss 的长字符串格式
     * @param date 需要转换的Date对象
     * @return 时间字符串
     */
    public static String getLongTimeAsString(Date date){
        return formatL.format(date);
    }

    /**
     * 将Date对象转换为 yyyy-MM-dd 的长字符串格式
     * @param date 需要转换的Date对象
     * @return 时间字符串
     */
    public static String getShortTimeAsString(Date date){
        return formatS.format(date);
    }

    /**
     * 将时间字符串转换为Date对象
     * 通过正则表达式进行判断字符串的类型
     * @param time 时间字符串
     * @return 转换后的Date对象
     * @throws ParseException 格式转换异常
     */
    public static Date getDate(String time) throws ParseException {
        if(time.matches("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}")) {
            return formatL.parse(time);
        }else if(time.matches("\\d{4}-\\d{2}-\\d{2}")){
            return formatS.parse(time);
        }else {
            throw new NullPointerException();
        }
    }

    /**
     * 将长时间字符串转换为短时间字符串
     * @param name 长时间字符串
     * @return 长时间字符串
     * @throws ParseException 格式转换异常
     */
    public static String changeFormatToShort(String name) throws ParseException {
        return getShortTimeAsString(getDate(name));
    }
}
