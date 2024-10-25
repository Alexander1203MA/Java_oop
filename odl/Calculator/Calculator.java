package Calculator;
import java.util.List;


/**
 * Реализация интерфейса для наших калькуляторов
 * @param <T>
 */

public interface Calculator<T>{
    Double sum(List<T> list);

    Double product(List<T> list);

    Double div(List<T> list);

    Long fromBinary(T num);
    
    String toBinary(T num);

    List<T> getNumbers();

    Object getNumber();

}