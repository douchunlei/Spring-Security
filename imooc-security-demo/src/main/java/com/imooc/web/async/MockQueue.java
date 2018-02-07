package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 15:39
 * @Description: 模拟消息队列
 * @Copyright(©) 2018 by peter.
 */
@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //模拟下单的消息(当 placeOrder 中有值,则认为有新的订单)
    private String placeOrder;

    //模拟订单完成的消息(当 completeOrder 中有值,则认为有订单完成)
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() ->{
            logger.info("接到新的订单:"+placeOrder);
            try {
                Thread.sleep(1000);//模拟下单请求过程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕："+placeOrder);
        }).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
