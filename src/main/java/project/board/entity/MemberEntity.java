package project.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.board.dto.MemberDTO;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    public static MemberEntity toSaveMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(memberDTO.getName());
        memberEntity.setLoginId(memberDTO.getLoginId());
        memberEntity.setPassword(memberDTO.getPassword());
        return memberEntity;
    }
}
