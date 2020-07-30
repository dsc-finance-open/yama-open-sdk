package com.dsc.financeopen.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author lg
 * @date 2020/6/15
 */
public class CollectionUtil {

    /**
     * map是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<? extends Object, ? extends Object> map) {
        return map == null || map.isEmpty();
    }

    /**
     * map是否不为空
     */
    public static boolean isNotEmpty(Map<? extends Object, ? extends Object> map) {
        return map != null && !map.isEmpty();
    }

    /**
     * 将Map转换为List
     */
    public static List<? extends Object> parseMap2List(Map<? extends Object, ? extends Object> map) {
        List<Object> list = null;
        if (isNotEmpty(map)) {
            list = new ArrayList<Object>();
            for (Map.Entry<? extends Object, ? extends Object> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public static boolean isEmpty(Collection<? extends Object> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Collection<? extends Object> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

}
