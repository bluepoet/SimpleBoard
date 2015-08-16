package bluepoet.simpleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bluepoet.simpleboard.domain.Board;
import bluepoet.simpleboard.repository.BoardRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public Long save(Board board) {
		boardRepository.save(board);
		return board.getId();
	}
	
	@Transactional(readOnly = true)
	public List<Board> getList() {
		return boardRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Board getBoard(Long boardId) {
		return boardRepository.findOne(boardId);
	}

	public void delete(Long boardId) {
		boardRepository.delete(boardId);
	}
}
