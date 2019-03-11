package com.liam.springboot.mybatisannotation.param;

/**
 * @Author: Liam
 * @Date: 2019/2/28 15:55
 */
public class PageParam {
    private int beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;

    public int getBeginLine() {
        return pageSize * currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "beginLine=" + beginLine +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }
}