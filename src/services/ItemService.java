package services;

import items.IItem;
import items.Category;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemService {

    List<IItem> items = new ArrayList<>();

    public void createItems() {
        items.add(new Item("apple", Category.FRUITS_VEGETABLES, 0.6));
        items.add(new Item("apple", Category.FRUITS_VEGETABLES, 0.6));
        items.add(new Item("apple", Category.FRUITS_VEGETABLES, 0.6));
        items.add(new Item("apple", Category.FRUITS_VEGETABLES, 0.6));
        items.add(new Item("orange", Category.FRUITS_VEGETABLES, 0.25));
        items.add(new Item("orange", Category.FRUITS_VEGETABLES, 0.25));
        items.add(new Item("orange", Category.FRUITS_VEGETABLES, 0.25));
    }

    public List<IItem> getItems() {
        return items;
    }

}
