package by.nikita.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Backet {
    private Map<Integer, Integer> backet = new HashMap<Integer, Integer>();

    public void setBacket(Integer idProduct, Integer qantityByProduct) {
        backet.put(idProduct, qantityByProduct);
    }

    public Map<Integer, Integer> getBacket() {
        return backet;
    }
    public  void clear(){
        backet.clear();
    }
    public void remove(Integer idProduct ){
        backet.remove(idProduct);
    }
}
