
package atm1;

import java.util.ArrayList;


public class NewClass implements ATM{  
    private double currentbalance;
    Client c =new Client(1000.0);
    ArrayList<String> typeList=new ArrayList<>();
    ArrayList<Double> balanceList=new ArrayList<>();
    ArrayList<Double> amountlist=new ArrayList<>();
    int y=-1;
    @Override
    public double getcurrentbalance() {
        return c.getBalance();
    }

    @Override
    public void withdarw(String amount) {
        double amount2=Double.parseDouble(amount);
        double current=c.getBalance();
        if (current>=amount2) {
            currentbalance=current-amount2;
             c.setBalance(currentbalance);
             if (balanceList.size()==5) {
        balanceList.remove(0);
        typeList.remove(0);
        amountlist.remove(0);
        y--;
    }
    balanceList.add(currentbalance);
    typeList.add("withdraw");
    amountlist.add(amount2);
       y++;
     }
        }    

    @Override
    public void deposit(String amount) {
        double amount2=Double.parseDouble(amount);
        double current=c.getBalance();
        currentbalance=current+amount2;
        c.setBalance(currentbalance);
             if (balanceList.size()==5) {
        balanceList.remove(0);
        typeList.remove(0);
        amountlist.remove(0);
        y--;
    }
    balanceList.add(currentbalance);
    typeList.add("deposit");
    amountlist.add(amount2);
    y++;
     }

    @Override
    public String prev() {
        if (y==0) {
            return "there is no prev history";  
        }
        else{
            int x=--y;
            String v= typeList.get(x)+"\n"+amountlist.get(x)+"\n"+balanceList.get(x);
            return v;
        }
    }

    @Override
    public String next() {
        if (y==4) {
            return "there is no next history";  
        }
        else{
            int x=++y;
            String v= typeList.get(x)+"\n"+amountlist.get(x)+"\n"+balanceList.get(x);
            return v;
            
        }
    }
}
