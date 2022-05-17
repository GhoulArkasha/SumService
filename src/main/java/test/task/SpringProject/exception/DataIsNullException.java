package test.task.SpringProject.exception;

import test.task.SpringProject.model.enums.Response;

public class DataIsNullException extends ServerException {
    public DataIsNullException() {
        super(Response.DATA_IS_NULL);
    }
}