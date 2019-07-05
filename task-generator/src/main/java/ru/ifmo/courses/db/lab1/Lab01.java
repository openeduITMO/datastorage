package ru.ifmo.courses.db.lab1;

import com.tuneit.courses.db.generate.Lab;
import com.tuneit.courses.db.generate.LabTaskQA;
import com.tuneit.courses.db.generate.Schema;
import com.tuneit.courses.db.generate.Task;
import ru.ifmo.courses.db.lab1.schema.Schema01;
import ru.ifmo.courses.db.lab1.task.*;

/**
 * First lab tasks generator
 */
public class Lab01 implements Lab {

    /**
     * generate selected task
     * @param task - task description
     * @param schema - task generation data
     * @return generated task question, correct answer and the column by which the sorting will be performed
     */
    @Override
    public LabTaskQA generate(Task task, Schema schema) {
        task.setLabId(1);
        switch (task.getTaskId()) {
            case 1:
                return new Lab1Task1().generate(((Schema01) schema).clone(), task);
            case 2:
                return new Lab1Task2().generate(((Schema01) schema).clone(), task);
            case 3:
                return new Lab1Task3().generate(((Schema01) schema).clone(), task);
            case 4:
                return new Lab1Task4().generate(((Schema01) schema).clone(), task);
            case 5:
                return new Lab1Task5().generate(((Schema01) schema).clone(), task);
            case 6:
                return new Lab1Task6().generate(((Schema01) schema).clone(), task);
            case 7:
                return new Lab1Task7().generate(((Schema01) schema).clone(), task);
            case 8:
                return new Lab1Task8().generate(((Schema01) schema).clone(), task);
            case 9:
                return new Lab1Task9().generate(((Schema01) schema).clone(), task);
            case 10:
                return new Lab1Task10().generate(((Schema01) schema).clone(), task);
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
        task.setLabId(1);

        return new LabTaskQA[]{
                new Lab1Task1().generate(((Schema01) schema).clone(), task),
                new Lab1Task2().generate(((Schema01) schema).clone(), task),
                new Lab1Task3().generate(((Schema01) schema).clone(), task),
                new Lab1Task4().generate(((Schema01) schema).clone(), task),
                new Lab1Task5().generate(((Schema01) schema).clone(), task),
                new Lab1Task6().generate(((Schema01) schema).clone(), task),
                new Lab1Task7().generate(((Schema01) schema).clone(), task),
                new Lab1Task8().generate(((Schema01) schema).clone(), task),
                new Lab1Task9().generate(((Schema01) schema).clone(), task),
                new Lab1Task10().generate(((Schema01) schema).clone(), task),
        };
    }
}

