package Exceptions.Control.Error;

public class DateFormatException extends RuntimeException{

    public DateFormatException(String date) {
        super(String.format("Неверный формат даты рождения \"%s\". Введите дату в формате YYYY.MM.DD", date));
    }
}