package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-01 10:22
 * @Description: Hello业务逻辑层
 * @Copyright(©) 2018 by peter.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello "+ name;
    }
}
