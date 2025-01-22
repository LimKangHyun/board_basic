package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.BoardFileEntity;

public interface BoardFileRepository extends JpaRepository<BoardFileEntity, Long> {
}
