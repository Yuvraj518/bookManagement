package com.YuvrajAce.bookManagment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addbook")
    public ResponseEntity addBook(@RequestBody Book bk){
        try {
            Boolean added=bookService.addBook(bk);
            return new ResponseEntity("book added sucessfully", HttpStatus.CREATED);
        } catch (BookAlreadyExistException e) {
            return new ResponseEntity("unable to add book as it already exist",HttpStatus.valueOf(400));
        }catch (Exception ex){
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity findBook(@PathVariable Integer id) {
        try{
            Book book=bookService.findBook(id);
            return new ResponseEntity(book,HttpStatus.OK);
        } catch (BookNotExistException e) {
            return new ResponseEntity("book not found in db",HttpStatus.valueOf(404));
        }catch (Exception ex){
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }
    }
    @PutMapping("/updatebook/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestParam(required = false) String tit,@RequestParam (required = false)String aut,@RequestParam(required = false) Integer pag){
        try{
            Boolean b=bookService.updateBook(id,tit,aut,pag);
            return new ResponseEntity("book sucessufully updated", HttpStatus.valueOf(200));
        } catch (BookNotExistException e) {
            return new ResponseEntity("Can't able to update book as it does not exist",HttpStatus.valueOf(410));
        }catch (Exception ex){
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }
    }
    @DeleteMapping("removebook/{id}")
    public ResponseEntity removeBook(@PathVariable Integer id){
        try{
            Boolean b=bookService.removeBook(id);
            return new ResponseEntity("sucessufully removed book from server",HttpStatus.OK);
        } catch (BookNotExistException e) {
            return new ResponseEntity("book not found for delete operation",HttpStatus.NOT_FOUND);
        }
    }
}
