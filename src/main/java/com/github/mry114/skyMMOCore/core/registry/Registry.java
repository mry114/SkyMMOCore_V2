package com.github.mry114.skyMMOCore.core.registry;

import java.util.HashMap;
import java.util.Map;

public class Registry<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public void register(K key, V data) {
        if (map.containsKey(key)) {
            throw new IllegalArgumentException("Registry登録にID重複が発生しています. キー: " + key);
        }
        map.put(key, data);
    }

    public V get(K key) {
        return map.get(key);
    }
}
