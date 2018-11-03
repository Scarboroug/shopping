package com.chusai.caiji;

import java.util.List;
import java.util.Scanner;

import com.chusai.utils.GetData;
import com.chusai.utils.IOUtiles;
import com.chusai.utils.JSOUPUtils;

public class Demo1 {
	static String html1 = null;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.手机");
		System.out.println("2.电脑");
		System.out.println("3.电视");
		System.out.println("4.相机");
		System.out.println("请输入要查询的类型");
		int n =scanner.nextInt();
		method(n);
	}

	public static void method(int n) {

		switch (n) {
		case 1:
			for (Integer i = 1; i <= 5; i++) {
				String url = "http://gouwu.sogou.com/shop?query=%CA%D6%BB%FA&host=www.baidu.com&pid=&sut=1431&sst0=1534562329660&page="
						+ i + "&w=01029901&dr=1&sourceid=sr_bpage&interV=";
			
			String html = JSOUPUtils.getHtml(url);
			List<String> list = GetData.getUrl(html);
			IOUtiles.Download(list,n);
			}
			break;
		case 2:
			for (Integer i = 1; i <= 5; i++) {
				String url = "http://gouwu.sogou.com/shop?display=grid&oq=%B1%CA%BC%C7%B1%BE&stj0=0&query=%B1%CA%BC%C7%B1%BE%B5%E7%C4%D4&host=www.baidu.com&stj=0%3B4%3B0%3B0&pid=&stj1=4&hp=200&hp1=&sut=5958&ri=0&sst0=1534644446887&page="+i+"&w=01025001&dr=1&sourceid=sr_bpage&interV=";	
			String html = JSOUPUtils.getHtml(url);
			List<String> list = GetData.getUrl(html);
			IOUtiles.Download(list,n);
			}
			break;
		case 3:
			for (Integer i = 1; i <= 5; i++) {
				String url = "http://gouwu.sogou.com/shop?display=grid&query=%B5%E7%CA%D3&host=www.baidu.com&pid=&sut=19425&sst0=1534725063809&page="+i+"&w=01029901&dr=1&sourceid=sr_bpage&interV=";
			String html = JSOUPUtils.getHtml(url);
			List<String> list = GetData.getUrl(html);
			IOUtiles.Download(list,n);
			}
			break;
		case 4:
			for (Integer i = 1; i <= 5; i++) {
				String url = "http://gouwu.sogou.com/shop?display=grid&query=%CF%E0%BB%FA&host=www.baidu.com&pid=&sut=45221&sst0=1534725254578&page="+i+"&w=01029901&dr=1&sourceid=sr_bpage&interV=";
			String html = JSOUPUtils.getHtml(url);
			List<String> list = GetData.getUrl(html);
			IOUtiles.Download(list,n);
			}
			break;
		default:
			break;
		}
	}

}