package com.example.controller;

import com.example.entity.Rent;
import com.example.entity.User;
import com.example.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class RentController {

    @Autowired
    private RentService service;
    private int obj1 = 2;
    private int obj2 = 3;
    @RequestMapping("/rent")
    public String rent(@RequestParam(value = "object") String object, HttpSession session) {
        Rent rent = new Rent();
        rent.setObject(object);
        User user = (User) session.getAttribute("user");
        if(user == null) {
            return "login";
        }
        if(!"消防".equals(user.getUtype())) {
            return "rentError";
        }
        rent.setUid(user.getUid());
        switch (object) {
            case "切割机" : rent.setOid(obj1);
            obj1+=2;
            break;
            case "千斤顶" : rent.setOid(obj2);
            obj2+=2;
            break;
        }
        service.addRent(rent);
        return "success";
    }

    @RequestMapping("/getAllRent")
    public String getAllRent(Model model) {
        List<Rent> list = service.getAllRent();
        model.addAttribute("rent", list);
        return "showAllrent";
    }
}
