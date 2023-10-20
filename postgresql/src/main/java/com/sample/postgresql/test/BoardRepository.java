package com.sample.postgresql.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JB
 * @packageName : com.sample.postgresql.test
 * @fileName : BoardRepository
 * @description :
 * @since : 2023-10-18
 */
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String> {
}
