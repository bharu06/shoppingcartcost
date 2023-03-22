import offers.OfferEvaluator;
import services.ItemService;

public class Main {
    public static void main(String[] args) {
        OfferEvaluator offerEvaluator = new OfferEvaluator();
        ItemService service = new ItemService();
        service.createItems();
        System.out.println(service.getItems());
        System.out.println(String.format("%.2f", offerEvaluator.getFinalPrice(service.getItems())));
    }
}