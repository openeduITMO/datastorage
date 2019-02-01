package com.tuneit.edx.lti.rest.in;

import com.tuneit.edx.lti.to.TasksForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LtiHandler {

    String LIS_SOURCED_ID_NAME  = "lis_result_sourcedid";

    String LIS_OUTCOME_URL_NAME = "lis_outcome_service_url";

    String LIS_LAB_ID_NAME      = "custom_labId";

    String MAIN_QUERY_URL       = "/api/rest/lti/db";

    String RESULT_QUERY_URL     = "/api/rest/lti/db/result";

    String handleMainQuery(String labId, String sourcedId, String serviceUrl,
       HttpServletRequest request, Map<String, Object> model);

    String handleResultsQuery(String labId,
      HttpServletRequest request, Map<String, Object> model, TasksForm queryForm);

}
