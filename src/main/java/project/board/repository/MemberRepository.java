package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
