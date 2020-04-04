package com.ht.algorithms;


import javax.swing.plaf.SliderUI;
import java.util.LinkedList;

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}
class Animal {
    private String name;
    private int order;
    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isLess(Animal other) {
        return this.order < other.order;
    }
}

public class Solution3_6 {

    private static class AnimalSeltor {
        private LinkedList<Dog> dogs = null;
        private LinkedList<Cat> cats = null;
        private int orderBatch = 0;

        public AnimalSeltor() {
            this.dogs = new LinkedList<>();
            this.cats = new LinkedList<>();
        }
        public void enqueue(Animal animal) {
            animal.setOrder(++this.orderBatch);

            if(animal instanceof Dog) {
                this.dogs.add((Dog)animal);
            } else {
                this.cats.add((Cat)animal);
            }
        }

        public Dog dequeueDog() {
            if(dogs.isEmpty()) {
                return null;
            }
            return this.dogs.poll();
        }

        public Cat dequeueCat() {
            if(this.cats.isEmpty()) {
                return null;
            }
            return this.cats.poll();
        }

        public Animal dequeueAny() {
            Dog dog = this.dogs.peek();
            Cat cat = this.cats.peek();
            if(dog.isLess(cat)) {
                return this.dogs.poll();
            } else {
                return this.cats.poll();
            }
        }
    }


    public static void main() {
        AnimalSeltor animalSeltors = new AnimalSeltor();
        animalSeltors.enqueue(new Dog("tommy1"));
        animalSeltors.enqueue(new Dog("tommy2"));
        animalSeltors.enqueue(new Cat("pussycat1"));
        animalSeltors.enqueue(new Dog("tommy3"));
        animalSeltors.enqueue(new Cat("pussycat2"));
        System.out.println(animalSeltors.dequeueCat().getName());
        System.out.println(animalSeltors.dequeueCat().getName());
//        System.out.println(animalSeltors.dequeueCat().getName());
    }
}
