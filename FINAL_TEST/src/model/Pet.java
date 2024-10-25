package model;

import java.util.List;

public interface Pet{
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    void addCommand(String newCom);
    String getColor();
    void setColor(String color);
    List<String> getCommandList();
}