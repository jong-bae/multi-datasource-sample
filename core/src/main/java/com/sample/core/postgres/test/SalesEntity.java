package com.sample.core.postgres.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : JB
 * @packageName : com.sample.core.postgres.test
 * @fileName : sales
 * @description :
 * @since : 2023-11-22
 */
@Entity
@Table(name = "sales", schema = "jpa")
@Getter
@NoArgsConstructor @AllArgsConstructor
public class SalesEntity {

    @Id @Column(name = "SALE_ID")
    private String saleId;
    @Column(name = "SALE_NAME")
    private String saleName;
    @Column(name = "SALE_PRICE")
    private int salePrice;
}
