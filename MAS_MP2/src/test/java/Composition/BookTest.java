package Composition;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void addPage() {
        Book book1 = new Book("Book1");
        assertEquals(0, book1.getAllPages().size());
        Page page1 = new Page("page1", book1);
        assertEquals(1, book1.getAllPages().size());
        Page page3 = new Page("page2", book1);
        assertEquals(2, book1.getAllPages().size());
    }

    @Test
    public void removePage() {
        Book book1 = new Book("Book1");
        assertEquals(0, book1.getAllPages().size());
        Page page1 = new Page("page1", book1);
        assertEquals(1, book1.getAllPages().size());
        Page page2 = new Page("page2", book1);
        assertEquals(2, book1.getAllPages().size());

        assertTrue(Page.getExtent().contains(page1));
        assertTrue(Page.getExtent().contains(page2));

        book1.removePage(page1);
        assertEquals(1, book1.getAllPages().size());
        assertFalse(Page.getExtent().contains(page1));
        assertTrue(Page.getExtent().contains(page2));

        book1.removePage(page2);
        assertEquals(0, book1.getAllPages().size());
        assertFalse(Page.getExtent().contains(page1));
        assertFalse(Page.getExtent().contains(page2));
    }

    @Test
    public void deletePage() {
        Book book1 = new Book("Book1");
        assertEquals(0, book1.getAllPages().size());
        Page page1 = new Page("page1", book1);
        assertEquals(1, book1.getAllPages().size());
        Page page2 = new Page("page2", book1);
        assertEquals(2, book1.getAllPages().size());

        assertTrue(Page.getExtent().contains(page1));
        assertTrue(Page.getExtent().contains(page2));

        Book.delete(book1);
        assertFalse(Book.getExtent().contains(page1));
        assertFalse(Book.getExtent().contains(page2));
    }
}