package org.nouk.stackplay.web.utils;

/**
 * @Description:
 * @author:
 * @date: 2021/7/16 16:55
 **/

import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class xx {
    public xx() {
    }

    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        } else if (o instanceof Collection) {
            return ((Collection)o).isEmpty();
        } else if (o instanceof Map) {
            return ((Map)o).isEmpty();
        } else if (o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        } else if (o instanceof Iterator) {
            return !((Iterator)o).hasNext();
        } else if (o instanceof Iterable) {
            return !((Iterable)o).iterator().hasNext();
        } else {
            return o instanceof String && o.toString().equals("");
        }
    }

    public static boolean isOneEmpty(Object... os) {
        Object[] arr$ = os;
        int len$ = os.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Object o = arr$[i$];
            if (isEmpty(o)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAllEmpty(Object... os) {
        Object[] arr$ = os;
        int len$ = os.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Object o = arr$[i$];
            if (!isEmpty(o)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNum(Object obj) {
        try {
            Integer.parseInt(obj.toString());
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean isTrue(Object str) {
        if (isEmpty(str)) {
            return false;
        } else {
            String s = str.toString().trim().toLowerCase();
            return s.equals("true") || s.equals("on");
        }
    }

    public static String format(Object str) {
        return "'" + str.toString() + "'";
    }

    public static String formatPath(String path, Object... args) {
        return String.format(path.replace("/", File.separator), args);
    }

    public static Integer toInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }

    public static Integer toInt(Object obj, int defaultValue) {
        return isEmpty(obj) ? defaultValue : toInt(obj);
    }

    public static long toLong(Object obj) {
        return Long.parseLong(obj.toString());
    }

    public static long toLong(Object obj, long defaultValue) {
        return isEmpty(obj) ? defaultValue : toLong(obj);
    }

    public static double toDouble(Object obj) {
        return Double.parseDouble(obj.toString());
    }

    public static Boolean toBoolean(Object obj) {
        return Boolean.parseBoolean(obj.toString());
    }

    public static Boolean toBoolean(Object obj, Boolean defaultValue) {
        return isEmpty(obj) ? defaultValue : toBoolean(obj);
    }

    public static Date toDate(String str) {
        try {
            return str != null && !"".equals(str.trim()) ? (new SimpleDateFormat("yyyy-MM-dd")).parse(str.trim()) : null;
        } catch (Exception var2) {
            throw new RuntimeException("Can not parse the parameter \"" + str + "\" to Date value.");
        }
    }

    public static String join(Collection<?> s) {
        return join(s, "", ",");
    }

    public static String join(Collection<?> s, String parcel, String sign) {
        if (s.isEmpty()) {
            return "";
        } else {
            Iterator<?> iter = s.iterator();
            StringBuilder sb = new StringBuilder(parcel + iter.next().toString() + parcel);

            while(iter.hasNext()) {
                sb.append(sign).append(parcel + iter.next() + parcel);
            }

            return sb.toString();
        }
    }

    public static String delStart(String s, String sign) {
        return s.startsWith(sign) ? s.substring(s.lastIndexOf(sign) + sign.length(), s.length()) : s;
    }

    public static String delEnd(String s, String sign) {
        if (isEmpty(s)) {
            return s;
        } else {
            return s.endsWith(sign) ? s.substring(0, s.lastIndexOf(sign)) : s;
        }
    }

    public static void costTime(long time) {
        System.err.println("Load Cost Time:" + (System.currentTimeMillis() - time) + "ms\n");
    }

    public static String formatJson(String json) {
        int level = 0;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < json.length(); ++i) {
            char c = json.charAt(i);
            if (level > 0 && '\n' == sb.charAt(sb.length() - 1)) {
                sb.append(getLevelStr(level));
            }

            switch(c) {
                case ',':
                    sb.append(c + "\n");
                    break;
                case '[':
                case '{':
                    sb.append(c + "\n");
                    ++level;
                    break;
                case ']':
                case '}':
                    sb.append("\n");
                    --level;
                    sb.append(getLevelStr(level));
                    sb.append(c);
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();

        for(int levelI = 0; levelI < level; ++levelI) {
            levelStr.append("  ");
        }

        return levelStr.toString();
    }

    private final static Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
    public static String replaceBlank(String s) {
        if (isEmpty(s)) {
            return s;
        } else {
            Matcher m = pattern.matcher(s);
            return m.replaceAll("");
        }
    }

    public static boolean isTimeout(Long oldTime, int timeoutSec) {
        if (oldTime == null) {
            return true;
        } else {
            return (System.currentTimeMillis() - oldTime) / 1000L > (long)timeoutSec;
        }
    }

    public static Object[] toArray(List<Object> list) {
        Object[] os = new Object[list.size()];
        list.toArray(os);
        return os;
    }
}

