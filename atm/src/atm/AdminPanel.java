package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame implements ActionListener {
    private JButton addAccount,deleteAccount,editAccount,saveToFile,logOut;
    private JLabel atmLab;
    private Container con;

    AdminPanel(){
        super("ADMIN");
        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(Color.black);

        atmLab = new JLabel(new ImageIcon("admin2.png"));
        atmLab.setBounds(10,10,500,100);

        addAccount = new JButton("Add Account");
        addAccount.setBounds(20,120,150,30);

        deleteAccount = new JButton("Delete Account");
        deleteAccount.setBounds(350,120,150,30);

        editAccount = new JButton("Edit Account");
        editAccount.setBounds(20,200,150,30);

        saveToFile = new JButton("Save to File");
        saveToFile.setBounds(350,200,150,30);

        logOut = new JButton("Logout");
        logOut.setBounds(190,250,150,30);

        con.add(atmLab);
        con.add(addAccount);
        con.add(deleteAccount);
        con.add(editAccount);
        con.add(saveToFile);
        con.add(logOut);

        addAccount.addActionListener(this);
        deleteAccount.addActionListener(this);
        editAccount.addActionListener(this);
        saveToFile.addActionListener(this);
        logOut.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        AccountSaver accountSaver = new AccountSaver();
        AccountEditor accountEditor = new AccountEditor();
        AccountDeleter accountDeleter = new AccountDeleter();
        AccountAdder accountAdder = new AccountAdder();
        JButton b = (JButton)e.getSource();
        if(b==addAccount) {
            accountAdder.addPerson();
        }
        if(b==deleteAccount) {
            accountDeleter.deleteAccount();
        }
        if(b==editAccount) {
            accountEditor.edit();
        }
        if(b==saveToFile) {
            accountSaver.savePerson();
        }

        if(b == logOut) {
            int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Good Bye", "ATM", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                dispose();
            }

        }
    }
}
