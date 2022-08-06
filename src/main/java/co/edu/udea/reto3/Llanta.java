package co.edu.udea.reto3;

/**
 *
 * @author Santiago Graciano
 */
public class Llanta {
    private String marca;
    private String referencia;
    private double peso;

    public Llanta() {
    }

    public Llanta(String marca, String referencia, double peso) throws  PesoException {
        this.marca = marca;
        this.referencia = referencia;
        if (peso >= 0) {
            this.peso = peso;
        }else {
            throw new PesoException();
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws  PesoException{
        if (peso >= 0) {
            this.peso = peso;
        }else {
            throw new PesoException();
        }
    }
    
}
