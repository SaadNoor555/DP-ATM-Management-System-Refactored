package atm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountSaver {
    Admin admin;
    AccountSaver()
    {
        admin = Admin.getAdmin();
    }
    public void savePerson()
    {
        try
        {
            AccountData atm;
            String line,line1;

            FileWriter fr=new FileWriter("Customer Record.txt");
            PrintWriter pw=new PrintWriter(fr);

            FileWriter fr1=new FileWriter("Customers Record.txt");
            PrintWriter pw1=new PrintWriter(fr1);

            pw1.print("PINCODE\t\t\tCUSTOMER NAME\t\t      ACCOUNT TYPE\t\tACCOUNT NUMBER\t\tSTARTING BALANCE\n");
            for (int i=0;i<admin.getCustomerlist().size(); i++)
            {
                atm=(AccountData)admin.getCustomerlist().get(i);
                line=atm.getPincode()+","+atm.getCustomername()+","+atm.getAccounttype()+","+atm.getAccountnumber()+","+atm.getStartbalance()+"\n";
                line1=atm.getPincode()+"\t\t\t"+atm.getCustomername()+"\t\t\t"+atm.getAccounttype()+"\t\t\t"+atm.getAccountnumber()+"\t\t\t"+atm.getStartbalance();
                pw1.println(line1);
                pw.print(line);
            }
            pw.flush();
            pw1.flush();
            pw.close();
            pw1.close();
            fr.close();
            fr1.close();
        }
        catch(IOException ioEX)
        {
            System.out.println(ioEX);
        }

    }
}
