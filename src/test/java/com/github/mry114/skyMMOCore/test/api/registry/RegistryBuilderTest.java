package com.github.mry114.skyMMOCore.test.api.registry;

import com.github.mry114.skyMMOCore.api.registry.MMORegistryContainer;
import com.github.mry114.skyMMOCore.api.registry.Registry;
import com.github.mry114.skyMMOCore.api.registry.RegistryBuilder;
import com.github.mry114.skyMMOCore.api.registry.RegistryType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryBuilderTest {
    @Inject
    private MMORegistryContainer container;

    @Test
    public void registryFactoryTest1() {
        RegistryBuilder builder = new RegistryBuilder();

        Registry<Integer, String> REGISTRY_A = new Registry<>();
        REGISTRY_A.register(1, "A");
        builder.addRegister(REGISTRY_A);

        Registry<Integer, String> REGISTRY_B = new Registry<>();
        REGISTRY_B.register(1, "B");
        builder.addRegister(REGISTRY_B);

        container.set(builder.getType(), builder.build());

        assertEquals();
    }
}
