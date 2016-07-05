package cn.csbit.common;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Answer on 16/7/4.
 */
public class PageUtil {
    public static Map<String, Object> PageToMap(Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("total", page.getTotalElements());
        map.put("rows", page.getContent());
        return map;
    }
}
