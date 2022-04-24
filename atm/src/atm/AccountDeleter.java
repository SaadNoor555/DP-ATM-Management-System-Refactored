package atm;

import javax.swing.*;

public class AccountDeleter {
    private Admin admin;

    public AccountDeleter() {
        this.admin = Admin.getAdmin();
    }
    public void deleteAccount()
    {
        String n =JOptionPane.showInputDialog(null,"Enter PinCode To Delete Account","DELETION MENU",JOptionPane.QUESTION_MESSAGE);
        int aa;

        for(int i=0;i<admin.getCustomerlist().size();i++)
        {
            AccountData atm=(AccountData)admin.getCustomerlist().get(i);
            if(n.equals(atm.getPincode()))
            {
                aa= JOptionPane.showConfirmDialog(null,"Do you really want to delete The Following Record"+"\n\nPINCODE : "+atm.getPincode()+"\nCustomer name : "+atm.getCustomername()+"\nAccount Type : "+atm.getAccounttype()+
                        "\nAccount Number : "+atm.getAccountnumber()+"\nTotal Balance : "+atm.getStartbalance(),"CONFIRMATION ABOUT DELETION",JOptionPane.YES_NO_OPTION);
                if(aa==JOptionPane.YES_OPTION)
                {
                    admin.deleteFromCustomerList(i);
                }
                else
                {
                    break;
                }
            }

        }

    }
}
