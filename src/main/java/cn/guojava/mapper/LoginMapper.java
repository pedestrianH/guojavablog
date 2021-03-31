package cn.guojava.mapper;

import cn.guojava.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoginMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User user);
    @Select("select * from user where id = #{id} ")
    User selectById(Integer id);
}
