package tomal.springframework.springAppExcercise.bootstarp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tomal.springframework.springAppExcercise.model.Author;
import tomal.springframework.springAppExcercise.model.Book;
import tomal.springframework.springAppExcercise.repositories.AuthorRepository;
import tomal.springframework.springAppExcercise.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author tolkien = new Author("J.R.R", "Tolkien");
        Book lotr = new Book("Lord of the Rings", "1234", "OxfordPress");
        tolkien.getBooks().add(lotr);
        lotr.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lotr);

    }


}
