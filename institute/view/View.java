package institute.view;

import institute.model.User;

public interface View<U extends User> {
    void print(U user);
}