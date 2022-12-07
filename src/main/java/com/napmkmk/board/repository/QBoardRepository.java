package com.napmkmk.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.board.entity.QuestionBoard;

public interface QBoardRepository extends JpaRepository<QuestionBoard, Integer> {
	public List<QuestionBoard> findBySubject(String subject);
	//글 제목과 일치하는 레코드를 반환
	public List<QuestionBoard> findBySubjectAndContent(String subject, String content);
	// 여러 필드를 and 조건으로 
	public List<QuestionBoard> findBySubjectLike(String namekey);
	

   
}
