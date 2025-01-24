package project.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.board.dto.CommentDTO;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String commentWriter;

    @Column
    private String commentContents;

    /*Board : Comment = 1 : N*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") //외래키 매핑 어노테이션
    private BoardEntity boardEntity; //@JoinColumn에 필요한 참조 테이블

    public static CommentEntity toSaveEntity(CommentDTO commentDTO, BoardEntity boardEntity) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentWriter(commentDTO.getCommentWriter());
        commentEntity.setCommentContents(commentDTO.getCommentContents());
        commentEntity.setBoardEntity(boardEntity); //BoardEntity에 있는 id 연결
        return commentEntity;
    }
}
