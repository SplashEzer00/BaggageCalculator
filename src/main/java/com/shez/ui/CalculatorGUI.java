package main.java.com.shez.ui;

import main.java.com.shez.bc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class CalculatorGUI extends JFrame {
    JComboBox areaCombox =new JComboBox();    //创建 起点相关的 JComboBox
    JComboBox cabinCombox = new JComboBox();    //创建 机舱相关的 JComboBox
    JComboBox passengerCombox = new JComboBox();    //创建 乘客类型相关的 JComboBox
    JComboBox vipCombox = new JComboBox();    //创建 会员相关的 JComboBox
    JTextArea bagInfo = new JTextArea();       //行李的信息
    JTextField priceInfo = new JTextField();    //票价信息

    JButton addBagBut = new JButton("添加普通托运行李");
    JButton addSpecialBut = new JButton("添加特殊托运行李");
    JButton calculateBut = new JButton("计算费用");
    JButton clearBtu = new JButton("清空");

    //两个子界面
    BaggageGUI baggageGUI = new BaggageGUI();
    SpecialBagGUI specialBagGUI =new SpecialBagGUI();

    //两个数据
    List<Baggage>baggages = new ArrayList<Baggage>();
    List<SpecialBaggage>specialBaggages = new ArrayList<SpecialBaggage>();

    public CalculatorGUI() throws HeadlessException {
        this.setTitle("国航托运行李计算器");
        this.setSize(700, 570);
        init();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init(){

        this.setLayout(null);
        baggageGUI.setModal(true);  //模式
        specialBagGUI.setModal(true);
        //设置区域
        for (String regional: Ticket.Regional){
            areaCombox.addItem(regional);
        }
        //机舱设置
        cabinCombox.addItem("豪华头等舱");
        cabinCombox.addItem("头等舱");
        cabinCombox.addItem("公务舱");
        cabinCombox.addItem("悦享经济舱");
        cabinCombox.addItem("超级经济舱");
        cabinCombox.addItem("经济舱");
        //乘客设置
        passengerCombox.addItem("成人");
        passengerCombox.addItem("儿童");
        passengerCombox.addItem("婴儿");
        //vip设置
        vipCombox.addItem("凤凰知音终身白金卡");
        vipCombox.addItem("白金卡");
        vipCombox.addItem("凤凰知音金卡");
        vipCombox.addItem("银卡");
        vipCombox.addItem("星空联盟金卡");


        JPanel ticketPanel = addTicketPanel();
        ticketPanel.setBounds(0,0,700,200);

        JPanel BagPanel = addBaggagePanel();
        BagPanel.setBounds(0,210,700,300);

        this.add(ticketPanel);
        this.add(BagPanel);
        //清空
        clearBtu.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                bagInfo.setText("");
                baggages.clear();
                specialBaggages.clear();

            }
        });
        //普通行李
        addBagBut.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                baggageGUI.setVisible(true);

                Baggage baggage = baggageGUI.getBaggage();

                String area = (String) areaCombox.getSelectedItem();//区域
                if (!CalculatorGUI.isNumeric(priceInfo.getText())){
                    JOptionPane.showMessageDialog(null, "请修改输入价格");
                    return;
                }
                float price = Float.valueOf(priceInfo.getText());//价格（手动输入）

                PassengerType passengerType = PassengerType.values()[passengerCombox.getSelectedIndex()] ;//乘客类型
                ClassType classType = ClassType.values()[cabinCombox.getSelectedIndex()];//机舱
                VIPType vipType = VIPType.values()[vipCombox.getSelectedIndex()];//vip类型
                Ticket ticket = new Ticket(area,price,passengerType, classType,vipType);
                //判断是否能够带上机
                if (baggage!=null){
                    if (Baggage.isCanConsign(baggage, ticket)){
                        bagInfo.append(baggage.toString());//行李的信息
                        baggages.add(baggage);
                    }else {
                        JOptionPane.showMessageDialog(null, "该普通行李无法上机");
                    }
                    baggageGUI.clear();
                }

            }
        });
        //特殊行李
        addSpecialBut.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                specialBagGUI.setVisible(true);

                String area = (String)areaCombox.getSelectedItem();//区域
                if (!CalculatorGUI.isNumeric(priceInfo.getText())){
                    JOptionPane.showMessageDialog(null, "请检查输入票价");
                    return;
                }
                float price = Float.valueOf( priceInfo.getText());//价格

                PassengerType passengerType = PassengerType.values()[passengerCombox.getSelectedIndex()] ;
                ClassType classType = ClassType.values()[cabinCombox.getSelectedIndex()];
                VIPType vipType = VIPType.values()[vipCombox.getSelectedIndex()];
                Ticket ticket = new Ticket(area,price,passengerType, classType,vipType);

                SpecialBaggage baggage =specialBagGUI.getSpecialBaggage();
                //判断是否能够带上机
                if (baggage!=null&&SpecialBaggage.isCanConsign(baggage, ticket)){
                    if (SpecialBaggage.isCanConsign(baggage, ticket)){
                        bagInfo.append(baggage.toString());
                        specialBaggages.add(baggage);
                    }else {
                        JOptionPane.showMessageDialog(null, "该特殊行李无法上机");
                    }
                    baggageGUI.clear();
                }
            }
        });
        //确定计算
        calculateBut.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                String area = (String)areaCombox.getSelectedItem();//区域

                if (!CalculatorGUI.isNumeric(priceInfo.getText())){
                    JOptionPane.showMessageDialog(null, "请重新输入票价");
                    return;
                }
                float price = Float.valueOf(priceInfo.getText());//价格

                PassengerType passengerType = PassengerType.values()[passengerCombox.getSelectedIndex()] ;
                ClassType classType = ClassType.values()[cabinCombox.getSelectedIndex()];
                VIPType vipType = VIPType.values()[vipCombox.getSelectedIndex()];
                Ticket ticket = new Ticket(area,price,passengerType,classType,vipType);
                float cost = Calculator.CalculateValue(baggages, specialBaggages, ticket);
                System.out.println(cost);
                if (cost!=-1)
                    JOptionPane.showMessageDialog(null, "费用："+cost);
                else
                    JOptionPane.showMessageDialog(null, "error");

            }
        });
    }

    /**
     * 添加和机票相关的界面
     * @return 机票相关的界面
     */
    private JPanel addTicketPanel(){
        JPanel jp=new JPanel(); //机舱相关的界面部分
        JLabel jb1 = new JLabel("区域:");
        JLabel jb2 = new JLabel("机舱:");
        JLabel jb3 = new JLabel("票价：");
        JLabel jb4 = new JLabel("乘客类型:");
        JLabel jb5 = new JLabel("vip类型：");
        //采用空布局
        jp.setLayout(null);
        jb1.setBounds(10, 30, 50, 30);areaCombox.setBounds(50,30,600,30);
        jb2.setBounds(10, 90, 50, 30);cabinCombox.setBounds(50,90,230,30);
        jb3.setBounds(10, 150, 50, 30);priceInfo.setBounds(50,150,230,30);
        jb4.setBounds(340, 90, 80, 30);passengerCombox.setBounds(420,90,230,30);
        jb5.setBounds(340, 150, 80, 30);vipCombox.setBounds(420,150,230,30);

        jp.add(jb1);jp.add(areaCombox);
        jp.add(jb2);jp.add(cabinCombox);
        jp.add(jb3);jp.add(priceInfo);
        jp.add(jb4);jp.add(passengerCombox);
        jp.add(jb5);jp.add(vipCombox);

        return jp;
    }

    /***
     * 添加和行李相关的界面
     * @return  行李相关的界面
     */
    private JPanel addBaggagePanel(){

        JPanel panel1 = new JPanel();JPanel panel2=new JPanel();JPanel panel3=new JPanel();
        panel1.setLayout(new GridLayout(1,2,10,5));
        panel1.add(addBagBut);
        panel1.add(addSpecialBut);
        panel1.add(clearBtu);

        panel2.setLayout(new BorderLayout(10,5));
        panel2.add(panel1,BorderLayout.NORTH);
        panel2.add(bagInfo,BorderLayout.CENTER);
        panel2.add(panel3,BorderLayout.SOUTH);

        panel3.setLayout(new GridLayout(1,2,10,5));
        panel3.add(calculateBut);
        return panel2;
    }


    /**
     * 判断字符串是否是数字,其中负数也是返回false
     * @param str   需要判断的字符串
     * @return
     */
    public static boolean isNumeric(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
