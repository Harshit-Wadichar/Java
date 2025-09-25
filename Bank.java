package bank;

class Account {
    //public: Open to all—any class, package, or subclass can access it.
    public String name;
    //protected: Accessible within the same package and by subclasses (even if they're in different packages).
    protected String email;
    //private: - Only accessible within the Account class itself.
    private String password;

    //- Encapsulation: Hiding internal data and exposing only what’s necessary through methods.

    //- Abstraction: Showing only essential features while hiding complex implementation details.

    // getters & setters
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
}

public class Bank {
    // Debug
    public static void main(String args[]) {
        Account account1 = new Account();
        account1.name = "Apna College";
        account1.email = "apnacollege@gmail.com";
        account1.setPassword("abcd");
        System.out.println(account1.getPassword());
    }
}