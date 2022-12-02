package com.napmkmk.board.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.napmkmk.board.entity.QuestionBoard;
import com.napmkmk.board.repository.QBoardRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestQBoard {

   @Autowired
   QBoardRepository qBoardRepository;
   
//   @Test
//   @DisplayName("저장 테스트")
//   public void createQBoard() {
//      QuestionBoard qBoard = new QuestionBoard();
//      
//      qBoard.setSubject("4번");
//      qBoard.setContent("난 마이너스의 손인가봄.");
//      
//      qBoardRepository.save(qBoard);
//   }
   
   @Test
   @DisplayName("조회 테스트1")
   public void searchQBoard1() {
	   
      List<QuestionBoard> qAll = qBoardRepository.findAll();
      assertEquals(5, qAll.size()); // 실제 모든글의 갯수와  내가 생각한 수와 같은지 글이 2개 맞나 확인해주세요.
      QuestionBoard q1 = qAll.get(1); //2번째 글 저장
      assertEquals("되라욍오옹옹", q1.getSubject());//테스트여부확인
   }
   
   @Test
   @DisplayName("조회 테스트2")
   public void searchQBoard2() {
	   
     Optional<QuestionBoard> qBoard = qBoardRepository.findById(5); //키값으로 찾기
     if(qBoard.isPresent()) { // Optional 있는 객체 (isPresent)없는 경우 처리 하는 코드
    	 QuestionBoard q1= qBoard.get(); //2번째 글 저장
         assertEquals("되라욍오옹옹", q1.getSubject());//테스트여부확인 
     }
      
    
   }
   
	 @Test
	 @DisplayName("저장 테스트")
	 public void createQBoard() {
	    QuestionBoard qBoard = new QuestionBoard();
	    
	    qBoard.setSubject("안녕");
	    qBoard.setContent("안녕");
	    
	    qBoardRepository.save(qBoard);
	 }
	   
	   @Test
	   @DisplayName("조회 테스트3")
	   public void searchQBoard3() {
		   
		   List<QuestionBoard> qBoards = qBoardRepository.findBySubject("질문"); //키값으로 찾기
		   
		   QuestionBoard q1 = qBoards.get(0); //2번째 글 저장
		   assertEquals(5, q1.getId());
		    
	   }
	
	   @Test
	   @DisplayName("테스트 문제2")  //제목과 질문이 모두 '안녕'인 글의 아이디가 6인지 테스트
	   public void searchAndsearch() {
		   
		   List<QuestionBoard> qBoards = qBoardRepository.findBySubjectAndContent("안녕", "안녕"); //키값으로 찾기
		   
		   QuestionBoard q1 = qBoards.get(0); //2번째 글 저장
		   assertEquals(6, q1.getId());
		    
	   }
	   
	   @Test
	   @DisplayName("테스트문제 3") //제목에 '질문' 이라는 낱말이 포함된 글의 개수가 5인지 테스트 하시오
	   public void searchQBoard5() {
		   
		   List<QuestionBoard> qBoards = qBoardRepository.findBySubjectLike("질문"); //키값으로 찾기
		   
		   QuestionBoard q1 = qBoards.get(0); //2번째 글 저장
		   assertEquals(5, q1.getId());
		    
	   }
	   
	   @Test //UPDATE
	   @DisplayName("테스트문제 4") //아이디가 2번인 글의 제목을 '저는 2번글입니다' 로 수정 2번 글의 제목이 수정되었는지 테스트
	   public void modifySubject() {
		   
		   Optional<QuestionBoard> qBoards = qBoardRepository.findById(2); //키값으로 찾기
		   assertTrue(qBoards.isPresent());
		   QuestionBoard bod  =  qBoards.get();
		   bod.setSubject("저는 2번글입니다");
		   qBoardRepository.save(bod);
		   List<QuestionBoard> questionBoards = qBoardRepository.findAll();
		 //  QuestionBoard q1 = qBoards.get(0); //2번째 글 저장
		  // assertEquals(5, q1.getId());
		    
	   }
	   
	   @Test //DELETE
	   @DisplayName("테스트문제 5") //아이디가 3번인 글을 삭제 하시오 -> 글을 삭제 한 후 모든 글의 개수가 1개 줄었는지 테스트
	   public void deleteId() {
		   
		   qBoardRepository.deleteById(3);
		   List<QuestionBoard> questionBoard = qBoardRepository.findAll();
		   
		  
		    
	   }
	 
   
   
}