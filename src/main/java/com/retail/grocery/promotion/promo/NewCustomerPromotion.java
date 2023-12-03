Sure, here is the code with comments:

        ```java
        package com.retail.grocery.promotion.promo;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;

public class NewCustomerPromotion implements Promotion {

    /**
     * Applies the new customer promotion to the given cart value.
     *
     * @param promotionRequest the promotion request containing the cart value
     * @param promotionInfo the promotion information (not used in this implementation)
     * @return the promotion response containing the total discount amount, which is half the cart value
     */
    @Override
    public PromotionResponse applyPromotion(PromotionRequest promotionRequest, PromotionInfo promotionInfo) {
        PromotionResponse promotionResponse = new PromotionResponse();

        // Set the discount amount to half the cart value
        promotionResponse.setTotalDiscount(promotionRequest.getTotalAmount() / 2);

        // Set the promotion to active
        promotionResponse.setActive(true);

        return promotionResponse;
    }
}
```
