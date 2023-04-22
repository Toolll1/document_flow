package ru.hakaton.documentFlow.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DocxFileUtils {

    int newDocNumber = 1;

    public void replaceText(String pathToNewFile, String keyWord, String correctWord) throws Exception {

       XWPFDocument doc = new XWPFDocument(new FileInputStream(pathToNewFile));

        for (XWPFParagraph p : doc.getParagraphs()) {

            for (XWPFRun r : p.getRuns()) {
                String text = r.getText(0);

                if (text != null && text.contains(keyWord)) {
                    text = text.replace(keyWord, correctWord);
                    r.setText(text, 0);
                }
            }
        }

        doc.write(new FileOutputStream(pathToNewFile));
        doc.close();
    }


    public Set<String> findPattern(String path) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        Set<String> keyWords = new HashSet<>();
        XWPFDocument doc = new XWPFDocument(fis);

        for (XWPFParagraph para : doc.getParagraphs()) {
            Pattern pattern = Pattern.compile("\\{(.+?)\\}");
            Matcher matcher = pattern.matcher(para.getText());
            while (matcher.find()) {
                keyWords.add(matcher.group(1));
            }
        }

        fis.close();
        doc.close();
        return keyWords;
    }

    public String copyFile(String path) throws IOException {

        String pathToNewFile = "D:\\dev\\documentFlow\\src\\main\\java\\ru\\hakaton\\documentFlow\\files\\test"
                + newDocNumber++ + ".docx";
        Path sourcePath = Paths.get(path);
        Path targetPath = Paths.get(pathToNewFile);
        Files.copy(sourcePath, targetPath);

        return pathToNewFile;
    }

}
