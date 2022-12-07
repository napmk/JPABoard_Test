package com.napmkmk.board.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.napmkmk.board.entity.AnswerBoard;
import com.napmkmk.board.entity.QuestionBoard;
import com.napmkmk.board.repository.ABoardRepository;
import com.napmkmk.board.repository.QBoardRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestABoard {

		@Autowired
		private QBoardRepository qBoardRepository; //레포지토리 주입받기
		
		@Autowired
		private ABoardRepository aBoardRepository; //레포지토리 주입받기
		
		
		   @Test
			@DisplayName("답변 저장 테스트")
			public void AnswerCreatTest() {
				
				Optional<QuestionBoard> oQboard = qBoardRepository.findById(7);
				assertTrue(oQboard.isPresent());
				
				QuestionBoard qboard = oQboard.get();
				AnswerBoard aBoard = new AnswerBoard();
				
				aBoard.setContent("7번글 답변입니다.");
				aBoard.setQuestionBoard(qboard);
				
				aBoardRepository.save(aBoard);
				
			}
		   
		  @Test
			@DisplayName("답변 조회 테스트")
			public void answerSearch() {
				Optional<AnswerBoard> oAborad = aBoardRepository.findById(11);
				assertTrue(oAborad.isPresent());
				AnswerBoard aBoard = oAborad.get();
				
				assertEquals(7, aBoard.getQuestionBoard().getId());
				//질문글의 아이디를 가져와서 확인
				
			}
		  
		  @Transactional
		  @Test
			@DisplayName("답변/질문조회 테스트") //트랜젝션으로 묶어줘야함. 테스트만 에러남
			public void answerQustionSearch() {
			  
				Optional<QuestionBoard> oQborad = qBoardRepository.findById(7);
				assertTrue(oQborad.isPresent()); //7번 질문글이 존재 하는지 테스트
				
				QuestionBoard qBoard = oQborad.get(); //7번 질문글 가져옴
				
				List<AnswerBoard> aBoard = qBoard.getAnswerList(); // 답변글 리스트 가져오기
				
				
				assertEquals(7, aBoard.size());
				//질문 7번에 달린 답변 글의 개수가 총 6개인지 확인
				
			}
}
