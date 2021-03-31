package cn.guojava.mapper;

import cn.guojava.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DaoBlog {

    @Insert("INSERT INTO blog(content, author,createT,title) VALUES(#{content},#{author},#{createT},#{title})")
    void insert(Blog blog);
    @Select("select * from blog where author = #{author}" )
    List<Blog> selectAll(Blog blog);
    @Update("Update  blog set content = #{content} where id = #{id}")
    Blog update(Blog blog);

    @Select("select * from blog  where id = #{id}")
    Blog select(Integer id);
    @Select("select * from blog")
    List<Blog> selectForAll();
    @Update("Update  blog set rank = #{rank} where id = #{id}")
    void updateLike(Blog blog);
    @Select("select * from blog order by rank desc LIMIT 11")
    List<Blog> selectForRanking();

//    select author from follow where authorFollow =
            @Select("select author from follow where authorFollow = (select id from user where username = #{username})")
    List<String> selectForAuthor(String username);
    //sql注入的问题问了 判断用户的这个登录状态
//    @Select("select * from blog where content like  '%fff%' CONCAT('%',#{content},'%') ")
//    List<Blog> selectFor(Blog blog);
    @Select("select * from blog where content like   CONCAT('%',#{content},'%') ")
    List<Blog> selectFor(Blog blog);
    @Select("select DISTINCT author from blog")
    List<String> selectForAllByDistinct();
    @Select("select *  from blog where author = #{author} ")
    List<Blog> selectByAuthor(String author);
    @Insert("INSERT INTO follow(author,authorFollow) VALUES(#{author},#{authorFollow})")
    void follow(Integer authorFollow,String author);
    @Select("select id  from user where username = #{username} ")
    Integer selectFollow(String username);
}
