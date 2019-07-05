package ru.ifmo.courses.db.lab2.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Substring;
import com.tuneit.courses.db.template.Table;
import ru.ifmo.courses.db.lab2.Lab2Task;
import ru.ifmo.courses.db.lab2.schema.Schema02;
import ru.ifmo.courses.db.lab2.schema.TableSubstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;

public class Lab2Task1 extends Lab2Task {
    @Override
    public LabTaskQA generate(Schema02 schema02, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();


        TableSubstring tableSubstring = getRandomElement(random, schema02.getTablesSubstrings());

        Table table = schema02.findTableBySqlName(tableSubstring.getSqlTableName());

        Substring substringType = getRandomElement(random, tableSubstring.getSubstring());

        Column likeColumn = table.findColumn(substringType.getSqlNameColumn());
        table.getColumns().remove(likeColumn);

        boolean isLeftSubstring = random.nextBoolean();

        String nativeSubstring;
        String sqlSubstring;
        if (isLeftSubstring) {
            String substring = getRandomElement(random, substringType.getLeftSubstrings());
            nativeSubstring = "начинаются на \"" + substring + "\"";
            sqlSubstring = "'" + substring + "%'";
        } else {
            String substring = getRandomElement(random, substringType.getRightSubstrings());
            nativeSubstring = "заканчиваются на \"" + substring + "\"";
            sqlSubstring = "'%" + substring + "'";
        }

        List<Column> columns = table.getRandomColumns(random, 2);
        List<String> columnsRevisedForWrite = new ArrayList<>();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getNamePlural()));

        query.append("Выведите содержимое полей ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", query);
        query.append(" из таблицы ")
                .append(table.getNameGenitive())
                .append(", ")
                .append(likeColumn.getNamePlural())
                .append(" которых ")
                .append(nativeSubstring)
                .append(".");

        columnsRevisedForWrite.clear();
        columns.forEach(
                column -> columnsRevisedForWrite.add(column.getColumnName()));

        answer.append("select ");
        writeColumnToQuery(columnsRevisedForWrite, ", ", answer);
        answer.append(" from ")
                .append(table.getTableName())
                .append(" where ")
                .append(likeColumn.getColumnName())
                .append(" like ")
                .append(sqlSubstring);

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), columns.get(0).getColumnName());
    }

}