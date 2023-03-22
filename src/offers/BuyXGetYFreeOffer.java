package offers;

import items.IItem;

import java.util.ArrayList;
import java.util.*;

public class BuyXGetYFreeOffer implements IOffer {


    /*
    This map stores what X items we need to pay if overall items are Y.
    ie buy 1 get 1 can be presented as (2,1) ie if we buy 2 items we need to pay only for 1 (ie apples)
    buy 3 for price of 2 can be represented as (3,2)
     */
    Map<String, List<BuyXGetYNode>> itemDiscounts = new HashMap<>();
    BuyXGetYFreeOffer() {
        BuyXGetYNode appleDiscount = new BuyXGetYNode(2,1);
        itemDiscounts.put("apple", Arrays.asList(appleDiscount));
        BuyXGetYNode orangeDiscount = new BuyXGetYNode(3,2);
        itemDiscounts.put("orange", Arrays.asList(orangeDiscount));
    }
    @Override
    public List<IItem> filterItems(List<IItem> items) {
        List<IItem> newList = new ArrayList<>();
        Map<String, List<IItem>> itemCounts = new HashMap<>();
        for (IItem item : items) {
            itemCounts.putIfAbsent(item.getName(), new ArrayList<>());
            itemCounts.get(item.getName()).add(item);
        }
        for (String itemName : itemCounts.keySet()) {
            int finalCount = itemCounts.get(itemName).size();
            if (!itemDiscounts.containsKey(itemName)) {
                //No discount present
                System.out.println("No discount codes present for " + itemName);
                continue;
            }
            BuyXGetYNode discount = itemDiscounts.get(itemName).get(0);
            if (finalCount >= discount.overallItems) {
                //For 3,2, we charge for only 2 items.
                int rem = finalCount % discount.overallItems;
                int divisor = finalCount / discount.overallItems;
                int itemsChargable = (divisor * discount.chargeableItems) + rem;
                System.out.println("Item " + itemName + " chargeable items " + itemsChargable);
                newList.addAll(itemCounts.get(itemName).subList(0, itemsChargable));
            } else {
                newList.addAll(itemCounts.get(itemName));
            }
        }
        return newList;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    class BuyXGetYNode {
        int overallItems;
        int chargeableItems;

        public BuyXGetYNode(int overallItems, int chargeableItems) {
            this.overallItems = overallItems;
            this.chargeableItems = chargeableItems;
        }
    }
}
