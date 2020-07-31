package com.example.controller;

import com.example.entity.FeedBack;
import com.example.entity.User;
import com.example.entity.UserFile;
import com.example.service.FeedbackService;
import com.example.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @Autowired
    UserFileService userFileService;
    @RequestMapping("/addFeedback")
    public String addFeedback(@RequestParam(value = "msg") String msg,
                              @RequestParam(value = "fid") int fid,
                              Model model) {
        UserFile userFile = userFileService.findFileById(fid);
        if( userFile == null) {
            model.addAttribute("error", "你输入的文件id不存在");
            return "fireman";
        }
        FeedBack feedback = new FeedBack();
        feedback.setFid(fid);
        feedback.setMsg(msg);
        service.addFeedback(feedback);
        return "fireman";
    }
    @RequestMapping("getFid")
    public String getFeedback(@RequestParam(value = "uid") int uid,
                              Model model, HttpSession session) {
        List<Integer> fid = service.getFid(uid);
         User user = (User) session.getAttribute("user");
         if(user.getUid() != uid) {
             return "fidError";
         }
        List<FeedBack> list = new ArrayList<FeedBack>();
        for (int id:
             fid) {
            list.add(service.getFeedback(id));
        }
        model.addAttribute("feedback",list);
        return "user";
    }
}
