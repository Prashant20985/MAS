package Composition;

import java.util.*;

public class Book {
    private static final Set<Book> extent = new HashSet<>();

    private String bookName;

    private final Set<Page> allPages = new HashSet<>();

    public Book(String bookName) {
        setBookName(bookName);
        extent.add(this);
    }

    public static Set<Book> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if(bookName == null || bookName.isBlank()){
            throw new IllegalArgumentException("Book name must not be null or Blank");
        }
        this.bookName = bookName;
    }

    public Set<Page> getAllPages() {
        return Collections.unmodifiableSet(allPages);
    }

    public Page checkPage(Page page){
        if(page == null){
            throw new IllegalArgumentException("Page must not be null");
        }
        if(page.getPageName().isBlank()){
            throw new IllegalArgumentException("Page Name must not be null");
        }

        return page;
    }

    public void addPage(Page page) {
        checkPage(page);
        if(allPages.contains(page)){
            return;
        }
        allPages.add(page);
    }

    public void removePage(Page page) {
        checkPage(page);
        if(!allPages.contains(page)) return;
        allPages.remove(page);
        Page.delete(page);
    }

    public static void delete(Book book){
        Set<Page> pageTemp = Set.copyOf(book.allPages);
        book.allPages.clear();
        pageTemp.forEach(Page::delete);
        extent.remove(book);
    }
}
