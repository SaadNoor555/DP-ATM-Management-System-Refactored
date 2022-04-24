package atm;

import javax.swing.*;

public class AccountAdder {
    private Admin admin;
    AccountAdder(){
        this.admin = Admin.getAdmin();
    }
    public void addPerson() {

        String pincode = JOptionPane.showInputDialog(null, "please enter PINCODE NO", "PINCODE ENTRY", JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < admin.getCustomerlist().size(); i++) {
            AccountData atm = (AccountData) admin.getCustomerlist().get(i);
            if (pincode.equals(atm.getPincode())) {
                pincode = JOptionPane.showInputDialog(null, "SORRY!This pincode is already in used for one customer\nEnter another pincode", "PINCODE ENTRY", JOptionPane.QUESTION_MESSAGE);
            }
        }
        String customername = JOptionPane.showInputDialog(null, "Please Enter Customer Name", "CUSTOMER NAME", JOptionPane.QUESTION_MESSAGE);
        String accounttype = JOptionPane.showInputDialog(null, "Please Enter Account Type\n(Saving or Current)", "ACCOUNT TYPE ENTRY FOR CUSTOMER", JOptionPane.QUESTION_MESSAGE);
        String accountnumber = JOptionPane.showInputDialog(null, "Enter Account Number", "ACCOUNT NUMBER ENTRY OF CUSTOMER", JOptionPane.QUESTION_MESSAGE);
        String startbalance = JOptionPane.showInputDialog(null, "Enter Starting Balance", "STARTING BALANCE ENTRY OF CUSTOMER", JOptionPane.QUESTION_MESSAGE);

        AccountData atm = new AccountData(pincode, customername, accounttype, accountnumber, startbalance);
        admin.addPersonToCustomerlist(atm);
    }
}
