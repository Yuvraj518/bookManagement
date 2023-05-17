package com.YuvrajAce.bookManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class BookManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagmentApplication.class, args);
		Book b1=new Book(11,"Jack With parrot","Jack",120);
	}

}
