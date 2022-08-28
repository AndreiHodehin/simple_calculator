import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;
    JTextField infoField;

    Font myFont = new Font("Arial",Font.BOLD,30);
    Font infoFont = new Font("Arial", Font.ITALIC,20);

    double num1=0, num2=0, result = 0;
    char operator;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        infoField = new JTextField();
        infoField.setBounds(50,10,300,25);
        infoField.setFont(infoFont);
        infoField.setEditable(false);

        textField = new JTextField();
        textField.setBounds(50,45,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("clr");
        negButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(true);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
//        panel.setBackground(C);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(infoField);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < numberButtons.length; i++) {
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
                infoField.setText(infoField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
            infoField.setText(infoField.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            infoField.setText(infoField.getText().concat("+"));
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            infoField.setText(infoField.getText().concat("-"));
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            infoField.setText(infoField.getText().concat("*"));
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            infoField.setText(infoField.getText().concat("/"));
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if(num2 == 0){
                        break;
                    }
                    result = num1 / num2;
                    break;
            }
            if (num2 == 0){
                textField.setText("Dividing by 0");
                infoField.setText("");
                num1 = 0;
            } else {
                textField.setText(String.valueOf(result));
                infoField.setText(infoField.getText().concat("=").concat(String.valueOf(result)));
                num1 = result;
            }

        }

        if(e.getSource() == clrButton) {
            textField.setText("");
            infoField.setText("");
        }
        if(e.getSource() == delButton) {
            String str = textField.getText();
            str = str.substring(0,str.length()-1);
            textField.setText(str);
            String info = infoField.getText();
            info = info.substring(0,info.length()-1);
            infoField.setText(info);
        }

        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *=-1;
            textField.setText(String.valueOf(temp));
            infoField.setText(infoField.getText().concat("*(-1)"));
        }
    }
}
