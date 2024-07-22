package dev.patika.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", unique = true, nullable = false)
    private int publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "publisher_establishment_year", length = 100, nullable = false)
    private int publisherEstablishmentYear;

    @Column(name = "publisher_address")
    private String publisherAddress;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> bookList;



    public Publisher() {
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublisherEstablishmentYear() {
        return publisherEstablishmentYear;
    }

    public void setPublisherEstablishmentYear(int publisherEstablishmentYear) {
        this.publisherEstablishmentYear = publisherEstablishmentYear;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
