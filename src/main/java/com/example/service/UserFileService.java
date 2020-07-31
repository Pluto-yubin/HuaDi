package com.example.service;

import com.example.entity.UserFile;
import com.example.mapper.UserFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class UserFileService {

    @Resource
    UserFileMapper mapper;

    public List<UserFile> getAllFile() {
        return mapper.showAllFile();
    }

    public void saveFile(UserFile file) {
        mapper.saveFile(file);
    }
    public UserFile findFileById(int id) {
        return mapper.findFileById(id);
    }

    public void delete(int id) {
        mapper.delete(id);
    }
}
