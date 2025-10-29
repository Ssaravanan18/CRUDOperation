package com.crudop.CRUDOperationexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CrudException extends RuntimeException
{

	public CrudException(String message) {
		super(message);
	}

}
