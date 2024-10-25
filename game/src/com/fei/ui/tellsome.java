package com.fei.ui;

import javax.swing.*;
import java.awt.*;

public class tellsome extends JFrame {
    String iwentsay = "<html><b>注册没有做^-^<br>(懒 :( <br>十分感谢您体验本游戏</b></html>"; // 使用HTML标签支持换行
    String mm = "<html>用户名：123<br> 密码：123<br>直接拿去登录吧</html>";
    // 构造函数
    public tellsome() {
        // 初始化窗口
        initframe();
        initview();
    }

    // 初始化窗口设置
    public void initframe() {
        this.setSize(600, 500);
        this.setTitle("----感谢体验！！----");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null); // 使用绝对布局
        this.setVisible(true);
    }

    // 初始化视图
    public void initview() {
        // 添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\tks.png"));
        background.setBounds(0, 0, 600, 500); // 确保背景图覆盖整个窗口
        this.getContentPane().add(background);

        // 添加文字标签
        JLabel textLabel = new JLabel(iwentsay);
        textLabel.setBounds(50, 300, 500, 100); // 设置位置和大小，调整宽度以适应文本
        textLabel.setFont(new Font("Serif", Font.BOLD, 20)); // 设置字体
        textLabel.setForeground(Color.black); // 设置文字颜色（根据背景调整）
        textLabel.setHorizontalAlignment(SwingConstants.CENTER); // 设置文本水平居中

        JLabel textLabel2 = new JLabel(mm);
        textLabel2.setBounds(30, 100, 500, 100);
        textLabel2.setFont(new Font("Serif", Font.BOLD, 20)); // 设置字体
        textLabel2.setForeground(Color.black);
        textLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        // 将文字标签添加到背景标签上
        background.add(textLabel2);
        background.add(textLabel);
    }

    public static void main(String[] args) {
        // 创建并显示窗口
        new tellsome();
    }
}
