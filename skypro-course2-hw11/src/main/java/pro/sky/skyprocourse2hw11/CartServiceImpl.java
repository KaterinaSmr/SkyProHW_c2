package pro.sky.skyprocourse2hw11;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
    private Cart cart;

    public CartServiceImpl(){
        cart = new Cart();
    }

    @Override
    public void addToCart(Integer itemId){
        cart.addToCart(itemId);
    }
    @Override
    public void addToCart(int[] itemId){
        cart.addToCart(itemId);
    }
    @Override
    public List<Integer> getCart(){
        return cart.getItems();
    }
}
