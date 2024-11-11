package Pizza;

import java.util.ArrayList;
import java.util.List;

enum Base{
    THIN(5),
    REGULAR(6),
    CHEESY(7);
    private final double price;
    
    Base(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
}

enum Size{
    SMALL(1),
    MEDIUM(1.5),
    LARGE(2);
    private final double multiplier;

    Size(double multiplier){
        this.multiplier = multiplier;
    }

    public double getMultiplier(){
        return multiplier;
    }
}

enum Topping{
    OLIVES(1),
    CHEESE(1.5),
    PEPPERONI(2);
    private final double price;

    Topping(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
}

abstract class Pizza {
    protected Base base;
    protected Size size;
    protected double baseCost;

    public Pizza(Base base, Size size){
        this.base = base;
        this.size = size;
        calculateCost();
    }

    private void calculateCost(){
        baseCost = base.getPrice()*size.getMultiplier();
    }

    public double getBaseCost(){
        return this.baseCost;
    }

    public abstract double getTotalCost();
}

public class SpecialPizza extends Pizza{
    private List<Topping> toppings;
    
    public SpecialPizza(Base base, Size size){
        super(base,size);
        toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    @Override
    public double getTotalCost() {
        return baseCost+toppings.stream().mapToDouble(Topping::getPrice).sum();
    }
}
