package com.example.mapper;

import com.example.entity.UserFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserFileMapper {
     List<UserFile> showAllFile();

    void  deleteFileById(int id);

    void saveFile(UserFile file);

    UserFile findFileById(int id);

    void delete(int id);
}
