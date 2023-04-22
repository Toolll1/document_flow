package ru.hakaton.documentFlow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hakaton.documentFlow.dao.DocDao;

@Service
@RequiredArgsConstructor
public class DocService {

      private final DocDao docDao;

    public void replaceText(int id) {

        docDao.replaceText(id);
    }
}
