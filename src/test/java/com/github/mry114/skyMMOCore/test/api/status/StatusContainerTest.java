package com.github.mry114.skyMMOCore.test.api.status;

import com.github.mry114.skyMMOCore.api.status.type.CalculateType;
import com.github.mry114.skyMMOCore.api.status.container.StatusContainer;
import com.github.mry114.skyMMOCore.api.status.type.StatusModifierType;
import com.github.mry114.skyMMOCore.api.status.type.StatusStepType;
import com.github.mry114.skyMMOCore.dummy.status.DummyStatusA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatusContainerTest {
    @Test
    public void addAndGet_ShouldReturnAddedValue() {
        StatusContainer container = new StatusContainer();
        StatusStepType BASE = new StatusStepType("base");
        StatusModifierType DUMMY_STATUS = new StatusModifierType(new DummyStatusA(), BASE, CalculateType.ADDITION);

        container.add(DUMMY_STATUS, 10.0);

        assertEquals(10.0, container.get(DUMMY_STATUS));
    }

    @Test
    public void get_ShouldThrowException_WhenKeyIsNotRegistered() {
        StatusContainer container = new StatusContainer();
        StatusStepType BASE = new StatusStepType("base");
        StatusModifierType DUMMY_STATUS = new StatusModifierType(new DummyStatusA(), BASE, CalculateType.ADDITION);

        assertThrows(IllegalArgumentException.class, () -> container.get(DUMMY_STATUS));
    }
}
