package org.example;

public class Box<T> {
    private T item;


    public Box(T item) {
        this.item = item;
    }

    public T getItem(){
        return item;
    }

    public boolean inspect(Object obj){
        if(item == null || obj == null)
            return false;

        return item.getClass().equals(obj.getClass());
    }
}
