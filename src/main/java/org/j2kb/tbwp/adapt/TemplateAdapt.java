package org.j2kb.tbwp.adapt;

import org.j2kb.tbwp.domain.entity.Template;
import org.j2kb.tbwp.dto.TemplateDto;

public interface TemplateAdapt {
    Template changeTemplate(TemplateDto templateDto);

    TemplateDto changeTemplateDto(Template template);
}
