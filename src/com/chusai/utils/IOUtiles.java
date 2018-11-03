package com.chusai.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class IOUtiles {
	static int j=1;
	public static void Download(List<String> listSrc,int n) {
		try {
			
			for (String url : listSrc) {
				File file = null ;
				SAXReader reader = new SAXReader();
				if (n==1) {
					file = new File("./phone/Data.xml");
				}else if (n==2) {
					file = new File("./computer/Data.xml");
				}else if (n==3) {
					file = new File("./TV/Data.xml");
				}else if (n==4) {
					file = new File("./camera/Data.xml");
				}
				 	
				org.dom4j.Document document = reader.read(file);
				
				org.dom4j.Element root = document.getRootElement();
				
				org.dom4j.Element child =root.addElement("type");
				
				child.addAttribute("typeID", "type"+(j++));
					
				Document document2 = Jsoup.connect(url)
						.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
	                    .get();
				Elements title = document2.select("#sb_title");
			
				Elements price = document2.select(".pro_detail_amount");
				Elements xiaol = document2.select(".pro_detail_sale").select("em:nth-child(1)");
				
				Elements title1 = document2.select("#store_c2c_1_item_1_title");
				Elements title2 = document2.select("#store_c2c_1_item_2_title");
				Elements title3 = document2.select("#store_c2c_1_item_3_title");
				Elements title4 = document2.select("#store_c2c_1_item_4_title");
				Elements title5 = document2.select("#store_c2c_1_item_5_title");
				
				Elements price1 = document2.select("#store_c2c_1_item_1").select("div:nth-child(3)").select("span:nth-child(1)");
				Elements price2 = document2.select("#store_c2c_1_item_2").select("div:nth-child(3)").select("span:nth-child(1)");
				Elements price3 = document2.select("#store_c2c_1_item_3").select("div:nth-child(3)").select("span:nth-child(1)");
				Elements price4 = document2.select("#store_c2c_1_item_4").select("div:nth-child(3)").select("span:nth-child(1)");
				Elements price5 = document2.select("#store_c2c_1_item_5").select("div:nth-child(3)").select("span:nth-child(1)");
 
				Elements miaoshu1 =document2.select("#store_c2c_1_item_1");
				Elements miaoshu2 =document2.select("#store_c2c_1_item_2");
				Elements miaoshu3 =document2.select("#store_c2c_1_item_3");
				Elements miaoshu4 =document2.select("#store_c2c_1_item_4");
				Elements miaoshu5 =document2.select("#store_c2c_1_item_5");
				
				Elements table = document2.getElementsByClass("parameter_table");
				Elements dianping = document2.getElementsByClass("tag_list");
				Elements pj = document2.getElementsByClass("comment_item");
			
				child.addElement("title").addText(title.text());
				child.addElement("xiaol").addText(xiaol.text());
				child.addElement("price").addText(price.text());
				child.addElement("基本参数").addText(table.text());
				child.addElement("点评").addText(dianping.text());
				child.addElement("心得").addText(pj.text());
				
				child.addElement("比价title1").addText(title1.text());
				child.addElement("比价price1").addText(price1.text());
				child.addElement("描述1").addText(miaoshu1.text());

				child.addElement("比价title2").addText(title2.text());
				child.addElement("比价price2").addText(price2.text());
				child.addElement("描述2").addText(miaoshu2.text());
		
				child.addElement("比价title3").addText(title3.text());
				child.addElement("比价price3").addText(price3.text());
				child.addElement("描述3").addText(miaoshu3.text());
			
				child.addElement("比价title4").addText(title4.text());
				child.addElement("比价price4").addText(price4.text());
				child.addElement("描述4").addText(miaoshu4.text());
				
				child.addElement("比价title5").addText(title5.text());
				child.addElement("比价price5").addText(price5.text());
				child.addElement("描述5").addText(miaoshu5.text());
				
				System.out.println("开始下载:" + title.text());
				BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file));
				OutputFormat of = OutputFormat.createPrettyPrint();
				of.setEncoding("UTF-8");
				XMLWriter writer = new XMLWriter(bw,of);
				writer.write(document);
				writer.close();
				bw.close();
				System.out.println("下载完成");		
			}	
		} catch (Exception e) {
			System.out.println("下载失败");
	}
}
}