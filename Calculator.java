//az file komak dakhele channel komak gereftam
//az chat gpt baraye nahveye format kardane double ha betori ke faghat ta deghat 6 raghame ashar ro dar nazar begirand komak gereftam
//https://youtu.be/Kmgo00avvEw?si=9iVCwkqxjYi_NHap
//Dar fil e zip, dar kenar code, file fonte entekhabi ham hast

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator implements ActionListener {

    //Declaring Objects
    JFrame frame;
    JPanel panel;
    JPanel numsPanel;
    JButton[] numButtons = new JButton[10]; //declaring array
    JButton[] functionButtons = new JButton[9];
    JTextField textBox;
    double num1, num2;
    char operator;

    Font font = new Font("BERNHC", Font.PLAIN, 40);

    //Initializing objects within the constructor
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        textBox = new JTextField();
        textBox.setBounds(20, 25, 350, 75);
        textBox.setBackground(Color.BLACK);
        textBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        textBox.setFont(font);
        textBox.setForeground(Color.WHITE);
        textBox.setEditable(false);

        panel.add(textBox);

        numsPanel = new JPanel();
        numsPanel.setBounds(20, 125, 350, 300);
        numsPanel.setLayout(new GridLayout(4, 4));

        panel.add(numsPanel);

        //Initializing number buttons
        for(int i = 0; i < 10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setBackground(Color.GRAY);
            numButtons[i].setFocusable(false);
            numButtons[i].setBorder(BorderFactory.createEtchedBorder());
            numButtons[i].setFont(new Font("BERNHC", Font.PLAIN, 35));
            numButtons[i].addActionListener(this);
        }

        //Initializing function buttons
        for(int i = 0; i < 9; i++){
            functionButtons[i] = new JButton();
            functionButtons[i].setBackground(Color.GRAY);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBorder(BorderFactory.createEtchedBorder());
            functionButtons[i].setFont(new Font("BERNHC", Font.PLAIN, 35));
            functionButtons[i].addActionListener(this);
        }

        functionButtons[0].setText("/");
        functionButtons[1].setText("X");
        functionButtons[2].setText("+");
        functionButtons[3].setText("-");
        functionButtons[4].setText(".");
        functionButtons[5].setText("=");
        functionButtons[6].setText("Del");
        functionButtons[6].setBounds(20, 450, 115, 75);
        functionButtons[7].setText("Clr");
        functionButtons[7].setBounds(135, 450, 115, 75);
        functionButtons[8].setText("Neg(-)");
        //functionButtons[8].setBorder(BorderFactory.createBevelBorder(2));
        functionButtons[8].setBounds(250, 450, 120, 75);

        //adding buttoms to the numsPanel

        numsPanel.add(numButtons[7]);
        numsPanel.add(numButtons[8]);
        numsPanel.add(numButtons[9]);

        numsPanel.add(functionButtons[0]);

        numsPanel.add(numButtons[4]);
        numsPanel.add(numButtons[5]);
        numsPanel.add(numButtons[6]);

        numsPanel.add(functionButtons[1]);

        numsPanel.add(numButtons[1]);
        numsPanel.add(numButtons[2]);
        numsPanel.add(numButtons[3]);

        numsPanel.add(functionButtons[2]);
        numsPanel.add(functionButtons[4]);

        numsPanel.add(numButtons[0]);

        numsPanel.add(functionButtons[5]);
        numsPanel.add(functionButtons[3]);

        panel.add(functionButtons[6]);
        panel.add(functionButtons[7]);
        panel.add(functionButtons[8]);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator temp = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10; i++){
            if(e.getSource()==numButtons[i])
                textBox.setText(textBox.getText() + i);
        }
        if(e.getSource()==functionButtons[0]){
            String input = textBox.getText();
            if(input.length() > 0){
                num1 = Double.parseDouble(input);
                textBox.setText("");
                operator = '/';
            }
        }
        if(e.getSource()==functionButtons[1]){
            String input = textBox.getText();
            if(input.length() > 0){
                num1 = Double.parseDouble(input);
                textBox.setText("");
                operator = '*';
            }
        }
        if(e.getSource()==functionButtons[2]){
            String input = textBox.getText();
            if(input.length() > 0){
                num1 = Double.parseDouble(input);
                textBox.setText("");
                operator = '+';
            }
        }
        if(e.getSource()==functionButtons[3]){
            String input = textBox.getText();
            if(input.length() > 0){
                num1 = Double.parseDouble(input);
                textBox.setText("");
                operator = '-';
            }
        }
        if(e.getSource()==functionButtons[4]){
            String temp = textBox.getText();
            int tmp = 1;
            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == '.')
                    tmp = 0;
            }
            if(tmp == 1)
                textBox.setText(textBox.getText() + '.');
        }
        if(e.getSource()==functionButtons[5]){
            num2 = Double.parseDouble(textBox.getText());
            textBox.setText("");
            if(operator == '+'){
                double resultAdd = num1 + num2;
                DecimalFormat df = new DecimalFormat("#.######");
                String formattedResult = df.format(resultAdd);
                textBox.setText(String.valueOf(formattedResult));
            }
            if(operator == '*'){
                double resultMul = num1 * num2;
                DecimalFormat df = new DecimalFormat("#.######");
                String formattedResult = df.format(resultMul);
                textBox.setText(String.valueOf(formattedResult));
            }
            if(operator == '/'){
                if(num2 == 0){
                    textBox.setText("ERROR");
                }
                else {
                    double resultDiv = num1 / num2;
                    DecimalFormat df = new DecimalFormat("#.######");
                    String formattedResult = df.format(resultDiv);
                    textBox.setText(formattedResult);
                }

            }
            if(operator == '-'){
                double resultSub = num1 - num2;
                DecimalFormat df = new DecimalFormat("#.######");
                String formattedResult = df.format(resultSub);
                textBox.setText(String.valueOf(formattedResult));
            }
        }
        if(e.getSource()==functionButtons[6]){
            String temp = textBox.getText();
            textBox.setText("");
            for(int i = 0; i < temp.length() - 1; i++)
                textBox.setText(textBox.getText() + temp.charAt(i));
        }
        if(e.getSource()==functionButtons[7])
            textBox.setText("");
        if(e.getSource()==functionButtons[8]){
            double temp = Double.parseDouble(textBox.getText());
            temp *= -1;
            textBox.setText(String.valueOf(temp));
        }

    }
}