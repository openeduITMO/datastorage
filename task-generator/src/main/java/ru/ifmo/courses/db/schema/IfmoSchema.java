package ru.ifmo.courses.db.schema;

import com.tuneit.courses.db.generate.Schema;
import com.tuneit.courses.db.template.Aggregation;
import com.tuneit.courses.db.template.Condition;
import com.tuneit.courses.db.template.Table;
import lombok.Getter;
import lombok.Setter;
import ru.ifmo.courses.db.lab1.schema.Schema01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This base class contains data for lab tasks.
 */
@XmlRootElement(name = "schema")
@XmlSeeAlso({Schema01.class})
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IfmoSchema extends Schema {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlElementWrapper(name = "conditions")
    @XmlElement(name = "table")
    protected List<TableCondition> tableConditions;
    @XmlElementWrapper(name = "aggregations")
    @XmlElement(name = "aggregation")
    protected List<Aggregation> aggregations;
    @XmlElementWrapper(name = "tables")
    @XmlElement(name = "table")
    protected List<Table> tables;

    @Override
    protected IfmoSchema clone() throws CloneNotSupportedException {
        IfmoSchema schema = (IfmoSchema) super.clone();
        schema.name = name;
        schema.tables = cloneList(tables);
        schema.aggregations = cloneList(aggregations);
        schema.tableConditions = cloneList(tableConditions);
        return schema;
    }

    public Table findTableBySqlName(String string) {
        return tables.stream().filter(table -> table.getTableName().equalsIgnoreCase(string)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Table with name \"" + string + "\" not exist"));
    }

    public Condition findCondition(String conditionName) {
        for (TableCondition tableCondition : getTableConditions()) {
            for (Condition condition : tableCondition.getConditions()) {
                if (condition.getSqlColumnName().equals(conditionName)) {
                    return condition;
                }
            }
        }
        throw new IllegalArgumentException("Condition with name " + conditionName + " not found");
    }

    /**
     * Loads schema from xml file
     * @param schemaName path to file in resources
     * @return schema with data the generation lab tasks
     */
    public IfmoSchema load(String schemaName) {
        IfmoSchema schema;
        try {
            JAXBContext jc = JAXBContext.newInstance(IfmoSchema.class);
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(schemaName);
            if (inputStream == null)
                throw new JAXBException("Could not get XML schema in application resourses");
            Source source = new StreamSource(inputStream);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            schema = unmarshaller.unmarshal(source, IfmoSchema.class).getValue();
        } catch (JAXBException ex) {
            Logger.getLogger(Schema.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("Schema01 " + schemaName + " could not be loaded", ex);
        }
        return schema;
    }

    public void update(IfmoSchema schema) {
        name = schema.name;
        tables = schema.tables;
        tableConditions = schema.tableConditions;
        aggregations = schema.aggregations;
    }
}
