package com.chusai.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class JSOUPUtils {

	public static String getHtml(String url) {
		
		Connection connection = Jsoup.connect(url);	
		Map<String, String> cookies = new HashMap<String,String>();
        Map<String, String> header = new HashMap<String, String>();
        header.put("Host", "http://info.bet007.com");
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
        header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        header.put("Accept-Language", "zh-cn,zh;q=0.5");
        header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
        header.put("Connection", "keep-alive");
		connection.headers(header);
		Response response = null;
		try {
			
			response = connection.ignoreContentType(true).method(Method.GET).data().cookies(cookies).postDataCharset("GBK").execute();
			return response.body();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/* public static String getHTML(String url) throws Exception { 
		    URL uri = new URL(url); 
		    URLConnection connection = uri.openConnection(); 
		    
		    InputStream in = connection.getInputStream(); 
		    byte[] buf = new byte[2048]; 
		    int length = 0; 
		    StringBuffer sb = new StringBuffer(); 
		    while ((length = in.read(buf, 0, buf.length)) > 0) { 
		      sb.append(new String(new String(buf, "gbk").getBytes(),"UTF-8")); 
		    } 
		    in.close(); 
		    return sb.toString(); 
		  } */
}
