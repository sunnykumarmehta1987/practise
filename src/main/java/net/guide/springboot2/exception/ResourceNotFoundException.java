package net.guide.springboot2.exception;

public class ResourceNotFoundException extends Exception {


    public ResourceNotFoundException(String message){
        super(message);
    }


}
