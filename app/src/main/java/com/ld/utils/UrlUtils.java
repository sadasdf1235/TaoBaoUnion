package com.ld.utils;

public class UrlUtils {
    public static String getUrl(int materialIdm,int page){
        return "discovery/"+materialIdm+"/"+page;
    }
}
