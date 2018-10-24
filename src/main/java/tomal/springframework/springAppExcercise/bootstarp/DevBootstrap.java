package tomal.springframework.springAppExcercise.bootstarp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tomal.springframework.springAppExcercise.model.Author;
import tomal.springframework.springAppExcercise.model.Book;
import tomal.springframework.springAppExcercise.model.Publisher;
import tomal.springframework.springAppExcercise.repositories.AuthorRepository;
import tomal.springframework.springAppExcercise.repositories.BookRepository;
import tomal.springframework.springAppExcercise.repositories.PublisherRepository;

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


        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisher.setAddress("Armii Krajowej, Krakow");
        publisherRepository.save(publisher);

        Author tolkien = new Author("J.R.R", "Tolkien");
        Book lotr = new Book("Lord of the Rings", "1234", publisher);
        tolkien.getBooks().add(lotr);
        lotr.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lotr);


    }



}
