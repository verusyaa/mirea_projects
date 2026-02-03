import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountrySelector {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Country Selector");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 200);

        String[] countries = {"Select a country","Russia", "USA", "Canada", "Germany", "Japan", "Australia"};
        JComboBox<String> comboBox = new JComboBox<>(countries);
        JTextArea infoArea = new JTextArea(5, 25);
        infoArea.setEditable(false);

        frame.add(comboBox);
        frame.add(new JScrollPane(infoArea));

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                String info = "";

                switch (selected) {
                    case "USA":
                        info = "Capital: Washington, D.C.\nPopulation: ~331 million";
                        break;
                    case "Canada":
                        info = "Capital: Ottawa\nPopulation: ~38 million";
                        break;
                    case "Russia":
                        info = "Capital: Moscow\nPopulation: ~230 million";
                        break;
                    case "Germany":
                        info = "Capital: Berlin\nPopulation: ~83 million";
                        break;
                    case "Japan":
                        info = "Capital: Tokyo\nPopulation: ~125 million";
                        break;
                    case "Australia":
                        info = "Capital: Canberra\nPopulation: ~26 million";
                        break;
                    default:
                        info = "Please select a country.";
                }
                infoArea.setText(info);
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
