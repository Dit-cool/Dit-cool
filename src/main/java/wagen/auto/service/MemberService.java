package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Member;
import wagen.auto.repository.MemberRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMember(){
        List<Member> memberList = (List<Member>) memberRepository.findAll();
        return memberList;
    }

    public List<Member> saveMember(Member member){
        member.setPoin(0);
        member.setStatus(1);
        member.setCreadate(new Date());
        member.setModidate(new Date());
        member.setCreaby(1);
        member.setModiby(1);
        memberRepository.save(member);
        return getAllMember();
    }

    public Member getMemberById(int id_member){
        Optional<Member> optional = memberRepository.findById(id_member);
        Member member = null;
        if(optional.isPresent()){
            member = optional.get();
        }else  {
            throw  new RuntimeException("Member not found" + id_member);
        }
        return member;
    }

    public int update(int id_member, Member member){
        Member members = memberRepository.findById(id_member)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id_member));
        members.setNama_member(member.getNama_member());
        members.setNo_ktp(member.getNo_ktp());
        members.setAlamat(member.getAlamat());
        members.setNo_telp(member.getNo_telp());
        members.setEmail(member.getEmail());
        members.setModidate(new Date());
        members.setModiby(2);
        memberRepository.save(members);

        return 1;
    }

    public int deleteMember(int id_member, Member member){
        Member members = memberRepository.findById(id_member)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id_member));
        members.setStatus(0);
        members.setModidate(new Date());
        members.setModiby(3);
        memberRepository.save(members);

        return 1;
    }
}
