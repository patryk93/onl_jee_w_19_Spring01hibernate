package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void editPublisher(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void deletePublisher(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher)); }
}
