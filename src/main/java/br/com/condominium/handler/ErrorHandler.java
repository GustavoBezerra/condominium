package br.com.condominium.handler;

import br.com.condominium.exception.ResourceNotFound;
import br.com.condominium.model.dto.ErrorDTO;
import br.com.condominium.model.dto.ErrorValidationDTO;
import com.google.common.collect.Lists;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorValidationDTO> handle(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return fieldErrors.stream().map(error -> new ErrorValidationDTO(error.getField(),
                messageSource.getMessage(error, LocaleContextHolder.getLocale()))).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFound.class)
    public List<ErrorDTO> handle(ResourceNotFound exception){
        return Lists.newArrayList(new ErrorDTO(HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getLocalizedMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<ErrorDTO> handle(ConstraintViolationException exception){
        return Lists.newArrayList(new ErrorDTO("Resource already exists.", "This RG already registered."));
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public List<ErrorDTO> handle(HttpRequestMethodNotSupportedException exception){
        return Lists.newArrayList(new ErrorDTO(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), exception.getLocalizedMessage()));
    }
}
