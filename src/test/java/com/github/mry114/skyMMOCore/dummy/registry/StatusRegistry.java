package com.github.mry114.skyMMOCore.dummy.registry;

import com.github.mry114.skyMMOCore.api.registry.MMORegistryContainer;
import com.github.mry114.skyMMOCore.api.registry.Registry;
import com.github.mry114.skyMMOCore.api.registry.RegistryType;
import com.github.mry114.skyMMOCore.api.status.Status;
import com.github.mry114.skyMMOCore.dummy.status.DummyStatusA;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class StatusRegistry {
    public static final RegistryType<Status> STATUS = new RegistryType<>("status");
    public static final Registry<Class<? extends Status>, Status> REGISTRY = new Registry<>();

    @Inject
    public StatusRegistry(MMORegistryContainer registryContainer) {
        registryContainer.set(STATUS, REGISTRY);
    }

    static {
        REGISTRY.register(DummyStatusA.class, new DummyStatusA());
    }
}
