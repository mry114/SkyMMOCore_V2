package com.github.mry114.skyMMOCore.core.registry;

import java.util.HashMap;
import java.util.Map;

public class MMORegistryContainer {
    private final Map<RegistryType<?>, Registry<?, ?>> registry = new HashMap<>();

    public <K, V> void set(RegistryType<V> type, Registry<K, V> data) {
        registry.put(type, data);
    }

    @SuppressWarnings("unchecked")
    public <K, V> Registry<K, V> get(RegistryType<V> type) {
        return (Registry<K, V>) registry.get(type);
    }
}
