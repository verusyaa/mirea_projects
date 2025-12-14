import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new FlowLayout());
        frame.setSize(350, 200);

        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");

        frame.add(new JLabel("First Number:"));
        frame.add(num1Field);
        frame.add(new JLabel("Second Number:"));
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(num1Field.getText().trim());
                    double x2 = Double.parseDouble(num2Field.getText().trim());
                    double result = 0;
                    String operation = "";

                    if (e.getSource() == addButton) {
                        result = x1 + x2;
                        operation = "Sum";
                    } else if (e.getSource() == subButton) {
                        result = x1 - x2;
                        operation = "Difference";
                    } else if (e.getSource() == mulButton) {
                        result = x1 * x2;
                        operation = "Product";
                    } else if (e.getSource() == divButton) {
                        if (x2 == 0) throw new ArithmeticException();
                        result = x1 / x2;
                        operation = "Quotient";
                    }

                    JOptionPane.showMessageDialog(frame, operation + " = " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, "Division by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}