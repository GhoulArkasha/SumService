package test.task.SpringProject.exception;

import test.task.SpringProject.model.enums.Response;

public class SessionCloseException extends ServerException {
    public SessionCloseException() {
        super(Response.SESSION_CLOSE);
    }
}
