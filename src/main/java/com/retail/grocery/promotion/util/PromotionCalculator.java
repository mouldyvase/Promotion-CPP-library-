package com.retail.grocery.promotion.util;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;
import com.retail.grocery.promotion.promo.PercentageDiscountPromotion;
import com.retail.grocery.promotion.promo.Promotion;

public class PromotionCalculator {

    public PromotionResponse calculateDiscount(PromotionRequest promotionRequest, PromotionInfo promotionInfo)
    {

        Promotion promotion = new PercentageDiscountPromotion();
        return promotion.applyPromotion(promotionRequest, promotionInfo);

    }

}
