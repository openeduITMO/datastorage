package ru.ifmo.courses.db.lab1.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Condition;
import com.tuneit.courses.db.template.Table;
import ru.ifmo.courses.db.lab1.Lab1Task;
import ru.ifmo.courses.db.lab1.schema.Schema01;
import ru.ifmo.courses.db.schema.TableCondition;

import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;

public class Lab1Task6 extends Lab1Task {
    @Override
    public LabTaskQA generate(Schema01 schema01, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        schema01.getTableConditions().removeIf(conditionTable ->
                conditionTable.getConditions().stream().allMatch(condition -> condition.getContainsNull().isEmpty()));

        TableCondition tableCondition = getRandomElement(random, schema01.getTableConditions());
        Table table = schema01.findTableBySqlName(tableCondition.getSqlTableName());
        Column columnToSort = getRandomElement(random, table.getColumns());

        tableCondition.getConditions().removeIf(condition -> condition.getContainsNull().isEmpty());

        Condition condition = getRandomElement(random, tableCondition.getConditions());

        query.append("Выведите содержимое всех полей из таблицы ")
                .append(table.getNameGenitive())
                .append(", которые удовлетворяют следующему условию: ")
                .append(condition.getNativeColumnName())
                .append(" ")
                .append(condition.getContainsNull())
                .append(".");

        answer.append("SELECT * FROM ")
                .append(table.getTableName())
                .append(" WHERE ")
                .append(condition.getSqlColumnName())
                .append(" ISNULL");

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), columnToSort.getColumnName());
    }

}