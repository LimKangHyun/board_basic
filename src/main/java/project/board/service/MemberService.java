package project.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.board.dto.BoardDTO;
import project.board.dto.MemberDTO;
import project.board.entity.MemberEntity;
import project.board.repository.MemberRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO findById(Long id) {
        MemberEntity memberEntity = memberRepository.findById(id).orElse(null);
        return MemberDTO.toMemberDTO(memberEntity);
    }

    public Optional<MemberEntity> findByLoginId(String loginId) {
        return memberRepository.findAll().stream()
                .filter(memberEntity -> memberEntity.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();

        for (MemberEntity member : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        }
        return memberDTOList;
    }

}
