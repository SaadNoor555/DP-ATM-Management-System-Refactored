package atm;

import javax.swing.*;

public class InqueryManager {
    private AccountManager accountManager;

    InqueryManager(){
        accountManager = AccountManager.getAccountManager();
    }

    public void makeInquery(String n) {
        for (int i = 0; i < accountManager.getCustomerlist().size(); i++) {
            AccountData atm = (AccountData) accountManager.getCustomerlist().get(i);
            if (n.equals(atm.getPincode())) {
                JOptionPane.showMessageDialog(null, "Welcome to your atm data Mr  ." + atm.getCustomername() + "\nYour Total Cash Is : " + atm.getStartbalance(), "WELCOME WELCOME MR  " + atm.getCustomername(), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
