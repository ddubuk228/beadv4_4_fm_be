package com.mossy.shared.member.event;

import com.mossy.shared.member.dto.event.UserPayload;

public record UserUpdatedEvent(
        UserPayload user
) { }
