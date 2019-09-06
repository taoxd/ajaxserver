package com.imooc;

import lombok.Data;

@Data
public class ResultBean {

    private String data;

    public ResultBean(String data) {
        this.data = data;
    }
}
