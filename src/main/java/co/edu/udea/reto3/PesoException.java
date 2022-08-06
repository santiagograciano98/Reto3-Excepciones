package co.edu.udea.reto3;

public class PesoException extends Exception{
    
    public PesoException(){
        super("El peso no puede ser menor que cero");
    }
    
}
