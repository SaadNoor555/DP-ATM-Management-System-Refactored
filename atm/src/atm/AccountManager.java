package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountManager extends JFrame implements ActionListener {

    JButton equiryBtn, withdrawBtn, logoutBtn, transferBtn;
    JLabel atmLab;
    Container con;
    private ArrayList customerlist;
    private static AccountManager accountManager = AccountManager.getAccountManager();

    //    String s1;
    public static AccountManager getAccountManager() {
        if (accountManager == null)
            accountManager = new AccountManager();
        return accountManager;
    }

    private AccountManager() {
        super("Transaction");
        customerlist = new ArrayList();

        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(Color.BLACK);


        atmLab = new JLabel(new ImageIcon("atm.png"));
        atmLab.setBounds(60, 10, 300, 100);

        equiryBtn = new JButton("Balance Enquiry");
        equiryBtn.setBounds(10, 130, 150, 40);

        transferBtn = new JButton("Transfer Money");
        transferBtn.setBounds(260, 130, 150, 40);

        withdrawBtn = new JButton("WithDraw Money");
        withdrawBtn.setBounds(260, 230, 150, 40);


        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(10, 230, 150, 40);

        con.add(atmLab);
        con.add(equiryBtn);
        con.add(withdrawBtn);
        con.add(transferBtn);
        con.add(logoutBtn);

        equiryBtn.addActionListener(this);
        transferBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
		UserLoader userLoader = new UserLoader();
        userLoader.loadUsers();
    }

    public ArrayList getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(ArrayList customerlist) {
        this.customerlist = customerlist;
    }


    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String s1;
        if (b == equiryBtn) {
            s1 = JOptionPane.showInputDialog(null, "Enter PinCode To Check Account Balance ", "Check Balance", JOptionPane.QUESTION_MESSAGE);
			InqueryManager inqueryManager = new InqueryManager();
            for (int i = 0; i < customerlist.size(); i++) {
                AccountData atm = (AccountData) customerlist.get(i);

                if (!s1.equals(atm.getPincode())) {
                    JOptionPane.showMessageDialog(null, "You have entered Wrong Pincode \nPlease Enter Valid Pincode!!!!", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (s1.equals(atm.getPincode())) {

                    inqueryManager.makeInquery(s1);
                }
            }
        }

        if (b == withdrawBtn) {
			WithdrawManager withdrawManager = new WithdrawManager();
            s1 = JOptionPane.showInputDialog(null, "Enter PinCode To withDraw Balance ", "Withdraw Balance", JOptionPane.QUESTION_MESSAGE);
            for (int i = 0; i < customerlist.size(); i++) {
                AccountData atm = (AccountData) customerlist.get(i);

                if (s1.equals(atm.getPincode())) {

                    withdrawManager.withdraw(s1);
                } else if (!s1.equals(atm.getPincode())) {
                    JOptionPane.showMessageDialog(null, "You have entered Wrong Pincode \nPlease Enter Valid Pincode!!!!", "Warning", JOptionPane.WARNING_MESSAGE);

                }
            }
        }

        if (b == transferBtn) {
			TransferManager transferManager = new TransferManager();
			s1 = JOptionPane.showInputDialog(null, "Enter PinCode To Transfer Balance ", "Share balance", JOptionPane.QUESTION_MESSAGE);

            for (int i = 0; i < customerlist.size(); i++) {
                AccountData atm = (AccountData) customerlist.get(i);

                if (!s1.equals(atm.getPincode())) {
                    JOptionPane.showMessageDialog(null, "You have entered Wrong Pincode \nPlease Enter Valid Pincode!!!!", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (s1.equals(atm.getPincode())) {

                    transferManager.transfer(s1);
                }
            }
        }
        if (b == logoutBtn) {
            int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Good Bye", "ATM", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        }
    }

}
