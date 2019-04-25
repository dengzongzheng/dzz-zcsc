package com.dzz.zcsc.service;


import com.dzz.zcsc.common.id.RandCodeUtils;
import com.dzz.zcsc.common.id.SnowFlake;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 * Id生成器
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月01 下午4:23
 */
@Service
public class IdService {

    private SnowFlake snowFlake = new SnowFlake(2, 3);

    /**
     * Id生成
     * @return 主键Id
     */
    public Long getId() {
        return snowFlake.nextId();
    }


    /**
     * 业务号生成
     * @param prefix 前缀
     * @return 结果
     */
    public  String getFormatId(String prefix) {

        return prefix + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMM")) + RandCodeUtils.getRandCode(6);
    }


}
