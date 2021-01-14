package dao;

import bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author lppppp
 * @create 2021-01-14 10:54
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Book book;

    @Override
    public int addBook(Book book) {
        String sql = "insert into j_book values(?,?,?)";
        Object[]args = {book.getBid(),book.getBname(),book.getbStatu()};
        int update = jdbcTemplate.update(sql, args);
        return update;
    }

    // 调用注入的方式赋值
    @Override
    public int addBook() {
        String sql = "insert into j_book values(?,?,?)";
        Object[]args = {book.getBid(),book.getBname(),book.getbStatu()};
        int update = jdbcTemplate.update(sql, args);
        return update;
    }

    @Override
    public int bookUpdate(Book book) {
        String sql = "update j_book set bname=?,bstatu=? where bid=?";
        Object[]args = {book.getBname(),book.getbStatu(),book.getBid()};
        int update = jdbcTemplate.update(sql, args);
        return update;
    }


    @Override
    public int bookDelete(int id) {
        String sql = "delete from j_book where bid=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int getCount() {
        String sql = "select count(*) from j_book";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from j_book where bid=?";
        Book book = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> getBookList() {
        String sql = "select * from j_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }

    @Override
    public void addBookBatch(List<Object[]> batchArgs) {
        String sql = "insert into j_book (bname,bstatu)values(?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void deleteBookBatch(List<Object[]> batchArgs) {
        String sql = "delete from j_book where bid=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
