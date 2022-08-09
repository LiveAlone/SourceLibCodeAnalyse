package org.yqj.source.demo.net.unsafe;

/**
 * @author yaoqijun on 2017-11-09.
 */
public class Animal {

    private String name;

    private Integer age;

    public static class Cat extends Animal{

        private String name;

        private Integer color;

        public Cat(String name, Integer age, String name1, Integer color) {
            super(name, age);
            this.name = name1;
            this.color = color;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public Integer getColor() {
            return color;
        }

        public void setColor(Integer color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", color=" + color +
                    '}' + super.toString();
        }
    }

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
