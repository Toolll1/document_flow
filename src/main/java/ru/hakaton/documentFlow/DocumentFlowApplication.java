package ru.hakaton.documentFlow;

import com.aspose.words.*;
import com.aspose.words.Font;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class DocumentFlowApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DocumentFlowApplication.class, args);


        // Создать объект документа
        Document doc = new Document();
// Создайте объект DocumentBuilder
        DocumentBuilder builder = new DocumentBuilder(doc);
// Создать таблицу
        Table table = builder.startTable();
// Вставить ячейку
        builder.insertCell();
        table.autoFit(AutoFitBehavior.AUTO_FIT_TO_WINDOW);
        builder.getCellFormat().setVerticalAlignment(CellVerticalAlignment.CENTER);
        builder.write("This is Row 1 Cell 1");
        builder.insertCell();
        builder.write("This is Row 1 Cell 2");
// Конец ряда
        builder.endRow();
// начать следующую строку и установить ее свойства
        builder.getRowFormat().setHeight(100);
        builder.getRowFormat().setHeightRule(HeightRule.EXACTLY);
        builder.insertCell();
        builder.write("This is Row 2 Cell 1");
        builder.insertCell();
        builder.write("This is Row 2 Cell 2");
        builder.endRow();
// Конечная таблица
        builder.endTable();

        Font font = builder.getFont();
        font.setSize(16.0);
        font.setBold(true);
        font.setColor(Color.BLUE);
        font.setName("Arial");
        font.setUnderline(Underline.DASH);

        ParagraphFormat paragraphFormat = builder.getParagraphFormat();
        paragraphFormat.setFirstLineIndent(8.0);
        paragraphFormat.setAlignment(ParagraphAlignment.JUSTIFY);
        paragraphFormat.setAddSpaceBetweenFarEastAndAlpha(true);
        paragraphFormat.setAddSpaceBetweenFarEastAndDigit(true);
        paragraphFormat.setKeepTogether(true);

        // The "Writeln" method ends the paragraph after appending text
        // and then starts a new line, adding a new paragraph.
        builder.writeln("Hello world!");

// Сохраните документ
        doc.save("Rich Word Document.docx");

newWord();
    }

    private static void newWord() throws Exception {

        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        Font font = builder.getFont();
        font.setSize(16.0);
        font.setBold(true);
        font.setColor(Color.BLUE);
        font.setName("Arial");
        font.setUnderline(Underline.DASH);

        ParagraphFormat paragraphFormat = builder.getParagraphFormat();
        paragraphFormat.setFirstLineIndent(8.0);
        paragraphFormat.setAlignment(ParagraphAlignment.JUSTIFY);
        paragraphFormat.setAddSpaceBetweenFarEastAndAlpha(true);
        paragraphFormat.setAddSpaceBetweenFarEastAndDigit(true);
        paragraphFormat.setKeepTogether(true);

        // The "Writeln" method ends the paragraph after appending text
        // and then starts a new line, adding a new paragraph.
        builder.writeln("Hello world!");

    }

}
