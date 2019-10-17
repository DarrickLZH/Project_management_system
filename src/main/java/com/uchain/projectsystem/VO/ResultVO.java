package com.uchain.projectsystem.VO;

import lombok.Data;

/**
 * @author LZH
 * @description
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
