package Pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public double calculateTotal(){
        return items.stream().mapToDouble(OrderItem::getTotalCost).sum();
    }
}
