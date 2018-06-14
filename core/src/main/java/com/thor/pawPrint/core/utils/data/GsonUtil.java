package com.thor.pawPrint.core.utils.data;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;

/**
 * google Gson 工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class GsonUtil {
    private static Gson gson;
    private static JsonParser parser;

    static {
        gson = new Gson();
        parser = new JsonParser();
    }

    /**
     * 初始化 Gson 对象
     *
     * @return Gson 对象
     */
    private static Gson initGson() {
        if (ObjectUtils.isEmpty(gson)) {
            gson = new Gson();
        }

        return gson;
    }

    /**
     * 初始化 JsonParser 对象
     *
     * @return JsonParser 对象
     */
    private static JsonParser initJsonParser() {
        if (ObjectUtils.isEmpty(parser)) {
            parser = new JsonParser();
        }

        return parser;
    }

    /**
     * 对象转json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String toJsonGson(Object object) {
        return initGson().toJson(object);
    }

    /**
     * json字符串转对象
     *
     * @param json json字符串
     * @param type 类型
     * @param <T>  泛型
     * @return 对象
     */
    public static <T> T fromJsonGson(String json, Type type) {
        return initGson().fromJson(json, type);
    }

    /**
     * 获取json字符串中某个节点的字符串值
     *
     * @param json json字符串
     * @param node 节点名称
     * @return 字符串值
     */
    public static String getNodeStringValueGson(String json, String node) {
        return initJsonParser().parse(json).getAsJsonObject().get(node).toString();
    }

}
