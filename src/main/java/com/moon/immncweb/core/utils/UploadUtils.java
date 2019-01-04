package com.moon.immncweb.core.utils;

import com.alibaba.fastjson.JSON;
import com.moon.immncweb.common.utils.QiniuUpload;
import com.moon.immncweb.core.config.UploadConfig;
import com.moon.immncweb.core.config.WebUrlConfig;
import com.moon.immncweb.core.form.SubImageForm;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author zhaoxiang
 * @Date 2018/12/25
 * @Desc 上传工具
 */
@Slf4j
@Builder
@Component
public class UploadUtils {

    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private WebUrlConfig urlConfig;
    @Autowired
    private QiniuUpload qiniuUpload;

    public String uploadAvatar(MultipartFile file, String subData) throws IOException {
//      获取图片
        if (subData == null) {
            return null;
        }
        SubImageForm subImageForm = JSON.parseObject(subData, SubImageForm.class);
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        BufferedImage subIMG = bufferedImage.getSubimage(subImageForm.getX(), subImageForm.getY(), subImageForm.getWidth(), subImageForm.getHeight());
        String fileName = KeyUtil.genUniqueKey() + ".jpg";
        File dir = new File(uploadConfig.getPath());
        //判断目录是否存在
        if (!dir.exists()) {
            // 如果不存在，自动创建
            dir.mkdirs();
        }
        if (ImageIO.write(subIMG, "JPEG", new File(uploadConfig.getPath() + File.separator + fileName))) {
            File dbFile = new File(uploadConfig.getPath() + File.separator + fileName);
            qiniuUpload.uploadFile(dbFile.getAbsoluteFile(),"po"+File.separator + fileName);
            return urlConfig.getImgPrefix()+File.separator+fileName;
        } else {
            return null;
        }

    }
}
