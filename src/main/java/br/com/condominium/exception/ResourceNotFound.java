package br.com.condominium.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String resource){
        super("The resource '"+resource+"' does not exist.");
    }
}
