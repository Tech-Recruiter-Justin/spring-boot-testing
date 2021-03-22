package justinchoi.springboot.testing.bootstrap;

import justinchoi.springboot.testing.domain.Author;
import justinchoi.springboot.testing.domain.Book;
import justinchoi.springboot.testing.domain.Publisher;
import justinchoi.springboot.testing.repositories.AuthorRepository;
import justinchoi.springboot.testing.repositories.BookRepository;
import justinchoi.springboot.testing.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author justin = new Author("Justin", "Choi");
        Book javaForNoobs = new Book("Java For Noobs", "1234");
        Publisher codeGuide = new Publisher("CodeGuide", "Hong Kong");

        publisherRepository.save(codeGuide);

        System.out.println("Publisher count: " + publisherRepository.count());

        justin.getBooks().add(javaForNoobs);
        javaForNoobs.getAuthors().add(justin);

        javaForNoobs.setPublishers(codeGuide);
        codeGuide.getBooks().add(javaForNoobs);

        authorRepository.save(justin);
        bookRepository.save(javaForNoobs);
        publisherRepository.save(codeGuide);

        Author caspar = new Author("Caspar", "Cheung");
        Book advancedJava = new Book("Advanced Java", "9999");

        caspar.getBooks().add(advancedJava);
        advancedJava.getAuthors().add(caspar);

        advancedJava.setPublishers(codeGuide);
        codeGuide.getBooks().add(advancedJava);

        authorRepository.save(caspar);
        bookRepository.save(advancedJava);
        publisherRepository.save(codeGuide);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + codeGuide.getBooks().size());
    }
}
