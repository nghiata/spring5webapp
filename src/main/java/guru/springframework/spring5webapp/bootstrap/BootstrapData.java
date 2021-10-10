package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.respositories.AuthorRepository;
import guru.springframework.spring5webapp.respositories.BookRepository;
import guru.springframework.spring5webapp.respositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("bootstrap started in here");

        Book book1 = new Book("The lord of the Rings", "123123");
        Author eric = new Author("Eric", "Gammar");
        book1.getAuthors().add(eric);
        eric.getBooks().add(book1);
        bookRepository.save(book1);
        authorRepository.save(eric);

        Book book2 = new Book("Harray Porter", "435345362");
        Author rowling = new Author("JK", "Rowling");
        book2.getAuthors().add(rowling);
        rowling.getBooks().add(book2);
        bookRepository.save(book2);
        authorRepository.save(rowling);

        Publisher publisher01 = new Publisher("tuoitre", "652 cong hoa");
        Publisher publisher02 = new Publisher("Thanh nien", "71 Che lan vien");

        book1.setPublisher(publisher01);
        publisher01.getBooks().add(book1);
        book2.setPublisher(publisher01);
        publisher01.getBooks().add(book2);

        publisherRepository.save(publisher01);
        publisherRepository.save(publisher02);

        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Number of publishers: "+ publisherRepository.count());
    }
}
