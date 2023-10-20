package com.sample.mssql.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : JB
 * @packageName : com.sample.mssql.test
 * @fileName : PostEntity
 * @description :
 * @since : 2023-10-18
 */

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor @AllArgsConstructor
public class PostEntity {

    @Id
    @Column(name = "POST_ID")
    private String postId;
    @Column(name="POST_NAME")
    private String postName;
}
