package com.imooc.exception;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 13:32
 * @Description: 用户不存在异常处理类
 * @Copyright(©) 2018 by peter.
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }
}
