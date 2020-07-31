package com.example.mapper;

import com.example.entity.FeedBack;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedBackMapper {
    /**
     * @return
     * 或许反馈信息
     */
    FeedBack getFeedBack(int fid);

    void addFeedBack(FeedBack feedBack);

    List<Integer> getFid(int uid);
}
