package com.koreaIT.java.BAM;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class util {
    public static String getDate() {
        
    	Date now = new Date();
 
        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
 
        // 포맷팅 적용
        String formatedNow = formatter.format(now);
        return formatter.format(now);
    }
}