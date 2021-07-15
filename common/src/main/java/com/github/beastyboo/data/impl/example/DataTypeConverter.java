package com.github.beastyboo.data.impl.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTypeConverter<T> {

    private  final T defaultValue;

    public DataTypeConverter(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<T> getList() {
        return new ArrayList<T>();
    }

}
