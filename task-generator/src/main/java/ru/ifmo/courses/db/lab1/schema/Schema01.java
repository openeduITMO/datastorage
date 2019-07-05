package ru.ifmo.courses.db.lab1.schema;

import com.tuneit.courses.db.template.DiffDate;
import lombok.Getter;
import lombok.Setter;
import ru.ifmo.courses.db.schema.IfmoSchema;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains data for first lab tasks.
 * Schema is used by {@link ru.ifmo.courses.db.lab1.Lab01}
 */
@Getter
@Setter
public class Schema01 extends IfmoSchema implements Cloneable {

    @XmlElementWrapper(name = "dates")
    @XmlElement(name = "date")
    private List<DiffDate> diffDates;

    @Override
    public Schema01 clone() {
        try {
            Schema01 schema01 = (Schema01) super.clone();
            schema01.diffDates = cloneList(diffDates);
            return schema01;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Loads schema from xml file
     * @param schemaName path to file in resources
     * @return schema with data the generation of 1 lab
     */
    @Override
    public Schema01 load(String schemaName) {
        Schema01 schema01 = loadSchema01(schemaName);
        IfmoSchema schema = super.load("lab.xml");
        schema01.update(schema);
        return schema01;
    }

    private Schema01 loadSchema01(String schemaName) {
        Schema01 schema01;
        try {
            JAXBContext jc = JAXBContext.newInstance(Schema01.class);
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(schemaName);
            if (inputStream == null)
                throw new JAXBException("Could not get XML schema in application resourses");
            Source source = new StreamSource(inputStream);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            schema01 = unmarshaller.unmarshal(source, Schema01.class).getValue();
        } catch (JAXBException ex) {
            Logger.getLogger(Schema01.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("Schema01 " + schemaName + " could not be loaded", ex);
        }
        return schema01;
    }
}
