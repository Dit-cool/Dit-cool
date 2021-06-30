package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.Member;
import wagen.auto.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/listMember")
    public String getMember (Model model){

        List<Member> memberList = memberService.getAllMember();
        model.addAttribute("listMember", memberList);
        return "/member/listMember";
    }

    @PostMapping("/addMember")
    public String addMember(Member member){

        memberService.saveMember(member);

        return "redirect:/listMember";
    }

    @RequestMapping ("viewaddMember")
    public String viewAddMember(Model model){
        model.addAttribute("memberObject", new Member());
        return "/member/addMember";
    }

    @GetMapping("/viewupdateMember/{id_member}")
    public String viewupdateMember(@PathVariable(value = "id_member") int id_member, Model model){

        Member member = memberService.getMemberById(id_member);

        model.addAttribute("memberObject", member);
        return "/member/updateMember";
    }

    //    #Detail
    @GetMapping("/detailMember/{id_member}")
    public String detailMember(@PathVariable(value = "id_member") Integer id_member, Model model){
        Member members = memberService.getMemberById(id_member);
        model.addAttribute("memberObject", members);

        return "member/detailMember";
    }

    //    #Update
    @PostMapping("/updateMember/{id_member}")
    public String update(@PathVariable("id_member") int id_member, Member member,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            member.setId_member(id_member);
            return "/member/viewupdateMember";
        }

        memberService.update(id_member, member);
        return "redirect:/listMember";
    }

    @GetMapping("/deleteMember/{id_member}")
    public String deleteMember(@PathVariable("id_member") int id_member, Member member,
                               BindingResult result, Model model) {

        memberService.deleteMember(id_member, member);
        return "redirect:/listMember";

    }
}
