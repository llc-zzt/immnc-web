package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Author  Administrator
 * @Date    2018/5/22 12:11
 * @Desc    评论赞
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentPraise implements Serializable {
    private static final long serialVersionUID = 9006096186676900486L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 被赞评论id
     */
    private String commentId;

    /**
     * 赞用户id
     */
    private String uid;

}
