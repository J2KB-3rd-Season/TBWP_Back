package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.Template;
import org.j2kb.tbwp.dto.TemplateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
public class TemplateServiceTest {
        @Autowired
        TemplateService templateService;
        LocalDateTime localDateTime = LocalDateTime.now();

    @Test
        public void 템플릿_생성_DTO(){
        TemplateDto templateDto = TemplateDto.builder()
                    .TemplateNo(1L)
                    .content("템플릿을 생성합니다.")
                    .extension("템플릿을 생성합니다.")
                    .fileName("템플릿을 생성합니다.")
                    .font("템플릿을 생성합니다.")
                    .modDate(localDateTime)
                    .path("템플릿을 생성합니다.")
                    .regDate(localDateTime)
                    .path("템플릿을 생성합니다.")
                    .build();
            templateService.create(templateDto);
        }

        @Test
        @Transactional
        public void 템플릿_삭제_ID(){
            templateService.remove(1L);
        }

        @Test
        public void 템플릿_삭제_객체(){
            Template template = Template.builder()
                    .TemplateNo(1L)
                    .content("삭제된 템플릿입니다.")
                    .extension("삭제된 템플릿입니다.")
                    .fileName("삭제된 템플릿입니다.")
                    .font("삭제된 템플릿입니다.")
                    .modDate(localDateTime)
                    .path("삭제된 템플릿입니다.")
                    .regDate(localDateTime)
                    .path("삭제된 템플릿입니다.")
                    .build();
            templateService.remove(template);
        }

        @Test
        public void 템플릿_삭제_DTO(){
            TemplateDto templateDto = TemplateDto.builder()
                    .TemplateNo(1L)
                    .content("삭제된 템플릿입니다.")
                    .extension("삭제된 템플릿입니다.")
                    .fileName("삭제된 템플릿입니다.")
                    .font("삭제된 템플릿입니다.")
                    .modDate(localDateTime)
                    .path("삭제된 템플릿입니다.")
                    .regDate(localDateTime)
                    .path("삭제된 템플릿입니다.")
                    .build();
            templateService.remove(templateDto);
        }
    }