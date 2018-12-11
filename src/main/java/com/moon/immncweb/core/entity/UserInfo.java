package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhaoxiang
 * @Date 2018/11/09
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "user")
public class UserInfo implements Serializable {
    @TableId
    private String userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String nikeName;

    /**
     * 个人中心背景图
     */
    private String backgroundImg;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 状态  1 0
     */
    private Integer status = 0;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 伪删除
     */
    private Integer showStatus = 1;

    /**
     * 前台后台账号分离
     */
    private String userType;

    /**
     * 姓名
     */
    private String name;


    /**
     * 我的粉丝数量
     */
    private Integer fansCounts = 0;

    /**
     * 我关注的人总数
     */
    private Integer followCounts = 0;

    private String createDate; //创建时间

    private String updateDate; //修改时间
    @TableField(value = "qq")
    private String QQ;
    private String email;
    private String city;
    private String birthday;
    /**
     * 0:女 1:男
     */
    private Integer sex;

    private String bankCardNumber;//银行卡号

    private String bankType;//开户银行

    private String bankUserName;//开户姓名

    private String aliPay;//支付宝

    @TableField(value = "qq_access_token")
    private String qqAccessToken;

    @TableField(value = "qq_openid")
    private String qqOpenID;

    @TableField(value = "we_chat_openid")
    private String weChatOpenID;

    //vip等级
    private Integer vip;

    //    喜欢TF-IDF值
    private String prefList;
    //    上一次登录时间
    private Date latestLogTime;
    private static final long serialVersionUID = 1L;
}
