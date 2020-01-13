package com.jianfei.sfexpresswaybillroute;

import com.jianfei.security.Md5Security;
import com.jianfei.security.MyMD5Util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-01-13 10:49
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //String s = "<Request service='RouteService' lang='zh-CN'><Head>BSPdevelop</Head><Body><RouteRequest tracking_type='1' method_type='1' tracking_number='444003077898'/></Body></Request>j8DzkIFgmlomPt0aLuwU";
        String s = "<Request service='RouteService' lang='zh-CN'><Head>sxzz</Head><Body><RouteRequest tracking_type='1' method_type='1' tracking_number='444003077898'/></Body></Request>LkBmVneVTQe1meEiMidNN80lMbw6jkZp";
        System.out.println(s);
        //String messageDigestResult = Md5Security.getMD5(s);
        String messageDigestResult = encodeByMd5(s);
        System.out.println("消息摘要结果：" + messageDigestResult);
        System.out.println("消息摘要结果1:" + MyMD5Util.encrypt(s));
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();

        //String result = encoder.encodeToString(messageDigestResult.getBytes("UTF-8"));
        String result = a(messageDigestResult);
        //System.out.println("base64结果：" + result);
        //byte[] origin = decoder.decode(result.getBytes("UTF-8"));
        //String o = new String(origin);
        System.out.println("****************************");
        a("test");
    }

    public static String encodeByMd5(String string) {
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            // 加密字符串
            return base64Encoder.encodeToString(md5.digest(string.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String a(String text) throws UnsupportedEncodingException {
        System.out.println("输入：" + text);
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        //final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println("base64编码结果：" + encodedText);
        //解码
        System.out.println("还原：" + new String(decoder.decode(encodedText), "UTF-8"));
        return encodedText;
    }

    public static String mymd5(String data) {

        StringBuilder sb = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }

    public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            byte[] result = md.digest();
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
