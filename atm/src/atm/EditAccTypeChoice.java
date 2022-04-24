package atm;

import javax.swing.*;

public class EditAccTypeChoice implements EditmenuOptionsMatcher {
    @Override
    public boolean match(int n) {
        return n==3;
    }

    @Override
    public AccountData set(AccountData atm) {
        atm.setAccounttype(JOptionPane.showInputDialog(null,"Enter Account Type\n(Saving or Current)","EDIT ACCOUNT TYPE",JOptionPane.QUESTION_MESSAGE));
        return atm;
    }
}
