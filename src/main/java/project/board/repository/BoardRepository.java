package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
