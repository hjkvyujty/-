package com.wowowo.view;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		guitext3 gt=new guitext3();
		new Thread(new time1(gt.time)).start();//启动线程
	}

}
