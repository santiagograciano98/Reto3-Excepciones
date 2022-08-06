package co.edu.udea.reto3;

public class AnioIngresoException extends Exception{
    
    public AnioIngresoException() {
        super("El año no puede ser mayor o menor al actual");
    }
    
}
