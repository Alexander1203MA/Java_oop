package service;

import model.Cat;
import model.Dog;
import model.Hamster;

import java.util.*;

public class DataPets <Pet>{
    List<Pet> listPets = new ArrayList<Pet>();
    public List<Pet> getAllPets (){
        return listPets;
    }

    public void addPet(Pet pet){
        listPets.add(pet);
    }
    public List<Pet> getDogs (){
        return listPets.stream().filter(x -> x instanceof Dog).toList();
    }
    public List<Pet> getHamsters (){
        return listPets.stream().filter(x -> x instanceof Hamster).toList();
    }
    public List<Pet> getCats(){
        return listPets.stream().filter(x -> x instanceof Cat).toList();
    }

    public Cat findCat(String name) {
        List<Cat> cats = (List<Cat>) this.getCats();
        Cat cat = null;
        for (Cat c : cats) {
            if (c.getName().equals(name)) {
                cat = c;
            }
        }
        return cat;
    }
    public Dog findDog(String name){
        List<Dog> dogs = (List<Dog>) this.getDogs();
        Dog dog = null;
        for (Dog d : dogs){
            if (d.getName().equals(name)){
                dog = d;
                break;
            }
        }
        return dog;
    }

    public Hamster findHamster(String name){
        List<Hamster> hamsters = (List<Hamster>) this.getHamsters();
        Hamster hamster = null;
        for (Hamster h : hamsters){
            if (h.getName().equals(name)){
                hamster=h;
                break;
            }
        }
        return hamster;
    }
}