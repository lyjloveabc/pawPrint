package com.thor.pawPrint.core.utils.net;

import com.google.common.collect.Maps;
import com.thor.pawPrint.core.common.constant.Constant;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Request工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class RequestUtil {
    /**
     * 根据请求获取所有请求参数
     *
     * @param httpServletRequest 请求
     * @return 请求参数map
     */
    public static Map<String, String> getParamMapFromRequest(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        return getParamMapFromRequest(httpServletRequest, null);
    }

    /**
     * 根据请求获取所有请求参数
     *
     * @param httpServletRequest 请求
     * @param charset            字符编码
     * @return 请求参数map
     * @throws UnsupportedEncodingException 异常
     */
    public static Map<String, String> getParamMapFromRequest(HttpServletRequest httpServletRequest, String charset) throws UnsupportedEncodingException {
        if (ObjectUtils.isEmpty(httpServletRequest)) {
            return Maps.newHashMap();
        }

        boolean charsetIsEmpty = ObjectUtils.isEmpty(charset);

        Map requestParams = httpServletRequest.getParameterMap();
        Map<String, String> params = new HashMap<>();

        for (Object o : requestParams.keySet()) {
            String name = (String) o;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = Constant.STRING_EMPTY;

            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + Constant.SPLIT_STR_COMMA;
            }

            params.put(name, charsetIsEmpty ? valueStr : new String(valueStr.getBytes("ISO-8859-1"), charset));
        }

        return params;
    }

    /**
     * 请求转XML
     *
     * @param httpServletRequest 请求
     * @return xml Map
     * @throws IOException       IOException
     * @throws DocumentException DocumentException
     */
    public static Map<String, String> requestToXml(HttpServletRequest httpServletRequest) throws IOException, DocumentException {
        Map<String, String> result = Maps.newHashMap();

        ServletInputStream servletInputStream = httpServletRequest.getInputStream();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(servletInputStream);

        //得到xml根元素
        Element root = document.getRootElement();

        // 得到根元素的所有子节点
        List elements = root.elements();

        // 遍历所有子节点
        for (Object object : elements) {
            Element element = (Element) object;
            result.put(element.getName(), element.getText());
        }

        // 释放资源
        servletInputStream.close();

        return result;
    }

}
