package com.github.mry114.skyMMOCore.api.registry;

import jakarta.inject.Singleton;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class MMORegistryContainer {
    private final Map<RegistryType, Registry<?, ?>> registry = new HashMap<>();

    public <K, V> void set(@NotNull RegistryType type, @NotNull Registry<K, V> data) {
        registry.put(type, data);
    }

    @SuppressWarnings("unchecked")
    public <K, V> Registry<K, V> get(@NotNull RegistryType type) {
        return (Registry<K, V>) registry.get(type);
    }
}
