package com.ld.utils;

public class UIUtils {
    public static String  getTickUrl(String url){
        if(url.startsWith("http:")||url.startsWith("https:")){
            return url;
        }else{
            return  "https:"+url;
        }
    }
}
