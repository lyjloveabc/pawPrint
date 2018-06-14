package com.thor.pawPrint.core.utils.code;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * AES安全编码工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class AESUtil {
    /**
     * 目前在用的密钥
     */
    public static final String SECURITY_KEY = "lmO7TKJBQek/HrHTVMrR6Q==";

    /**
     * 密钥算法
     */
    public static final String KEY_ALGORITHM = "AES";

    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     * Java 6 支持 PKCS5Padding 填充方式
     * Bouncy 支持 PKCS7Padding 填充方式
     */
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 转换密钥
     *
     * @param key 二进制密钥
     * @return Key 密钥
     */
    private static Key toKey(byte[] key) {
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return 解密数据
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        //还原密钥
        Key k = toKey(key);
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化，设置为揭秘模式
            cipher.init(Cipher.DECRYPT_MODE, k);

            //执行操作
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    /**
     * 加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return 加密数据
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        Key k = toKey(key);
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化，设置为揭秘模式
            cipher.init(Cipher.ENCRYPT_MODE, k);

            //执行操作
            return cipher.doFinal(data);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    /**
     * 生成密钥
     *
     * @return 二进制密钥
     */
    public static byte[] initKey() {
        try {
            //实例化
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            keyGenerator.init(128);

            //生成密钥，获得密钥的二进制编码形式
            return keyGenerator.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //安全密钥
        byte[] securityKey = Base64.decodeBase64(SECURITY_KEY);
        System.out.println(Base64.encodeBase64String(securityKey));

        String test = "Thor";

        byte[] testEncrypt = encrypt(test.getBytes(), securityKey);
        String testEncryptString = Base64.encodeBase64String(testEncrypt);
        System.out.println(testEncryptString);

        System.out.println(new String(AESUtil.decrypt(Base64.decodeBase64(testEncryptString), securityKey)));
    }

}
