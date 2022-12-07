package com.napmkmk.board.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "qboard00_seq_gengerator", 
				   sequenceName = "qboard00_seq" ,
				   allocationSize = 1) //시퀀스 만들기  allocationSize은 1씩 증가
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
	
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createTime;

	//테이블 참조시키기
	@OneToMany(mappedBy = "questionBoard", cascade = CascadeType.REMOVE) 
	// mappedBy = (질문객체이름 가져오기. questionBoard 가져와야함 , 질문이 삭제 되면 그 질문 답변 글도 모두 삭제)
//	private AnswerBoard answerBoard;
	private List<AnswerBoard> answerList; // 여러개 저장해야 하니까 list로 설정해주어야함.
}
