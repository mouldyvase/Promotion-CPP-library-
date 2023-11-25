package com.retail.grocery.promotion.promo;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;

public class NewCustomerPromotion implements Promotion{
    @Override
    public PromotionResponse applyPromotion(PromotionRequest promotionRequest, PromotionInfo promotionInfo) {
        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setTotalDiscount(promotionRequest.getTotalAmount()/2);
        promotionResponse.setActive(true);
        return promotionResponse;
    }
}
