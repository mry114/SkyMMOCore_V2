package com.github.mry114.skyMMOCore.test.registry;

import com.github.mry114.skyMMOCore.dummy.status.api.TestStatus;
import com.github.mry114.skyMMOCore.core.registry.Registry;
import com.github.mry114.skyMMOCore.dummy.status.TestTestStatus2;
import com.github.mry114.skyMMOCore.dummy.status.TestTestStatus1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistryTest {
    private static final TestStatus TEST_TEST_STATUS_1 = new TestTestStatus1();
    private static final TestStatus TEST_TEST_STATUS_2 = new TestTestStatus2();

    @Test
    public void registeredObjectCanBeRetrieved() {
        Registry<Class<? extends TestStatus>, TestStatus> STATUS = new Registry<>();

        STATUS.register(TEST_TEST_STATUS_1.getClass(), TEST_TEST_STATUS_1);

        TestStatus result = STATUS.get(TEST_TEST_STATUS_1.getClass());

        assertEquals(TEST_TEST_STATUS_1, result);
    }

    @Test
    public void duplicateRegistrationThrowsException() {
        Registry<Integer, TestStatus> STATUS = new Registry<>();

        STATUS.register(1 , TEST_TEST_STATUS_1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            STATUS.register(1, TEST_TEST_STATUS_2);
        });

        assertEquals("Registry登録にID重複が発生しています. キー: 1", exception.getMessage());
    }
}
