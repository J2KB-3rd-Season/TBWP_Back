package org.j2kb.tbwp.service;

import org.j2kb.tbwp.dto.TemplateDto;

import java.util.List;


public interface TemplateService {
    void create(TemplateDto dto);

    void create(Long id);

    void update(TemplateDto dto);

    void update(Long id);

    TemplateDto selectOne(Long id);

    List<TemplateDto> selectAll();

    void remove(Long id);

    void remove(TemplateDto dto);

    Long max();

}
