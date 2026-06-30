package com.github.mry114.skyMMOCore.test.api.registry;

import com.github.mry114.skyMMOCore.api.registry.RegistryHolder;
import com.github.mry114.skyMMOCore.api.status.Status;
import com.github.mry114.skyMMOCore.dummy.status.DummyStatusA;
import com.github.mry114.skyMMOCore.dummy.status.DummyStatusB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryBuilderTest {
    @Test
    public void registryBuilderTest1() {
        RegistryHolder<Status> builderA = new RegistryHolder<>("plugin_name_a");
        builderA.registry(new DummyStatusA());

        RegistryHolder<Status> builderB = new RegistryHolder<>("plugin_name_b");
        builderB.registry(new DummyStatusB());
    }
}
