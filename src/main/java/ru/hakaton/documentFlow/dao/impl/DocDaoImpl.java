package ru.hakaton.documentFlow.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.hakaton.documentFlow.dao.DocDao;
import ru.hakaton.documentFlow.util.DocxFileUtils;

import java.util.List;
import java.util.Set;

@Primary
@Slf4j
@Component
@RequiredArgsConstructor
public class DocDaoImpl implements DocDao {
    String path = "D:\\dev\\documentFlow\\src\\main\\java\\ru\\hakaton\\documentFlow\\files\\test.docx";
    private final DocxFileUtils docxFileUtils;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void replaceText(int id) {

        try {
            Set<String> keyWords = docxFileUtils.findPattern(path);
            String pathToNewFile = docxFileUtils.copyFile(path);

            for (String oldWord : keyWords) {
                String newWord = findData(id, oldWord);

                docxFileUtils.replaceText(pathToNewFile, oldWord, newWord);
            }

            for (String s : List.of("{", "}")) {
                docxFileUtils.replaceText(pathToNewFile, s, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String findData(int id, String keyWord) {

        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from users where id = ?", id);

        if (userRows.next()) {
            return userRows.getString(keyWord.toLowerCase());
        } else {
            return "некорректно задано поле";
        }
    }
}
