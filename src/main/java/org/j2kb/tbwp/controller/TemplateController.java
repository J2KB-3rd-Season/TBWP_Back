package org.j2kb.tbwp.controller;

import lombok.RequiredArgsConstructor;
import org.j2kb.tbwp.service.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TemplateController {

    @Autowired
    private final TemplateServiceImpl templateService;

    @PostMapping()
    public ResponseEntity<String> newTemplate(){
        return null;
    }
}
