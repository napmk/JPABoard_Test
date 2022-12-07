package com.napmkmk.board.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "aboard00_seq_gengerator", 
				   sequenceName = "aboard00_seq" ,
				   allocationSize = 1) //오라클일 경우!!!시퀀스 만들기  allocationSize은 1씩 증가
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 200)
	private String content;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createTime;
	
	@ManyToOne //다대일 질문은 많고 질문은하나
	private QuestionBoard questionBoard;

}
