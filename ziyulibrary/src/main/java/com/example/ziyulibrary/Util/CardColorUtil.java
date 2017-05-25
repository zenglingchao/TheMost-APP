package com.example.ziyulibrary.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyu on 2016/10/27.
 */

public class CardColorUtil {

    public static List<Integer> colorList(List<Integer> oldlist ,int size){
        if(oldlist == null){
            oldlist = new ArrayList<>();
        }
        for (int i = 0; i < size; i++) {
            oldlist.add((int) -(Math.random() * (16777216 - 1) + 1));
        }
        return oldlist;
    }
}
