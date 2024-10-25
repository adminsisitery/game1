package com.fei.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedinsterJFrame extends JFrame implements ActionListener {
    // 构造函数
    public RedinsterJFrame() {
        iniframe();
        iniview();
    }

    // 初始化注册窗口
    public void iniframe() {

        this.setSize(488, 430);

        this.setTitle("拼图 注册");

        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    // 定义用户名和密码的输入字段
    JTextField username1 = new JTextField();
    JPasswordField password1 = new JPasswordField();
    JPasswordField repassword1 = new JPasswordField();
    JButton registerButton = new JButton();

    public void iniview() {
        this.setLayout(null); // 使用绝对布局

        // 1. 添加用户名标签
        JLabel usernameText = new JLabel(new ImageIcon("image\\register\\注册用户名.png"));
        usernameText.setBounds(76, 135, 107, 17);
        this.getContentPane().add(usernameText);

        // 2. 添加用户名输入框
        username1.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username1);

        // 3. 添加密码标签
        JLabel passwordText = new JLabel(new ImageIcon("image\\register\\注册密码.png"));
        passwordText.setBounds(70, 195, 102, 16);
        this.getContentPane().add(passwordText);

        // 4. 添加密码输入框
        password1.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password1);

        // 5. 添加再次输入密码标签
        JLabel repasswordText = new JLabel(new ImageIcon("image\\register\\再次输入密码.png"));
        repasswordText.setBounds(70, 250, 107, 16);
        this.getContentPane().add(repasswordText);

        // 6. 添加再次输入密码输入框
        repassword1.setBounds(195, 250, 200, 30);
        this.getContentPane().add(repassword1);

        // 7. 添加注册按钮
        registerButton = new JButton(new ImageIcon("image\\register\\注册按钮.png"));
        registerButton.setBounds(195, 310, 100, 40);
        this.getContentPane().add(registerButton);

        // 添加背景
        JLabel background = new JLabel(new ImageIcon("image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

        registerButton.addActionListener(this );
    }
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new tellsome();

    }
}
