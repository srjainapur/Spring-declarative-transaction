package com.zensar.transaction.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.transaction.entity.Story;
import com.zensar.transaction.repository.StoryRepository;
import com.zensar.transaction.service.StoryService;

@Service
public class StoryServiceImpl implements StoryService {
	
	@Autowired
	private StoryRepository storyRepository;
	
	private static final Logger LOG = Logger.getLogger(StoryServiceImpl.class.getName());
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, readOnly=false, noRollbackFor=ArithmeticException.class)
	public void saveStory(Story story) {
		LOG.log(Level.INFO, "BEGIN :: saveStory()");
		storyRepository.save(story);
		LOG.log(Level.INFO, "BEGIN :: saveStory()");
	}

}
