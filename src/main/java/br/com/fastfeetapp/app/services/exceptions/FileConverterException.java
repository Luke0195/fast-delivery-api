package br.com.fastfeetapp.app.services.exceptions;

public class FileConverterException extends RuntimeException{

    public FileConverterException(){};

    public FileConverterException(String message){
        super(message);
    }
}
