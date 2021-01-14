package bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author lppppp
 * @create 2021-01-14 10:51
 */
@Repository
public class Book {
    @Value("1-java2 编程思想")
    private String bname;
    @Value("1")
    private int bid;
    @Value("2")
    private String bstatu;
    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bid='" + bid + '\'' +
                ", bStatu='" + bstatu + '\'' +
                '}';
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getbStatu() {
        return bstatu;
    }

    public void setbStatu(String bstatu) {
        this.bstatu = bstatu;
    }

    public Book() {
    }

    public Book(String bname, int bid, String bstatu) {
        this.bname = bname;
        this.bid = bid;
        this.bstatu = bstatu;
    }

}
