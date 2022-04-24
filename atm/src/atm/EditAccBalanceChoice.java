package atm;

import javax.swing.*;

public class EditAccBalanceChoice implements EditmenuOptionsMatcher {
    @Override
    public boolean match(int n) {
        return n==5;
    }

    @Override
    public AccountData set(AccountData atm) {
        atm.setStartbalance(JOptionPane.showInputDialog(null,"Enter new Starting Balance to Replace the Old One","EDIT STARTING BALANCE",JOptionPane.QUESTION_MESSAGE));
        return atm;
    }
}
