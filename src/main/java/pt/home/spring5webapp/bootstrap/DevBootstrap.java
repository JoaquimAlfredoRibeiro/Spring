package pt.home.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.home.spring5webapp.model.Author;
import pt.home.spring5webapp.model.Book;
import pt.home.spring5webapp.model.Publisher;
import pt.home.spring5webapp.repositories.AuthorRepository;
import pt.home.spring5webapp.repositories.BookRepository;
import pt.home.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //publishers
        Publisher pub1 = new Publisher("Publisher 1", "John Adams Street 123");
        Publisher pub2 = new Publisher("Publisher 2", "John Adams Street 456");

        publisherRepository.save(pub1);
        publisherRepository.save(pub2);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driver Design", "1234", "Harper Colins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub1);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development withouth EJB", "23444", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub2);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
