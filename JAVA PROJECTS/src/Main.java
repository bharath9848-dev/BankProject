import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1 Create Account");
            System.out.println("2 Deposit Money");
            System.out.println("3 Withdraw Money");
            System.out.println("4 Check Balance");
            System.out.println("5 Show All Accounts");
            System.out.println("6 Delete Account");
            System.out.println("7 Transaction History");
            System.out.println("8 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    long accNo = sc.nextLong();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    bank.createAccount(accNo, name, balance);

                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    long depAcc = sc.nextLong();

                    System.out.print("Enter Amount: ");
                    double depAmt = sc.nextDouble();

                    bank.deposit(depAcc, depAmt);

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    long withAcc = sc.nextLong();

                    System.out.print("Enter Amount: ");
                    double withAmt = sc.nextDouble();

                    bank.withdraw(withAcc, withAmt);

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    long balAcc = sc.nextLong();

                    bank.checkBalance(balAcc);

                    break;

                case 5:

                    bank.showAllAccounts();

                    break;

                case 6:

                    System.out.print("Enter Account Number: ");
                    long delAcc = sc.nextLong();

                    bank.deleteAccount(delAcc);

                    break;

                case 7:

                    System.out.print("Enter Account Number: ");
                    long tAcc = sc.nextLong();

                    bank.showTransactions(tAcc);

                    break;

                case 8:

                    System.out.println("Thank you for using the system.");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}