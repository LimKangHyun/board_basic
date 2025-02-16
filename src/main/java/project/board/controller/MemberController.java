package project.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.board.dto.MemberDTO;
import project.board.repository.MemberRepository;
import project.board.service.MemberService;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") MemberDTO memberDTO) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("member") MemberDTO memberDTO) {
        memberService.save(memberDTO);
        log.info("added memberDTO = {}", memberDTO);
        return "members/addMemberForm";
    }
}
