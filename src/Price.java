public class Price {
    private final int blackWhitePrice = 20;
    private final int colorPrice = 80;
    public int calculate(int pages, int copies, boolean color){
        if (pages <= 0 || copies <= 0){
            throw new IllegalArgumentException("Invalid number of pages or copies");
        }
        int pricePerPage = color ? colorPrice : blackWhitePrice;
        long total = (long) pages * copies * pricePerPage;
        if(total > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Print job is too large");
        }
        System.out.println("Total price: " + total + "KZT");
        return (int) total;
    }
}
