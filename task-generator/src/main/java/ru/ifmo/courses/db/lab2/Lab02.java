package ru.ifmo.courses.db.lab2;

import com.tuneit.courses.db.generate.Lab;
import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Schema;
import com.tuneit.courses.db.generate.Task;
import ru.ifmo.courses.db.lab2.schema.Schema02;
import ru.ifmo.courses.db.lab2.task.*;

/**
 * Second lab tasks generator
 */
public class Lab02 implements Lab {

    /**
     * generate selected task
     * @param task - task description
     * @param schema - task generation data
     * @return generated task question, correct answer and the column by which the sorting will be performed
     */
    @Override
    public LabTaskQA generate(Task task, Schema schema) {
        task.setLabId(2);

        switch (task.getTaskId()) {
            case 1:
                return new Lab2Task1().generate(((Schema02)schema).clone(), task);
            case 2:
                return new Lab2Task2().generate(((Schema02)schema).clone(), task);
            case 3:
                return new Lab2Task3().generate(((Schema02)schema).clone(), task);
            case 4:
                return new Lab2Task4().generate(((Schema02)schema).clone(), task);
            case 5:
                return new Lab2Task5().generate(((Schema02)schema).clone(), task);
            default:
                return null;
        }
    }

    /**
     * generates all tasks for this lab
     * @param task - task description
     * @param schema - task generation data
     * @return generated tasks with question, correct answer and the column by which the sorting will be performed
     */
    @Override
    public LabTaskQA[] generateAll(Task task, Schema schema) {
        task.setLabId(2);

        return new LabTaskQA[]{
                new Lab2Task1().generate(((Schema02)schema).clone(), task),
                new Lab2Task2().generate(((Schema02)schema).clone(), task),
                new Lab2Task3().generate(((Schema02)schema).clone(), task),
                new Lab2Task4().generate(((Schema02)schema).clone(), task),
                new Lab2Task5().generate(((Schema02)schema).clone(), task),
        };
    }
}

