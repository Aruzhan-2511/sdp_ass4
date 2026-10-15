public class FileChecker {
    public void checkFile(String fileName, int pages, int copies){
        if(fileName == null || fileName.isBlank()){
            throw new IllegalArgumentException("File nameis required");
        }
        String name = fileName.toLowerCase();
        if(!name.endsWith(".pdf") && !name.endsWith(".docx")){
            throw new IllegalArgumentException("Unsupported file format");
        }
        if(pages <= 0){
            throw  new IllegalArgumentException("Invalid number of pages");
        }
        if (copies <= 0){
            throw new IllegalArgumentException("Invalid number of copies");
        }
        System.out.println("File checked successfully: "+fileName);
    }
}
