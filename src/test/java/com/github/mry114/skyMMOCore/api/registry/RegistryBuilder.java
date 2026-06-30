package com.github.mry114.skyMMOCore.api.registry;

import java.util.ArrayList;
import java.util.List;

public class RegistryBuilder<T> {
    private final String pluginName;
    private final List<T> registryData = new ArrayList<>();

    public RegistryBuilder(String pluginName) {
        this.pluginName = pluginName;
    }

    public void registry(T data) {
        registryData.add(data);
    }

    public List<T> getAll() {
        return registryData;
    }

    public String getPluginName() {
        return pluginName;
    }
}
