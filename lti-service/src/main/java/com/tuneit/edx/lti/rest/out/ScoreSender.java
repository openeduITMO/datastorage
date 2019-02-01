package com.tuneit.edx.lti.rest.out;

import java.io.IOException;

public interface ScoreSender {

    String SOURCED_ID_PATTERN = "####";

    String SCORE_PATTERN = "----";

    String XML_PATTERN =
          "    <?xml version = \"1.0\" encoding = \"UTF-8\"?>\n"
        + "    <imsx_POXEnvelopeRequest xmlns = \"some_link (may be not required)\">\n"
        + "      <imsx_POXHeader>\n"
        + "        <imsx_POXRequestHeaderInfo>\n"
        + "          <imsx_version>V1.0</imsx_version>\n"
        + "          <imsx_messageIdentifier>528243ba5241b</imsx_messageIdentifier>\n"
        + "        </imsx_POXRequestHeaderInfo>\n"
        + "      </imsx_POXHeader>\n"
        + "      <imsx_POXBody>\n"
        + "        <replaceResultRequest>\n"
        + "          <resultRecord>\n"
        + "            <sourcedGUID>\n"
        + "              <sourcedId>" + SOURCED_ID_PATTERN + "</sourcedId>\n"
        + "            </sourcedGUID>\n"
        + "            <result>\n"
        + "              <resultScore>\n"
        + "                <language>en-us</language>\n"
        + "                <textString>" + SCORE_PATTERN + "</textString>\n"
        + "              </resultScore>\n"
        + "            </result>\n"
        + "          </resultRecord>\n"
        + "        </replaceResultRequest>\n"
        + "      </imsx_POXBody>\n"
        + "    </imsx_POXEnvelopeRequest>";

    default String getXmlContent(String sourcedId, String score) {
        return XML_PATTERN
                .replace(SOURCED_ID_PATTERN, sourcedId)
                .replace(SCORE_PATTERN, score);
    }

    int push(String sourcedId, String outcomeServiceUrl, float rating) throws IOException;

}
