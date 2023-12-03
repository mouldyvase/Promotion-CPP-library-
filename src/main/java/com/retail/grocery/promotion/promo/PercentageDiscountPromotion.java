package com.retail.grocery.promotion.promo;

import com.retail.grocery.promotion.dto.PromotionInfo;
import com.retail.grocery.promotion.dto.PromotionRequest;
import com.retail.grocery.promotion.dto.PromotionResponse;

public class PercentageDiscountPromotion implements Promotion {

    private PromotionInfo promotionInfo;

    /**
     * Applies the percentage discount promotion to the given cart value.
     *
     * @param promotionRequest the promotion request containing the cart value
     * @param promotionInfo the promotion information containing the discount percentage and maximum discount
     * @return the promotion response containing the total discount amount
     */
    @Override
    public PromotionResponse applyPromotion(PromotionRequest promotionRequest, PromotionInfo promotionInfo) {
        PromotionResponse promotionResponse = new PromotionResponse();

        // Check if the promotion is active and applicable to the cart value
        if (promotionInfo == null || !promotionInfo.isActive() || promotionInfo.getMinValue() > promotionRequest.getTotalAmount()) {
            promotionResponse.setActive(false);
            promotionResponse.setTotalDiscount(0);
            return promotionResponse;
        }

        // Calculate the discount amount
        double discount = calculateDiscount(promotionRequest.getTotalAmount(), promotionInfo);

        promotionResponse.setActive(true);
        promotionResponse.setTotalDiscount(discount);
        return promotionResponse;
    }

    /**
     * Calculates the discount amount based on the cart value and promotion information.
     *
     * @param cartValue the cart value
     * @param promotionInfo the promotion information containing the discount percentage and maximum discount
     * @return the calculated discount amount
     */
    private double calculateDiscount(double cartValue, PromotionInfo promotionInfo) {
        double discount = cartValue * promotionInfo.getDiscountPercentage() * .001;

        // Limit the discount to the maximum discount amount
        discount = calculateDiscount(discount, promotionInfo.getMaxDiscount());

        return discount;
    }

    /**
     * Enforces the maximum discount limit.
     *
     * @param calculatedDiscount the calculated discount amount
     * @param maxDiscount the maximum discount amount
     * @return the final discount amount, which is the minimum of the calculated discount and the maximum discount
     */
    private double calculateDiscount(double calculatedDiscount, double maxDiscount) {
        return Math.min(calculatedDiscount, maxDiscount);
    }
}
