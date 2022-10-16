package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private PasswordGenerator passwordGenerator;
    private Icon iconCopy = new ImageIcon(this.getClass().getResource("/copy-icon.png"));
    private Icon iconDice = new ImageIcon(this.getClass().getResource("/dice-icon.png"));
    private JPasswordField txtGeneratedPassword = new JPasswordField();
    private JButton btnGeneratePassword = new JButton(iconDice);
    private JButton btnCopyPassword = new JButton(iconCopy);

    public MainFrame(PasswordGenerator passwordgenerator) {
        super("demo-java-swing");
        this.passwordGenerator = passwordgenerator;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnGeneratePassword.setToolTipText("Generate Password");
        btnCopyPassword.setToolTipText("Copy Password");

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(btnGeneratePassword);
        toolBar.add(btnCopyPassword);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toolBar, BorderLayout.EAST);
        panel.add(txtGeneratedPassword, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.CENTER);

        txtGeneratedPassword.setPreferredSize(new Dimension(350, 24));
        pack();
        setLocationRelativeTo(null);

        btnCopyPassword.addActionListener(e -> {
            txtGeneratedPassword.putClientProperty("JPasswordField.cutCopyAllowed", true);
            txtGeneratedPassword.selectAll();
            txtGeneratedPassword.copy();
        });

        btnGeneratePassword.addActionListener(e -> {
            String generatedPassword = passwordgenerator.generate();
            txtGeneratedPassword.setText(generatedPassword);
        });
    }
}
