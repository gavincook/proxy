package org.antstudio;

/**
 * @author Gavin
 * @date 14-7-27 下午2:09
 */
public class Person implements Animal{

    private String name;

    public Person(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(name+" Eating...");
    }

    public void sleep(){
        System.out.println(name+" Sleeping...");
    }
}
