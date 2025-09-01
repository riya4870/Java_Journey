import java.util.*;
class BankAccount {
    private double balance;
    public BankAccount(double initialBal)
    {
        this.balance = initialBal;
    }
    public synchronized void deposit(double amt)
    {
        if(amt > 0)
        {
            balance+=amt;
        }

    }
    public synchronized boolean withdraw(double amt)
    {
        if(amt > 0 && balance >= amt)
        {
            balance -= amt;
            return true;
        }
        return false;
    }
    public synchronized double getBal()
    {
        return balance;
    }
}
public class BankAccountTest
{
    public static void main(String args[]) throws InterruptedException
    {
        double bal;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial balance of your account: ");
        bal=sc.nextDouble();
        BankAccount acc = new BankAccount(bal);

        Runnable depositBal = () -> {
            for(int i=0; i<100; i++)
            {
                acc.deposit(50);
                Thread.yield();
            }

        };
        Runnable withdrawBal = () -> {
            for(int i=0; i<100; i++)
            {
                acc.withdraw(50);
                Thread.yield();
            }
        };
        Thread[] threads = new Thread[6]; // 3 depositors, 3 withdrawers

        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(depositBal, "Depositor-" + i);
            threads[i + 3] = new Thread(withdrawBal, "Withdrawer-" + i);
        }

        // Start all threads
        for (Thread t : threads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        // Final balance
        System.out.println("Final balance: ₹" + acc.getBal());

        sc.close();
    }
}




