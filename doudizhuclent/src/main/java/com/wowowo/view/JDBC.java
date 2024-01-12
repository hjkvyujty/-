package com.wowowo.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;
import java.time.LocalTime;



public class JDBC {
    public static void main(String[] args) {
        guitext3 gt=new guitext3();
        new Thread(new time1(gt.time)).start();//启动线程

    }
}
class guitext3 {
    JFrame jf;
    JLabel l1,l2,time;
    JTextField f1;
    JPasswordField f2;
    JButton jb1,jb2,jb3;
    JCheckBox jc;

    public guitext3() {
        jf = new JFrame("欢乐斗地主");
        jf.setSize(320,400);
        jf.setLocation(700,300);//设置窗口每次启动都显示在屏幕正中央
        jf.setLayout(null);

        ImageIcon img=new ImageIcon("F:\\xuexiJAVA\\doudizhu\\bg\\denglu3.jpg");//背景图片
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        jf.getLayeredPane().add(background, Integer.MIN_VALUE);

        Font font = new Font("仿宋", Font.BOLD, 20);//设置统一的字体，让代码更加整洁美观
        l1 = new JLabel("用户名：");
        l1.setBounds(10,30,100,40);
        l1.setFont(font);
        f1 = new JTextField(null,20);
        f1.setBounds(90,35,180,30);
        f1.setFont(font);
        l2 = new JLabel("密 码：");
        l2.setBounds(8,95,100,40);
        l2.setFont(font);
        f2=new JPasswordField(null,20);
        f2.setBounds(90,100,180,30);
        f2.setEchoChar('*');//设置密码的外显为*
        f2.setFont(font);
        jc=new JCheckBox("显示密码");
        jc.setBounds(230,270,80,40);
        jc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {//被选中
                    f2.setEchoChar((char) 0);
                } else {
                    f2.setEchoChar('*');
                }
            }
        });
        ActionListener listener=new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        jc.addActionListener(listener);
        jb1 = new JButton("登录");
        jb1.setBounds(15,180,80,40);
        time=new JLabel();
        time.setBounds(30,270,140,40);
        time.setFont(font);
        //匿名内部类
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Statement st=null;
                Connection con=null;
                ResultSet rs=null;
                try {
                    //注册驱动
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //这里的3306/后跟的是数据库名
                    //获取数据库连接
                    String url="jdbc:mysql://localhost:3306/doudizhu?serverTimezone=UTC";
                    //通过DriverManager完成注册
                    con= DriverManager.getConnection(url,"root","1234");//你自己的数据库用户名和密码
                    //执行SQL语句
                    String sql="select * from test";//from 后跟表名
                    st=con.createStatement();
                    rs=st.executeQuery(sql);
                    boolean flag=false;
                    while(rs.next()){

                        //如果输入的用户名和密码与数据库中的用户和对应的密码相同，则弹出“登录成功！”的窗口
                        if(f1.getText().equals(rs.getString(2))&&f2.getText().equals(rs.getString(3))){
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            flag=true;//登陆成功后将标记改为true方便确认
                            //1.获得用户名
                            String uname=f1.getText();

                            //2.创建一个socket链接服务器端
                            try {
                                Socket socket=new Socket("127.0.0.1",8888);

                                //3.跳转到主窗口
                                new MainFrame(uname,socket);
                                jf.dispose();//关闭窗体，释放所有资源
                            /*} catch (UnknownHostException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                             
                                e.printStackTrace();*/
                            } catch (UnknownHostException ex) {
                                throw new RuntimeException(ex);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        }
                    }
                    if(flag==false){//如果标记为false，则表示用户名和密码在数据库中未找到，弹出“登录失败！请注册账户！”的窗口
                        JOptionPane.showMessageDialog(null, "登录失败！请注册账户！");
                        f1.setText(null);//清空用户栏
                        f2.setText(null);//清空密码栏
                        //这个账号不存在，需要注册，跳转到注册窗口


                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jb1.setFont(font);
        jb2 = new JButton("注册");
        jb2.setBounds(115,180,80,40);
        //匿名内部类
        jb2.addMouseListener(new MouseAdapter() {
            //重写鼠标点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                guitext4 gt=new guitext4();
                jf.dispose();//关闭窗体，释放所有资源
            }
        });
        jb2.setFont(font);

        jb3 = new JButton("退出");
        jb3.setBounds(215,180,80,40);
        //匿名内部类
        jb3.addMouseListener(new MouseAdapter() {
            //重写鼠标点击事件
            @Override
            public void mouseClicked(MouseEvent e) {

                //如果点击了退出窗口，则弹出“退出成功！”的窗口
                JOptionPane.showMessageDialog(null, "退出成功！");
                //系统退出
                System.exit(0);
            }
        });
        jb3.setFont(font);
        //将这些按钮和文本等加入到窗体中

        jf.add(l1);
        jf.add(f1);
        jf.add(l2);
        jf.add(f2);
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(time);
        jf.add(jc);
        jf.add(background);
        jf.setVisible(true);//让组件显示
    }
}
//写一个时间线程类
class time1 implements Runnable{
    JLabel time;//方便传参
    public time1(JLabel time) {
        this.time = time;
    }
    @Override
    public void run(){
        while (true) {
            try {
                Thread.sleep(1000);//休眠1秒
                LocalTime time=LocalTime.now();//获取当前时间
                this.time.setText(time.toString());//设置JLabel文本
                //SimpleDateFormat t = new SimpleDateFormat ("HH:mm:ss");//格式化时间，把时间格式化为时：分：秒
                // this.time.setText(t.format(time));//给标签添加内容，即时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}