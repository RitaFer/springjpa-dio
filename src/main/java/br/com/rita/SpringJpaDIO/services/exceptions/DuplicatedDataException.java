package br.com.rita.SpringJpaDIO.services.exceptions;

import java.io.Serial;

public class DuplicatedDataException  extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicatedDataException(String message) {
        super(message);
    }
}
