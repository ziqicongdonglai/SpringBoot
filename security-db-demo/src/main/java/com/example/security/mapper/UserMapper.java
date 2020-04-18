package com.example.security.mapper;

import com.example.security.model.Role;
import com.example.security.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/16 11:34
 * @description
 */
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);

    @Select({"select * from role r",
             "left join user_role ur",
             "on r.id = ur.rid",
             "where ur.uid = #{id}"})
    List<Role> getUserRolesById(Integer id);
}
