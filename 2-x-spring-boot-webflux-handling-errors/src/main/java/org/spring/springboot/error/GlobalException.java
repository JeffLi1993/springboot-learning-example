package org.spring.springboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GlobalException extends ResponseStatusException {
    
    public GlobalException(HttpStatus status, String message) {
        super(status, message);
    }
    
    public GlobalException(HttpStatus status, String message, Throwable e) {
        super(status, message, e);
    }
}
