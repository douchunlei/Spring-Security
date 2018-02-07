package com.imooc.dto;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-01-31 17:59
 * @Description: 用户查询条件实体类
 * @Copyright(©) 2018 by peter.
 */
public class UesrQueryCondition {

    private String username;

    private Integer age;

    private Integer ageTo;

    private String xxx;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return "UesrQueryCondition{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", ageTo=" + ageTo +
                ", xxx='" + xxx + '\'' +
                '}';
    }
}
