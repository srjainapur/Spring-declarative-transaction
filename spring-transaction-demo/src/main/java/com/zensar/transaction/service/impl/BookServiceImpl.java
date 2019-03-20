package com.zensar.transaction.service.impl;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.transaction.entity.Book;
import com.zensar.transaction.repository.BookRepository;
import com.zensar.transaction.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	private static final Logger LOG = Logger.getLogger(BookServiceImpl.class.getName());

	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class, noRollbackFor=ArithmeticException.class)
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	public void saveBook(Book book) {
		LOG.log(Level.INFO, "BEGIN :: saveBook()");
		
		bookRepository.save(book);
		
		// No Rollback even after Arithmetic exception
		int a = 10/0;
		LOG.log(Level.INFO, " Dividing by zero Arithmetic Exception a " + a);
		
		LOG.log(Level.INFO, "END :: saveBook()");
	}
}
