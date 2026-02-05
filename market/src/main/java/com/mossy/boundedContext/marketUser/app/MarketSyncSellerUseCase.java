package com.mossy.boundedContext.app.market;

import com.mossy.boundedContext.domain.market.MarketSeller;
import com.mossy.boundedContext.out.market.MarketSellerRepository;
import com.mossy.global.eventPublisher.EventPublisher;
import com.mossy.shared.market.event.MarketSellerCreatedEvent;
import com.mossy.shared.member.dto.event.SellerPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketSyncSellerUseCase {

    private final MarketSellerRepository marketSellerRepository;
    private final EventPublisher eventPublisher;

    public MarketSeller syncSeller(SellerPayload seller) {
        boolean isNew = !marketSellerRepository.existsById(seller.sellerId());

        MarketSeller marketSeller = marketSellerRepository.save(MarketSeller.from(seller));

        if (isNew) {
            eventPublisher.publish(new MarketSellerCreatedEvent(marketSeller.toDto()));
        }

        return marketSeller;
    }
}
