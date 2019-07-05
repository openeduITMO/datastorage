package ru.ifmo.courses.db.lab2.schema;

import com.tuneit.courses.db.generate.Clone;
import com.tuneit.courses.db.template.Substring;
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
public class TableSubstring implements Cloneable, Clone<TableSubstring> {

    @XmlElement(name = "substring")
    private List<Substring> substring;

    @XmlAttribute(name = "sql")
    private String sqlTableName;

    @Override
    public TableSubstring clone() {
        try {
            TableSubstring tableSubstring = (TableSubstring) super.clone();
            tableSubstring.sqlTableName = sqlTableName;
            tableSubstring.substring = cloneList(substring);
            return tableSubstring;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
