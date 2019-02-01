package com.tuneit.edx.lti.rest.in;

import lombok.extern.slf4j.Slf4j;
import org.imsglobal.aspect.Lti;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@Profile("prod")
public class EdxSqlShellHandler implements SqlShellHandler {

    @Lti
    @Override
    @PostMapping("/api/rest/lti/shell/sql")
    public String handleInitShell() {

        return "shell";
    }

    @Override
    @PostMapping("/api/rest/lti/shell/sql/query")
    public String handleSqlQuery() {
        return null;
    }
}
