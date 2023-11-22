package com.sample.core.postgres.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JB
 * @packageName : com.sample.core.postgres.test
 * @fileName : SalesRepository
 * @description :
 * @since : 2023-11-22
 */
@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, String> {
}
