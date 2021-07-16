package org.j2kb.tbwp.domain.repository;

import org.j2kb.tbwp.domain.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Long> {
}
