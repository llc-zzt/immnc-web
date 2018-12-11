package com.moon.immncweb.common.exception;

import com.moon.immncweb.common.bean.ResponseCode;
import lombok.*;

import java.io.Serializable;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 6802603991958193825L;
    private Integer status;
    private String msg;
    private Exception e;

    public APIException(ResponseCode statusEnum, Exception e) {
        this.status = statusEnum.code;
        this.msg = statusEnum.msg;
        this.e = e;
    }


    public APIException(ResponseCode statusEnum) {
        this.status = statusEnum.code;
        this.msg = statusEnum.msg;
    }

    public synchronized static APIException fail(String msg) {
        return APIException.builder()
                .status(ResponseCode.FAIL.code)
                .msg(msg)
                .build();
    }

    public synchronized static APIException fail(String msg, Exception e) {
        return APIException.builder()
                .status(ResponseCode.FAIL.code)
                .msg(msg)
                .e(e)
                .build();
    }

    public synchronized static APIException fail(Integer code, String msg, Exception e) {
        return APIException.builder()
                .status(code)
                .msg(msg)
                .e(e)
                .build();
    }
}
