package com.examly.springapp.service;

import com.examly.springapp.model.Membership;
import java.util.List;

public interface MembershipService {

  Membership saveMembership(Membership membership);

  List<Membership> getAllMemberships();
}

