package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Icon iconCopy = new ImageIcon(this.getClass().getResource("/copy-icon.png"));
    private Icon iconDice = new ImageIcon(this.getClass().getResource("/dice-icon.png"));
    private JPasswordField txtGeneratedPassword = new JPasswordField();
    private JButton btnGeneratePassword = new JButton(iconDice);
    private JButton btnCopy = new JButton(iconCopy);

    public MainFrame() {
        super("demo-java-swing");
        setSize(400, 120);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnGeneratePassword.setToolTipText("Generate Password");
        btnCopy.setToolTipText("Copy");

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(btnGeneratePassword);
        toolBar.add(btnCopy);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toolBar, BorderLayout.PAGE_START);
        panel.add(txtGeneratedPassword, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);

        btnCopy.addActionListener(e -> {
            txtGeneratedPassword.putClientProperty("JPasswordField.cutCopyAllowed", true);
            txtGeneratedPassword.selectAll();
            txtGeneratedPassword.copy();
        });

        btnGeneratePassword.addActionListener(e -> {
            String generatedPassword = "8bg?vq$R>Y&aLQ9y";
            txtGeneratedPassword.setText(generatedPassword);
        });
    }
}
