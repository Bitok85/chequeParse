package ru.chequeparse.chequeService.botMsgDataProcessing;

import ru.chequeparse.chequeService.model.Buyer;

import java.util.Optional;

/**
 * Интерфейс описывающий обработку сообщений пользователя в TG.
 */
public interface MsgProcess {

    /**
     * @param name принимает имя пользователя из сообщения и передаёт его в API для добавления в БД.
     * @return если пользователь новый, то возвращает Optional нового пользователя, иначе Empty
     */
    Optional<Buyer> addBuyer(String name);

    /**
     * Приветствие нового пользователя
     */
    String greetNewBuyer();

}
