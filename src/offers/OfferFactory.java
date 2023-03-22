package offers;

import java.util.Arrays;
import java.util.List;

public class OfferFactory {

    public static List<IOffer> getFilterOffers() {
        return Arrays.asList(new BuyXGetYFreeOffer());
    }
}
