package com.YuvrajAce.bookManagment;

public class BookNotExistException extends Exception {
    public BookNotExistException(Integer id) {
        super("Book not exist in the server");
    }
}
