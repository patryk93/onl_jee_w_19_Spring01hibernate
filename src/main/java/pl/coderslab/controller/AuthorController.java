package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    @RequestMapping("/author/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorDao.saveAuthor(author);
        return "Id dodanego autora to:"
                + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, String lastName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.editAuthor(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.deleteAuthor(author);
        return "deleted";
    }
}
