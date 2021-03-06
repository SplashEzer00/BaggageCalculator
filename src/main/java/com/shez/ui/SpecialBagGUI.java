package main.java.com.shez.ui;

import main.java.com.shez.bc.Baggage;
import main.java.com.shez.bc.SpecialBaggage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialBagGUI extends JDialog  implements ActionListener{

    JTextField WeightField = new JTextField();    //重
    JTextField LengthField = new JTextField();    //长度
    JComboBox BagTypeComboBox =new JComboBox();    //选择特殊行李的内容
    JButton  addbtu =new JButton("确定添加");

    SpecialBaggage specialBaggage;

    public SpecialBaggage getSpecialBaggage() {
        return specialBaggage;
    }

    public SpecialBagGUI() throws HeadlessException {
        this.setTitle("特殊行李");
        this.setSize(600, 200);
        init();
        this.setLayout(null);
    }

    private void init(){
        for (String type:SpecialBaggage.AllType) {
            BagTypeComboBox.addItem(type);
        }
        JLabel jl1 = new JLabel("类型:");
        JLabel jl2 = new JLabel("重量:");
        jl1.setBounds(10, 10, 50, 25);BagTypeComboBox.setBounds(100,10,450,30);
        jl2.setBounds(10, 50, 50, 25);WeightField.setBounds(100,50,450,30);
        addbtu.setBounds(150, 90, 300, 30);
        this.add(jl1);
        this.add(jl2);
        this.add(WeightField);
        this.add(BagTypeComboBox);
        this.add(addbtu);

        addbtu.addActionListener(this);
    }

    public static void main(String[] args) {
        new SpecialBagGUI();
    }

    public void actionPerformed(ActionEvent e) {

        if (!CalculatorGUI.isNumeric(WeightField.getText())){
            JOptionPane.showMessageDialog(null, "输入信息有误");
            return;
        }

        String type = (String) BagTypeComboBox.getSelectedItem();
        float weight = Float.valueOf(WeightField.getText());
        specialBaggage = new SpecialBaggage(weight, type);
        System.out.println(specialBaggage);
        this.setVisible(false);
    }

    public void clear(){
        specialBaggage =null;
        WeightField.setText("");
    }
}
