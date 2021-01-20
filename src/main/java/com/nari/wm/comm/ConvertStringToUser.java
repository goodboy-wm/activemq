package com.nari.wm.comm;


import com.nari.wm.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ConvertStringToUser implements Converter<String, User> {
    @Override
    public User convert(String s) {
        String[] split = s.split("-");
        User user = new User();
        user.setName(split[0]);
        user.setSex(split[1]);
        user.setAge(Integer.parseInt(split[2]));
        return user;
    }


}
