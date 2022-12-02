package com.napmkmk.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(length = 200)
	private String subject;
	
	@Column(length = 1000) // 255자 제한 해제 // "varchar(1000) default 'TEXT'"글자수 1000자  TEXT 값으로
	private String content;
	

	
}
