package ru.chequeparse;

import org.junit.jupiter.api.Test;
import ru.chequeparse.chequeService.jsonUtil.TakeJson;

import static org.assertj.core.api.Assertions.*;

public class UnitTests {

    @Test
    public void whenTakeUrlStringThenReturnUrlToJsonOFD() {
        String url
                = "https://consumer.1-ofd.ru/ticket?t=20220728T1603&s=3715.49&fn=9960440302514929&i=6386&fp=1100431538&n=1";
        String jsonUrl
                = "https://consumer.1-ofd.ru/api/tickets/ticket/t=20220728T1603&s=3715.49&fn=9960440302514929&i=6386&fp=1100431538&n=1";
        assertThat(TakeJson.urlToJsonUrl(url)).isEqualTo(jsonUrl);
    }

    @Test
    public void whenParseUrlThenTakeJsonString() {
        String url
                = "https://consumer.1-ofd.ru/ticket?t=20220728T1603&s=3715.49&fn=9960440302514929&i=6386&fp=1100431538&n=1";
        assertThat(TakeJson.takeJson(url))
                .startsWith("{\"ticket\":{\"requestPayload\":null,\"responsePayload\":null,\"acceptedAt\":\"2022-07-28T16:03:40.585+03:00\",\"insertedAt\":\"2022-07-28T16:03:40.585+03:00\"");
    }
}
