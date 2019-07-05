package ru.ifmo.lab1;

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
import static ru.ifmo.lab1.Lab1Data.*;

@SpringBootTest(classes = Main.class)
@RunWith(SpringRunner.class)
@Import({IfmoTaskGeneratorConfiguration.class})
public class Lab1VariantTest {
    @Autowired
    TaskGeneratorService taskGenerator;

    @Test
    public void testTask1AllVariants() {
        for (int i = 0; i < getAnswerTask1().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 1, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask1()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask1()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask2AllVariants() {
        for (int i = 0; i < getAnswerTask2().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 2, Integer.toString(i), 0);
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
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 3, Integer.toString(i), 0);
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
            Task task = taskGenerator.getTask("0d0ad95120ae6f87b3f88e5552c094da", 1, 4, Integer.toString(i), 0);
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
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 5, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask5()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask5()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask6AllVariants() {
        for (int i = 0; i < getAnswerTask6().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 6, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask6()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask6()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask7AllVariants() {
        for (int i = 0; i < getAnswerTask7().length; i++) {
            Task task = taskGenerator.getTask("b81c5993b8bc5c1db5b975cd12f0e17c", 1, 7, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask7()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask7()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask8AllVariants() {
        for (int i = 0; i < getAnswerTask8().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 8, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask8()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask8()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask9AllVariants() {
        for (int i = 0; i < getAnswerTask9().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 9, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask9()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask9()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

    @Test
    public void testTask10AllVariants() {
        for (int i = 0; i < getAnswerTask10().length; i++) {
            Task task = taskGenerator.getTask("1db56a451774ae25e5d2788a78f5863a", 1, 10, Integer.toString(i), 0);
            task.setAnswer(getAnswerTask10()[i]);
            task.setComplete(true);
            taskGenerator.checkTasks(task);
            System.out.println(task.getTaskId() + ") " + task.getQuestion());

            assertEquals(getQueryTask10()[i], task.getQuestion());
            assertEquals(1, (int) task.getRating());
        }
    }

}
