package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import java.util.List;

public interface MemberService {

  Member save(Member member);

  Member update(int id, Member member);

  Member getById(int id);

  List<Member> getPaged(int page, int size);
}

