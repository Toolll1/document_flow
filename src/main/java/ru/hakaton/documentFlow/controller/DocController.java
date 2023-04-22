package ru.hakaton.documentFlow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hakaton.documentFlow.service.DocService;

@RestController
@RequiredArgsConstructor
public class DocController {

    private final DocService docService;

    @PutMapping("/documentFlow/{id}")
    public void replaceText(@PathVariable int id) {
        docService.replaceText(id);
    }
}
