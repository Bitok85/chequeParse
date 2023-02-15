package ru.chequeparse.chequeService.jsonUtil;

import org.apache.commons.lang3.StringUtils;
import ru.chequeparse.chequeService.model.FinalData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Утилитный класс, методы которого нужны для преобразования строкового выражения чека в FinalData модель
 */
public final class ChequeStringParse {

    private ChequeStringParse() {}

    public static FinalData chequeParse (List<String> chequeUrls) {
        if (chequeUrls.size() < 1) {
            throw new IllegalArgumentException("cheques list is empty");
        }
        List<String> data = chequeUrls.stream()
                .map(string -> TakeJson.takeJson(string))
                .toList();
        return null;
    }

    /**
     *
     * @param cheque
     * @return возвращает LocalDateTime объект из чека. Метод в дальнейшем требует переработки.
     */
    private String takeDateFromCheque(String cheque) {
        String str = TakeJson.takeJson(cheque);
        String dateStr = StringUtils.substringBetween(str, "acceptedAt", "insertedAt");
        dateStr = dateStr.substring(3, str.length() - 9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, hh:mm");
        return LocalDateTime.parse(dateStr).format(formatter);
    }

    /**
     *
     * @param str
     * @return возвращает название продукта, которое предполагается первым словом в строке
     */
    private String productName(String str) {
        return str.split("")[0];
    }

    private float productPrice(String str) {
        String priceStr = StringUtils.substringBetween(str, "sum", "price");
        return 0;
    }

    public static void main(String[] args) {
        String data
                = TakeJson.takeJson("https://consumer.1-ofd.ru/ticket?t=20220728T1603&s=3715.49&fn=9960440302514929&i=6386&fp=1100431538&n=1");
        String price = StringUtils.substringBetween(data.split("name:")[0], "sum", "price");
        price = price.substring(3, price.length() - 3);
        float pr = Float.parseFloat(price);
        System.out.println(pr/100);

    }

}
