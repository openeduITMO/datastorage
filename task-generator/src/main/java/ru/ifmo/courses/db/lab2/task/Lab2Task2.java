package ru.ifmo.courses.db.lab2.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Case;
import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Table;
import ru.ifmo.courses.db.lab2.Lab2Task;
import ru.ifmo.courses.db.lab2.schema.Schema02;
import ru.ifmo.courses.db.lab2.schema.TableCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;

public class Lab2Task2 extends Lab2Task {
    @Override
    public LabTaskQA generate(Schema02 schema02, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        TableCases tableCases = getRandomElement(random, schema02.getTablesCases());
        Table table = schema02.findTableBySqlName(tableCases.getSqlTableName());

        Case randomCase = getRandomElement(random, tableCases.getCases());
        Column caseColumn = table.findColumn(randomCase.getSqlNameColumn());
        table.getColumns().remove(caseColumn);


        List<Column> columns = table.getRandomColumns(task.getRandom(), 1);

        List<String> columnsRevisedForWrite = new ArrayList<>();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getNamePlural()));

        query.append("Выведите содержимое следующих полей из таблицы ")
                .append(table.getNameGenitive())
                .append(": ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", query);
        query.append(", ")
                .append(caseColumn.getNamePlural())
                .append(". Замените значения ")
                .append(caseColumn.getNameGenitivePlural())
                .append(" ")
                .append(randomCase.getNativeQuery())
                .append(".");

        columnsRevisedForWrite.clear();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getColumnName()));

        answer.append("select ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", answer);
        answer.append(", ")
                .append(randomCase.getSqlQuery())
                .append(" from ")
                .append(table.getTableName());

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), columns.get(0).getColumnName());

    }

}