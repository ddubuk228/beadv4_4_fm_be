package com.mossy.boundedContext.cart.in.dto.response;

import com.mossy.boundedContext.product.in.dto.response.ProductInfoResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record CartResponse(
        Long cartId,
        String buyerName,
        String buyerAddress,
        int itemCount,
        List<ProductInfoResponse> items
) {
}