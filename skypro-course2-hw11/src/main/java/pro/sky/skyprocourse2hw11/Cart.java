package pro.sky.skyprocourse2hw11;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Cart {
    private List <Integer> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addToCart(Integer item){
        items.add(item);
    }

    public void addToCart(int[] item){
        for (int i = 0; i < item.length; i++) {
            items.add(item[i]);
        }
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
}
