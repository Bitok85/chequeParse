package ru.chequeparse.chequeService.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Map;


/**
 * Модель в которую записывается результат обработки всех полученных чеков за сеанс одного пользователя.
 * Основным хранилищем является мапа продуктов со вложенными мапами по ключу - дате и значению - цене.
 * Модель предполагается записывать в PDF файл или напрямую выводить в ТГ пользователю.
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FinalData {
    @EqualsAndHashCode.Include
    private String user;
    private Map<String, Map<LocalDate, Float>> products;

}
