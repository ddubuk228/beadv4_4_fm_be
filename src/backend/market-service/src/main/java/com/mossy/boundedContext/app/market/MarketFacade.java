package com.mossy.boundedContext.app.market;

import com.mossy.boundedContext.domain.market.MarketSeller;
import com.mossy.boundedContext.domain.market.MarketUser;
import com.mossy.shared.member.dto.event.SellerPayload;
import com.mossy.shared.member.dto.event.UserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MarketFacade {
    private final MarketSyncUserUseCase marketSyncUserUseCase;
    private final MarketSyncSellerUseCase marketSyncSellerUseCase;

    @Transactional
    public MarketUser syncUser(UserPayload user) {
        return marketSyncUserUseCase.syncUser(user);
    }

    @Transactional
    public MarketSeller syncSeller(SellerPayload seller) {
        return marketSyncSellerUseCase.syncSeller(seller);
    }
}
