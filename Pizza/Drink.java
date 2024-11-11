package Pizza;

import java.util.HashMap;
import java.util.Map;

enum DrinkType{
    WATER,
    SODA,
    JUICE;
}

enum DrinkSize{
    SMALL,
    MEDIUM,
    LARGE;
}

public class Drink implements OrderItem{
    private DrinkType type;
    private DrinkSize size;

    private static final Map<DrinkType, Map<DrinkSize, Double>> DRINK_PRICES = new HashMap<>();

    static {
        Map<DrinkSize, Double> waterPrices = new HashMap<>();
        waterPrices.put(DrinkSize.SMALL, 1.0);
        waterPrices.put(DrinkSize.MEDIUM, 1.0);
        waterPrices.put(DrinkSize.LARGE, 1.0);
        DRINK_PRICES.put(DrinkType.WATER, waterPrices);

        Map<DrinkSize, Double> sodaPrices = new HashMap<>();
        sodaPrices.put(DrinkSize.SMALL, 1.5);
        sodaPrices.put(DrinkSize.MEDIUM, 2.0);
        sodaPrices.put(DrinkSize.LARGE, 2.5);
        DRINK_PRICES.put(DrinkType.SODA, sodaPrices);

        Map<DrinkSize, Double> juicePrices = new HashMap<>();
        juicePrices.put(DrinkSize.SMALL, 2.0);
        juicePrices.put(DrinkSize.MEDIUM, 3.0);
        juicePrices.put(DrinkSize.LARGE, 4.0);
        DRINK_PRICES.put(DrinkType.JUICE, juicePrices);
    }

    public Drink(DrinkType type, DrinkSize size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public double getTotalCost() {
        return DRINK_PRICES.get(type).get(size);
    }
}
