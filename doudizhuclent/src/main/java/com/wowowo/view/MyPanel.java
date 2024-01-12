package com.wowowo.view;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

	public MyPanel()
	{
		this.setLayout(null);  //如果需要用到setLocation() setBounds() 就需要设置布局为null
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		//super.paintComponent(arg0);

		Image image=new ImageIcon("F:\\xuexiJAVA\\doudizhu\\bg\\bg1.png").getImage();
		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		
		
	}
	
	   	  
	

}
