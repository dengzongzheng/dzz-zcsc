package com.dzz.zcsc.common.page;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 分页包装类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 22:56
 */
@Data
public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = -8419082543496293641L;

    /**
     * 页号
     */
    private Integer pageNo = 1;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    /**
     * 数据
     */
    private List<T> data;

    /**
     * 计算一共多少页
     */
    public void setTotalPage() {
        if (this.totalCount == 0) {
            this.totalPage = 0;
        } else {
            this.totalPage =
                    (this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
                            : this.totalCount / this.pageSize;
        }
    }

}
