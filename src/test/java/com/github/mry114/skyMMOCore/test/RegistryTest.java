package com.github.mry114.skyMMOCore.test;

import com.github.mry114.skyMMOCore.api.status.Status;
import com.github.mry114.skyMMOCore.core.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryTest {
    private static final Status MAX_HEALTH = new MaxHealth();

    @Test
    public void registeredObjectCanBeRetrieved() {
        Registry<Status> STATUS = new Registry<>();

        STATUS.register(MAX_HEALTH);

        Status result = STATUS.get(MAX_HEALTH);

        assertEquals(MAX_HEALTH, result);
    }
}
