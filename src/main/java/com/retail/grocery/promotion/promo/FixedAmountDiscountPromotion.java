package com.retail.grocery.promotion.promo;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;

public class FixedAmountDiscountPromotion implements Promotion {
    @Override
    public PromotionResponse applyPromotion(PromotionRequest promotionRequest, PromotionInfo promotionInfo) {
        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setTotalDiscount(15);
        promotionResponse.setActive(true);
        return promotionResponse;

    }
}