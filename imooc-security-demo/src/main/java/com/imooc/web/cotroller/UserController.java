package com.imooc.web.cotroller;

import com.imooc.dto.UesrQueryCondition;
import com.imooc.dto.User;
import com.imooc.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-01-31 17:43
 * @Description: 用户前端控制器
 * @Copyright(©) 2018 by peter.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /*@RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> query(@RequestParam(required = false,defaultValue = "tom",name = "username") String uname){
        System.out.println(uname);
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }*/

    /*@RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> query(UesrQueryCondition uesrQueryCondition){
        System.out.println(ReflectionToStringBuilder.toString(uesrQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(uesrQueryCondition);
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }*/

    @GetMapping()
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UesrQueryCondition uesrQueryCondition, @PageableDefault(page = 1,size = 15,sort = "username,asc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(uesrQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(uesrQueryCondition);
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String idxxxx){
        throw new UserNotExistException(idxxxx);
//          throw new RuntimeException("user not exist");
//        System.out.println("进入getInfo服务");
//        User user = new User();
//        user.setUsername("tom");
//        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(error -> System.out.println(error));
            //System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(error ->{
//                        FieldError fieldError = (FieldError) error;
//                        String message = fieldError.getField() +" "+fieldError.getDefaultMessage();
//                        System.out.println(message);
                        System.out.println(error.getDefaultMessage());
                    }
                   );
            //System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        user.setId("1");
        return user;
    }
}
