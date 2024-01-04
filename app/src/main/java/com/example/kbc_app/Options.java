package com.example.kbc_app;

import java.io.Serializable;

public class Options implements Serializable {
    int id;
    String options;
    boolean check;

    public Options(int id, String options, boolean check) {
        this.id = id;
        this.options = options;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
