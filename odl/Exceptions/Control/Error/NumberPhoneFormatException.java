package Exceptions.Control.Error;

public class NumberPhoneFormatException extends RuntimeException{
    public NumberPhoneFormatException(String number) {
        super(String.format("Неверный формат номера телефона \"%s\". Введите номер телефона без пробелов и символов.", number));
    }
}