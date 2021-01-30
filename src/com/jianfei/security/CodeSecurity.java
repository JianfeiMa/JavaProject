package com.jianfei.security;


/**
 * 加解密方法的封装类
 * Created by Administrator on 2015/12/10 0010.
 */
public class CodeSecurity {

    public static final String desEncode(String str){
        return DESBase64Util.encodeInfo(str);
    }


    public static final String desDecodeInfo(String str){
        return DESBase64Util.decodeInfo(str);
    }

    /**
     * AES解码
     * @param str
     * @return
     */
    public static final String aesDecodeInfo(String str){
        String result = "";
        try {
            result = AESUtil.Decrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * AES编码
     * @param str
     * @return
     */
    public static final String aesEncodeInfo(String str){
        String result = "";
        try {
            result = AESUtil.Encrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String info = "511126555881";
        //生成密文
        String encodeInfo = desEncode(info);
        System.out.println(encodeInfo);
        //还原成原文
        String decodeInfo = desDecodeInfo(encodeInfo);
        System.out.println(decodeInfo);

        //String cipher = aesDecodeInfo(info);
        //System.out.println("密文->" + cipher);
        //String plaintext = aesDecodeInfo(cipher);
        //System.out.println("明文->" + plaintext);

        //System.out.println(MD5.getMD5("checkPhonecz20150803"));

        System.out.println("md5->" + Md5Security.getMD5("oiv1hddkf45nitcfy3kkjhbkt3dadxgbbuyerNick亨利林88endCreated2021-01-21 23:59:59pageNo1pageSize100startCreated2021-01-21 00:00:00statusWAIT_SELLER_SEND_GOODStimestamp1611215982292oiv1hddkf45nitcfy3kkjhbkt3dadxgb"));
    }
}
