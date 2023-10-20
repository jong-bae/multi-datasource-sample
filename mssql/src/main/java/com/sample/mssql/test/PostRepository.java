package com.sample.mssql.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JB
 * @packageName : com.sample.mssql.test
 * @fileName : PostRepository
 * @description :
 * @since : 2023-10-18
 */
@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {
}
