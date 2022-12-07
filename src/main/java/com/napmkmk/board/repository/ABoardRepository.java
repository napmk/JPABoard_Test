package com.napmkmk.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.board.entity.AnswerBoard;

public interface ABoardRepository extends JpaRepository<AnswerBoard, Integer> {

}
