package com.thor.pawPrint.core.utils.thirdParty;

import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.MessageDigestConstant;
import com.thor.pawPrint.core.utils.data.StringBuilderUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 微信工具类
 * Created by Thor on 2017/2/7.
 * happy coding - 1203!
 */
public class WeChatUtil {
    /**
     * 微信消息校验
     *
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param params    其他参数
     * @return 校验是否通过
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    public static boolean checkSignature(String signature, String... params) throws NoSuchAlgorithmException {
        //按字典顺序排序
        Arrays.sort(params);

        //字符串拼接
        StringBuilder content = StringBuilderUtil.connectString(params);

        //SHA-1加密
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestConstant.SHA_1);
        byte[] digest = messageDigest.digest(content.toString().getBytes());
        String testingStr = byteArrayToHexString(digest);

        return testingStr.equalsIgnoreCase(signature.toUpperCase());
    }

    // 将字节数组转换为十六进制字符串
    private static String byteArrayToHexString(byte[] byteArray) {
        String result = Constant.STRING_EMPTY;

        for (byte item : byteArray) {
            result += byteToHexString(item);
        }

        return result;
    }

    // 将字节转换为十六进制字符串
    private static String byteToHexString(byte ib) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];

        return new String(ob);
    }

}
