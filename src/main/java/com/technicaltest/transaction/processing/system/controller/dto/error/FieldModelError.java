package com.technicaltest.transaction.processing.system.controller.dto.error;

import java.io.Serializable;

public record FieldModelError(String field, String error) implements Serializable {
}
