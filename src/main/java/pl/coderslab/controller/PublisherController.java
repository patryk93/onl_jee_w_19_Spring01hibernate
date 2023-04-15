package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

@Controller
public class PublisherController {

    private final PublisherDao publisherDao;
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
    @RequestMapping("/publisher/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher1");
        publisherDao.savePublisher(publisher);
        return "Id dodanego publishera to:"
                + publisher.getId();
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.editPublisher(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.deletePublisher(publisher);
        return "deleted";
    }
}