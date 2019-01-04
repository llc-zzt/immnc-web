package com.moon.immncweb.core.controller.api;

import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.form.AvatarForm;
import com.moon.immncweb.core.form.SubImageForm;
import com.moon.immncweb.core.service.UserInfoService;
import com.moon.immncweb.core.utils.UploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/12/24
 * @Desc
 */
@RestController
@RequestMapping("/moon/user")
@Api(tags = {"用户相关操作"})
public class UserAPIController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/upload/avatar/{userId}")
    @ApiOperation(value = "上传头像")
    public ResponseVO<String> uploadAvatar(@ApiParam(value = "avatar_data") @RequestParam String avatar_data,
                                           @ApiParam(value = "avatar_file") @RequestParam MultipartFile avatar_file,
                                           @PathVariable String userId) {
        return userInfoService.updateUserAvatar(userId,avatar_file,avatar_data);
    }
}
