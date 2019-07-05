package ru.ifmo.courses.db;

import com.tuneit.courses.db.generate.Lab;
import com.tuneit.courses.db.generate.Labs;
import org.springframework.stereotype.Component;
import ru.ifmo.courses.db.lab1.Lab01;
import ru.ifmo.courses.db.lab2.Lab02;

/**
 * Lab factory
 */
@Component
public class IfmoLabs implements Labs {
    /**
     * Construct lab by it's number
     * @param labId lab number from 1 to 2
     * @return generated lab
     * @throws IllegalArgumentException if lab id is out of bounds
     */
    @Override
    public Lab getLab(int labId) {
        switch (labId) {
            case 1:
                return new Lab01();
            case 2:
                return new Lab02();
            default:
                throw new IllegalArgumentException("Lab with number " + labId + " doesn't exist");
        }
    }
}
