package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author zhaoxiang
 * @Date 2018/11/09
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classify implements Serializable {
    private static final long serialVersionUID = -8600161604611139977L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String classify;
}
