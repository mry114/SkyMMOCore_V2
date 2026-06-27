package com.github.mry114.skyMMOCore.core.status;

import com.github.mry114.skyMMOCore.api.Status;

public record StatusModifierType(Status status, StatusStepType type, CalculateType calcType) {
}
