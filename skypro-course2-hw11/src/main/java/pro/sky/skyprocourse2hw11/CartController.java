package pro.sky.skyprocourse2hw11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public String index(){
        return "Hello world!";
    }

    @GetMapping("/add")
    public String addItem(@RequestParam(value = "id") int[] itemId){
        System.out.println("addItem is called");
        cartService.addToCart(itemId);
        return "Item added";
    }
    @GetMapping("/get")
    public List<Integer> getItem(){
        return cartService.getCart();
    }
}
