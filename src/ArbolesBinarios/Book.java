package ArbolesBinarios;

public class Book implements Comparable {
    private int code;
    private String title;
    private int pages;

    public Book(int code, String title, int pages) {
        super();
        this.code = code;
        this.title = title;
        this.pages = pages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Libro [code= " + code + ", title= " + title + ", pages = "+ pages + "]";
    }

    @Override
    public int compareTo(Object o) {
        Book aBook = (Book) o;
        return code - aBook.getCode();
    }
}