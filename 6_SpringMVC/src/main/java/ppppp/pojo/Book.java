package ppppp.pojo;

/**
 * @author lppppp
 * @create 2021-01-19 21:31
 */
public class Book {
    private String name;
    private String author;
    private Double price;
    private Integer stock;
    private Address address;

    public Book() {
    }

    public Book(String name, String author, Double price, Integer stock, Address address, Integer sales) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.address = address;
        this.sales = sales;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", address=" + address +
                ", sales=" + sales +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    private Integer sales;

}
