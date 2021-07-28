package com.example.datastructure.mapper;


import com.example.datastructure.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import com.example.datastructure.model.article;

@Mapper
public interface ArticleMapper {
    @Select("select * from article where type=#{type}")
    public List<article> getArticle(String type);

    @Insert("insert into article (type,details) values (#{type},#{details})")
    void addArticle(article at);

    @Update("update article set type=#{type},details=#{details} where id=#{id}")
    void updateArticleById(int id,String type,String details);

    @Delete("delete from article where id=#{id}")
    void deleteArticle(int  id);

    @Select("select * from article")
    public List<article> getAllarticle();

    @Select("select * from article where id=#{id}")
    article getArticleById(int id);


/*
    @Select("select count(*) from article")
    int articlecount();
   ;

 */
}
