package org.rcslab.exception;

public class ServiceException extends IllegalStateException {
    public ServiceException(String msg) {
        super(msg);
    }
    public ServiceException(Exception e) {
        super(e.getMessage());
    }
}
