package com.central.common.utils;

import java.util.regex.Pattern;

/**
 * Created with IDEA
 * author:Dingsheng Huang
 * Date:2019/7/2
 * Time:下午6:51
 */
public class RegexUtils {
    /**
     *
     * @param in
     * @return 手机号
     */
    /*public static boolean validateMobilePhone(String in) {
        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        return pattern.matcher(in).matches();
    }*/


    /**
     * 验证手机：符合手机格式返回true
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        return Pattern.compile(regex).matcher(phone).find();
    }

    /**
     * 校验邮箱：符合格式返回true
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return Pattern.compile(regex).matcher(email).find();
    }

    /**
     * 校验用户名：用户名只能由字母和汉字组成，符合要求返回true
     *
     * @param base_name
     * @return
     */
    public static boolean isName(String base_name) {
        String regex = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
        return Pattern.compile(regex).matcher(base_name).find();
    }

    /**
     * 校验用户密码：用户密码必须同时包含 数字、大小写字母、特殊符号、长度在8-16位
     * @param password
     * @return
     */
    public static boolean isPassword(String password) {
        String regex = "^(?:(?=.*[0-9].*)(?=.*[A-Za-z].*)(?=.*[\\W].*))[\\W0-9A-Za-z]{8,16}$";
        return Pattern.compile(regex).matcher(password).find();
    }
}

