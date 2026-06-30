package com.github.mry114.skyMMOCore.test.api.registry;

import com.github.mry114.skyMMOCore.api.registry.RegistryHolder;
import com.github.mry114.skyMMOCore.api.status.Status;
import com.github.mry114.skyMMOCore.dummy.status.DummyStatusA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryHolderTest {
    @Test
    public void register_ShouldStoreRegisteredClass() {
        RegistryHolder<Class<? extends Status>> builder = new RegistryHolder<>("plugin_name");
        builder.registry(DummyStatusA.class);

        assertEquals(DummyStatusA.class, builder.getAll().getFirst());
    }
}
