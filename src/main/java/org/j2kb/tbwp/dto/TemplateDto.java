package org.j2kb.tbwp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.j2kb.tbwp.adapt.TemplateAdapt;
import org.j2kb.tbwp.domain.entity.Template;

import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDto implements TemplateAdapt {
    private Long templateNo;

    private String content;

    private String path; // 파일 위치

    private String fileName; // 변환된 파일 명

    private String extension; // 확장자

    private String font; // 폰트

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    @Override
    public Template changeTemplate(TemplateDto templateDto) {
        Template template = Template.builder()
                .templateNo(templateDto.getTemplateNo())
                .content(templateDto.getContent())
                .extension(templateDto.getExtension())
                .fileName(templateDto.getFileName())
                .font(templateDto.getFont())
                .modDate(templateDto.getModDate())
                .regDate(templateDto.getModDate())
                .path(templateDto.getPath())
                .build();
        return template;
    }

    @Override
    public TemplateDto changeTemplateDto(Template template) {
        TemplateDto templateDto = TemplateDto.builder()
                .templateNo(template.getTemplateNo())
                .content(template.getContent())
                .extension(template.getExtension())
                .fileName(template.getFileName())
                .font(template.getFont())
                .modDate(template.getModDate())
                .regDate(template.getRegDate())
                .path(template.getPath())
                .build();
        return templateDto;
    }
}
