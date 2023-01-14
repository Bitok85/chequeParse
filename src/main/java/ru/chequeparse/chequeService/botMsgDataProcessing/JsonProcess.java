package ru.chequeparse.chequeService.botMsgDataProcessing;

import org.json.JSONObject;
import ru.chequeparse.chequeService.model.Product;

import java.util.List;

/**
 * Интерфейс описывающий получение и обработку Json файлов c данными о покупке по переданной url на чек на сайте
 * фискального оператора
 */
public interface JsonProcess {

    /**
     *
     * @param url сылка на Json
     * @return Json с данными
     */
    JSONObject getJson(String url);

    /**
     *
     * @param jsonObject
     * @return список продуктов
     */
    List<Product> parseJson(JSONObject jsonObject);
}
