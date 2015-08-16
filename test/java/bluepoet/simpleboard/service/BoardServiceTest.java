package bluepoet.simpleboard.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bluepoet.simpleboard.domain.Board;
import bluepoet.simpleboard.repository.BoardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class BoardServiceTest {

	@Autowired
	BoardService boardService;

	@Autowired
	BoardRepository boardRepository;

	@Test
	public void save() throws Exception {
		// Given
		Board board = createBoard();

		// When
		Long savedBoardId = boardService.save(board);

		// Then
		assertEquals(board, boardRepository.findOne(savedBoardId));
		assertTrue(savedBoardId == 1L);
	}

	private Board createBoard() {
		Board board = new Board();
		board.setAuthor("bluepoet");
		board.setTitle("test");
		board.setContent("hello world");
		return board;
	}
}
