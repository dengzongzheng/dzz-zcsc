package com.dzz.zcsc.domain.model;

import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 用户表
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月28 20:51
 */
@Data
@Document(collection = "user")
public class User {


    /**
     * 用户名
     */
    @Indexed(unique = true)
    @Field("user_name")
    private String userName;

    /**
     * 密码
     */
    @Field("password")
    private String password;

    /**
     * 状态1:有效 0:无效
     */
    @Field("status")
    private Integer status;


    /**
     * 创建时间
     */
    @Field("create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Field("update_date")
    private Date updateDate;
}
