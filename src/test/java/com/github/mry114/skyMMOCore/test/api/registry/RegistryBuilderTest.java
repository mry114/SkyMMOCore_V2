package com.github.mry114.skyMMOCore.test.api.registry;

import com.github.mry114.skyMMOCore.api.registry.RegistryBuilder;
import com.github.mry114.skyMMOCore.api.status.Status;
import com.github.mry114.skyMMOCore.dummy.status.DummyStatusA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryBuilderTest {
    @Test
    public void register_ShouldStoreRegisteredClass() {
        RegistryBuilder<Class<? extends Status>> builder = new RegistryBuilder<>("plugin_name");
        builder.registry(DummyStatusA.class);

        assertEquals(DummyStatusA.class, builder.getAll().getFirst());
    }
}
