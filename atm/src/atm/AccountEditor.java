package atm;

import javax.swing.*;
import java.util.ArrayList;

public class AccountEditor {
    private Admin admin;
    AccountEditor(){
        admin = Admin.getAdmin();
    }
    public void edit() {
        String str=JOptionPane.showInputDialog(null,"Enter PinCode To Edit Account","EDITING MENU",JOptionPane.QUESTION_MESSAGE);
        String aa;
        int ch;
        for(int i=0;i<admin.getCustomerlist().size();i++) {
            int bb;
            AccountData atm=(AccountData)admin.getCustomerlist().get(i);
            if(str.equals(atm.getPincode())) {
                bb= JOptionPane.showConfirmDialog(null,"Do You Want To Edit The Following Record"+"\n\nPINCODE : "+atm.getPincode()+"\nCustomer name : "+atm.getCustomername()+"\nAccount Type : "+atm.getAccounttype()+
                        "\nAccount Number : "+atm.getAccountnumber()+"\nTotal Balance : "+atm.getStartbalance(),"CONFIRMATION BOX",JOptionPane.YES_NO_OPTION);
                if(bb==JOptionPane.YES_OPTION) {
                    aa=JOptionPane.showInputDialog(null,"Enter 1 To Edit PinCode\nEnter 2 To Edit Customer Name \nEnter 3 To Edit Account Type\nEnter 4 Account Number\nEnter 5 To Edit Starting Balance\n\n ","EDITING MENU",JOptionPane.INFORMATION_MESSAGE);
                    ch=Integer.parseInt(aa);
                    AccountSaver accountSaver = new AccountSaver();
                    ArrayList<EditmenuOptionsMatcher>menuOptions = new ArrayList<>();
                    menuOptions.add(new EditAccBalanceChoice());
                    menuOptions.add(new EditAccNumChoice());
                    menuOptions.add(new EditAccTypeChoice());
                    menuOptions.add(new EditCustomerNameChoice());
                    menuOptions.add(new EditPinCodeChoice());
                    boolean flag = false;
                    for(EditmenuOptionsMatcher menuOption : menuOptions){
                        if(menuOption.match(ch))
                        {
                            flag = true;
                            atm = menuOption.set(atm);
                            accountSaver.savePerson();
                        }
                    }
                    if(flag==false)
                        JOptionPane.showMessageDialog(null,"Oh No! You have entered the Wrong Pin Code \nPlease Enter Valid Pincode","SORRY",JOptionPane.WARNING_MESSAGE);


                }
                else {
                    break;
                }
            }

        }
    }
}
