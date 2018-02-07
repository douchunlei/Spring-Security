package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;


@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    @Override
    protected void send(ServletWebRequest request, ImageCode validateCode) throws IOException {
        //将生成的图片写到接口的响应中
        ImageIO.write(validateCode.getImage(),"JPEG",request.getResponse().getOutputStream());
    }

}
