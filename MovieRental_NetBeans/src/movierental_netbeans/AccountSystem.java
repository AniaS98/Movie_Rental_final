package movierental_netbeans;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AccountSystem {
    public ArrayList<Client> AccountsList;

    public ArrayList<Client> getAccountsList() {
        return AccountsList;
    }

    public void setAccountsList(ArrayList<Client> accountsList) {
        AccountsList = accountsList;
    }

    public AccountSystem()
    {
        AccountsList = new ArrayList<Client>();
    }

    public void AddAccount(Client c)
    {
        AccountsList.add(c);
    }

    public boolean IfExist(String nrL)
    {
        for(Client n : AccountsList)
        {
            if (n.login.equals(nrL))
                return true;
        }
        return false;
    }

    public void DeleteAccount(Client c)
    {
        AccountsList.remove(c);
    }

    public Client CheckLoginPassword(String l, String p)
    {
        for(Client c : AccountsList)
        {
            if (c.login.equals(l) && c.password.equals(p))
            {
                return c;
            }
        }
        return null;
    }
    public void EnterChanges(Client c, ArrayList<Movie> l)
    {
        Client client = c;
        c.rentalMoviesList = l;
    }

    public double PenaltyCharging(Client c) {
        c.penalty = 0;
        Calendar now = Calendar.getInstance();
        for (Movie m:c.rentalMoviesList) {
            if (now.after(m.returnDate)) {
                long days = Math.round((m.returnDate.getTimeInMillis()-now.getTimeInMillis())/(24*60*60*1000));
                c.penalty = days * 1;
            }
        }
        return c.penalty;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Client c : AccountsList)
        {
            sb.append(c.toString());
        }
        return sb.toString();
    }

    public static void SaveXML(String FileName, AccountSystem s) throws IOException {
        FileOutputStream fos = new FileOutputStream(FileName);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(s);
        encoder.close();
        fos.close();
    }

    public static Object ReadXML(String FileName) throws IOException {
        FileInputStream fis = new FileInputStream(FileName);
        XMLDecoder decoder = new XMLDecoder(fis);
        Object decodedSettings = (Object) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }




}
