package com.sample.core.postgres.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : JB
 * @packageName : com.sample.core.postgres.test
 * @fileName : SalesService
 * @description :
 * @since : 2023-11-22
 */

@Service
public class SalesService {

    @Autowired private SalesRepository salesRepository;

    public void insert(SalesEntity param) {
        salesRepository.save(param);
    }
}
