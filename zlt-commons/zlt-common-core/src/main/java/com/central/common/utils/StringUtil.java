package com.central.common.utils;

import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串公用类
 *
 * @author ljb
 */
public class StringUtil {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 判断字符串是否中文
     */
    public static boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        return matcher.find();
    }

    /**
     * 产生随机字符串
     */
    private static Random randGen = null;
    private static char[] numbersAndLetters = null;
    private static Object initLock = new Object();

    /**
     * 验证可能为空格或者""及null的字符串
     *
     * <pre>
     *   StringUtils.isBlank(null)      = true
     *   StringUtils.isBlank(&quot;&quot;)        = true
     *   StringUtils.isBlank(&quot; &quot;)       = true
     *   StringUtils.isBlank(&quot;bob&quot;)     = false
     *   StringUtils.isBlank(&quot;  bob  &quot;) = false
     * </pre>
     *
     * @param cs 可能为空格或者""及null的字符序列
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(cs.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Description:验证字符串数组是否为空
     *
     * @param css
     * @return
     * @author 唐海洋
     * @Version 1.0 2016-7-21下午5:34:41
     */
    public static boolean isBlank(final CharSequence... css) {
        if (css == null)
            return true;

        for (CharSequence cs : css) {
            if (isNotBlank(cs)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证可能为""或者null的字符串
     *
     * @param cs 可能为空的字符串
     * @return
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 把数组内的对象通过分隔符连接为字符串
     *
     * @param array     对象数组
     * @param separator 分隔符
     * @return
     */
    public static String join(final Object[] array, final String separator) {
        return join(Arrays.asList(array), separator);
    }

    /**
     * 连接迭代器内对象为字符串
     *
     * @param it        实现迭代接口的集合
     * @param separator 分隔符
     * @return
     */
    public static String join(final Iterable<?> it, final String separator) {
        Iterator<?> iterator = null;
        if ((iterator = it.iterator()) == null || !iterator.hasNext()) {
            return null;
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return String.valueOf(first);
        }

        StringBuilder buf = new StringBuilder().append(first);
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(separator).append(obj);
            }
        }
        return buf.toString();
    }

    /**
     * 截取指定长度字符串，超长部分截取后加"..."
     *
     * @param str    源字符串
     * @param length 截取长度
     * @param dot    是否为未显示内容添加"..."
     * @return
     */
    public static String substring(String str, final int length, final boolean dot) {
        return substring(str, 0, length, dot);
    }

    /**
     * 截取指定长度字符串，超长部分截取后加"..."
     *
     * @param str        源字符串
     * @param beginIndex 开始下标(包含本身)
     * @param endIndex   结束下标(不包含本身)
     * @param dot        是否为未显示内容添加"..."
     * @return
     */
    public static String substring(String str, int beginIndex, int endIndex, final boolean dot) {
        if (str != null) {
            if (str.length() >= (endIndex + 1)) {
                str = str.substring(beginIndex, endIndex);
                return dot ? str + "..." : str;
            }
        }
        return str;
    }

    /**
     * 以分隔标记分隔字符串为字符串数组
     *
     * @param str       源字符串
     * @param separator 分隔符,字符串或正则表达式对象，它标识了分隔字符串时使用的是一个还是多个字符。
     * @return
     */
    public static String[] split(final String str, final String separator) {
        return split(str, separator, false);
    }

    /**
     * 以分,隔标记分,隔字符串,为字符串数组
     *
     * @param str       源字符串
     * @param separator 分隔符
     * @param bool      是否把分隔符添加到字符串尾部返回
     * @return
     */
    public static String[] split(String str, String separator, boolean bool) {
        String[] strs = null;
        if (str != null) {
            strs = str.split(separator);
            if (bool) {
                for (int i = 0, length = strs.length; i < length; i++) {
                    strs[i] += separator;
                }
            }
        }
        return strs;
    }

    /**
     * 将字符串以相同步长分隔生成List返回
     *
     * <pre>
     * 		StringUtil.split("我的世界因为有你才会美",3);   --> "[我的世, 界因为, 有你才, 会美]"
     * 		StringUtil.split("我的世界因为有你才会美",2);   --> "[我的, 世界, 因为, 有你, 才会, 美]"
     * </pre>
     *
     * @param str  源字符串
     * @param step 拆分步长
     * @return
     */
    public static List<String> split(final String str, int step) {
        if (str != null && step > 0) {
            List<String> list;
            if (step > str.length()) {
                list = new ArrayList<String>(1);
                list.add(str);
            } else {
                list = new ArrayList<String>();

                int i = 0;
                do {
                    list.add(str.substring(i, i += step));
                }
                while ((i + step) < str.length());

                if (i < str.length()) {
                    list.add(str.substring(i, str.length()));
                }
            }
            return list;
        }
        return null;
    }


    /**
     * 获取字符串对应的字节数
     *
     * @param string
     * @return
     */
    public static int getStrLen(String string) {
        try {
            int count = string.getBytes("gb2312").length;
            return count;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return 0;
    }

    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        if (randGen == null) {
            synchronized (initLock) {
                if (randGen == null) {
                    randGen = new Random();
                    numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                    //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                }
            }
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            //randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
        }
        return new String(randBuffer);
    }

    /**
     * @param length 生成数字字符串长度，长度>1
     * @return
     */
    public static final String randomCode(int length) {
        String number = String.valueOf((long) (Math.random() * 10));
        while (number.length() < length) {
            number += String.valueOf((long) (Math.random() * 10));
        }
        return number;
    }

    /**
     * Convert byte[] to hex string
     *
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        if (b < 0) {
            b = (byte) "0123456789abcdef".indexOf(c);
        }
        return b;
    }

    /**
     * 将16进制的字符串转换为字节数组,例如有16进制字符串"12345678"<br/>
     * 转换后的结果为：{18, 52 ,86 ,120 };
     *
     * @param hex 需要转换的16进制字符串
     * @return 以字节数组返回转换后的结果
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }


    /**
     * replace方法替换掉所有正则表达式匹配的字符串
     *
     * @param text
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceAll(String text, String regex, String replacement) {
        if ((text == null) || (regex == null) || (replacement == null)) {
            return text;
        }
        return text.replaceAll(regex, replacement);
    }

    /**
     * replaceFirst方法替换掉第一个匹配正则表达式的子字符串
     *
     * @param text
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceFirst(String text, String regex, String replacement) {
        if ((text == null) || (regex == null) || (replacement == null)) {
            return text;
        }
        return text.replaceFirst(regex, replacement);
    }


    /**
     * replacePattern方法替换掉与正则表达式匹配的子字符串
     *
     * @param source
     * @param regex
     * @param replacement
     * @return
     */
    public static String replacePattern(String source, String regex, String replacement) {
        if ((source == null) || (regex == null) || (replacement == null)) {
            return source;
        }
        return Pattern.compile(regex, 32).matcher(source).replaceAll(replacement);
    }

    /**
     * object convert to bigDecimal
     */
    public static BigDecimal objToDecimal(Object obj) throws Exception {
        return (null != obj) ? BigDecimal.valueOf(objToInt(obj)) : BigDecimal.ZERO;
    }

    /**
     * object convert to date
     */
    public static Date objToDate(Object obj) throws Exception {
        return (null != obj) ? DateUtils.parse(obj.toString().substring(0, 10)) : null;
    }

    /**
     * object convert to long
     */
    public static long objToLong(Object obj) {
        return (null != obj) ? Long.parseLong(obj.toString()) : 0;
    }

    /**
     * object convert to integer
     */
    public static int objToInt(Object obj) {
        return (null != obj) ? Integer.parseInt(obj.toString()) : 0;
    }

    /**
     * object convert to string
     */
    public static String objToStr(Object obj) {
        return (null != obj) ? obj.toString() : null;
    }

    /**
     * 判断对象为空
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        else if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
        else if (obj instanceof Collection) return ((Collection) obj).isEmpty();
        else if (obj instanceof Map) return ((Map) obj).isEmpty();
        else if (obj.getClass().isArray()) return Array.getLength(obj) == 0;

        return false;
    }

}
