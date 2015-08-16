package bluepoet.simpleboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bluepoet.simpleboard.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

