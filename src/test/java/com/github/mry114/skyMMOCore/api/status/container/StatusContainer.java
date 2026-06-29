package com.github.mry114.skyMMOCore.api.status.container;

import com.github.mry114.skyMMOCore.api.status.type.StatusModifierType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StatusContainer {
    private final Map<StatusModifierType, Double> modifier = new HashMap<>();

    public StatusContainer() {}

    public void add(@NotNull StatusModifierType type, double value) {
        modifier.merge(type, value, Double::sum);
    }

    public double get(@NotNull StatusModifierType type) {
        if (!modifier.containsKey(type)) {
            throw new IllegalArgumentException("Key is not registered: " + type);
        }
        return modifier.get(type);
    }
}
