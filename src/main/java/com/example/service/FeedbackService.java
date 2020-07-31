package com.example.service;

import com.example.entity.FeedBack;
import com.example.mapper.FeedBackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86177
 */

@Service
public class FeedbackService {

    @Autowired
    FeedBackMapper feedBackMapper;

    public FeedBack getFeedback(int fid) {
        return feedBackMapper.getFeedBack(fid);
    }

    public void addFeedback(FeedBack feedBack) {
        feedBackMapper.addFeedBack(feedBack);
    }

    public List<Integer> getFid(int uid) {
        return feedBackMapper.getFid(uid);
    }
}
