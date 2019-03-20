package com.zensar.transaction.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.transaction.entity.Book;
import com.zensar.transaction.entity.Story;
import com.zensar.transaction.service.BookService;
import com.zensar.transaction.service.StoryService;

@RestController
@RequestMapping(value="/transaction")
public class TransactionController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private StoryService storyService;
	
	private static final Logger LOG = Logger.getLogger(TransactionController.class.getName());
	
	@RequestMapping(value="/book", method=RequestMethod.POST)
	public String saveBook(@RequestBody Book book) {
		LOG.log(Level.INFO, "BEGIN :: saveBook()");
		
		bookService.saveBook(book);
		
		LOG.log(Level.INFO, "END :: saveBook()");
		return "Book Saved successfully";
	}
	
	@RequestMapping(value="/story", method=RequestMethod.POST)
	public String saveStory(@RequestBody Story story) {
		LOG.log(Level.INFO, "BEGIN :: saveStory()");
		storyService.saveStory(story);
		LOG.log(Level.INFO, "END :: saveStory()");
		
		return "Story saved Successfully";
	}
}
