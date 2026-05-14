package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "\"Parking\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parking {

	@Id
	private Integer id;
	private String name;
	private String addres;
	private Integer fee;
	private Integer maxfee;
	private LocalDateTime entrytime;
	
	public LocalDateTime getEntryTime() {
		return entrytime;
	}
	
	public void setEntryTime(LocalDateTime entryTime) {
		this.entrytime=entryTime;
	}

}
