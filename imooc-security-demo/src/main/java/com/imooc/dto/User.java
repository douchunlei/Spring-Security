package com.imooc.dto;


import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-01-31 17:45
 * @Description: 用户实体类
 * @Copyright(©) 2018 by peter.
 */
public class User {
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    private String id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @MyConstraint(message = "这是我的自定义注解")
    private String password;

    @NotNull(message = "生日不能为空")
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
