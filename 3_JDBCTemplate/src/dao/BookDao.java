package dao;

import bean.Book;

/**
 * @author lppppp
 * @create 2021-01-14 10:53
 */
public interface BookDao {
    int addBook(Book book);
    int addBook();

    int bookUpdate(Book book);

    int bookDelete(int id);

    int getCount();

    Book getBookById(int id);
}
