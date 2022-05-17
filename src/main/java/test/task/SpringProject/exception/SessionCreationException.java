package test.task.SpringProject.exception;

import test.task.SpringProject.model.enums.Response;

public class SessionCreationException extends ServerException {
    public SessionCreationException() {
        super(Response.SESSION_CREATION);
    }
}