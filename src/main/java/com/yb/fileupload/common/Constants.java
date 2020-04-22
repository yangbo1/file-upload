package com.yb.fileupload.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yangbo
 * @time: 2020/4/20 10:48
 */
public final class Constants {

    public static final Integer OK = 200;

    public static final Integer ERROR = -1;

    public static final Map<String, String> TYPES = new HashMap<String, String>() {
        {
            put("PNG", "");
            put("png", "");
            put("JPEG", "");
            put("jpeg", "");
            put("JPG", "");
            put("jpg", "");
            put("GIF", "");
            put("gif", "");
        }
    };
}
