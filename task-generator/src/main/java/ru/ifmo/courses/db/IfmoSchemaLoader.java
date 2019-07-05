package ru.ifmo.courses.db;

import com.tuneit.courses.db.generate.SchemaLoader;
import org.springframework.stereotype.Component;
import ru.ifmo.courses.db.lab1.schema.Schema01;
import ru.ifmo.courses.db.lab2.schema.Schema02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Schema loader
 */
@Component
public class IfmoSchemaLoader extends SchemaLoader {
    /**
     * load postgresql driver
     */
    @Override
    protected void loadDBDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(SchemaLoader.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * load data for task generation
     */
    @Override
    protected void loadSchemas() {
        schemas.put(1, new Schema01().load("lab1.xml"));
        schemas.put(2, new Schema02().load("lab2.xml"));
    }
}
