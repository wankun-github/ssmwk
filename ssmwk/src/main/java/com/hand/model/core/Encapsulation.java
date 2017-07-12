package com.hand.model.core;

import java.util.List;

/**
 * Created by wankun on 2017/7/11.
 * 封装类
 */

public class Encapsulation<T> {
    List<T> classList;

    public List<T> getClassList() {
        return classList;
    }

    public void setClassList(List<T> classList) {
        this.classList = classList;
    }
}
