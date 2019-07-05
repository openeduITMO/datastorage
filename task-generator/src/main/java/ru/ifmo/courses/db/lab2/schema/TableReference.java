package ru.ifmo.courses.db.lab2.schema;

import com.tuneit.courses.db.generate.Clone;
import com.tuneit.courses.db.template.Reference;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

import static com.tuneit.courses.db.generate.Schema.cloneList;

@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class TableReference implements Cloneable, Clone<TableReference> {

    @XmlElement(name = "reference")
    private List<Reference> references;

    @XmlAttribute(name = "sql-name")
    private String sqlTableName;

    @Override
    public TableReference clone() {
        try {
            TableReference tableReference = (TableReference) super.clone();
            tableReference.sqlTableName = sqlTableName;
            tableReference.references = cloneList(references);
            return tableReference;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
