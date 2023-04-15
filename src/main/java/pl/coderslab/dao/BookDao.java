package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void editBook(Book book) {
        entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }
}
