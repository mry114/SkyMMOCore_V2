package com.github.mry114.skyMMOCore.api.status.container;

import com.github.mry114.skyMMOCore.api.status.ItemStatus;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStatusContainer {
    private final Map<ItemStatus<?>, Double> status;

    public ItemStatusContainer(List<@NotNull ItemStatus<?>> itemStatusList) {
        this.status = new HashMap<>();

        for (ItemStatus<?> itemStatus : itemStatusList) {
            status.put(itemStatus, 0.0);
        }
    }

    public double get(@NotNull ItemStatus<?> type) {
        return status.get(type);
    }

    public void add(@NotNull ItemStatus<?> type, double value) {
        status.merge(type, value, Double::sum);
    }
}
