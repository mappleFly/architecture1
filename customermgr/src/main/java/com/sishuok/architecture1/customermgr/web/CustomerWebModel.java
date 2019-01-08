package com.sishuok.architecture1.customermgr.web;

import lombok.Data;

@Data
public class CustomerWebModel {

    private String queryJsonStr="";
    private int nowPage = 1;
    private int pageShow = 0;
}
