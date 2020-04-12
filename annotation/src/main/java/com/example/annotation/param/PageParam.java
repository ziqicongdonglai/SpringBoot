package com.example.annotation.param;

import lombok.Data;

/**
 * @author ke_zhang
 * @create 2020/4/12 15:11
 * @description 分页的基础类
 */
@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize;
    private Integer currentPage = 0;
    public int getBeginLine() {
        return pageSize * currentPage;
    }
}
