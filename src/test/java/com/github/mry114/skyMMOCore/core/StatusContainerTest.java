package com.github.mry114.skyMMOCore.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusContainerTest {
    @Test
    void shouldMergeItemStatusIntoPlayerStatus() {
        MaxHealth status = new MaxHealth();
        StatusContainer container = new StatusContainer();

        container.add(status, RegionKeys.BASE, CalculationType.ADDITION, 100d);

        assertEquals(100, container.get(status, RegionKeys.BASE, CalculationType.ADDITION));
    }
}
