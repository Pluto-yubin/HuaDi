package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;


import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller

public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/getAllUser")
    public String getAllUser(Model model) {
         List<User> allUser = service.getAllUser();
         model.addAttribute("users", allUser);
        return "showAllUser";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam(value = "id") int id) {
        System.out.println(id);
        service.deleteUser(id);
        return "success";
    }
//    @RequestMapping("/showUser")
//    public void showAllUser(HttpServletResponse response) throws IOException {
//        List<User> users = service.getAllUser();
//        String data = JSONArray.toJSONString(users);
//        response.setCharacterEncoding("utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.append(data);
//    }
    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value = "uid") Integer id,
                         @RequestParam(value = "upassword") String password,
                            @RequestParam(value = "utype") String type,
                            @RequestParam(value = "unumber") String number) {
        List<User> allUser = service.getAllUser();
        for (User user:
             allUser) {
            if(user.getUid().equals(id)) {
                return "404";
            }
        }
        User user = new User();
        user.setUnumber(number);
        user.setUpassword(password);
        user.setUtype(type);
        user.setUid(id);
        service.addUser(user);
        System.out.println("success");
        return "login";
    }

    @RequestMapping("/checkUser")
    public String checkUser(@RequestParam(value = "id") int id,
                        @RequestParam(value = "password") String password,
                            @RequestParam(value = "type") String type,
                            HttpSession session) {

        List<User> allUser = service.getAllUser();
        for (User u :
                allUser) {
            if(u.getUid() == id && u.getUpassword().equals(password)) {
                session.setAttribute("user", u);
                if(type.equals("消防")) {
                    return "fireman";
                } else if(type.equals("用户")){

                    return "user";
                } else if(type.equals("管理员")) {

                    return "admin";
                }
            }
        }
        return "redirect:/login";
    }
}
