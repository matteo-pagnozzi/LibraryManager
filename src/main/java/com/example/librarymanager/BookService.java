package com.example.librarymanager;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>(List.of(
            new Book(1L, "Fiorirà l'aspidista", "George orwell", 150),
            new Book(2L, "La fatoria degli animali", "George Orwell", 150)
    ));

    public List<Book> getAllBooks() {
        return books;
    }

    public String getTitleById(Long id){
        for(Book b: books){
            if(b.getId().equals(id)){
                return b.getTitle();
            }
        }
        throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Libro non trovato con ID: " + id);
    }

    public List<Book> getBooksByAuthor(String author){
        List<Book> result = new ArrayList<>();
        for (Book b: books){
            if(b.getAuthor().equalsIgnoreCase(author)){
                result.add(b);
            }
        }
        if (result.isEmpty()) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Nessun libro trovato per l'autore: " + author);
        }
        return result;
    }

    public void addBooks(List<Book> newBooks){
        for(Book b: newBooks){
            books.add(b);
        }
    }

    public void deleteBook(Long id){
        Book bookToWebRemove = null;
        for(Book b: books){
            if(b.getId().equals(id)){
                bookToWebRemove = b;
                break;
            }
        }
        if(bookToWebRemove != null){
            books.remove(bookToWebRemove);
        }else {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Impossibile eliminare: ID non esistente");
        }
    }

    public void updateBook(Long id, Book updateBook){
        for(Book b: books){
            if(b.getId().equals(id)){
                b.setTitle(updateBook.getTitle());
                b.setAuthor(updateBook.getAuthor());
                b.setPages(updateBook.getPages());
                return;
            }
        }
        throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Impossibile aggiornare il libro: ID non esistente");
    }

    public void patchBookPages(Long id, int newPages){
        for(Book b: books){
            if(b.getId().equals(id)){
                b.setPages(newPages);
                return;
            }
        }
        throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Libro non trovato per l'aggiornamento delle pagine");
    }

    public void patchBookAuthor(Long id, String newAuthor){
        for(Book b: books){
            if(b.getId().equals(id)){
                b.setAuthor(newAuthor);
                return;
            }
        }
        throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND, "Libro non trovato per l'aggiornamento autore");

    }

    public void patchBookTitle(Long id, String newTitle){
        for(Book b: books){
            if(b.getId().equals(id)){
                b.setTitle(newTitle);
                return;
            }
        }
        throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND, "Libro non trovato per l'aggiornamento del titolo");

    }
}
