package com.github.mry114.skyMMOCore.api.status.container;

import com.github.mry114.skyMMOCore.api.status.ItemStatus;
import com.github.mry114.skyMMOCore.dummy.type.ADummyItemStatusType;
import com.github.mry114.skyMMOCore.dummy.type.BDummyItemStatusType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStatusContainer {
    private final Map<ItemStatus<?>, Double> status;

    public ItemStatusContainer() {
        this.status = new HashMap<>();

        List<ItemStatus<?>> itemStatusList = List.of(
                ADummyItemStatusType.TEST_1,
                BDummyItemStatusType.TEST_2
        );

        for (ItemStatus<?> itemStatus : itemStatusList) {
            status.put(itemStatus, 0.0);
        }
    }

    public double get(ItemStatus<?> type) {
        return status.get(type);
    }

    public void add(ItemStatus<?> type, double value) {
        status.merge(type, value, Double::sum);
    }
}
