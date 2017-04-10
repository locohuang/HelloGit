package com.example.my.hellogit;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by huangpeiquan on 17/3/26.
 */

public class MyMap implements Serializable{
    private Map<String,String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
