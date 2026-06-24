package com.github.mry114.skyMMOCore.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryTest {
    private static final Status MAX_HEALTH = new MaxHealth();

    @Test
    public void registeredObjectCanBeRetrieved() {
        Registry<Status> STATUS = new Registry<Status>(MAX_HEALTH);

        STATUS.register(MAX_HEALTH);

        Status result = STATUS.get(MAX_HEALTH);

        assertEquals(MAX_HEALTH, result);
    }
}
