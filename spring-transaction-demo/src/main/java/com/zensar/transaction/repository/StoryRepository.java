package com.zensar.transaction.repository;

import org.springframework.data.repository.CrudRepository;

import com.zensar.transaction.entity.Story;

public interface StoryRepository extends CrudRepository<Story, Integer> {

}
