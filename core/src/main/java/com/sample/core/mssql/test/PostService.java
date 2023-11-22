package com.sample.core.mssql.test;

import com.sample.core.mssql.test.PostEntity;
import com.sample.core.mssql.test.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : JB
 * @packageName : com.sample.mssql.test
 * @fileName : PostService
 * @description :
 * @since : 2023-10-18
 */
@Service
public class PostService {
    @Autowired private PostRepository postRepository;


    public void insert(PostEntity param) {
        postRepository.save(param);
    }

    public List<PostEntity> load() {
        return postRepository.findAll();
    }
}
