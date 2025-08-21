package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shipment<T>{
    private List<Box<T>> boxes = new ArrayList<>();

    public void addBox(Box<T> box){
        boxes.add(box);
    }

    public boolean inspectShipment(Object obj) {
        for (Box<T> box : boxes){
            if(box.inspect(obj)){
                return true;
            }
        }

        return false;
    }
}
