package ru.ifmo.courses.db.lab2.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Condition;
import com.tuneit.courses.db.template.Reference;
import ru.ifmo.courses.db.lab2.Lab2Task;
import ru.ifmo.courses.db.lab2.schema.Schema02;

import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;

public class Lab2Task4 extends Lab2Task {
    @Override
    public LabTaskQA generate(Schema02 schema02, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        //get 2 table for join
        Reference.ChainTable chainTable = schema02.getRandomChainTable(random);

        //get condition for right table
        schema02.getTableConditions().removeIf(conditionTable ->
                !conditionTable.getSqlTableName().equalsIgnoreCase(chainTable.getRightTable().getTableName()));
        Condition condition = getRandomElement(random, schema02.getTableConditions().get(0).getConditions());

        String option = getRandomElement(random, condition.getOptionConditions());
        Condition.PairSign conditionSign = condition.getConditionSign(random);

        //delete equals columns for 2 tables
        chainTable.getLeftTable().getColumns().removeIf(column ->
                chainTable.getRightTable().getColumns().stream()
                        .anyMatch(column1 -> column1.getColumnName().equals(column.getColumnName())));

        Column column = getRandomElement(random, chainTable.getLeftTable().getColumns());

        query.append("Напишите запрос для получения полей из объединённых таблиц, " +
                "удовлетворяющих указанным условиям. Таблицы: ")
                .append(chainTable.getLeftTable().getNameGenitive())
                .append(", ")
                .append(chainTable.getRightTable().getNameGenitive())
                .append(". Поля: все уникальные значения ")
                .append(column.getNameGenitivePlural())
                .append(" из таблицы ")
                .append(chainTable.getLeftTable().getNameGenitive())
                .append(". Условия: ")
                .append(condition.getNativeColumnName())
                .append(conditionSign.getSignConditionNative())
                .append("\"")
                .append(option)
                .append("\". В запросе должен использоваться INNER JOIN.");

        answer.append("select distinct ")
                .append(chainTable.getLeftTable().getTableName())
                .append(".")
                .append(column.getColumnName())
                .append(" from ")
                .append(chainTable.getLeftTable().getTableName())
                .append(" inner join ")
                .append(chainTable.getRightTable().getTableName())
                .append(" on ")
                .append(chainTable.getLeftTable().getTableName())
                .append(".")
                .append(chainTable.getLeftColumn().getColumnName())
                .append(" = ")
                .append(chainTable.getRightTable().getTableName())
                .append(".")
                .append(chainTable.getRightColumn().getColumnName())
                .append(" where ")
                .append(chainTable.getRightTable().getTableName())
                .append(".")
                .append(condition.getSqlColumnName())
                .append(conditionSign.getSignConditionSql())
                .append("'")
                .append(option)
                .append("';");

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), column.getColumnName());
    }

}