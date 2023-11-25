package com.retail.grocery.promotion.promo;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;

public interface Promotion {
    PromotionResponse applyPromotion(PromotionRequest promotionRequest, PromotionInfo promotionInfo);
}