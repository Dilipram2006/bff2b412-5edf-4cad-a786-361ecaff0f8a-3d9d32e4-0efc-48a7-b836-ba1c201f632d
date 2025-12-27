package com.examly.springapp.service;

import com.examly.springapp.model.MembershipType;
import java.util.List;

public interface MembershipTypeService {

  MembershipType saveMembershipType(MembershipType membershipType);

  MembershipType updateMembershipType(int id, MembershipType membershipType);

  List<MembershipType> getAllMembershipTypes();

  MembershipType getMembershipTypeById(int id);

  List<MembershipType> getMembershipTypesByName(String name);

  List<MembershipType> getMembershipTypesByPriceRange(double min, double max);

  List<MembershipType> getMembershipTypesByPriceLessThan(double price);

  List<MembershipType> getMembershipTypesByDurationGreaterThan(int duration);
}

