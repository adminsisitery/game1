package com.fei.ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class LoginJFrame extends JFrame implements  MouseListener {
   static ArrayList<user> list = new ArrayList();
   static {
        list.add(new user("liupengfei","20050703"));
        list.add(new user("feifei","123"));
        list.add(new user("123","123"));
    }

    String usernames = "";
    String passwords = "";
    String codes = "";
    String codeStr;

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField password = new JTextField();
    JTextField username = new JTextField();
    JTextField code = new JTextField();
//    JLabel passwordshow = new JLabel(new ImageIcon("image\\login\\显示密码.png"));

    public LoginJFrame() {
        initJFrame();

        initView();

        this.setVisible(true);

    }

    public void initJFrame(){
        this.setSize(488,430);
        this.setTitle("拼图 登录");//设置界面标题
        this.setAlwaysOnTop(true);//设置界面置顶
        this.setLocationRelativeTo(null);//设置界面居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置结束程序 点击叉号时
    }

    public void initView(){

//1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框

        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //添加密码显示按钮
//        passwordshow.setBounds(385, 170, 50, 80);
//        this.getContentPane().add(passwordshow);
//        password.addMouseListener(this);

        //4.密码输入框

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框

        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);
        codes = code.getText();

        codeStr = CodeUtil.getCode();//随机验证码
        JLabel rightCode = new JLabel();
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);



        //5.添加登录按钮

        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        login.addMouseListener(this);

        //6.添加注册按钮

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);
        register.addMouseListener(this);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

    }

    public void showsworry() {
        String message = "";
        ImageIcon icon = null;
        // 检查输入框是否为空
        if (usernames.isEmpty() || passwords.isEmpty() || codes.isEmpty()) {

            message = "用户名、密码或验证码不能为空！";
            icon = new ImageIcon("image\\damie.jpg"); // 自定义空字段的图片
        } else if (!codeStr.equalsIgnoreCase(codes)) {  // 用户名或密码错误
            message = "验证码错误！";
            icon = new ImageIcon("image\\damie.jpg"); // 自定义空字段的图片
        } else if (!isUserValid()) {  // 验证码错误
            message = "用户名或密码错误！";
            icon = new ImageIcon("image\\damie.jpg"); // 自定义空字段的图片
        }

        // 弹出错误提示对话框
        JOptionPane.showMessageDialog(this, message, "错误", JOptionPane.WARNING_MESSAGE,icon);
    }


    public boolean isUserValid() {
        for (user u : list) {
            if (u.name.equals(usernames) && u.password.equals(passwords)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if(source == login) {
            login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        }
        else if(source == register) {
            register.setIcon(new ImageIcon("image\\login\\注册按下.png"));
        }
//        }else if(source == passwordshow) {
//            passwordshow.setIcon(new ImageIcon("image\\login\\显示密码按下.png"));
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
       // passwordshow.setIcon(new ImageIcon("image\\login\\显示密码.png"));
        Object obj = e.getSource();
        if (obj == login) {
            usernames = username.getText(); // 点击按钮时获取输入的用户名
            passwords = password.getText(); // 点击按钮时获取输入的密码
            codes = code.getText(); // 获取验证码输入框内容

            if (!usernames.isEmpty() && !passwords.isEmpty() && !codes.isEmpty()) {
                if (isUserValid() && codeStr.equalsIgnoreCase(codes)) { // 增加验证码验证
                    System.out.println("登录成功");
                    new GameJFrame();
                    this.setVisible(false);
                } else {
                    showsworry();
                    System.out.println("登录失败，用户名或密码或验证码错误");
                }
            } else {
                showsworry();
                System.out.println("登录失败，输入不能为空");
            }
        } else if (obj == register) {
            new RedinsterJFrame();
            this.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    static class CodeUtil {
        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final int CODE_LENGTH = 5;

        public static String getCode() {
            StringBuilder code = new StringBuilder(CODE_LENGTH);
            Random random = new Random();

            for (int i = 0; i < CODE_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                code.append(CHARACTERS.charAt(index));
            }

            return code.toString();
        }
    }

}

class user{
    String name;
    String password;
    public user(String name, String password) {
        this.name = name;
        this.password = password;
    }
}


