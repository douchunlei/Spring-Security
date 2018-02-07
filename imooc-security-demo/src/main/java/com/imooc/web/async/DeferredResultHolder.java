package com.imooc.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 16:09
 * @Description: 线程之间进行数据传递的处理器
 * @Copyright(©) 2018 by peter.
 */
@Component
public class DeferredResultHolder {
    //key --> 订单号，value --> 订单处理结果
    private Map<String,DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }

}
