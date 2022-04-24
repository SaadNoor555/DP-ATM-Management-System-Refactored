package atm;

import javax.swing.*;

public class EditPinCodeChoice implements EditmenuOptionsMatcher {

    @Override
    public boolean match(int n) {
        return n==1;
    }

    @Override
    public AccountData set(AccountData atm) {
        atm.setPincode(JOptionPane.showInputDialog(null,"Enter new PinCode to Replace old one","EDIT PINCODE",JOptionPane.QUESTION_MESSAGE));
        return atm;
    }
}
