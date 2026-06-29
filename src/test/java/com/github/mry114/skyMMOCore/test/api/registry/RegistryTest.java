package com.github.mry114.skyMMOCore.test.api.registry;

import com.github.mry114.skyMMOCore.api.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistryTest {
    private static final String data1 = "data1";
    private static final String data2 = "data2";

    @Test
    public void registeredObjectCanBeRetrieved() {
        Registry<Integer, String> STATUS = new Registry<>();

        STATUS.register(1, data1);

        String result = STATUS.get(1);

        assertEquals(data1, result);
    }

    @Test
    public void duplicateRegistrationThrowsException() {
        Registry<Integer, String> STATUS = new Registry<>();

        STATUS.register(1 , data1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> STATUS.register(1, data2));

        assertEquals("Registry登録にID重複が発生しています. キー: 1", exception.getMessage());
    }
}
