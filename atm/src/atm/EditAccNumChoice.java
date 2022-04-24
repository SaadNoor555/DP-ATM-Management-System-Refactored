package atm;

import javax.swing.*;

public class EditAccNumChoice implements EditmenuOptionsMatcher {
    @Override
    public boolean match(int n) {
        return n==4;
    }

    @Override
    public AccountData set(AccountData atm) {
        atm.setAccountnumber(JOptionPane.showInputDialog(null,"Enter Account Number","ACCOUNT NUMBER",JOptionPane.QUESTION_MESSAGE));
        return atm;
    }
}

