package com.poplar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create BY poplar ON 2020/3/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = -6326600450195023830L;

    private Long id;

    /*流水号*/
    private String serialNumber;
}
