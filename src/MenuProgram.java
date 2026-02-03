import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuProgram {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Program");
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea("This is the area you can write text.");
        textArea.setRows(5);

        panel.add(button1);
        panel.add(button2);
        panel.add(textField);
        panel.add(new JScrollPane(textArea));

        frame.add(panel, BorderLayout.CENTER);

        button1.addActionListener(e -> textArea.append("\nButton 1 clicked."));
        button2.addActionListener(e -> textArea.append("\nButton 2 clicked."));

        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Save clicked"));
        exitItem.addActionListener(e -> System.exit(0));
        copyItem.addActionListener(e -> textArea.copy());
        cutItem.addActionListener(e -> textArea.cut());
        pasteItem.addActionListener(e -> textArea.paste());
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Menu Program v1.0"));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}