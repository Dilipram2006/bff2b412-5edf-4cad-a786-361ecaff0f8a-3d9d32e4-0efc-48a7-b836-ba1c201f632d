package com.examly.springapp.repository;

import com.examly.springapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer> {

  // Find by name
  List<MembershipType> findByTypeName(String typeName);

  // JPQL: price range
  @Query("SELECT m FROM MembershipType m WHERE m.price BETWEEN :min AND :max")
  List<MembershipType> findByPriceRange(double min, double max);

  // Price less than
  List<MembershipType> findByPriceLessThan(double price);

  // Duration greater than
  List<MembershipType> findByDurationInMonthsGreaterThan(int duration);
}

