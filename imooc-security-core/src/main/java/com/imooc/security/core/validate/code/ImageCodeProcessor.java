package com.imooc.security.core.validate.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    @Override
    protected void send(ServletWebRequest request, ImageCode validateCode) throws IOException {
        //将生成的图片写到接口的响应中
        ImageIO.write(validateCode.getImage(),"JPEG",request.getResponse().getOutputStream());
    }
}
