package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginForm extends JFrame implements ActionListener {


    JPanel panel;
    JLabel name_label, pass_label, picLab, userLab, adminLab;
    JCheckBox box;
    JButton loginButton, resetButton;
    JTextField usernameField;
    JPasswordField passwordField;
    String password;
    char[] pa;
    ImageIcon img;
    JRadioButton userRadio, adminRadio;


    LoginForm() {
        super("Login Forum");
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        name_label = new JLabel("User Name :");
        pass_label = new JLabel("Password :");
        userLab = new JLabel("User");
        adminLab = new JLabel("Admin");

        box = new JCheckBox();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        img = new ImageIcon("ims.jpg");
        picLab = new JLabel(img);

        userRadio = new JRadioButton();
        adminRadio = new JRadioButton();

        usernameField = new JTextField();
        usernameField.setColumns(5);
        passwordField = new JPasswordField();
        passwordField.setColumns(6);

        this.add(panel);
        panel.add(picLab);
        panel.add(name_label);
        panel.add(usernameField);
        panel.add(pass_label);
        panel.add(passwordField);
        panel.add(box);
        panel.add(loginButton);
        panel.add(resetButton);
        panel.add(userRadio);
        panel.add(userLab);
        panel.add(adminRadio);
        panel.add(adminLab);


        ButtonGroup group = new ButtonGroup();
        group.add(userRadio);
        group.add(adminRadio);


        this.setVisible(true);
        this.setSize(590, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        panel.setBackground(Color.white);
        panel.setForeground(Color.gray);

        box.addActionListener(this);
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader("loginInfo.txt");
                br = new BufferedReader(fr);

                String s1 = br.readLine();
                String s4 = br.readLine();     // for Password

                char[] p = passwordField.getPassword();
                password = new String(p);
                String text = usernameField.getText();


                if (text.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ENTER YOUR USER NAME and Password");
                } else if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ENTER YOUR USER NAME ");
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ENTER YOUR Password");
                } else if (!usernameField.getText().equals(s1) && !password.equals(s4)) {
                    JOptionPane.showMessageDialog(null, "WRONG USERNAME AND PASSWORD");
                } else if (!userRadio.isSelected() && !adminRadio.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please Select on Option admin or user");
                } else if (usernameField.getText().equals(s1) && password.equals(s4)) {
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                    if (userRadio.isSelected()) {
                        AccountManager t = AccountManager.getAccountManager();
                        t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        t.setSize(460, 400);
                        t.setVisible(true);
                        t.setLocationRelativeTo(null);
                    } else if (adminRadio.isSelected()) {
                        AdminPanel t2 = new AdminPanel();
                        t2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        t2.setSize(540, 350);
                        t2.setVisible(true);
                        t2.setLocationRelativeTo(null);
                    }
                }

                fr.close();
                br.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        } else if (ae.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        }
        if (box.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }

}
    

