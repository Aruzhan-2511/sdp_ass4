public class PrintFacade {
    private final FileChecker fileChecker;
    private final Printer printer;
    private final Price price;
    private final Payment payment;
    public PrintFacade(){
        fileChecker = new FileChecker();
        printer = new Printer();
        price = new Price();
        payment = new Payment();
    }
    public void printDocument(String fileName, int pages, int copies, boolean color){
        System.out.println("\n=== Student Print Center ===");
        fileChecker.checkFile(fileName, pages, copies);
        printer.checkReady(pages, copies);
        int total = price.calculate(pages, copies, color);
        payment.pay(total);
        printer.printFile(fileName, pages, copies, color);
        System.out.println("Print request completed successfully!");
    }
    public void addBalance(int amount){
        payment.addBalance(amount);
    }
    public int getBalance(){
        return payment.getBalance();
    }
}
