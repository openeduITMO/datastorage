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

public class Lab1Task4 extends Lab1Task {
    @Override
    public LabTaskQA generate(Schema01 schema01, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        Table table = getRandomElement(random, schema01.getTables());
        Column sortedColumn = getRandomElement(random, table.getColumns());
        table.getColumns().remove(sortedColumn);

        List<Column> columns = table.getRandomColumns(task.getRandom(), 2);
        boolean isDirectionSortedASC = random.nextBoolean();

        List<String> columnsRevisedForWrite = new ArrayList<>();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getNamePlural() + " (" + column.getColumnName().toLowerCase() + ")"));

        query.append("Выведите содержимое полей ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", query);
        query.append(" для таблицы ")
                .append(table.getTableName())
                .append(". Отсортируйте результат по столбцу ")
                .append(sortedColumn.getNamePlural())
                .append(" (")
                .append(sortedColumn.getColumnName().toLowerCase())
                .append(") в порядке ");
        if (isDirectionSortedASC) {
            query.append("возрастания.");
        } else {
            query.append("убывания.");
        }

        columnsRevisedForWrite.clear();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getColumnName()));

        answer.append("SELECT ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", answer);
        answer.append(" FROM ")
                .append(table.getTableName())
                .append(" ORDER BY ")
                .append(sortedColumn.getColumnName());
        if (isDirectionSortedASC) {
            answer.append(" ASC;");
        } else {
            answer.append(" DESC;");
        }

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), null);
    }

}