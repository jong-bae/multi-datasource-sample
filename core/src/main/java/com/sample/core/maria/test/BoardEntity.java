package com.sample.core.maria.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : JB
 * @packageName : com.sample.postgresql.test
 * @fileName : BoardEntity
 * @description :
 * @since : 2023-10-18
 */
@Entity
@Table(name = "board")
@Data
@NoArgsConstructor @AllArgsConstructor
public class BoardEntity {

    @Id @Column(name = "BOARD_ID")
    private String boardId;
    @Column(name = "BOARD_NAME")
    private String boardName;
}
