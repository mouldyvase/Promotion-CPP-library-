package com.retail.grocery.promotion.promo;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;

public class PercentageDiscountPromotion implements Promotion {
    private PromotionInfo promotionInfo;


    @Override
    public PromotionResponse applyPromotion(PromotionRequest promotionRequest , PromotionInfo promotionInfo)
    {
        PromotionResponse promotionResponse = new PromotionResponse();
        if(promotionInfo == null || !promotionInfo.isActive() || promotionInfo.getMinValue() > promotionRequest.getTotalAmount())
        {
            promotionResponse.setActive(false);
            promotionResponse.setTotalDiscount(0);
            return promotionResponse;
        }

        double discount = calculateDiscount(promotionRequest.getTotalAmount(), promotionInfo);
        promotionResponse.setActive(true);
        promotionResponse.setTotalDiscount(discount);
        return promotionResponse;

    }


    private double calculateDiscount(double cartValue, PromotionInfo promotionInfo)
    {
        double discount = cartValue * promotionInfo.getDiscountPercentage()*.001;
        discount = calculateDiscount(discount, promotionInfo.getMaxDiscount());
        return discount;
    }

    private double calculateDiscount(double calculatedDiscount, double maxDiscount)
    {
        return Math.min(calculatedDiscount, maxDiscount);
    }
}