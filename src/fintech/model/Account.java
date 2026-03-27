package fintech.model;

public class Account {
    private String owner;
    private String accountName;
    private double balance;

    public Account(String owner, String accountName) {
        this.owner = owner;
        this.accountName = accountName;
        this.balance = 0.0;
    }

    @Override
    public String toString() {
        return accountName + "|" + owner + "|" + balance;
    }
}