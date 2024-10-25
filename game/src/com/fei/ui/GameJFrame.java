package com.fei.ui;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //游戏界面

    int[][] b = new int[4][4];
    int x;
    int y;
    Boolean ifvin = false;
    Random rand = new Random();
    int randomnum = 3;
   static String girls = "image\\girl\\girl";
   static String animals = "image\\animal\\animal";
   static String sports = "image\\sport\\sport";

    String path = "image\\animal\\animal";

    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    int step = 0;
    JMenuItem repalyItem = new JMenuItem("重新游戏");


    JMenuItem reLoginItem = new JMenuItem("重新登录");

    JMenuItem closeItem = new JMenuItem("关闭游戏");


    JMenuItem accontItem = new JMenuItem("加好友");

    //给JMenu添加对象
    JMenuItem girl = new JMenuItem("美女");

    JMenuItem animal = new JMenuItem("动物");

    JMenuItem sport = new JMenuItem("运动");


    public GameJFrame() {

        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数组
        initnum();

        //初始化图片
        initImage();

        this.setVisible(true);//显示界面 最后写



    }



    private void initImage() {

        this.getContentPane().removeAll();

        if(victory()){
            ifvin = true;
            JLabel winjl = new JLabel(new ImageIcon("image\\win.png"));
            winjl.setBounds(203, 280, 197, 73);
            this.getContentPane().add(winjl);
        }

        JLabel stepjl = new JLabel("步数" + step);
        stepjl.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepjl);

        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int num = b[i][j];
                JLabel label = new JLabel(new ImageIcon(path + randomnum +"\\" + num + ".jpg"));
                label.setBounds(105 * j + 83, 105 * i + 134, 105,105);
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(label);
            }
        }


        //添加背景图片
        ImageIcon icon = new ImageIcon("image\\background.png");
        JLabel background = new JLabel(icon);
        background.setBounds(40, 40, icon.getIconWidth(), icon.getIconHeight());
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }


    private void initnum(){
        int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int x = r.nextInt(a.length);
            int t = a[x];
            a[x] = a[i];
            a[i] = t;
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0){
                x=i/4;
                y=i%4;
            }
            b[i/4][i%4] = a[i];
        }

    }


    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();//初始化菜单

        //创建功能菜单
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenu changeImage = new JMenu("更换图片");


        //每个菜单的添加监听动作
        repalyItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accontItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);

        //将每个条目添加到菜单功能中
        changeImage.add(girl);
        changeImage.add(animal);
        changeImage.add(sport);

        functionJMenu.add(repalyItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(changeImage);
        aboutJMenu.add(accontItem);

        //添加功能到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //设置当前界面的菜单
        this.setJMenuBar(jMenuBar);


    }


    private void initJFrame() {
        this.setSize(603,680);//设置游戏的宽高

        this.setTitle("拼图 v1.0");//设置界面标题

        this.setAlwaysOnTop(true);//设置界面置顶

        this.setLocationRelativeTo(null);//设置界面居中

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置结束程序 点击叉号时

        this.addKeyListener(this);//给整个界面添加监听
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65 && !ifvin){
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel label = new JLabel(new ImageIcon(path + randomnum + "\\" +"all.jpg"));
            label.setBounds(83, 134, 420,420);
            this.getContentPane().add(label);

            ImageIcon icon = new ImageIcon("image\\background.png");
            JLabel background = new JLabel(icon);
            background.setBounds(40, 40, icon.getIconWidth(), icon.getIconHeight());
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }
        //对上下左右判断
        int code = e.getKeyCode();
        switch (code){
            case 37: {
                System.out.println("向左移动");
                if (y==3) return;
                b[x][y] = b[x][y+1];
                b[x][y+1] = 0;
                y++;
                step++;
                initImage();
            }
            break;
            case 38: {
                System.out.println("向上移动");
                if(x==3) return;
                b[x][y] = b[x+1][y];
                b[x+1][y] = 0;
                x++;
                step++;
                initImage();

            }
            break;
            case 39: {
                System.out.println("向右移动");
                if(y==0) return;
                b[x][y] = b[x][y-1];
                b[x][y-1] = 0;
                y--;
                step++;
                initImage();

            }
            break;
            case 40: {
                System.out.println("向下移动");
                if(x==0) return;
                b[x][y] = b[x-1][y];
                b[x-1][y] = 0;
                x--;
                step++;
                initImage();

            }break;
            case 65:{
                initImage();
            }
            break;
            case 87: {
                b = new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                };
                initImage();
            }break;
        }
    }


    public boolean victory(){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if(b[i][j] == win[i][j]){

                }
                else return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == repalyItem){
            ifvin = false;
            step = 0;
            //初始化数组
            initnum();
            //初始化图片
            initImage();

            System.out.println("重新游戏");
        }else if(obj == reLoginItem){
            this.setVisible(false);
            new LoginJFrame();
            System.out.println("重新登录");
        }else if(obj == closeItem){
            System.exit(0);
            System.out.println("关闭游戏");
        }else if(obj == accontItem){
            JDialog jd = new JDialog();
            JLabel jdl = new JLabel(new ImageIcon("image\\about.jpg"));
            jdl.setBounds(0,0,259,317);
            jd.getContentPane().add(jdl);
            jd.setSize(500,500);

            jd.setLocationRelativeTo(null);
            jd.setAlwaysOnTop(true);
            jd.setModal(true);
            jd.setVisible(true);
            System.out.println("加好友");
        }
        else if(obj == girl){
            ifvin = false;
            randomnum = rand.nextInt(13);
            if(randomnum == 0){
                randomnum++;
            }
            path = girls;
            step = 0;
            //初始化数组
            initnum();
            //初始化图片
            initImage();
            System.out.println("女孩");

        }else if(obj == animal){
            ifvin = false;
            randomnum = rand.nextInt(8);
            if(randomnum == 0){
                randomnum++;
            }
            path = animals;
            step = 0;
            //初始化数组
            initnum();
            //初始化图片
            initImage();
            System.out.println("动物");

        }else if(obj == sport){
            ifvin = false;
            randomnum = rand.nextInt(10);
            if(randomnum == 0){
                randomnum++;
            }
            path = sports;
            step = 0;
            //初始化数组
            initnum();
            //初始化图片
            initImage();
            System.out.println("运动");

        }
    }
}
