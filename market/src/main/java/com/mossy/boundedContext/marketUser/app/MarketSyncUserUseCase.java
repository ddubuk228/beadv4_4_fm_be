package com.mossy.boundedContext.marketUser.app;

import com.mossy.boundedContext.marketUser.domain.MarketUser;
import com.mossy.boundedContext.marketUser.out.MarketUserRepository;
import com.mossy.global.eventPublisher.EventPublisher;
import com.mossy.shared.market.event.MarketUserCreatedEvent;
import com.mossy.shared.member.dto.event.UserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketSyncUserUseCase {
    private final MarketUserRepository marketUserRepository;
    private final EventPublisher eventPublisher;

    public MarketUser syncUser(UserPayload user) {
        boolean isNew = !marketUserRepository.existsById(user.id());

        MarketUser marketUser = marketUserRepository.save(MarketUser.from(user));

        if (isNew) {
            eventPublisher.publish(new MarketUserCreatedEvent(marketUser.toDto()));
        }

        return marketUser;
    }
}
