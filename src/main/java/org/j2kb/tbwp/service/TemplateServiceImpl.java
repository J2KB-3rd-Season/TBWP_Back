package org.j2kb.tbwp.service;

import lombok.RequiredArgsConstructor;
import org.j2kb.tbwp.domain.entity.Template;
import org.j2kb.tbwp.domain.repository.TemplateRepository;
import org.j2kb.tbwp.dto.TemplateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private final TemplateRepository templateRepository;

    LocalDateTime localDateTime = LocalDateTime.now();


    @Override
    public void create(TemplateDto dto) {
        Template template = dto.changeTemplate(dto);
        templateRepository.save(template);
    }

    @Override
    public void create(Long id) {
        Optional<Template> result = templateRepository.findById(id);
        if(result.isPresent()){
            templateRepository.findById(result.get().getTemplateNo());
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void update(TemplateDto dto) {
        Template template = dto.changeTemplate(dto);
        templateRepository.save(template);
    }

    @Override
    public void update(Long id) {
        Optional<Template> result = templateRepository.findById(id);
        if(result.isPresent()){
            templateRepository.findById(result.get().getTemplateNo());
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public TemplateDto selectOne(Long id) {
        TemplateDto result = new TemplateDto();
        Optional<Template> findOne = templateRepository.findById(id);

        if(findOne.isPresent()){
            result = result.changeTemplateDto(findOne.get());
        }else{
            throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public List<TemplateDto> selectAll() {
        List<Template> findList = templateRepository.findAll();
        TemplateDto dto = new TemplateDto();
        List<TemplateDto> result = new ArrayList<>();

        for(Template t : findList){
            result.add(dto.changeTemplateDto(t));
        }
        return result;
    }

    @Override
    public void remove(Long id) {
        templateRepository.deleteById(id);
    }

    @Override
    public void remove(TemplateDto dto) {
        Optional<Template> result = templateRepository.findById(dto.getTemplateNo());
        if(result.isPresent()){
            templateRepository.deleteById(result.get().getTemplateNo());
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public Long max() {
        BigDecimal max = templateRepository.max();
        return Long.valueOf(String.valueOf(max));
    }
}
