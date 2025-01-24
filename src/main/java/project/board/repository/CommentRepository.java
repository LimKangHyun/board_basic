package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.BoardEntity;
import project.board.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    // JPA 메서드 명에 따라 그대로 지원한다.
    List<CommentEntity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}
