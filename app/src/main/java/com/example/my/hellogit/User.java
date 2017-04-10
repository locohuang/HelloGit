package com.example.my.hellogit;

import java.io.Serializable;

/**
 * Created by huangpeiquan on 17/3/26.
 */

public class User implements Serializable{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
