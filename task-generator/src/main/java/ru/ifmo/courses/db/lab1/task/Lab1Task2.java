package ru.ifmo.courses.db.lab1.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Table;
import ru.ifmo.courses.db.lab1.Lab1Task;
import ru.ifmo.courses.db.lab1.schema.Schema01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;


public class Lab1Task2 extends Lab1Task {
    @Override
    public LabTaskQA generate(Schema01 schema01, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        Table table = getRandomElement(random, schema01.getTables());
        List<Column> columns = table.getRandomColumns(random, 2);

        List<String> columnsRevisedForWrite = new ArrayList<>();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getNamePlural() + " (" + column.getColumnName().toLowerCase() + ")"));

        query.append("Выведите содержимое полей ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", query);
        query.append(" для таблицы ")
                .append(table.getTableName())
                .append(".");

        columnsRevisedForWrite.clear();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getColumnName()));

        answer.append("SELECT ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", answer);
        answer.append(" FROM ")
                .append(table.getTableName())
                .append(";");

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), columns.get(0).getColumnName());
    }

}