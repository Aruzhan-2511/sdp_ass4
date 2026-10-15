public class Printer {
    private int paperLeft = 100;
    public void checkReady(int pages, int copies){
        if (pages <= 0 || copies <= 0){
            throw new IllegalArgumentException("Invalid print request");
        }
        long totalPages = (long) pages * copies;
        if(totalPages > paperLeft){
            throw new IllegalStateException("Not enough paper in printer");
        }
        System.out.println("Printer is ready");
    }
    public void printFile(String fileName, int pages, int copies, boolean color){
        checkReady(pages, copies);
        int totalPages = pages * copies;
        paperLeft -= totalPages;
        String mode = color ? "Color" : "Black and White";
        System.out.println("Printing: "+ fileName);
        System.out.println("Mode: " + mode);
        System.out.println("Printed pages: " + totalPages);
        System.out.println("Paper left: " + paperLeft);
    }
}
