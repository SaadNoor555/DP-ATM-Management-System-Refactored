package atm;

import javax.swing.*;

public class WithdrawManager {
    private AccountManager accountManager;

    WithdrawManager(){
        accountManager = AccountManager.getAccountManager();
    }

    public void withdraw(String o) {
        String startBalance, withdrawAmount, currentBalance_str;
        int startBalance_int, withdrawAmount_int, currentBalance;

        for (int i = 0; i < accountManager.getCustomerlist().size(); i++) {
            AccountData atm = (AccountData) accountManager.getCustomerlist().get(i);
            if (o.equals(atm.getPincode())) {
                startBalance = atm.getStartbalance();
                startBalance_int = Integer.parseInt(startBalance);

                withdrawAmount = JOptionPane.showInputDialog(null, "Enter The Amount To Withdarw", "WITHDARW MENU", JOptionPane.QUESTION_MESSAGE);
                withdrawAmount_int = Integer.parseInt(withdrawAmount);

                currentBalance = startBalance_int - withdrawAmount_int;

                while (currentBalance < 0) {
                    startBalance = atm.getStartbalance();
                    startBalance_int = Integer.parseInt(startBalance);

                    withdrawAmount = JOptionPane.showInputDialog(null, "Invalid Amount\nPlease Enter The Suffecient Amount To WithDraw", "WITHDRAW MENU", JOptionPane.WARNING_MESSAGE);
                    withdrawAmount_int = Integer.parseInt(withdrawAmount);

                    currentBalance = startBalance_int - withdrawAmount_int;
                }
                currentBalance_str = String.valueOf(currentBalance);
                atm.setStartbalance(currentBalance_str);
                JOptionPane.showMessageDialog(null, "Withdarw proccesed\nYou have Withdarwed Amount of" + withdrawAmount + "\nYour Total Cash Is now: " + atm.getStartbalance(), "Information", JOptionPane.INFORMATION_MESSAGE);
                AccountSaver accountSaver = new AccountSaver();
                accountSaver.savePerson();
            }
        }
    }
}
