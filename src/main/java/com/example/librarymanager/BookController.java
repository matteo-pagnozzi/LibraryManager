package com.example.librarymanager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
      return bookService.getAllBooks();
    }

    @GetMapping("/title/{id}")
    public String getBookTitle(@PathVariable Long id){
        return bookService.getTitleById(id);
    }

    @GetMapping("/author/{name}")
    public List<Book> getBookByAuthor(@PathVariable String name){
        return bookService.getBooksByAuthor(name);
    }

    @PostMapping
    public String addBook(@RequestBody List<Book> books){
        bookService.addBooks(books);
        return "Operazione completa: " + books.size() + " libri aggiunti con successo";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        bookService.deleteBook(id);
        return "Libro eliminato con successo.";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return "Libro aggiornato con successo.";
    }

    @PatchMapping("/{id}/pages")
    public String patchPages(@PathVariable Long id, @RequestBody int newPages){
        bookService.patchBookPages(id, newPages);
        return "Pagine aggiornate con successo";
    }

    @PatchMapping("/{id}/author")
    public String patchAuthor(@PathVariable Long id, @RequestBody String newAuthor){
        bookService.patchBookAuthor(id, newAuthor);
        return "Autore aggiornato con successo";
    }

    @PatchMapping("/{id}/title")
    public String patchTitle(@PathVariable Long id, @RequestBody String newTitle){
        bookService.patchBookTitle(id, newTitle);
        return "Titolo aggiornato con successo";
    }

}
