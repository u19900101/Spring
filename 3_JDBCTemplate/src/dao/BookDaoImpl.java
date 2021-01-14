package dao;

import bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        return 0;
    }

    @Override
    public int addBook() {
        String sql = "insert into j_book values(?,?,?)";
        Object[]args = {book.getBid(),book.getBname(),book.getbStatu()};
        int update = jdbcTemplate.update(sql, args);
        return update;
    }
}
