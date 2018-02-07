package com.imooc.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-04 16:35
 * @Description: 图形验证码实体类
 * @Copyright(©) 2018 by peter.
 */
public class ImageCode extends ValidateCode{

    //存放验证码的图片
    private BufferedImage image;


    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
