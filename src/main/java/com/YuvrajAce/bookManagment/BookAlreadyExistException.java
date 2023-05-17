package com.YuvrajAce.bookManagment;

public class BookAlreadyExistException extends Exception {
    public BookAlreadyExistException(Integer bookID) {
        super("Book already exist in the database");
    }
}
