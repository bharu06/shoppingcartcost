package offers;

import items.IItem;

import java.util.List;

public class OfferEvaluator {

    public double getFinalPrice(List<IItem> itemList) {

        List<IOffer> filters = OfferFactory.getFilterOffers();
        for (IOffer offer : filters) {
            itemList = offer.filterItems(itemList);
        }

        //Apply per item disconnt offers

        //Get final price
        double price = 0.0;
        for (IItem item : itemList) {
            price += item.getPrice();
        }

        //Apply final item discount if required

        return price;
    }
}
