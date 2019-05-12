package com.dzz.zcsc.common.enums;

import java.util.Objects;

/**
 * 类别分类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 10:09
 */
public enum  CategoryEnum {

    PORCELAIN(1, "瓷器"),
    JADE(2, "玉器"),
    PICTURE(3, "书画"),
    RECOMMENDED(5, "重点推荐"),
    OTHER(4, "杂项");

    private Integer code;

    private String name;

    CategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(Integer code) {
        for (CategoryEnum status : CategoryEnum.values()) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }
        return "";
    }

    public static Integer getCodeByName(String name) {
        for (CategoryEnum type : CategoryEnum.values()) {
            if (Objects.equals(name, type.getName())) {
                return type.getCode();
            }
        }
        return null;
    }

}
