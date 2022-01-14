package com.example.amharickeyboard;

import java.util.ArrayList;

public class KeyFamily {
    private int code;
    public KeyFamily(int code){
        this.code = code-5;
    }

    public ArrayList createFamily(){
        ArrayList newArray = new ArrayList();
        for (int i = 0; i < 7; i++) {
            newArray.add(code+i);
        }
        return newArray;
    }
}
