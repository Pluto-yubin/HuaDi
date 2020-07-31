package com.example.controller;

import com.example.entity.UserFile;
import com.example.service.UserFileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class DownloadController {

    @Autowired
    private UserFileService service;

    @GetMapping("/download")
    public void download(HttpServletResponse response, int id) throws IOException {
        response.setContentType("application/octet-stream");

        UserFile file = service.findFileById(id);
        response.setHeader("content-disposition", "attachment;filename="+
                URLEncoder.encode(file.getF_name(), "utf-8"));
        String url = ResourceUtils.getURL("classpath:").getPath()+"/static/file/"+file.getPath();
        FileInputStream inputStreamstream = new FileInputStream(new File(url));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStreamstream, outputStream);
        IOUtils.closeQuietly(inputStreamstream);
        IOUtils.closeQuietly(outputStream);
    }

    @GetMapping("delete")
    public String delete(int id) throws FileNotFoundException {

        UserFile userFile = service.findFileById(id);
        String url = ResourceUtils.getURL("classpath:").getPath()+"/static/file/"+userFile.getPath();
        File file = new File(url);
        if(file.exists()) {
            file.delete();
        }
        service.delete(id);
        return "redirect:/showAllFile";
    }
}
