package fintech.driver;

/**
 * @author 12S24026 Griselda Tabitha Nathania Hutahaean
 */

import fintech.model.*;

import java.util.*;

public class Driver2 {

    public static void main(String[] args) {

    
        Scanner input = new Scanner(System.in);

        
        Map<String, Account> accountMap = new LinkedHashMap<>();

        
        List<Transaction> transactionLog = new ArrayList<>();

        int idCounter = 1; 
        String command;


        while (input.hasNextLine()) {

            command = input.nextLine().trim();

            if (command.equals("---")) {
                break;
            }

            String[] data = command.split("#");

            if (command.startsWith("create-account#")) {

                if (data.length == 3) {
                    String name = data[1];
                    String username = data[2];

                    accountMap.put(username, new Account(name, username));
                }
            }

            else if (command.startsWith("deposit#")) {

                if (data.length == 5) {

                    String username = data[1];
                    double amount = Double.parseDouble(data[2]);
                    String time = data[3];
                    String desc = data[4];

                    Account acc = accountMap.get(username);

                    if (acc != null) {

                        acc.deposit(amount);

                        Transaction trx = new DepositTransaction(
                                idCounter++, username, amount, timestamp, description
                        );

                        acc.addTransaction(trx);
                        transactionLog.add(trx);
                    }
                }
            }


            else if (command.startsWith("withdraw#")) {

                if (data.length == 5) {

                    String username = data[1];
                    double amount = Double.parseDouble(data[2]);
                    String time = data[3];
                    String desc = data[4];

                    Account acc = accountMap.get(username);

                    if (acc != null) {

                        try {
                            // Kurangi saldo
                            acc.withdraw(amount);

                        
                            Transaction trx = new WithdrawTransaction(
                                    idCounter++, username, amount, time, desc
                            );

                            acc.addTransaction(trx);
                            transactionLog.add(trx);

                        } catch (NegativeBalanceException) {
                           
                        }
                    }
                }
            }
        }
        for (Account acc : accountMap.values()) {
            System.out.println(acc);
        }

        input.close();
    }
}