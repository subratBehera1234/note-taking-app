package com.org.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Note {

	@Id
	private int noteId;
	private String title;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
}
