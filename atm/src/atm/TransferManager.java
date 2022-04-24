package atm;

import javax.swing.*;

public class TransferManager {
    private AccountManager accountManager;

    public TransferManager() {
        this.accountManager = AccountManager.getAccountManager();
    }

    public void transfer(String k) {
        String acc_start_balance, amountToTransfer, recipient;
        int acc_start_balance_int, amountTransferred_int, currentBalance;


        for (int i = 0; i < accountManager.getCustomerlist().size(); i++) {
            AccountData atm = (AccountData) accountManager.getCustomerlist().get(i);
            if (k.equals(atm.getPincode()));
            {
                acc_start_balance = atm.getStartbalance();
                acc_start_balance_int = Integer.parseInt(acc_start_balance);

                recipient = JOptionPane.showInputDialog(null, "Enter The Account Number To whom you Transfer Amount", "MONEY TRANSACTION MENU", JOptionPane.QUESTION_MESSAGE);
                amountToTransfer = JOptionPane.showInputDialog(null, "Enter The Amount To Transfer", "MONEYTRANSACTION MENU", JOptionPane.QUESTION_MESSAGE);
                amountTransferred_int = Integer.parseInt(amountToTransfer);

                currentBalance = acc_start_balance_int - amountTransferred_int;
                while (currentBalance < 0) {
                    acc_start_balance = atm.getStartbalance();
                    acc_start_balance_int = Integer.parseInt(acc_start_balance);

                    amountToTransfer = JOptionPane.showInputDialog(null, "Invalid Amount\nPlease Enter The Suffecient Amount To Transfer", "MONEYTRANSACTION MENU", JOptionPane.WARNING_MESSAGE);
                    amountTransferred_int = Integer.parseInt(amountToTransfer);
                    currentBalance = acc_start_balance_int - amountTransferred_int;
                }
                String u = String.valueOf(currentBalance);
                atm.setStartbalance(u);

                JOptionPane.showMessageDialog(null, "Transaction is done succesfully\n\nAmount of " + amountToTransfer + "is transferd To " + recipient + "\n\nYour Total Cash Is : " + atm.getStartbalance(), "MONEY TRANSACTION PROCESSED", JOptionPane.INFORMATION_MESSAGE);

                AccountSaver accountSaver = new AccountSaver();
                accountSaver.savePerson();
            }
        }
    }
}
