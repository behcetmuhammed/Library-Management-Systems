package dev.patika;

import dev.patika.Entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistem Çalıştı");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library-Management-System");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();

        //Yazar Ekleme
        Author author1 = new Author();
        author1.setAuthorName("Ahmet Konanç");
        author1.setAuthorCountry("Türkiye");
        author1.setAuthorBirthDate(LocalDate.of(1974, 1, 1));
        entityManager.persist(author1);

        //Kategori Ekleme
        Category category1 = new Category();
        category1.setCategoryName("Roman");
        category1.setCategoryDescription("Sefiller açıklama");
        entityManager.persist(category1);

        //Yayınevi Ekleme
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Doğa Yayıncılık");
        publisher1.setPublisherEstablishmentYear(2008);
        publisher1.setPublisherAddress("Beşiktaş, İstanbul");
        entityManager.persist(publisher1);

        //Kitap Ödünç Alma
        BookBorrowing bookBorrowing1 = new BookBorrowing();
        bookBorrowing1.setBorrowerName("Emir Emiroğlu");
        bookBorrowing1.setBorrowerDate(LocalDate.of(2023,5,14));
        bookBorrowing1.setBorrowerReturnDate(LocalDate.of(2023,6,3));
        entityManager.persist(bookBorrowing1);

        //Kitap Ekleme
        Book book1 = new Book();
        book1.setBookName("Sefiller");
        book1.setBookStock(25);
        book1.setPublicationYear(50);
        book1.setAuthor(author1);
        book1.setPublisher(publisher1);
        book1.setBookBorrowing(bookBorrowing1);
        entityManager.persist(book1);

        transaction.commit();

        System.out.println("\nSistem Çalışması Bitti");
    }
}