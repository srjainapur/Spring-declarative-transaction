package com.zensar.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORY")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STORY_ID")
	private int storyId;

	@Column(name = "STORY_NAME")
	private String storyName;

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
}
