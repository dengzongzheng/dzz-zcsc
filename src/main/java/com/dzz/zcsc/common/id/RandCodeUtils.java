package com.dzz.zcsc.common.id;

import java.util.Random;

/**
 * 随机号生成器
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月01 下午4:34
 */
public class RandCodeUtils {

    private final static String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    private final static Random strGen = new Random();
    private final static Random numGen = new Random();
    private final static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    private final static char[] numbers = ("0123456789").toCharArray();

    /**
     * 生产6位随机码
     *
     * @return
     */
    public static String getRandCode() {
        return getRandCode(6);
    }

    /**
     * 生产length位随机码
     *
     * @param length
     * @return
     */
    public static String getRandCode(int length) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            sb.append(arr[(int) (Math.random() * arr.length)]);
        }
        return sb.toString();
    }

    /**
     * 产生随机字符串
     */
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[strGen.nextInt(numbersAndLetters.length)];
        }
        return new String(randBuffer);
    }

    /**
     * 产生随机数值字符串
     */
    public static final String randomNumStr(int length) {
        if (length < 1) {
            return null;
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbers[numGen.nextInt(numbers.length)];
        }
        return new String(randBuffer);
    }

    /**
     * 返回随机字符串，同时包含数字，大写字母，小写字母
     * @param len 字符串长度，不能小于3
     * @return String 随机字符串
     */
    public static String randomNumberAndLetter(int len){
        if(len < 3){
            throw new IllegalArgumentException("字符串长度不能小于3");
        }
        //数组，用于存放随机字符
        char[] chArr = new char[len];
        //为了保证必须包含数字、大小写字母
        chArr[0] = (char)('0' + NumberRandom.uniform(0,10));
        chArr[1] = (char)('A' + NumberRandom.uniform(0,26));
        chArr[2] = (char)('a' + NumberRandom.uniform(0,26));

        //charArr[3..len-1]随机生成codes中的字符
        for(int i = 3; i < len; i++){
            chArr[i] = numbersAndLetters[NumberRandom.uniform(0,numbersAndLetters.length)];
        }

        //将数组chArr随机排序
        for(int i = 0; i < len; i++){
            int r = i + NumberRandom.uniform(len - i);
            char temp = chArr[i];
            chArr[i] = chArr[r];
            chArr[r] = temp;
        }

        return new String(chArr);
    }
}
