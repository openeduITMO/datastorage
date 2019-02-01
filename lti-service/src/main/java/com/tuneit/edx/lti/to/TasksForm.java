package com.tuneit.edx.lti.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TasksForm {

    private String textQuery;

    // temporary workaround
    private String textQuery2;
    private String textQuery3;
    private String textQuery4;
    private String textQuery5;

    public String[] asArray() {
        return new String[] {textQuery, textQuery2, textQuery3, textQuery4, textQuery5};
    }
}
