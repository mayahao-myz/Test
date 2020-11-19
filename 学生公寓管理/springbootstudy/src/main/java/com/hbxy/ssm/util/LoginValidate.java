package com.hbxy.ssm.util;

//登录校验
public class LoginValidate {
    /**
     * 判断原始密码与密码进行比较
     * @param orginal 原始名
     * @param secret  加密
     * @return
     */
    public static final boolean validate(String orginal,String secret){
        if (secret == null) {
            return false;
        }

        try{
            return secret.equals(EncryptUtil.encryptSHA256((orginal)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
