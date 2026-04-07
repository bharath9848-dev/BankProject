import java.sql.*;

public class Bank {

    // Create Account
    public void createAccount(long accNo, String name, double balance) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "INSERT INTO accounts VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setLong(1, accNo);
            ps.setString(2, name);
            ps.setDouble(3, balance);

            ps.executeUpdate();

            System.out.println("Account created successfully.");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deposit Money
    public void deposit(long accNo, double amount) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "UPDATE accounts SET balance = balance + ? WHERE accountNumber=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setLong(2, accNo);

            ps.executeUpdate();

            addTransaction(accNo, "Deposit", amount);

            System.out.println("Money deposited successfully.");

            showUpdatedBalance(conn, accNo);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Withdraw Money
    public void withdraw(long accNo, double amount) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "UPDATE accounts SET balance = balance - ? WHERE accountNumber=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setLong(2, accNo);

            ps.executeUpdate();

            addTransaction(accNo, "Withdraw", amount);

            System.out.println("Money withdrawn successfully.");

            showUpdatedBalance(conn, accNo);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Check Balance
    public void checkBalance(long accNo) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "SELECT balance FROM accounts WHERE accountNumber=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setLong(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Current Balance: " + rs.getDouble("balance"));

            } else {

                System.out.println("Account not found.");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Account
    public void deleteAccount(long accNo) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "DELETE FROM accounts WHERE accountNumber=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setLong(1, accNo);

            ps.executeUpdate();

            System.out.println("Account deleted successfully.");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Show All Accounts
    public void showAllAccounts() {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "SELECT * FROM accounts";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                System.out.println("Account Number: " + rs.getLong("accountNumber"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
                System.out.println("---------------------------");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Transaction
    public void addTransaction(long accNo, String type, double amount) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "INSERT INTO transactions(accountNumber,type,amount) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setLong(1, accNo);
            ps.setString(2, type);
            ps.setDouble(3, amount);

            ps.executeUpdate();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Show Transaction History
    public void showTransactions(long accNo) {

        try {

            Connection conn = DatabaseConnection.connect();

            String query = "SELECT * FROM transactions WHERE accountNumber=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setLong(1, accNo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Transaction ID: " + rs.getInt("id"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Amount: " + rs.getDouble("amount"));
                System.out.println("Date: " + rs.getTimestamp("transactionDate"));
                System.out.println("---------------------------");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Show Updated Balance
    private void showUpdatedBalance(Connection conn, long accNo) throws Exception {

        String query = "SELECT balance FROM accounts WHERE accountNumber=?";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setLong(1, accNo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("Updated Balance: " + rs.getDouble("balance"));
        }
    }
}