package ru.chequeparse.chequeService.botMsgDataProcessing;


import ru.chequeparse.chequeService.model.ChequeUrl;

import java.util.Optional;

/**
 * Интерфейс для обработки переданных пользователем URL чеков
 */
public interface UrlProcess {

    /**
     * @param url метод проверки, что пользователь передал именно URL на чек на сайте фискального оператора
     */
    boolean urlValidation(String url);

    /**
     Проверка переданной ссылки. Если в БД у пользователя таковая уже существует, вернётся пустой Optional
     */
    Optional<ChequeUrl> addUrl(String url);
}
