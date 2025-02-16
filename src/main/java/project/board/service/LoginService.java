package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.board.entity.MemberEntity;
import project.board.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    /**
     * return이 null이면 로그인 실패
     */
    public MemberEntity login(String loginId, String password) {
        return memberService.findByLoginId(loginId)
                .filter(memberEntity -> memberEntity.getPassword().equals(password))
                .orElse(null);
    }
}
