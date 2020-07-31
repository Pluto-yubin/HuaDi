package com.example.controller;

import com.example.Message;
import com.example.entity.User;
import com.example.entity.UserFile;
import com.example.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

@Controller
public class FileUploadController {
    private int fileid = 2;
    @Autowired
    private UserFileService service;

    UserFile userFile;
    @RequestMapping("/upload")

    public Object upload(@RequestParam(value = "fileName") MultipartFile fileUpload,
                        HttpSession session) throws FileNotFoundException {

        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID().toString().replace("-", "")+fileName;
        //指定本地文件夹存储图片
        String s = ResourceUtils.getURL("classpath:").getPath() + "/static/file";
  //      String filePath = "D:\\JavaWebCode\\HuaDi_proj\\src\\main\\resources\\static\\file";
        String dataDirPath = s+"/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dateFile = new File(dataDirPath);
        if(!dateFile.exists()) {
            dateFile.mkdirs();
        }
        long size = fileUpload.getSize();
        //file type
        String type = fileUpload.getContentType();
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(dataDirPath, fileName));
            userFile = new UserFile();
            service = new UserFileService();
//            userFile.setId(fileUpload.hashCode() % 100000000);
            userFile.setId(fileid);
            fileid++;
            session.setAttribute("fid", userFile.getId());
            userFile.setF_name(fileName);
            userFile.setSize((int) size);
            userFile.setType(type);
            User user = (User) session.getAttribute("user");
            userFile.setUid(user.getUid());
            userFile.setPath(new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"/"+fileName);
            session.setAttribute("addFile", userFile);
            return "user";
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(-1,"fail to upload");
        }
    }
}
