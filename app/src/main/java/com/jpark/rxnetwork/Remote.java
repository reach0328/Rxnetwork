package com.jpark.rxnetwork;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JH on 2017-03-20.
 */

public class Remote {

    public static String getUrlByGet(String siteUrl) {
        String result = "";
        if(!siteUrl.startsWith("http")){
           siteUrl = "http://"+siteUrl;
        }
        try {
            URL url = new URL(siteUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // GET : 데이터 요청시 사용하는 방식
            int responseCode = connection.getResponseCode();
            if(responseCode ==HttpURLConnection.HTTP_OK){
                // 연결로 부터 스트림을 얻고, 버퍼래퍼로 감싼다.
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder temp = new StringBuilder();
                String lineOfdata = "";
                // 번복문을 돌며넛 버퍼의 데이터를 읽어온다.
                while((lineOfdata = br.readLine()) != null) {
                    temp.append(lineOfdata);
                }
                return result.toString();
            } else {
                Log.e("HTTPConnection","Error Code "+ responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
