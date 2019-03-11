package com.liam.springboot.mybatisxml.result;

import com.liam.springboot.mybatisxml.param.PageParam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/26 22:47
 */
public class Page<E> implements Serializable {
    private static final long serialVersionUID = -8242436312191250294L;

    private int currentPage = 0;
    private long totalPage;
    private long totalNumber;
    private List<E> list;

    public static Page NULL = new Page(0, 0, 15, new ArrayList());

    public Page() {
        super();
    }

    public Page(int beginLine, long totalNumber, int pageSize, List<E> list) {
        super();
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber / pageSize : totalNumber / pageSize + 1;
    }

    public Page(PageParam pageParam, long totalNumber, List<E> list) {
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber / pageParam
                .getPageSize() : totalNumber / pageParam.getPageSize() + 1;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalNumber=" + totalNumber +
                ", list=" + list +
                '}';
    }
}
