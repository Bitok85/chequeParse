package ru.chequeparse.chequeService.jsonUtil;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;


/**
 * Утилитный класс для перевода ссылки присланной пользьвоателем на чек в строку со ссылкой на Json с данными чека
 * и последующим получением самого JSONObject по этой ссылке.
 */

public final class TakeJson {

    private final static Logger LOG = Logger.getLogger(TakeJson.class.getSimpleName());

    private TakeJson() {
    }

    /**
     * @param url ссылка на чек
     * @return ссылка на Json
     */
    public static String urlToJsonUrl (String url) {
        return url.replace("ticket?", "api/tickets/ticket/");
    }

    /**
     * @param url ссылка на Json
     * @return Json в строковом представлении
     */
    public static String takeJson(String url)  {
        try(InputStream is = new URL(urlToJsonUrl(url)).openStream()) {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            LOG.error("Take json error", e);
        }
        return null;
    }
}
