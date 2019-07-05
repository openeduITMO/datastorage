package ru.ifmo.lab2;

import com.tuneit.courses.db.generate.Task;
import com.tuneit.courses.db.service.TaskGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ifmo.Main;
import ru.ifmo.courses.db.IfmoTaskGeneratorConfiguration;

import static org.junit.Assert.assertEquals;
import static ru.ifmo.lab2.Lab2Data.*;

@SpringBootTest(classes = Main.class)
@RunWith(SpringRunner.class)
@Import({IfmoTaskGeneratorConfiguration.class})
public class Lab2VariantTest {
    @Autowired
    TaskGeneratorService taskGenerator;

    @Test
    public void testTask1AllVariants() {
        for (int i = 0; i < getAnswerTask1().length; i++) {
            Task task = taskGenerator.getTask("88cf2413899516f809380fb6dbfcb007", 2, 1, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask1()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + "Выведите все уникальные значения статусов из таблицы рейсов воздушных судов, максимальная дальность полёта которых превышает \"4200\". Для выборки использовать данные из объединения таблиц рейсов воздушных судов и воздушных судов.");

            assertEquals(getQueryTask1()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask2AllVariants() {
        for (int i = 0; i < getAnswerTask2().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 2, 2, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask2()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask2()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask3AllVariants() {
        for (int i = 0; i < getAnswerTask3().length; i++) {
            Task task = taskGenerator.getTask("ee6a572e780fff2bbc7dc8da6c48c4ca", 2, 3, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask3()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask3()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask4AllVariants() {
        for (int i = 0; i < getAnswerTask4().length; i++) {
            Task task = taskGenerator.getTask("9d70783eaa12c377b158086b78dabb2c", 2, 4, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask4()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask4()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask5AllVariants() {
        for (int i = 0; i < getAnswerTask5().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 2, 5, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask5()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask5()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }
}
