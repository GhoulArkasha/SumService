package test.task.SpringProject.exception;

import test.task.SpringProject.model.enums.Response;

public class RecordAlreadyExistsException extends ServerException {
    public RecordAlreadyExistsException() {
        super(Response.RECORD_ALREADY_EXISTS);
    }
}