package com.zensar.transaction.service;

import org.springframework.stereotype.Service;

import com.zensar.transaction.entity.Story;
@Service
public interface StoryService {
	public void saveStory(Story story);
}
