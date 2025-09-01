import java.util.Scanner;

// custom exceptions
class ATMException extends Exception {
    public ATMException(String msg) { super(msg); }
}

class InvalidAmountException extends ATMException {
    public InvalidAmountException(String msg) { super(msg); }
}

class InsufficientFundsException extends ATMException {
    public InsufficientFundsException(String msg) { super(msg); }
}

class InvalidOptionException extends ATMException {
    public InvalidOptionException(String msg) { super(msg); }
}

// account class
class Account {
    private double balance;

    public Account(double openingBalance) throws InvalidAmountException {
        if (openingBalance < 0) throw new InvalidAmountException("Opening balance < 0 not allowed");
        this.balance = openingBalance;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("deposit must be > 0");
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("withdraw must be > 0");
        if (amount > balance) throw new InsufficientFundsException("not enough money");
        balance -= amount;
    }
}

// atm class
class ATM {
    private final Scanner sc;
    private final Account account;
    private final String pin = "1234"; // fixed pin
    private final int maxTries = 3;

    public ATM(Scanner sc, Account account) {
        this.sc = sc;
        this.account = account;
    }

    // read int from user
    private int readInt(String msg) throws InvalidOptionException {
        System.out.print(msg);
        String line = sc.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new InvalidOptionException("not a number");
        }
    }

    // read double from user
    private double readAmount(String msg) throws InvalidAmountException {
        System.out.print(msg);
        String line = sc.nextLine().trim();
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new InvalidAmountException("not a valid number");
        }
    }

    // check pin
    public boolean authenticate() {
        System.out.println("=== ATM Login ===");
        for (int i = 1; i <= maxTries; i++) {
            System.out.print("enter pin: ");
            String entered = sc.nextLine().trim();
            if (entered.equals(pin)) {
                System.out.println("login ok\n");
                return true;
            }
            System.out.println("wrong pin " + i + "/" + maxTries);
        }
        System.out.println("too many wrong tries");
        return false;
    }

    // main atm loop
    public void run() {
        boolean run = true;
        while (run) {
            System.out.println("\n--- menu ---");
            System.out.println("1) balance");
            System.out.println("2) deposit");
            System.out.println("3) withdraw");
            System.out.println("4) exit");
            try {
                int choice = readInt("choose: ");
                switch (choice) {
                    case 1 -> System.out.println("balance = " + account.getBalance());
                    case 2 -> {
                        double amt = readAmount("deposit amt: ");
                        account.deposit(amt);
                        System.out.println("done. balance = " + account.getBalance());
                    }
                    case 3 -> {
                        double amt = readAmount("withdraw amt: ");
                        account.withdraw(amt);
                        System.out.println("done. balance = " + account.getBalance());
                    }
                    case 4 -> {
                        System.out.println("bye");
                        run = false;
                    }
                    default -> throw new InvalidOptionException("menu 1-4 only");
                }
            } catch (ATMException e) {
                System.out.println("error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("unexpected: " + e.getMessage());
            }
        }
    }
}

// main class
public class ATMApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        // ask opening balance
        while (true) {
            try {
                System.out.print("opening balance: ");
                String line = sc.nextLine().trim();
                double val = Double.parseDouble(line);
                account = new Account(val);
                break;
            } catch (NumberFormatException e) {
                System.out.println("enter number only");
            } catch (InvalidAmountException e) {
                System.out.println("error: " + e.getMessage());
            }
        }

        ATM atm = new ATM(sc, account);
        if (atm.authenticate()) {
            atm.run();
        }
    }
}

