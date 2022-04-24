package atm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserLoader {
    AccountManager accountManager;
    UserLoader(){
        accountManager = AccountManager.getAccountManager();
    }
    public void loadUsers() {
        String[] ss = null;
        String pincode, customername, accounttype, accountnumber, startbalance;

        try {
            FileReader fr = new FileReader("Customer Record.txt");
            BufferedReader br = new BufferedReader(fr);


            String line = br.readLine();

            while (line != null) {
                ss = line.split(",");
                pincode = ss[0];
                customername = ss[1];
                accounttype = ss[2];
                accountnumber = ss[3];
                startbalance = ss[4];

                AccountData atm = new AccountData(pincode, customername, accounttype, accountnumber, startbalance);
                accountManager.getCustomerlist().add(atm);
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }
    }
}
