package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Component
public class MainFrameImpl implements MainFrame {

    private final PasswordGenerator passwordGenerator;
    private final JFrame frame = new JFrame();
    private final Icon iconCopy = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/copy-icon.png")));
    private final Icon iconDice = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/dice-icon.png")));
    private final JPasswordField txtGeneratedPassword = new JPasswordField();
    private final JButton btnGeneratePassword = new JButton(iconDice);
    private final JButton btnCopyPassword = new JButton(iconCopy);

    @Autowired
    public MainFrameImpl(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;

        frame.setTitle("demo-java-swing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnGeneratePassword.setToolTipText("Generate Password");
        btnCopyPassword.setToolTipText("Copy Password");

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(btnGeneratePassword);
        toolBar.add(btnCopyPassword);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toolBar, BorderLayout.EAST);
        panel.add(txtGeneratedPassword, BorderLayout.CENTER);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        txtGeneratedPassword.setPreferredSize(new Dimension(350, 24));
        frame.pack();
        frame.setLocationRelativeTo(null);

        btnCopyPassword.addActionListener(e -> {
            txtGeneratedPassword.putClientProperty("JPasswordField.cutCopyAllowed", true);
            txtGeneratedPassword.selectAll();
            txtGeneratedPassword.copy();
        });

        btnGeneratePassword.addActionListener(e -> {
            String generatedPassword = this.passwordGenerator.generate();
            txtGeneratedPassword.setText(generatedPassword);
        });
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }
}
