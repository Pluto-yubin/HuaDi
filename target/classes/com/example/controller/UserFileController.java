package com.example.controller;

import com.example.entity.UserFile;
import com.example.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 86177
 */

@Controller
public class UserFileController {
    @Autowired
    private UserFileService service;

    @RequestMapping("showAllFile")
    public String showAllFile(Model model, HttpSession session) {
        List<UserFile> list = service.getAllFile();
        model.addAttribute("files", list);
        return "showAllFile";
    }


    @RequestMapping("addFile")
    public String addFile(HttpSession session , Model model) {
        UserFile file = (UserFile) session.getAttribute("addFile");
        service.saveFile(file);
        model.addAttribute("msg", "success");
        return "user";
    }

//    @RequestMapping("feedback")
//    public String feedback(@RequestParam(value = "fid") String fid,
//                           @RequestParam(value = "feedback") String feedback,
//                           HttpSession session) {
//        session.setAttribute("feedback", feedback);
//
//        return "fireman";
//    }
}
