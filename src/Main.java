public class Main {
    public static void main(String[] args){
        PrintFacade facade = new PrintFacade();
        try{
            facade.printDocument("assignment.pdf", 5, 2, false);
            System.out.println("\nCurrent balance: "+facade.getBalance()+" KZT");
        } catch(IllegalArgumentException | IllegalStateException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
