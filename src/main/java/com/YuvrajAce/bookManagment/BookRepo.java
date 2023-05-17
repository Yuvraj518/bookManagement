package com.YuvrajAce.bookManagment;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository
public class BookRepo {
    Map<Integer,Book> data=new HashMap<>();
    public Boolean addBook(Book bk) {
        data.put(bk.getBookID(),bk);
        return true;
    }
    public Optional<Book> getById(Integer id){
        if(data.containsKey(id)){
            return Optional.of(data.get(id));
        }
        return Optional.empty();
    }

    public Boolean removeBook(Integer id) {
        data.remove(id);
        return true;
    }
}
