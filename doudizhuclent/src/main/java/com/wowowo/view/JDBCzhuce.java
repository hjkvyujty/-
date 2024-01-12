package com.wowowo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCzhuce {
    public static void main(String[] args) {
        guitext4 gt=new guitext4();
    }
}
class guitext4{
    JFrame jf;
    // JPanel jp;
    JLabel l1,l2,l3;
    JTextField f1;
    JPasswordField f2,f3;
    JButton jb1,jb2;
    JRadioButton jr1,jr2;
    JCheckBox jc;
    public guitext4() {
        jf = new JFrame("欢乐斗地主注册窗口");
        jf.setSize(320,400);//设置窗体大小
        jf.setLocation(700,300);//设置窗口每次启动都显示在屏幕正中央
        jf.setLayout(null);
        ImageIcon img=new ImageIcon("F:\\xuexiJAVA\\doudizhu\\bg\\denglu3.jpg");//背景图片
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        jf.getLayeredPane().add(background, Integer.MIN_VALUE);
        // jp = new JPanel();
        Font font = new Font("仿宋", Font.BOLD, 20);//设置统一的字体，让代码更加整洁美观
        l1 = new JLabel("用户名：");
        l1.setBounds(10,25,100,40);
        l1.setFont(font);
        f1 = new JTextField(null,20);
        f1.setBounds(90,30,180,30);
        f1.setFont(font);
        l2 = new JLabel("密  码：");
        l2.setBounds(8, 85, 100, 40);
        l2.setFont(font);
        f2 = new JPasswordField(null, 20);
        f2.setBounds(90, 90, 180, 30);
        f2.setEchoChar('*');//设置密码的外显为*
        f2.setFont(font);
        l3 = new JLabel("确认密码：");
        l3.setBounds(8, 140, 130, 40);
        l3.setFont(font);
        f3 = new JPasswordField(null, 20);
        f3.setBounds(120, 145, 160, 30);
        f3.setEchoChar('*');//设置密码的外显为*
        jc=new JCheckBox("显示密码");//创建一个复选按钮
        jc.setBounds(230,200,80,40);
        jc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {//被选中
                    f2.setEchoChar((char) 0);//显示原本的数据
                    f3.setEchoChar((char)0);//显示原本的数据
                } else {
                    f2.setEchoChar('*');//设置密码的外显为*
                    f3.setEchoChar('*');//设置密码的外显为*
                }
            }
        });
        f3.setFont(font);
        ButtonGroup group = new ButtonGroup();
        //创建两个单选按钮
        jr1 = new JRadioButton("男");
        jr1.setBounds(70, 200, 80, 40);
        jr1.setFont(font);
        jr2 = new JRadioButton("女");
        jr2.setBounds(150, 200, 80, 40);
        jr2.setFont(font);
        //将两个单选按钮加入到同一个ButtonGroup组中
        group.add(jr1);
        group.add(jr2);
        //实现监听接口
        ActionListener listener = new AbstractAction() {
            @Override
            //actionPerformed==>发生动作时调用
            public void actionPerformed(ActionEvent e) {

            }
        };
        jr1.addActionListener(listener);
        jr2.addActionListener(listener);
        jc.addActionListener(listener);
        jb1 = new JButton("注册");
        jb1.setBounds(50, 270, 80, 40);
        //匿名内部类
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PreparedStatement ps = null;//PreparedStatement==>表示预编译的SQL语句的对象。
                // SQL语句已预编译并存储在PreparedStatement对象中。
                Connection con = null;//Connection==>与特定数据库的连接
                try {
                    //注册驱动
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //这里的3306/后跟的是数据库名
                    //获取数据库连接
                    String url="jdbc:mysql://localhost:3306/doudizhu?serverTimezone=UTC";
                    //通过DriverManager完成注册
                    con = DriverManager.getConnection(url, "root", "1234");//你自己数据库的用户名和密码
                    //执行SQL语句
                    String sql = "insert into test(username,password,sex) values(?,?,?)";
                    ps = con.prepareStatement(sql);
                    if(f1.getText().length()!=0){
                        //注：这里的所有getText()都不能写成!=null
                        ps.setString(1, f1.getText());
                    }else{
                        JOptionPane.showMessageDialog(null, "姓名不能为空！");//弹出窗口
                    }
                    if(f2.getText().length()!=0) {
                        ps.setString(2, f2.getText());
                    }else{
                        JOptionPane.showMessageDialog(null, "密码不能为空！");
                    }
                    if(jr1.isSelected()||jr2.isSelected()) {//如果选择男或者女，就存入数据库。
                        if (jr1.isSelected()) {//isSelected（）==>判断按钮有没有被选中
                            ps.setString(3, jr1.getText());//选中男，则将sex=男添加到数据
                        }
                        if (jr2.isSelected()) {
                            ps.setString(3, jr2.getText());//选中女，则将sex=女添加到数据
                        }
                    }else{//否则弹出窗口提醒“请选择性别！”
                        JOptionPane.showMessageDialog(null, "请选择性别！");
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (new String(f2.getPassword()).equals(new String(f3.getPassword()))) {//如果密码与确认密码一致
                    if (new String(f2.getPassword()).equals(new String(f3.getPassword()))&&f1.getText().length()!=0&&f2.getText().length()!=0
                            &&(jr1.isSelected()||jr2.isSelected())) {//如果密码与确认密码一致，用户名和密码不为空并且选择了性别，则注册成功
                        JOptionPane.showMessageDialog(null, "注册成功！");
                        //注册成功后跳转到登录窗口
                        guitext3 gt=new guitext3();
                        jf.dispose();//关闭窗体，释放所有资源
                        try {
                            int i = ps.executeUpdate();//将注册的账户存储到数据库中
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "注册失败！密码与确认密码不一致！");
                    f2.setText(null);//清空密码
                    f3.setText(null);//清空确认密码
                }
            }
        });
        jb1.setFont(font);
        jb2 = new JButton("退出");
        jb2.setBounds(170, 270, 80, 40);
        //匿名内部类
        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "退出成功！");
                //系统退出
                System.exit(0);
            }
        });
        jb2.setFont(font);
        jf.add(l1);
        jf.add(f1);
        jf.add(l2);
        jf.add(f2);
        jf.add(l3);
        jf.add(f3);
        jf.add(jr1);
        jf.add(jr2);
        jf.add(jc);
        jf.add(jb1);
        jf.add(jb2);
        // jf.add(jp);
        jf.add(background);
        jf.setVisible(true);
    }
}