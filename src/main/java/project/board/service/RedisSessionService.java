package project.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import project.board.dto.MemberDTO;

@Service
@Slf4j
public class RedisSessionService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Redis에서 MemberDTO 객체를 가져와 역직렬화
    public MemberDTO getMemberFromSession(String sessionId) {
        // Redis에서 세션 데이터를 가져오기 (세션 ID에 해당하는 값을 읽기)
        MemberDTO member = (MemberDTO) redisTemplate.opsForValue().get(sessionId);

        if (member != null) {
            // 세션이 있으면 콘솔에 출력
            log.info("Session Data Retrieved: {}", member);  // 로그로 출력
        } else {
            log.warn("No session found for ID: {}", sessionId);  // 세션이 없으면 경고 출력
        }

        return member;
    }
}