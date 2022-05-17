package test.task.SpringProject.exception;

import test.task.SpringProject.model.enums.Response;

public class RecordNotFoundException extends ServerException {
    public RecordNotFoundException() {
        super(Response.RECORD_NOT_FOUND);
    }
}
