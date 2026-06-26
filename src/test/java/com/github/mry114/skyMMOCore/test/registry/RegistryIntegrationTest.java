package com.github.mry114.skyMMOCore.test.registry;

import com.github.mry114.skyMMOCore.core.registry.MMORegistryContainer;
import com.github.mry114.skyMMOCore.core.registry.RegistryType;
import com.github.mry114.skyMMOCore.core.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryIntegrationTest {
    private static final RegistryType<String> TEST = new RegistryType<>("test");

    @Test
    public void registryIntegrationTest() {
        MMORegistryContainer REGISTRY_CONTAINER = new MMORegistryContainer();
        Registry<Integer, String> registry = new Registry<>();
        String data = "data";

        registry.register(1, data);
        REGISTRY_CONTAINER.set(TEST, registry);

        assertEquals(REGISTRY_CONTAINER.get(TEST), registry);
    }
}
