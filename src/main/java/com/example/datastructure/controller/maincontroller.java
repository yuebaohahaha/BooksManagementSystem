package com.example.datastructure.controller;

import com.example.datastructure.mapper.UserMapper;
import com.example.datastructure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class maincontroller {
    @Autowired
    private UserMapper userMapper;
    //用户登录
    @RequestMapping("/loginHtml")
    public String login(HttpServletRequest request,Map<String,Object> map){

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username);
            if(username!=null && password!=null){
                // System.out.println("进来了");
                User loginuser = userMapper.login(username, password);
                if(loginuser!=null){
                    return "left";
                }else{
                    map.put("msg2","您输入的用户名不存在或密码错误" );
                }
            }
             return "login";
    }


    @RequestMapping("/updateuser")
    public String updata(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nepassword  = request.getParameter("newpassword");
        User getuser = userMapper.login(username,password);
        if(getuser!=null){
            userMapper.updateuser(username,nepassword);
             return"login";
        }else{
            map.put("msg1","您输入的用户名不存在或原密码错误" );
            return"imgtable";
        }
    }
    @RequestMapping("/registerHtml")
    public String  insert(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       // System.out.println("&"+username);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userMapper.getuser(username);
        if(user1!=null){
          //  System.out.println("进来！！！！");
            map.put("mag3","此用户已存在");
            return "register";
        }else{
            userMapper.adduser(user);
            return"login";
        }
    }



    @RequestMapping("/registerhtml")
    public String regi(){
        return "register";
    }

    @RequestMapping("/leftHtml")
    public String reg1(){
        return "left";
    }
    @RequestMapping("/imgtableHtml")
    public String reg2(){
        return "imgtable";
    }
    @RequestMapping("/tabHtml")
    public String reg3(){
        return "tab";
    }
    @RequestMapping("/paixuHtml")
    public String reg4(){
        return "paixu";
    }
    @RequestMapping("/chazhaoHtml")
    public String reg5(){
        return "chaozhao";
    }
    @RequestMapping("/shuHtml")
    public String reg6(){
        return "shu";
    }
    @RequestMapping("/xianxingbiaoHtml")
    public String reg7(){
        return "xianxingbiao";
    }
    @RequestMapping("/duilieHtml")
    public String reg8(){
        return "duilie";
    }
    @RequestMapping("/jiheHtml")
    public String reg9(){
        return "jihe";
    }
    @RequestMapping("/tuHtml")
    public String reg10(){
        return "tu";
    }
    @RequestMapping("/uparticleHtml")
    public String reg14(){
        return "uparticle";
    }

}
