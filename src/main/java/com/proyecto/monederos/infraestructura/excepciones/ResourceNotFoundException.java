package com.proyecto.monederos.infraestructura.excepciones;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(){
        super();
    }
    
    public ResourceNotFoundException(String message){
        super(message);
    }
}
