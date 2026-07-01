package com.github.mry114.skyMMOCore.test.api.status;

import com.github.mry114.skyMMOCore.api.status.ItemStatus;
import com.github.mry114.skyMMOCore.api.status.container.ItemStatusContainer;
import com.github.mry114.skyMMOCore.dummy.type.ADummyItemStatusType;
import com.github.mry114.skyMMOCore.dummy.type.BDummyItemStatusType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemStatusTest {
    private static final List<ItemStatus<?>> ITEM_STATUSES = List.of(
            ADummyItemStatusType.TEST_1,
            BDummyItemStatusType.TEST_2
    );

    @Test
    public void get_ShouldReturnZero_WhenStatusDoesNotExist() {
        ItemStatusContainer container = new ItemStatusContainer(List.of(ADummyItemStatusType.TEST_1));

        assertEquals(0.0, container.get(ADummyItemStatusType.TEST_1));
    }

    @Test
    public void add_ShouldStoreMultipleStatusIndependently() {
        ItemStatusContainer container = new ItemStatusContainer(ITEM_STATUSES);

        container.add(ADummyItemStatusType.TEST_1, 1.0);
        container.add(BDummyItemStatusType.TEST_2, 2.0);

        assertEquals(1.0, container.get(ADummyItemStatusType.TEST_1));
        assertEquals(2.0, container.get(BDummyItemStatusType.TEST_2));
    }
}
