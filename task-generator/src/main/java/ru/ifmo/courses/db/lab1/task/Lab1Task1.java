package ru.ifmo.courses.db.lab1.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Table;
import ru.ifmo.courses.db.lab1.Lab1Task;
import ru.ifmo.courses.db.lab1.schema.Schema01;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;


public class Lab1Task1 extends Lab1Task {
    @Override
    public LabTaskQA generate(Schema01 schema01, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Table table = getRandomElement(task.getRandom(), schema01.getTables());
        Column columnToSort = getRandomElement(task.getRandom(), table.getColumns());

        query.append("Выведите содержимое всех полей таблицы ")
                .append(table.getTableName())
                .append(".");

        answer.append("SELECT * FROM ")
                .append(table.getTableName())
                .append(";");

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), columnToSort.getColumnName());
    }

}