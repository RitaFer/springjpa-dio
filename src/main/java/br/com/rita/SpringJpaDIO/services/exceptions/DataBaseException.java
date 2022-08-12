package br.com.rita.SpringJpaDIO.services.exceptions;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String message) {
        super(message);
    }
}
