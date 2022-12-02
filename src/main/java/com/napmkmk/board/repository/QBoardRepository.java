package com.napmkmk.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.board.entity.QuestionBoard;

public interface QBoardRepository extends JpaRepository<QuestionBoard, Integer> {
	public List<QuestionBoard> findBySubject(String subject);
	public List<QuestionBoard> findBySubjectAndContent(String subject, String content);
	public List<QuestionBoard> findBySubjectLike(String namekey);
	

   
}
