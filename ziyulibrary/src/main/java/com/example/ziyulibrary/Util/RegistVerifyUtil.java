package com.example.ziyulibrary.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ziyu on 2016/9/26  16:20.
 */

public class RegistVerifyUtil {

    /**
     * 判断邮箱地址是否有效
     * @param email
     */
    public static boolean isEmailValid(String email)
    {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }
    /**
     * 判断电话号码是否有效
     * @param phoneNumber
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {

        boolean isValid = false;

        String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        CharSequence inputStr = phoneNumber;

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
