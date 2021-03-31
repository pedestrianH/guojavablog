package cn.guojava.controller;

import cn.guojava.entity.Blog;
import cn.guojava.mapper.DaoBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class ControllerBlog {
    @Autowired
    private DaoBlog daoBlog;
    @PostMapping("/api/insert")
    public void insert(@RequestBody Blog blog){
        daoBlog.insert(blog);
    }

    @PostMapping  ("/api/selectAll")
    public List<Blog> selectAll(@RequestBody Blog blog){
      return   daoBlog.selectAll(blog);
    }

    @PostMapping("/api/update")
    public Blog update(@RequestBody Blog blog){
       return daoBlog.update(blog);
    }
    @PostMapping("/api/updateLike")
    public void updateLike(@RequestBody Blog blog){
         daoBlog.updateLike(blog);
    }
    @PostMapping("/api/select")
    public Blog select(@RequestParam Integer id){
       return daoBlog.select(id);
    }
    @PostMapping("/api/selectFor")
    public List<Blog> selectFor(@RequestBody Blog blog){
        return daoBlog.selectFor(blog);
    }
    @GetMapping("/api/selectForAll")
    public List<Blog> selectForAll(){
        return daoBlog.selectForAll();
    }
    @GetMapping("/api/selectForRanking")
    public List<Blog> selectForRanking(){
        return daoBlog.selectForRanking();
    }
    @GetMapping("/api/selectForAllByDistinct")
    public List<String> selectForAllByDistinct(){
        return daoBlog.selectForAllByDistinct();
    }
    @PostMapping("/api/selectByAuthor")
    public List<Blog> selectByAuthor(@RequestParam String author){
        return daoBlog.selectByAuthor(author);
    }
    @PostMapping("/api/selectForAuthor")
    public List<String> selectForAuthor(@RequestParam String username){

        List<String> author1  =  daoBlog.selectForAuthor(username);
        System.out.println(author1);

        if(author1==null){
            return null;
        }else {
            return author1;
        }
    }
    @PostMapping("/api/follow")
    public void follow(@RequestParam() String author,String username){

    Integer authorFollow =  daoBlog.selectFollow(username);
    daoBlog.follow(authorFollow,author);
    }
}
