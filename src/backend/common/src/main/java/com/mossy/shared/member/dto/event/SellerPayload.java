package com.mossy.shared.member.dto.event;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record SellerPayload(
        Long sellerId,
        Long userId,
        String sellerType,
        String storeName,
        String businessNum,
        BigDecimal latitude,
        BigDecimal longitude,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

}
