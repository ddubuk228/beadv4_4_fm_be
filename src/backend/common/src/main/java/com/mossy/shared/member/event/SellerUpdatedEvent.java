package com.mossy.shared.member.event;

import com.mossy.shared.member.dto.event.SellerPayload;

public record SellerUpdatedEvent(
        SellerPayload seller
) {

}
