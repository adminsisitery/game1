package test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class test1 extends JFrame implements  KeyListener  {
    //创建按钮对象
    JButton button1 = new JButton("button1");
    JButton button2 = new JButton("点我呀");
    public test1() {

        //创建窗口
        this.setSize(800, 600);

        //设置窗口标题
        this.setTitle("事件测试 v1");

        //设置页面置顶
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //取消原先的布局
        this.setLayout(null);



//        //设置按钮大小和位置 并且设置监听
//        button1.setBounds(0,0,100, 50);
//        button1.addActionListener(this);
//
//
//        //设置第二个按钮和大小 并且设置监听
//        button2.setBounds(100,0,100,50);
//        button2.addActionListener(this);


        //设置键盘监听对象
        this.addKeyListener(this);


        //将按钮添加到隐藏布局中
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);


        //设置视图可见
        this.setVisible(true);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object source = e.getSource();
//        if (source == button1) {
//            button1.setSize(200,100);
//        }else if (source == button2) {
//            Random r = new Random();
//            button2.setBounds(r.nextInt(600),r.nextInt(400),100,50);
//        }
//    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("点击");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("释放");
        if(e.getKeyCode() == 67){
            System.out.println("a");
        }
    }
}
