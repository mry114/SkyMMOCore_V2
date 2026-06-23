package com.github.mry114.skyMMOCore.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusContainerTest {
    @Test
    void StatusContainerAddGetTest() {
        Status status = StatusRegistry.STATUS;
        StatusContainer container = new StatusContainer();

        container.add(status, RegionKeys.BASE, CalculationType.ADDITION, 100.0);

        assertEquals(100.0, container.get(status, RegionKeys.BASE, CalculationType.ADDITION));
    }


}
