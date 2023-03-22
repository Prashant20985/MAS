package Composition;

import org.junit.Test;

import static org.junit.Assert.*;

public class PageTest {

    @Test
    public void create(){
        Book book1 = new Book("book1");
        assertEquals(0, book1.getAllPages().size());
        Page page1 = new Page("page1", book1);
        Page page2 = new Page("page2", book1);
        assertEquals(2, book1.getAllPages().size());
    }

    @Test
    public void deleteBook(){
        Book book1 = new Book("book1");
        assertEquals(0, book1.getAllPages().size());
        Page page1 = new Page("page1", book1);
        Page page2 = new Page("page2", book1);
        assertEquals(2, book1.getAllPages().size());
        Book.delete(book1);
        assertEquals(0, book1.getAllPages().size());
    }

}