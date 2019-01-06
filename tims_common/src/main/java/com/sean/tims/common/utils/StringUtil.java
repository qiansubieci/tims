package com.sean.tims.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {
    /**
     * ******************************************************************************
     *
     * @param obj
     * @return String
     * ******************************************************************************
     * @function : 将对象转化为String类型
     * @memo ：如果对象为空，则返回null
     * ******************************************************************************
     */
    public static String valueOf(Object obj) {
        return obj == null ? null : String.valueOf(obj);
    }

    public static String valueOf(Object obj, String defaultValue) {
        return obj == null ? defaultValue : String.valueOf(obj);
    }

    /**
     * ******************************************************************************
     *
     * @param String
     * @return Long
     * ******************************************************************************
     * @function : 将String转化为Long类型
     * @memo ：如果对象为空，则返回null
     * ******************************************************************************
     */
    public static Long toLong(String str) {
        return str == null ? null : Long.valueOf(str);
    }

    public static Long toLongAsNull(String str) {
        return str == null ? null : (str.length() == 0 ? null : Long.valueOf(str));
    }

    /**
     * ******************************************************************************
     *
     * @param String
     * @return Integer
     * ******************************************************************************
     * @function : 将String转化为Integer类型
     * @memo ：如果对象为空，则返回null
     * ******************************************************************************
     */
    public static Integer toInteger(String str) {
        return str == null ? null : (str.length() == 0 ? 0 : Integer.valueOf(str));
    }

    public static Integer toIntegerAsNull(String str) {
        return str == null ? null : (str.length() == 0 ? null : Integer.valueOf(str));
    }

    /**
     * ******************************************************************************
     *
     * @param String
     * @return Integer
     * ******************************************************************************
     * @function : 将String转化为Integer类型
     * @memo ：如果对象为空，则返回null
     * ******************************************************************************
     */
    public static Byte toByte(String str) {
        return str == null ? null : Byte.valueOf(str);
    }

    /**
     * 将字符串使用","进行拼接
     *
     * @param
     * @return ******************************************************************************
     * @memo ：
     * *
     */
    public static String toAppend(List<String> list) {
        StringBuffer sb = new StringBuffer();
        if (null != list) {
            for (String obj : list) {
                if (null != obj && !"".equals(obj)) {
                    sb.append(obj).append(",");
                }
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
        return null;
    }

    /**
     * 将String串转化成List
     *
     * @param
     * @return ******************************************************************************
     * @memo ：
     * *
     */
    public static List<String> toAddList(String obj) {
        if (null != obj && !"".equals(obj)) {
            List<String> list = new ArrayList<String>();
            String[] ob = obj.split(",");
            for (String o : ob) {
                list.add(o);
            }
            return list;
        }
        return null;
    }

    /**
     * ******************************************************************************
     *
     * @param str
     * @return ******************************************************************************
     * @function : 判断字符串是否为空
     * @memo ：字符串为null或者为空字符串都返回true
     * ******************************************************************************
     */
    public static boolean positionModel(String str) {
        if (str != null && !"".equals(str.trim())) {
            return false;
        }
        return true;
    }

    /**
     * ******************************************************************************
     *
     * @param str
     * @return ******************************************************************************
     * @function : 替换字符串中内容
     * @memo ：字符串为null或者为空字符串都返回null
     * ******************************************************************************
     */
    public static String replace(String str, String oldStr, String newStr) {
        if (str != null && !"".equals(str.trim())) {
            return str.replace(oldStr, newStr);
        }
        return null;
    }

    /**
     * ******************************************************************************
     *
     * @param str
     * @return ******************************************************************************
     * @function : 字符串转换为BigDecimal
     * @memo ：字符串为null或者为空字符串都返回null
     * ******************************************************************************
     */
    public static BigDecimal toBigDecimal(String str) {
        if (str != null && !"".equals(str.trim())) {
            return new BigDecimal(str);
        }
        return null;
    }

    public static BigDecimal toBigDecimalAsZero(String str) {
        return str == null ? null : (str.length() == 0 ? BigDecimal.ZERO : new BigDecimal(str));
    }

    public static BigDecimal toBigDecimalNullAsZero(String str) {
        return str == null ? BigDecimal.ZERO : (str.length() == 0 ? BigDecimal.ZERO : new BigDecimal(str));
    }

    /**
     * ******************************************************************************
     *
     * @param str
     * @return ******************************************************************************
     * @function : 字符串拆分
     * @memo ：字符串为null或者为空字符串都返回null
     * ******************************************************************************
     */
    public static String[] splitToArray(String str, String mark) {
        if (str != null && !"".equals(str.trim())) {
            return str.split(mark);
        }
        return null;
    }

    public static String removeBackquote(String simpleName) {
        return simpleName.trim();
    }

    public static List<Integer> getIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        if (stringList != null && stringList.size() > 0) {
            for (String string : stringList) {
                integerList.add(toIntegerAsNull(string));
            }
        }
        return integerList;
    }

    public static List<String> getStringList(List<Integer> integerList) {
        List<String> stringList = new ArrayList<>();
        if (integerList != null && integerList.size() > 0) {
            for (Integer integer : integerList) {
                stringList.add(valueOf(integer));
            }
        }
        return stringList;
    }

    //url去除"http://wzw.tc.com/"
    public static String getImgUrl(String url) {
        if (StringUtil.isNotEmpty(url)) {
            int k = 0;
            int index = 0;
            for (int i = 0; i < url.length(); i++) {
                if (String.valueOf(url.charAt(i)).equals("/")) {
                    k++;
                }
                if (k == 3) {
                    index = i;
                    break;
                }
            }
            String v = url.substring(index + 1, url.length());
            return v;
        }
        return null;
    }

    /**
     * 判断字符串是否为数字字母，忽略字符串中的空格<br>
     * <p>
     * 各种字符的unicode编码的范围：<br>
     * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）<br>
     * 数字：[0x30,0x39]（或十进制[48, 57]）<br>
     * 小写字母：[0x61,0x7a]（或十进制[97, 122]）<br>
     * 大写字母：[0x41,0x5a]（或十进制[65, 90]）<br>
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigit(String str) {
        str = replaceBlank(str);
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

    /**
     * 去除字符串中的空格、回车、换行符、制表符
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

}
