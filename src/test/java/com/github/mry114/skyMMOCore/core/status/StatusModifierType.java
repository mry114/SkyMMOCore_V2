package com.github.mry114.skyMMOCore.core.status;

import com.github.mry114.skyMMOCore.api.status.Status;
import org.jetbrains.annotations.NotNull;

public record StatusModifierType(@NotNull Status status, @NotNull StatusStepType type, @NotNull CalculateType calcType) {
}
