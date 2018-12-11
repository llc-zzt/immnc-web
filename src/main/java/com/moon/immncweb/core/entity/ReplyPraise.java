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
public class ReplyPraise implements Serializable {
    private static final long serialVersionUID = -1668695994121004704L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 被赞回复id
     */
    private String replyId;

    /**
     * 赞用户id
     */
    private String uid;

}
