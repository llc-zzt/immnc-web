package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchWords implements Serializable {
    private static final long serialVersionUID = -3138161920671167281L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String content;

    private Integer searchCount;
}
