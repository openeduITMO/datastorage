package com.tuneit.edx.lti.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Обертка для быстрого парсинга edx-user-info
 * в Java-объект
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "username",
        "version",
        "enrollmentStatusHash",
        "header_urls"
})
public class EdxUserInfo {

    @JsonProperty("username")
    private String username;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("enrollmentStatusHash")
    private String enrollmentStatusHash;

    @JsonProperty("header_urls")
    private HeaderUrls headerUrls;

}
