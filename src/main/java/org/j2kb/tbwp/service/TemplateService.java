package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.Template;
import org.j2kb.tbwp.domain.repository.TemplateRepository;
import org.j2kb.tbwp.dto.TemplateDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TemplateService implements Service{

    @Autowired
    TemplateRepository templateRepository;
    LocalDateTime localDateTime = LocalDateTime.now();

    // save : CREATE , INSERT
    // findById, findAll : SELECT
    // deleteById, deleteAll : DELETE


    // CREATE
    public void create(Template template){
        templateRepository.save(template);
    }

    public void create(Long TemplateNo){
        Optional<org.j2kb.tbwp.domain.entity.Template> byId = templateRepository.findById(TemplateNo);
        templateRepository.save(byId.get());
    }

    public void create(TemplateDto templateDto){
        Optional<Template> byId = templateRepository.findById(templateDto.getTemplateNo());
        templateRepository.save(byId.get());
    }

    // Update
    public void update(Template template){ templateRepository.save(template);
    }

    public void update(Long id){
        Optional<org.j2kb.tbwp.domain.entity.Template> byId = templateRepository.findById(id);
        templateRepository.save(byId.get());
    }

    public void update(TemplateDto templateDto){
        Optional<org.j2kb.tbwp.domain.entity.Template> byId = templateRepository.findById(templateDto.getTemplateNo());
        templateRepository.save(byId.get());
    }


    // SELECT
    public Template selectOne(Template template){ // 1L -> 탈퇴
        Optional<Template> temp = templateRepository.findById(template.getTemplateNo());
        if(temp.isPresent()){
            return temp.get();
        }else {
            Template entity = Template.builder()
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
            return entity;
        }
    }


    public Template selectOne(Long id){ // 1L -> 탈퇴
        Optional<org.j2kb.tbwp.domain.entity.Template> temp = templateRepository.findById(id);
        if(temp.isPresent()){
            return temp.get();
        }else {
            Template entity = Template.builder()
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
            return entity;
        }

    }

    public Template selectOne(TemplateDto TemplateDto){ // 1L -> 탈퇴
        Optional<Template> temp = templateRepository.findById(TemplateDto.getTemplateNo());
        if(temp.isPresent()){
            return temp.get();
        }else {
            Template entity = Template.builder()
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
            return entity;
        }
    }


    public List<Template> selectAll(){
        return templateRepository.findAll();
    }

    // DELETE
    public void remove(Long id){
        templateRepository.deleteById(id);
    }
    public void remove(TemplateDto templateDto){ templateRepository.deleteById(templateDto.getTemplateNo());
    }
    public void remove(Template Template){
        templateRepository.deleteById(Template.getTemplateNo());
    }

}
