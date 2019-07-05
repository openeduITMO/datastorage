package ru.ifmo.courses.db.lab1.task;

import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.template.DiffDate;
import com.tuneit.courses.db.template.DiffDateOption;
import ru.ifmo.courses.db.lab1.Lab1Task;
import ru.ifmo.courses.db.lab1.schema.Schema01;

import java.util.Random;

import static com.tuneit.courses.db.generate.Schema.getRandomElement;

public class Lab1Task10 extends Lab1Task {

    @Override
    public LabTaskQA generate(Schema01 schema01, Task task) {
        query = new StringBuilder();
        answer = new StringBuilder();

        Random random = task.getRandom();

        DiffDate diffDate = getRandomElement(random, schema01.getDiffDates());
        DiffDateOption option = getRandomElement(random, diffDate.getDiffDateOptions());

        query.append("Подсчитайте ")
                .append(diffDate.getNativeDescription())
                .append(" ")
                .append(option.getNativeOption())
                .append(". Важно: в postgresql результат вычитания двух дат имеет тип interval. Для извлечения количества минут из данных типа interval можно воспользоваться функцией extract.");

        answer.append("SELECT ")
                .append("EXTRACT(EPOCH FROM ")
                .append(diffDate.getSqlNameColumn1())
                .append(" - ")
                .append(diffDate.getSqlNameColumn2())
                .append(")")
                .append(option.getSqlOption())
                .append(" FROM ")
                .append(diffDate.getSqlTableName())
                .append(";");

        return new LabTaskQA(task.getId(), query.toString(), answer.toString(), "1");
    }

}