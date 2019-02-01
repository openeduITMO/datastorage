package com.tuneit.edx.lti.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "resume_block",
        "logout"
})
public class HeaderUrls {

    @JsonProperty("resume_block")
    private String resumeBlock;

    @JsonProperty("logout")
    private String logout;

    /**
     * No args constructor for use in serialization
     *
     */
    public HeaderUrls() { }

    /**
     *
     * @param logout
     * @param resumeBlock
     */
    public HeaderUrls(String resumeBlock, String logout) {
        super();
        this.resumeBlock = resumeBlock;
        this.logout = logout;
    }
}