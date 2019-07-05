package ru.ifmo.courses.db.lab2.schema;

import com.tuneit.courses.db.template.Column;
import com.tuneit.courses.db.template.Reference;
import com.tuneit.courses.db.template.Table;
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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class contains data for second lab tasks.
 * Schema is used by {@link ru.ifmo.courses.db.lab2.Lab02}
 */
@Getter
@Setter
public class Schema02 extends IfmoSchema implements Cloneable {

    @XmlElementWrapper(name = "references")
    @XmlElement(name = "table")
    private List<TableReference> tablesReferences;

    @XmlElementWrapper(name = "substrings")
    @XmlElement(name = "table")
    private List<TableSubstring> tablesSubstrings;

    @XmlElementWrapper(name = "cases")
    @XmlElement(name = "table")
    private List<TableCases> tablesCases;

    @XmlElementWrapper(name = "subqueries")
    @XmlElement(name = "table")
    private List<TableSubquery> tablesSubqueries;

    @Override
    public Schema02 clone() {
        try {
            Schema02 schema02 = (Schema02) super.clone();
            schema02.tablesReferences = cloneList(tablesReferences);
            schema02.tablesSubstrings = cloneList(tablesSubstrings);
            schema02.tablesCases = cloneList(tablesCases);
            schema02.tablesSubqueries = cloneList(tablesSubqueries);
            return schema02;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Reference.ChainTable getRandomChainTable(Random random) {
        TableReference reference = getRandomElement(random, getTablesReferences());
        return getRandomChainTable(random, findTableBySqlName(reference.getSqlTableName()));
    }

    public Reference.ChainTable getRandomChainTable(Random random, Table table) {
        TableReference firstTableReference = findTableReferenceBySqlTableName(table.getTableName());

        Reference referenceToSecondTable = getRandomElement(random, firstTableReference.getReferences());
        Table rightTable = findTableBySqlName(referenceToSecondTable.getTableReference());

        Column leftColumn = table.findColumn(referenceToSecondTable.getNameColumnReference());
        Column rightColumn = rightTable.findColumn(referenceToSecondTable.getNameJoinColumnReference());

        return new Reference.ChainTable(table, leftColumn, rightTable, rightColumn);
    }

    public TableReference findTableReferenceBySqlTableName(String tableName) {
        return tablesReferences.stream().filter(table -> table.getSqlTableName().equalsIgnoreCase(tableName)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Table with name \"" + tableName + "\" not exist"));
    }

    /**
     * Loads schema from xml file
     * @param schemaName path to file in resources
     * @return schema with data the generation of 2 lab
     */
    @Override
    public Schema02 load(String schemaName) {
        Schema02 schema02 = loadSchema02(schemaName);
        IfmoSchema schema = super.load("lab.xml");
        schema02.update(schema);
        return schema02;
    }

    private Schema02 loadSchema02(String schemaName) {
        Schema02 schema02;
        try {
            JAXBContext jc = JAXBContext.newInstance(Schema02.class);
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(schemaName);
            if (inputStream == null)
                throw new JAXBException("Could not get XML schema in application resourses");
            Source source = new StreamSource(inputStream);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            schema02 = unmarshaller.unmarshal(source, Schema02.class).getValue();
        } catch (JAXBException ex) {
            Logger.getLogger(Schema02.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("Schema02 " + schemaName + " could not be loaded", ex);
        }
        return schema02;
    }
}
