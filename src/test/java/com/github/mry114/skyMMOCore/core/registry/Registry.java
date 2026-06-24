package com.github.mry114.skyMMOCore.core.registry;

import java.util.HashMap;
import java.util.Map;

public class Registry<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public Registry() {
    }
}
