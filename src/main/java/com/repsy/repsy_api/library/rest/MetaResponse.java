package com.repsy.repsy_api.library.rest;

import com.repsy.repsy_api.library.enums.MessageCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class MetaResponse {

    private String code;
    private String description;

    public MetaResponse() {
    }

    public MetaResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MetaResponse of(String code, String description) {
        return new MetaResponse(code, description);
    }

    public static MetaResponse success() {
        return new MetaResponse(MessageCodes.SUCCESS.getCode(), "Success");
    }

    public static MetaResponse fail(String description) {
        return new MetaResponse(MessageCodes.FAIL.getCode(), description);
    }


}
