package co.edu.udea.reto3;

public class KilometrajeNegativoException extends Exception{
    
    public KilometrajeNegativoException(){
        super("El automovil no puede tener kilometraje negativo");
    }
    
}
