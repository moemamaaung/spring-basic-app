package com.hostmdy.jpa.data;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hostmdy.jpa.entity.Author;
import com.hostmdy.jpa.entity.Book;
import com.hostmdy.jpa.repository.AuthorRepository;
import com.hostmdy.jpa.repository.BookRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public InitialDataLoader(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initialize();
		
	}
	
	private void initialize() {
		Book book1 = new Book("Eric Evan","Domain Drivere Design",34.5);
		Author author1 = new Author("Eric","Evan",60,"eric.evan@gmai.com");
		//ManyToMany Connect
		book1.getAuthors().add(author1);
		author1.getBooks().add(book1);
		
		authorRepository.save(author1);//Create/Insert
		bookRepository.save(book1);//Create/Insert
		
		

		
		Book book2 = new Book("Java 8 in Action ","Programming",50.0);
		Author author2 = new Author("John","Doe",60,"johndoe@gmai.com");
		//ManyToMany Connect
		book2.getAuthors().add(author2);
		author2.getBooks().add(book2);
		
		
		authorRepository.save(author2);
		bookRepository.save(book2);
		
		
		
		Book book3 = new Book("JModern Design Pattern","Programming",50.0);
		Author author3 = new Author("Ma","Sapal",40,"masapal@gmai.com");
		//ManyToMany Connect
		book3.getAuthors().add(author3);
		author3.getBooks().add(book3);
		
		authorRepository.save(author3);
		bookRepository.save(book3);
		
		
		Book book4 = new Book("Java MultiThreading", "Programming", 40.6);
		book4.getAuthors().add(author1);
		book4.getAuthors().add(author2);
		book4.getAuthors().add(author3);
		
		authorRepository.save(author1);
		authorRepository.save(author2);
		authorRepository.save(author3);
		bookRepository.save(book4);
				
	}

}