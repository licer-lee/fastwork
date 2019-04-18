package com.licerlee.fastwork.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author licer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageModel<E> implements Serializable {

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     *每页显示的数量
     */
    private int pageSize = 10;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 当前页数
     */
    private int currentPage = 1;

    /**
     * 分页集合列表
     */
    private List<E> list;

    /**
     * 分页跳转的URL
     */
    private String url;


}
