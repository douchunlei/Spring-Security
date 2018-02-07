package com.imooc.security.core.properties;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-06 11:00
 * @Description: 验证码默认配置
 * @Copyright(©) 2018 by peter.
 */
public class ImageCodeProperties extends SmsCodeProperties{

    //图片宽度
    private Integer width = 67;

    //图片高度
    private Integer height = 40;

    //干扰线条数
    private Integer lineCount = 50;

    public ImageCodeProperties() {
        setLength(4);
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    public Integer getLineCount() {
        return lineCount;
    }

    public void setLineCount(Integer lineCount) {
        this.lineCount = lineCount;
    }
}
