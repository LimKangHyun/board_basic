package project.board.dto;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import project.board.entity.MemberEntity;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String loginId;
    private String password;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setLoginId(memberEntity.getLoginId());
        memberDTO.setPassword(memberEntity.getPassword());
        return memberDTO;
    }
}
