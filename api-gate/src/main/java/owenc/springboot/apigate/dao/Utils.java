package owenc.springboot.apigate.dao;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

public final class Utils {
    private Utils() {
    }
    /**
     * 判断字符串是否为�?
     *
     * @param str
     *            String
     * @return boolean
     */
    public static boolean notEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断对象数组是否为空
     *
     * @param objs
     *            Object[]
     * @return boolean
     */
    public static boolean notEmpty(Object[] objs) {
        return !isEmpty(objs);
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /** 至少有一个为�? */
    public static boolean isAnyEmpty(Object... args) {
        for (Object object : args) {
            if (isEmpty(object))
                return true;
        }
        return false;
    }

    /** 全部为空 */
    public static boolean isAllEmpty(Object... args) {
        for (Object object : args) {
            if (notEmpty(object))
                return false;
        }
        return true;
    }

    /** 全部不为�? */
    public static boolean allNotEmpty(Object... args) {
        for (Object object : args) {
            if (isEmpty(object))
                return false;
        }
        return true;
    }

    /** 至少有一个不为空 */
    public static boolean notAllEmpty(Object... args) {
        for (Object object : args) {
            if (notEmpty(object))
                return true;
        }
        return false;
    }

    /**
     * 判断集合]是否为空
     *
     * @param coll
     *            Collection
     * @return boolean
     */
    public static boolean notEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(Collection<?> coll) {
        if (coll == null || coll.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断int数组是否为空
     *
     * @param intArr
     *            int[]
     * @return boolean
     */
    public static boolean notEmpty(int[] arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(int[] intArr) {
        if (intArr == null || intArr.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断long数组是否为空
     *
     * @param longArr
     *            long[]
     * @return boolean
     */
    public static boolean notEmpty(long[] arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(long[] longArr) {
        if (longArr == null || longArr.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断Map是否为空
     *
     * @param map
     *            Map
     * @return boolean
     */
    public static boolean notEmpty(Map<?, ?> arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null || map.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean notEmpty(Object arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return obj.equals("");
        }
        return false;
    }

    public static boolean isEmpty(Object obj, Object nullValue) {
        if (obj == null) {
            return true;
        } else if (obj.equals(nullValue)) {
            return true;
        }
        return false;
    }

    public static boolean isAllEmpty(String... strings) {
        for (String s : strings) {
            if (Utils.notEmpty(s))
                return false;
        }
        return true;
    }

    public static String getIp(HttpServletRequest req) {
        String ip = "";
        if (req.getHeader("x-forwarded-for") == null) {
            ip = req.getRemoteAddr();
        }else {
            ip = req.getHeader("x-forwarded-for");
        }
        return ip;
    }
    /**
     * 生成指定长度的随机字符串
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//含有字符和数字的字符串
        Random random = new Random();//随机类初始化
        StringBuffer sb = new StringBuffer();//StringBuffer类生成，为了拼接字符串

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);// [0,62)

            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
