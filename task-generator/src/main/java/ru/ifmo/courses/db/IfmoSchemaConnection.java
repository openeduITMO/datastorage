package ru.ifmo.courses.db;

import com.tuneit.courses.db.checking.SchemaConnection;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;

/**
 * JAXB bean: ru.ru.ifmo.courses.db connection representation
 */
@Component
@XmlRootElement(name = "connection")
@XmlAccessorType(XmlAccessType.FIELD)
public class IfmoSchemaConnection extends SchemaConnection {
    @XmlElement(name = "uri")
    private String uri;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;

    /**
     * Loads data from xml for jdbc connection
     * @return jdbc connection info
     */
    @Override
    public DBInfo load() {
        IfmoSchemaConnection connection;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IfmoSchemaConnection.class);
            InputStream inputStream = IfmoSchemaConnection.class.getClassLoader().getResourceAsStream("connection.xml");
            if (inputStream == null)
                throw new JAXBException("Could not get XML schema in application resourses");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            connection = (IfmoSchemaConnection) unmarshaller.unmarshal(inputStream);
            return new DBInfo(connection.uri, connection.username, connection.password);
        } catch (JAXBException ex) {
            throw new IllegalArgumentException("SchemaConnection could not be loaded", ex);
        }
    }
}
