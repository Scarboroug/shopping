package com.chusai.analy;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import org.dom4j.io.SAXReader;


/************************
 * @className Test.java
 * @author wsq
 * @date 2018年8月18日
 * @version V1.0
 * @description
 *************************/
public class Test {
	public static ArrayList<Information> InputPhone(String url) throws Exception {
		File file = new File(url);
		if(!file.exists()){
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("<?xml version=\"1.1\"?>");
			fileWriter.write("<location/>");
			fileWriter.close();
		}
		
		
		List<Information> cun = new ArrayList<Information>();
		
		SAXReader reader = new SAXReader();
		
		Document document = reader.read(file);
		
		Element root = document.getRootElement();
		
		List<Element> rows = root.elements();
		
		for (Element row : rows) {
			Information inf = new Information();
			inf.setTitle(row.element("title").getText());
			inf.setXiaol(row.element("xiaol").getText());
			inf.setPrice(row.element("price").getText());
			inf.setBasicparam(row.element("基本参数").getText());
			inf.setComment(row.element("点评").getText());
			inf.setPreception(row.element("心得").getText());
				inf.setCompareTitle1(row.element("比价title1").getText());
				inf.setComparePrice1(row.element("比价price1").getText());
				inf.setDescribeFirst(row.element("描述1").getText());
				inf.setCompareTitle2(row.element("比价title2").getText());
				inf.setComparePrice2(row.element("比价price2").getText());
				inf.setDescribeSecond(row.element("描述2").getText());
				inf.setCompareTitle3(row.element("比价title3").getText());
				inf.setComparePrice3(row.element("比价price3").getText());
				inf.setDescribeThird(row.element("描述3").getText());
				inf.setCompareTitle4(row.element("比价title4").getText());
				inf.setComparePrice4(row.element("比价price4").getText());
				inf.setDescribeForth(row.element("描述4").getText());
				inf.setCompareTitle5(row.element("比价title5").getText());
				inf.setComparePrice5(row.element("比价price5").getText());
				inf.setDescribeFifth(row.element("描述5").getText());
			
			cun.add(inf);
		}
		return (ArrayList<Information>) cun;
	
	}
	public static ArrayList Search(int id,String url) throws Exception{
		ArrayList<Information> list =Test.InputPhone(url);
		ArrayList list2 = new ArrayList();
		list2.add("标题为："+list.get(id).getTitle());
		list2.add("销量为："+list.get(id).getXiaol());
		list2.add("价格为："+list.get(id).getPrice());
		list2.add("基本参数为："+list.get(id).getBasicparam());
		list2.add("点评："+list.get(id).getComment());
		list2.add("心得："+list.get(id).getPreception());
			if(!list.get(id).getCompareTitle1().isEmpty()){
				list2.add("\t同类商品："+list.get(id).getCompareTitle1());
				list2.add("\t    价格："+list.get(id).getComparePrice1());
				list2.add("\t    描述："+list.get(id).getDescribeFirst());
			}
			if(!list.get(id).getCompareTitle2().isEmpty()){
				list2.add("\t同类商品："+list.get(id).getCompareTitle2());
				list2.add("\t    价格："+list.get(id).getComparePrice2());
				list2.add("\t    描述："+list.get(id).getDescribeSecond());
			}
			if (!list.get(id).getCompareTitle3().isEmpty()) {
				list2.add("\t同类商品："+list.get(id).getCompareTitle3());
				list2.add("\t    价格："+list.get(id).getComparePrice3());
				list2.add("\t    描述："+list.get(id).getDescribeThird());
			}
			if (!list.get(id).getCompareTitle4().isEmpty()) {
				list2.add("\t同类商品："+list.get(id).getCompareTitle4());
				list2.add("\t    价格："+list.get(id).getComparePrice4());
				list2.add("\t    描述："+list.get(id).getDescribeForth());
			}
			if (!list.get(id).getCompareTitle5().isEmpty()) {
				list2.add("\t同类商品："+list.get(id).getCompareTitle5());
				list2.add("\t    价格："+list.get(id).getComparePrice5());
				list2.add("\t    描述："+list.get(id).getDescribeFifth());
			}
		return list2;
	}
	
}
