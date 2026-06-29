package com.github.mry114.skyMMOCore.api.registry;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Registry<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public void register(@NotNull K key, @NotNull V data) {
        if (map.containsKey(key)) {
            throw new IllegalArgumentException("Duplicate ID found during registry registration. Key: " + key);
        }
        map.put(key, data);
    }

    public V get(@NotNull K key) {
        return map.get(key);
    }
}
