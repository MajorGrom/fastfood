package com.park.test.fastfood.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message ){
        super(message);
    }
}
