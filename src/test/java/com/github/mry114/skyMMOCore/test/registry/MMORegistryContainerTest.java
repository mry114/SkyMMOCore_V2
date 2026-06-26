package com.github.mry114.skyMMOCore.test.registry;

import com.github.mry114.skyMMOCore.core.registry.MMORegistryContainer;
import com.github.mry114.skyMMOCore.core.registry.RegistryType;
import com.github.mry114.skyMMOCore.core.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MMORegistryContainerTest {
    private static final RegistryType<String> TEST = new RegistryType<>("test");
    private static final Registry<Integer, String> registry = new Registry<>();

    @Test
    public void canStoreAndRetrieveRegistry() {
        MMORegistryContainer REGISTRY_CONTAINER = new MMORegistryContainer();

        REGISTRY_CONTAINER.set(TEST, registry);

        assertEquals(registry, REGISTRY_CONTAINER.get(TEST));
    }

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
