package org.j2kb.tbwp.domain.repository;

import org.j2kb.tbwp.domain.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Long> {
    @Query(value = "select max(templateNo) from Template ")
    BigDecimal max();
}
