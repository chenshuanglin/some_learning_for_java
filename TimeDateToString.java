/**
 * @author lin
 * String.format方法的使用，主要是把日期格式化成相应的字符串
 * */
package test;

import java.util.Date;

public class TimeDateToString {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("直接输出date对象："+date);
		
		String str1 = String.format("全部日期和时间信息：%tc",date);
		System.out.println(str1);
		
		String str2 = String.format("月/日/年格式(两位年份)：%tD",date);
		System.out.println(str2);
		
		String str3 = String.format("年-月-日（四位年份）:%tF", date);
		System.out.println(str3);
		
		String str4 = String.format("HH：MM：SS PM格式（12时制）%tr", date);
		System.out.println(str4);
		
		String str5 = String.format("HH:MM 格式(24时制)%tR", date);
		System.out.println(str5);
		
		String str6 = String.format("HH:MM:SS (24时制)%tT",date);
		System.out.println(str6);
	}

}
