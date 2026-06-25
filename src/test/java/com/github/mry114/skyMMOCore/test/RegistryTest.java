package com.github.mry114.skyMMOCore.test;

import com.github.mry114.skyMMOCore.api.status.Status;
import com.github.mry114.skyMMOCore.core.registry.Registry;
import com.github.mry114.skyMMOCore.core.status.AttackDamage;
import com.github.mry114.skyMMOCore.core.status.MaxHealth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistryTest {
    private static final Status MAX_HEALTH = new MaxHealth();
    private static final Status ATTACK_DAMAGE = new AttackDamage();

    @Test
    public void registeredObjectCanBeRetrieved() {
        Registry<Class<?>, Status> STATUS = new Registry<>();

        STATUS.register(MAX_HEALTH.getClass() , MAX_HEALTH);

        Status result = STATUS.get(MAX_HEALTH.getClass());

        assertEquals(MAX_HEALTH, result);
    }

    @Test
    public void duplicateRegistrationThrowsException() {
        Registry<Integer, Status> STATUS = new Registry<>();

        STATUS.register(1 , MAX_HEALTH);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            STATUS.register(1, ATTACK_DAMAGE);
        });

        // エラーメッセージの内容が正しいかも検証
        assertEquals("Registry登録にID重複が発生しています. キー: 1", exception.getMessage());
    }
}
