package za.co.cjl.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import za.co.cjl.spring5webapp.model.Author;
import za.co.cjl.spring5webapp.model.Book;
import za.co.cjl.spring5webapp.model.Publisher;
import za.co.cjl.spring5webapp.model.PublisherAddress;
import za.co.cjl.spring5webapp.repositories.AuthorRepository;
import za.co.cjl.spring5webapp.repositories.BookRepository;
import za.co.cjl.spring5webapp.repositories.PublisherAddressRepository;
import za.co.cjl.spring5webapp.repositories.PublisherRepoistory;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepoistory publisherRepoistory;
    private PublisherAddressRepository publisherAddressRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepoistory publisherRepoistory,
                        PublisherAddressRepository publisherAddressRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepoistory = publisherRepoistory;
        this.publisherAddressRepository = publisherAddressRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        PublisherAddress harperCollinsAddress = new PublisherAddress("Street 1", "Some Ville", "Idaho", "I1234");
        PublisherAddress harperCollinsPublisherAddress = publisherAddressRepository.save(harperCollinsAddress);
        Publisher harperCollins = new Publisher("Harper Collins", harperCollinsPublisherAddress);
        Publisher harperCollinsPublisher = publisherRepoistory.save(harperCollins);

        Author eric = new Author("Eric", "Evens");
        Book ddd = new Book("Domain Driven Design", "12345", harperCollinsPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        PublisherAddress worxAddress = new PublisherAddress("Street 2", "Some Place", "Ville One Be", "Indiana", "K8734");
        PublisherAddress worxPublisherAddress = publisherAddressRepository.save(worxAddress);
        Publisher worx = new Publisher("Worx", worxPublisherAddress);
        Publisher worxPublisher = publisherRepoistory.save(worx);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "34534543", worxPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
