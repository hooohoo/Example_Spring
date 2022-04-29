package co.kr.project.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kr.project.mvc.domain.Board;
import co.kr.project.mvc.repository.BoardRepository;
import co.kr.project.mvc.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping
	public List<Board> getList(){
		return service.getList();
	}
	
	@GetMapping("/{boardSeq}")
	public Board get(@PathVariable int boardSeq) {
		return service.get(boardSeq);
	}
	
	@GetMapping("/save")
	public void save(Board board) {
		service.save(board);
	}

	// save와 같은 기능. 주석처리
//	public void update(Board board) {
//		service.update(board);
//	}
	
	@GetMapping("/delete/{boardSeq}")
	public void delete(@PathVariable int boardSeq) {
		service.delete(boardSeq);
	}

}
