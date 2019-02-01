package com.tuneit.edx.lti.rest.in;

import com.tuneit.edx.lti.config.WebConfig;
import com.tuneit.edx.lti.to.EdxUserInfo;
import com.tuneit.edx.lti.to.TasksForm;
import com.tuneit.edx.lti.unit.ModelViewProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
@Profile("dev")
public class DevLtiHandler implements LtiHandler {

    @Autowired
    private ModelViewProcessor modelViewProcessor;

    @Override
    @GetMapping(MAIN_QUERY_URL)
    public String handleMainQuery(
            @RequestParam(name=LIS_LAB_ID_NAME, required = false) String labId,
            @RequestParam(name=LIS_SOURCED_ID_NAME, required = false) String sourcedId,
            @RequestParam(name=LIS_OUTCOME_URL_NAME, required = false) String serviceUrl,
            HttpServletRequest request,
            Map<String, Object> model) {

        // pre handling
        checkUser(request);

        return modelViewProcessor.renderMain (
                labId,
                sourcedId == null ? "DEBUG_ID" : sourcedId,
                serviceUrl == null ? "://SOUT/" : serviceUrl,
                request,
                model
        );
    }

    @Override
    @PostMapping(RESULT_QUERY_URL)
    public String handleResultsQuery(
            @RequestParam(name=LIS_LAB_ID_NAME, required = false) String labId,
            HttpServletRequest request,
            Map<String, Object> model,
            @ModelAttribute TasksForm queryForm
    ) {

        // pre handling
        checkUser(request);

        // redirect call to logical unit
        return modelViewProcessor.renderResult(labId, request, model, queryForm);
    }

    private void checkUser(HttpServletRequest request) {
        EdxUserInfo userInfo = (EdxUserInfo) request.getAttribute(WebConfig.ATTRIBUTE_USER_INFO);
        if(userInfo == null) {
            EdxUserInfo tmpUser = new EdxUserInfo();
            tmpUser.setUsername("ivanov.ivan");
            tmpUser.setVersion(1);
            tmpUser.setHeaderUrls(null);
            request.setAttribute(WebConfig.ATTRIBUTE_USER_INFO, tmpUser);
        }
    }
}
