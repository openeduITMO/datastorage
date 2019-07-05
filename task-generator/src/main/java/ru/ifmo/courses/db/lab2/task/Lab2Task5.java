package ru.ifmo.courses.db.lab2.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Aggregation;
import com.tuneit.courses.db.template.Condition;
import com.tuneit.courses.db.template.Reference;
import ru.ifmo.courses.db.lab2.Lab2Task;
import ru.ifmo.courses.db.lab2.schema.Schema02;
import ru.ifmo.courses.db.schema.TableCondition;

import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;

public class Lab2Task5 extends Lab2Task {
    @Override
    public LabTaskQA generate(Schema02 schema02, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        Aggregation aggregation = getRandomElement(random, schema02.getAggregations());
        Reference.ChainTable chainTable = schema02.getRandomChainTable(random,
                schema02.findTableBySqlName(aggregation.getTableSqlName()));

        //find conditions for right table
        schema02.getTableConditions().removeIf(conditionTable ->
                !conditionTable.getSqlTableName().equalsIgnoreCase(chainTable.getRightTable().getTableName()));
        TableCondition tableCondition = schema02.getTableConditions().get(0);

        //delete condition for join column
        tableCondition.getConditions().removeIf(condition ->
                condition.getSqlColumnName().equalsIgnoreCase(chainTable.getRightColumn().getColumnName()));
        Condition condition = getRandomElement(random, tableCondition.getConditions());

        String option = getRandomElement(random, condition.getOptionConditions());
        Condition.PairSign conditionSign = condition.getConditionSign(random);

        query.append("Выведите ")
                .append(aggregation.getColumnFunctionNativeName())
                .append(": ").append(condition.getNativeColumnName())
                .append(conditionSign.getSignConditionNative())
                .append("\"")
                .append(option)
                .append("\" (данные из таблицы ")
                .append(chainTable.getRightTable().getNameGenitive())
                .append("). В запросе должен использоваться INNER JOIN.");

        answer.append("select ")
                .append(aggregation.getFunctionSqlName())
                .append("(")
                .append(chainTable.getLeftTable().getTableName())
                .append(".")
                .append(aggregation.getColumnSqlName())
                .append(") from ")
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

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), "1");
    }

}