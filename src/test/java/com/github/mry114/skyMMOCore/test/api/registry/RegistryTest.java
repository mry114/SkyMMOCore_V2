package com.github.mry114.skyMMOCore.test.api.registry;

import com.github.mry114.skyMMOCore.api.registry.Registry;
import com.github.mry114.skyMMOCore.api.registry.RegistryType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistryTest {
    private static final String data1 = "data1";
    private static final String data2 = "data2";

    @Test
    public void registeredObjectCanBeRetrieved() {
        Registry<Integer, String> DATA = new Registry<>(new RegistryType("string"));

        DATA.register(1, data1);

        String result = DATA.get(1);

        assertEquals(data1, result);
    }

    @Test
    public void duplicateRegistrationThrowsException() {
        Registry<Integer, String> DATA = new Registry<>(new RegistryType("string"));

        DATA.register(1 , data1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> DATA.register(1, data2));

        assertEquals("Duplicate ID found during registry registration. Key: 1", exception.getMessage());
    }
}
