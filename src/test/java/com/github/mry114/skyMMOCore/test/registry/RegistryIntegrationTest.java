package com.github.mry114.skyMMOCore.test.registry;

import com.github.mry114.skyMMOCore.core.registry.MMORegistryContainer;
import com.github.mry114.skyMMOCore.core.registry.RegistryType;
import com.github.mry114.skyMMOCore.core.registry.Registry;
import com.github.mry114.skyMMOCore.dummy.status.TestTestStatus1;
import com.github.mry114.skyMMOCore.dummy.status.api.TestStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistryIntegrationTest {
    private static final RegistryType<TestStatus> TEST = new RegistryType<>("test");

    @Test
    public void registryIntegrationTest() {
        MMORegistryContainer REGISTRY_CONTAINER = new MMORegistryContainer();
        Registry<Class<? extends TestStatus>, TestStatus> STATUS = new Registry<>();
        TestStatus TEST_TEST_STATUS_1 = new TestTestStatus1();

        STATUS.register(TEST_TEST_STATUS_1.getClass(), TEST_TEST_STATUS_1);
        REGISTRY_CONTAINER.set(TEST, STATUS);

        assertEquals(REGISTRY_CONTAINER.get(TEST), STATUS);
    }
}
