public class Payment {
    private int balance = 1000;
    public void pay(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Invalid pyment amount");
        }
        if(amount > balance){
            throw new IllegalStateException("Not enough money");
        }
        balance -= amount;
        System.out.println("Pyment successful: "+ amount +" KZT");
        System.out.println("Remaining balance: "+balance +" KZT");
    }
    public void addBalance(int amount){
        if (amount <= 0 || amount > Integer.MAX_VALUE - balance){
            throw new IllegalArgumentException("Invalid top-up amount");
        }
        balance += amount;
        System.out.println("Balance updated: "+ balance +" KZT");
    }
    public int getBalance(){
        return balance;
    }
}
