package com.repsy.repsy_api.library.exception;


import com.repsy.repsy_api.library.enums.MessageCodes;
import com.repsy.repsy_api.library.rest.MetaResponse;
import com.repsy.repsy_api.library.rest.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends BaseExceptionHandler {

    private final MessageSource messageSource;

    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CoreException.class)
    public Response<MetaResponse> handleCoreException(CoreException coreException, Locale locale) {
        MessageCodes messageCode = coreException.getCode();
        String message = StringUtils.hasLength(coreException.getMessage())
                ? coreException.getMessage()
                : messageSource.getMessage(messageCode.getMessage(), coreException.getArgs(), locale);
        String sb = "[CoreException] messageCode: " + messageCode.getCode() +
                " , message: " +
                message;
        System.out.println(sb);
        return respond(MetaResponse.of(messageCode.getCode(), message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<MetaResponse> handleValidationErrors(MethodArgumentNotValidException ex, Locale locale) {
        String error = ex.getBindingResult().getFieldErrors()
                .stream().findFirst().map(FieldError::getDefaultMessage).orElse(MessageCodes.BAD_REQUEST.getMessage());
        String message = messageSource.getMessage(error, null, locale);
        String sb = "[MethodArgumentNotValidException] code: " + MessageCodes.BAD_REQUEST +
                " , message: " +
                message;
        System.out.println(sb);
        return respond(MetaResponse.of(MessageCodes.BAD_REQUEST.getCode(), message));
    }
}
