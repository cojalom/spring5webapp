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
        publisherAddressRepository.save(harperCollinsAddress);
        Publisher harperCollins = new Publisher("Harper Collins", harperCollinsAddress);
        publisherRepoistory.save(harperCollins);

        Author eric = new Author("Eric", "Evens");
        Book ddd = new Book("Domain Driven Design", "12345", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        PublisherAddress wroxAddress = new PublisherAddress("Street 2", "Some Place", "Ville One", "Indiana", "K8734");
        publisherAddressRepository.save(wroxAddress);
        Publisher wrox = new Publisher("Wrox", wroxAddress);
        publisherRepoistory.save(wrox);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "34534543", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
