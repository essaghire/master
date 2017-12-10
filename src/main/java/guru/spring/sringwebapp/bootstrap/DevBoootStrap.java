package guru.spring.sringwebapp.bootstrap;

import guru.spring.sringwebapp.model.Author;
import guru.spring.sringwebapp.model.Book;
import guru.spring.sringwebapp.model.Publisher;
import guru.spring.sringwebapp.model.repositories.AuthorRepository;
import guru.spring.sringwebapp.model.repositories.BookRepository;
import guru.spring.sringwebapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by said on 03/12/2017.
 */
@Component
public class DevBoootStrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBoootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initData(){
        Publisher publisher1 = new Publisher("PublishIt", "NY 1290 Street1");

        Author said = new Author("Said", "Saghir");
        Book book1= new Book("In The Dark","wws12344nncb", publisher1);
        said.getBooks().add(book1);
        book1.getAuthors().add(said);

        publisherRepository.save(publisher1);
        authorRepository.save(said);
        bookRepository.save(book1);

        Author retik = new Author("Retik", "Rochan");
        Book book2= new Book("Alone","wws12344cb", publisher1);
        retik.getBooks().add(book2);

        authorRepository.save(retik);
        bookRepository.save(book2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
