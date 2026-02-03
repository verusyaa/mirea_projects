import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator {
    private JFrame frame;
    private JTextField display;
    private double num1, num2, result;
    private String operator;

    public GUICalculator() {
        frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                display.setText(display.getText() + command);
            } else if ("+-*/".contains(command)) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            } else if ("=".equals(command)) {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }
                display.setText(String.valueOf(result));
            } else if ("C".equals(command)) {
                display.setText("");
                num1 = num2 = result = 0;
                operator = "";
            }
        }
    }

    public static void main(String[] args) {
        new GUICalculator();
    }
}
