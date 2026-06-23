package com.github.mry114.skyMMOCore.core;

import java.util.HashMap;
import java.util.Map;

public class StatusContainer {
    private final Map<Status, Map<StatusRegionKey, Map<CalculationType, Double>>> container;

    public StatusContainer() {
        Map<CalculationType, Double> type = new HashMap<>();
        type.put(CalculationType.ADDITION, 0.0);

        Map<StatusRegionKey, Map<CalculationType, Double>> key = new HashMap<>();
        key.put(RegionKeys.BASE, type);

        Map<Status, Map<StatusRegionKey, Map<CalculationType, Double>>> container = new HashMap<>();
        container.put(StatusRegistry.STATUS, key);
        this.container = container;
    }

    public void add(Status status, StatusRegionKey key, CalculationType type, double value) {
        container.get(status).get(key).merge(type, value, Double::sum);
    }

    public double get(Status status, StatusRegionKey key, CalculationType type) {
        return container.get(status).get(key).get(type);
    }
}
