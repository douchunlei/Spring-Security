package com.imooc.web.cotroller;

import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 14:41
 * @Description: 文件上传控制器
 * @Copyright(©) 2018 by peter.
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "E:\\java_develop\\idea_workspace\\imooc-security\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\cotroller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        //file.getInputStream();
        File localFile = new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try(
                InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
                OutputStream outputStream = response.getOutputStream();){
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }
}
