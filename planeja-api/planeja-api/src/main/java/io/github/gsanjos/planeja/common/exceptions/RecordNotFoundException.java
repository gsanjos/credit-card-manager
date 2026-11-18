package io.github.gsanjos.planeja.common.exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException() {
        super("Registro não encontrado.");
    }

}
