package com.gosun.util.console;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * 系统工具
 * @author caixiaopeng
 */
public class SystemUtils {
	
	/**
	 * 显示info，然后退出程序
	 * 如果info为null或者为空，则不显示，直接退出程序
	 */
	public static void exit(String info) {
		Scanner scanner=new Scanner(System.in);
		if(StringUtils.isNotBlank(info)){
			System.out.println(info);
		}
		System.out.print("请按回车键，退出程序！");
		scanner.nextLine();
		System.out.println("<======================END======================>");
	}
}
