package ru.ifmo.courses.db.schema;


import com.tuneit.courses.db.generate.Clone;
import com.tuneit.courses.db.template.Condition;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

import static com.tuneit.courses.db.generate.Schema.cloneList;

@XmlAccessorType(XmlAccessType.FIELD)
public class TableCondition implements Cloneable, Clone<TableCondition> {
    @XmlElement(name = "condition")
    @Getter
    @Setter
    private List<Condition> conditions;

    @XmlAttribute(name = "sql")
    @Getter
    @Setter
    private String sqlTableName;

    @XmlAttribute(name = "native")
    @Getter
    @Setter
    private String nativeTableName;

    @Override
    public TableCondition clone() {
        try {
            TableCondition tableCondition = (TableCondition) super.clone();
            tableCondition.sqlTableName = sqlTableName;
            tableCondition.nativeTableName = nativeTableName;
            tableCondition.conditions = cloneList(conditions);
            return tableCondition;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
