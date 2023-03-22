package offers;

import items.IItem;

import java.util.List;

/*
Diff Offer Types
-> Buy x get y free
-> Per item 20% discount
-> By x+y get Z free
 */
public interface IOffer {

    List<IItem> filterItems(List<IItem> item);
    double getPrice();
}
