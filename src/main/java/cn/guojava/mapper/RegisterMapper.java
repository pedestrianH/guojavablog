package cn.guojava.mapper;

import cn.guojava.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RegisterMapper {
    @Insert("INSERT INTO user(username,password) VALUES(#{username},#{password})")
    void registerUser(User user);
}
