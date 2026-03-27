
package fintech.model;

public abstract class Transaction {

    protected int id;
    protected String username;
    protected double amount;
    protected String timestamp;
    protected String description;

    public Transaction(int id, String username, double amount, String timestamp, String description) {
        this.id = id;
        this.username = username;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
    }

    public int getid(){
        return id;
    }

    public String getusername(){
        return username;
    }

    public double amount(){
        return amount;
    }

    public String timestamp(){
        return timestamp;
    }

    public String description(){
        return description;
    }
    
    public abstract String getType();

    @Override
    public String toString() {
        return id + "|" + getType() + "|" + amount + "|" + timestamp + "|" + description;
    }
}

