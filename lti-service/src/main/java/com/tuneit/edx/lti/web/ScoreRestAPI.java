package com.tuneit.edx.lti.web;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ScoreRestAPI {

    @POST("{fullUrl}")
    Call<Void> post(
        @Path(value = "fullUrl", encoded = true) String outcomeServiceUrl,
        @Body                                    String body
    );

}
