package Multi_Aspect;

public class Book extends Product {
    private String author;

    public Book(double price, String name, String author) {
        super(price, name);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("Author name cannot be blank or null");
        this.author = author;
    }

    @Override
    public double calculateDiscount(double discountRate) {
        double discountedPrice = price * (1 - discountRate);
        return discountedPrice;
    }
}
