package pro.sky.skyprocourse2hw11;

import java.util.List;

public interface CartService {
    void addToCart(Integer itemId);

    void addToCart(int[] itemId);

    List<Integer> getCart();
}
