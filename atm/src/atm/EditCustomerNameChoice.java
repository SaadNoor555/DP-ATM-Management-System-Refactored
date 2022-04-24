package atm;

import javax.swing.*;

public class EditCustomerNameChoice implements EditmenuOptionsMatcher {

    @Override
    public boolean match(int n) {
        return n==2;
    }

    @Override
    public AccountData set(AccountData atm) {
        atm.setCustomername(JOptionPane.showInputDialog(null,"Enter New Customer Name to Replace Old One","EDIT CUSTOMER NAME",JOptionPane.QUESTION_MESSAGE));
        return atm;
    }
}
