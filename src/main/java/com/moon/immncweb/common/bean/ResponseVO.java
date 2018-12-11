package com.moon.immncweb.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "请求结果响应体")
public class ResponseVO<T> implements Serializable {
    @ApiModelProperty(value = "响应状态回执码")
    private Integer code;

    @ApiModelProperty(value = "数据体")
    private T data;

    @ApiModelProperty(value = "响应回执消息")
    private String msg;

    @ApiModelProperty(value = "响应时间戳")
    private final long timestamps = System.currentTimeMillis();
    public synchronized static <T> ResponseVO<T> e(ResponseCode statusEnum, T data) {
        ResponseVO<T> res = new ResponseVO<>();
        res.setCode(statusEnum.code);
        res.setMsg(statusEnum.msg);
        res.setData(data);
        return res;
    }

    public synchronized static <T> ResponseVO<T> e(Integer code, String msg) {
        ResponseVO<T> res = new ResponseVO<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public synchronized static <T> ResponseVO<T> e(ResponseCode statusEnum) {
        return e(statusEnum, null);
    }

    private static final long serialVersionUID = 8992436576262574064L;

}
