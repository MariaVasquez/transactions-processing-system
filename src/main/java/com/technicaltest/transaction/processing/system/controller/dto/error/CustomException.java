package com.technicaltest.transaction.processing.system.controller.dto.error;

import com.technicaltest.transaction.processing.system.controller.dto.ResponseCode;
import lombok.Getter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CustomException extends RuntimeException {

    private final ResponseCode responseCode;
    private final List<FieldModelError> fieldModelErrors;

    public CustomException(ResponseCode responseCode, String... params) {
        super(MessageFormat.format(responseCode.getHtmlMessage(), (Object[]) params));
        this.responseCode = responseCode;
        this.fieldModelErrors = new ArrayList<>();
    }

    public void addFieldError(FieldModelError fieldModelError) {
        this.fieldModelErrors.add(fieldModelError);
    }
}
