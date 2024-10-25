package model;

import java.util.List;
import java.util.Objects;

public abstract class Pets  implements Pet{
    private String name;
    private int age;
    private String color;
    private List<String> commands;

    public Pets(String name, int age, String color, List<String> commands) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.commands = commands;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age=age;
    }

    @Override
    public void addCommand(String newCom) {
        commands.add(newCom);
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public List<String> getCommandList() {
        return commands;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return age == pets.age && Objects.equals(name, pets.name) && Objects.equals(color, pets.color) && Objects.equals(commands, pets.commands);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", commands=" + commands +
                '}';
    }
}