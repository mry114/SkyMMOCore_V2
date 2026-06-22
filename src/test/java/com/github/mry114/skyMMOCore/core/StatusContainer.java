package com.github.mry114.skyMMOCore.core;

import java.util.HashMap;
import java.util.Map;

public class StatusContainer {
    private final Map<Status, Map<StatusRegionKey, Map<CalculationType, Double>>> container;

    public StatusContainer() {
        this.container = new HashMap<>().put(new MaxHealth, new HashMap<>().put(RegionKeys.BASE, new HashMap<>().put(CalculationType.ADDITION, 0)));
    }

    public void add(Status status, StatusRegionKey key, CalculationType type, double value) {
        container.get(status).get(key).merge(type, value, Double::sum);
    }

    public double get(Status status, StatusRegionKey key, CalculationType type) {
        return container.get(status).get(key).get(type);
    }
}
