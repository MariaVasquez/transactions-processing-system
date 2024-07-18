package com.technicaltest.transaction.processing.system.controller.dto;

import com.technicaltest.transaction.processing.system.controller.dto.error.FieldModelError;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class GenericResponseDto<T> {
    private String responseCode;
    private int status;
    private String responseMessage;
    private T data;
    private List<FieldModelError> fieldModelErrors;


    public GenericResponseDto(ResponseCode responseCode, String responseMessage, List<FieldModelError> fieldModelErrors, T data) {
        this.status = responseCode.getStatus();
        this.responseCode = responseCode.toString();
        this.responseMessage = responseMessage;
        this.fieldModelErrors = fieldModelErrors;
        this.data = data;
    }


    public GenericResponseDto(ResponseCode responseCode, String responseMessage, List<FieldModelError> fieldModelErrors) {
        this(responseCode, responseMessage, fieldModelErrors, null);
    }

    public GenericResponseDto(ResponseCode responseCode, String responseMessage, T data) {
        this(responseCode, responseMessage, null, data);
    }
}