package Composition;

import java.util.HashSet;
import java.util.Set;

public class Page {
    private static final Set<Page> extent = new HashSet<>();
    private String pageName;
    private Book book;

    public Page(String pageName, Book book) {
        setPageName(pageName);
        setBook(book);
        book.addPage(this);
        extent.add(this);
    }

    public static Set<Page> getExtent() {
        return extent;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        if(pageName == null){
            throw new IllegalArgumentException("Book name must not be null");
        }
        this.pageName = pageName;
    }

    public Book getBook() {
        return book;
    }

    private void setBook(Book book) {
        if(book == null){
            throw new IllegalArgumentException("Book must not be null");
        }
        this.book = book;
    }

    public static void delete(Page page){
        if(page == null){
            throw new IllegalArgumentException("Page Must not be null");
        }
        page.book.removePage(page);
        extent.remove(page);
    }
}
