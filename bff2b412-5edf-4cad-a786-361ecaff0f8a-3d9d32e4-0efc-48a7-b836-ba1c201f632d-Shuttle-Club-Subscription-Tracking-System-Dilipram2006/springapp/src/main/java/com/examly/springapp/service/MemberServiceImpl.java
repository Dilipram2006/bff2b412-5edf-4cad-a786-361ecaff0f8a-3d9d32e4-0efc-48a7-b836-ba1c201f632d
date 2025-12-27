package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public Member save(Member member) {
    return memberRepository.save(member);
  }

  @Override
  public Member update(int id, Member member) {
    Member existing = memberRepository.findById(id)
        .orElse(new Member());

    existing.setName(member.getName());
    existing.setEmail(member.getEmail());

    return memberRepository.save(existing);
  }

  @Override
  public Member getById(int id) {
    return memberRepository.findById(id)
        .orElse(new Member());
  }

  @Override
  public List<Member> getPaged(int page, int size) {
    return memberRepository
        .findAll(PageRequest.of(page, size))
        .getContent();
  }
}

