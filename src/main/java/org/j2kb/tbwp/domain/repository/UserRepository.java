package org.j2kb.tbwp.domain.repository;

import org.j2kb.tbwp.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select max(userNo) from User ")
    BigDecimal max();
}
