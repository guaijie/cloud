package com.example.server.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultByPageVO<T>{

    private Integer code;

    private String msg;

    private List<T> dataList;

    private long totalNumber;

    private Integer currentNumber;

    private Integer currentPage;
}
