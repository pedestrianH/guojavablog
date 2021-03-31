package cn.guojava.entity;

import lombok.Data;


@Data
public class Blog {

    private Integer id;
    private Integer rank;
    private String author;
    private String content;
    private String createT;

    private String title;
}
