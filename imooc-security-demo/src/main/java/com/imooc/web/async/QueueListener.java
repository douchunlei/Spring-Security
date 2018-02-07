package com.imooc.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 16:19
 * @Description: 队列消息监听器
 * @Copyright(©) 2018 by peter.
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{
    //ContextRefreshedEvent -- spring 初始化完毕的事件

    private Logger logger = LoggerFactory.getLogger(Logger.class);

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //系统启动完毕，要做的业务
        new Thread(() ->{
            while(true){
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                    //有处理完成的订单
                    String orderNumber = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果:"+orderNumber);
                    //DeferredResult进行setResult操作时,说明异步处理已经完成，要向浏览器返回结果了
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                }else{
                    //无处理完成的订单 休眠100ms
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

    }
}
