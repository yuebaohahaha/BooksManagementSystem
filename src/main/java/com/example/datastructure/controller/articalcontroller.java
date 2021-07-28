package com.example.datastructure.controller;

import com.example.datastructure.mapper.ArticleMapper;

import com.example.datastructure.model.User;
import com.example.datastructure.model.article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
@Controller
public class articalcontroller {
    @Autowired
    private ArticleMapper articlerMapper;

    @RequestMapping("/articleHtml")
    public String reg11(Model model){
        List<article> articles = articlerMapper.getAllarticle();
        model.addAttribute("articles",articles);
        return "article";
    }
    @RequestMapping("/addArticle")
    public String addArticle(HttpServletRequest request){

        String type = request.getParameter("type");
        String details= request.getParameter("details");
        article a=new article();
        a.setType(type);
        a.setDetails(details);
        articlerMapper.addArticle(a);
        return "redirect:/articleHtml";//重定向
    }

    @RequestMapping("/query")
    public String showlist(HttpServletRequest request,Model model){
        String biaoti = request.getParameter("biaoti");
        List<article> articles = articlerMapper.getArticle(biaoti);
        model.addAttribute("articles",articles);
        return "article";
    }

    @RequestMapping("/shanchu")
    public  String deletearticle(article ac){

        int id = ac.getId();
        articlerMapper.deleteArticle(id);
        //重定向
        return "redirect:/articleHtml";

    }

    @RequestMapping("/gengxin")
    public String update(article ac,Model model,Map<String,Object> map){
        int id = ac.getId();
        System.out.println(id);
        //List<article> articles = articlerMapper.getArticleById(biaoti);
        article ac1 = articlerMapper.getArticleById(id);
        System.out.println("内容："+ac1.getDetails());
        map.put("id",id);
        map.put("type",ac1.getType());
        map.put("details",ac1.getDetails());
        return "uparticle";

    }
    @RequestMapping("/updateArticleById")
    public String updateArticle(HttpServletRequest request,Map<String,Object> map){
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        String details = request.getParameter("details");
        articlerMapper.updateArticleById(id,type,details);
        return "redirect:/articleHtml";
    }


}
