package com.java668.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 *
 * @author zlt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResp<T> implements Serializable {
    private static final long serialVersionUID = -275582248840137389L;
    /**
     * 总数
     */
    private Long count;

    /**
     * 当前页结果集
     */
    private List<T> list;
}
