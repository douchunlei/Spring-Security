package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 15:17
 * @Description: 异步处理控制器
 * @Copyright(©) 2018 by peter.
 */
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    //同步请求
    @RequestMapping("/order1")
    public String order1() throws InterruptedException {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程结束");
        return "success";
    }

    //使用 Runnable 进行异步请求处理
    @RequestMapping("/order2")
    public Callable<String> order2() throws InterruptedException {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                //模拟业务逻辑请求的耗时
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "success";
            }
        };
        logger.info("主线程结束");
        return result;
    }

    //用 DeferredResult 进行异步处理
    @RequestMapping("/order3")
    public DeferredResult<String> order3() throws InterruptedException {
        logger.info("主线程开始");
        //生成订单号
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> deferredResult = new DeferredResult();
        deferredResultHolder.getMap().put(orderNumber,deferredResult);
        logger.info("主线程结束");
        return deferredResult;
    }
}
