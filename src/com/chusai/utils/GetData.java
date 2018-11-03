package com.chusai.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetData {

	  public static List<String> getUrl(String HTML) { 
	    Matcher matcher = Pattern.compile("<a class=\"item_pic\" target=\"_blank\" hidefocus=\"true\" href=\"(\\S+)\".*").matcher(HTML); 
	    
	    List<String> listUrl = new ArrayList<String>(); 
	    
	    while (matcher.find()) { 
	    	
	      listUrl.add("http://gouwu.sogou.com/"+matcher.group(1)); 
	      
	    } 
	    return listUrl; 
	    
	  } 
	  
	  
	
}
