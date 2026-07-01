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
        RegistryType TYPE_1 = new RegistryType("type_1");
        RegistryType TYPE_2 = new RegistryType("type_2");

        Registry<Integer, String> REGISTRY_A = new Registry<>(TYPE_1);
        REGISTRY_A.register(1, "A");
        builder.addRegister(REGISTRY_A);

        Registry<Integer, String> REGISTRY_B = new Registry<>(TYPE_2);
        REGISTRY_B.register(2, "B");
        builder.addRegister(REGISTRY_B);

        //container.set(builder.getType(), builder.build());

        assertEquals("A", container.get(TYPE_1).get(1));
        assertEquals("B", container.get(TYPE_2).get(2));
    }
}
