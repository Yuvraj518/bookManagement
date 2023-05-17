package com.YuvrajAce.bookManagment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public Boolean addBook(Book bk) throws BookAlreadyExistException {
        Optional<Book> op2=bookRepo.getById(bk.getBookID());
        if(op2.isPresent()){
            throw new BookAlreadyExistException(bk.getBookID());
        }
        return bookRepo.addBook(bk);
    }

    public Book findBook(Integer id) throws BookNotExistException {
        Optional<Book> op1=bookRepo.getById(id);
        if(op1.isEmpty()){
            throw new BookNotExistException(id);
        }
        return op1.get();
    }

    public Boolean updateBook(Integer id, String tit, String aut, Integer pag) throws BookNotExistException {
        Optional<Book> op1=bookRepo.getById(id);
        if(op1.isEmpty()){
            throw new BookNotExistException(id);
        }
        Book b1=op1.get();
        if(Objects.nonNull(tit)){
            b1.setTitle(tit);
        }
        if(Objects.nonNull(aut)){
            b1.setAuthor(aut);
        }
        if(Objects.nonNull(pag)){
            b1.setPages(pag);
        }
        //bookRepo.addBook(b1);
        return true;
    }

    public Boolean removeBook(Integer id) throws BookNotExistException {
        Optional<Book> op3=bookRepo.getById(id);
        if(op3.isEmpty()){
            throw new BookNotExistException(id);
        }
        bookRepo.removeBook(id);
        return true;
    }
}
