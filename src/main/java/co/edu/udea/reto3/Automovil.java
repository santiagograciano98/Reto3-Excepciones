package co.edu.udea.reto3;

import static co.edu.udea.reto3.Vendedor.sdf;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Graciano
 */
public class Automovil {

    private String placa;
    private String marca;
    private String modelo;
    private double kilometraje;
    private String color;
    private double precio;
    private String descripcion;
    private Date fechaFabricacion;

    public Automovil() {
    }

    public Automovil(String placa, String marca, String modelo, double kilometraje, String color, double precio, String descripcion, Date fechaFabricacion) throws KilometrajeNegativoException{
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        if (kilometraje >= 0) {
            this.kilometraje = kilometraje;
        }else {
            throw new KilometrajeNegativoException();
        }
        this.color = color;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) throws KilometrajeNegativoException {
        
        if (kilometraje >= 0) {
            this.kilometraje = kilometraje;
        }else {
            throw new KilometrajeNegativoException();
        }
        
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String usoAutomovil() {
        String mensaje;

        if (this.kilometraje == 0) {
            mensaje = "El auto es 0km";
        } else if (this.kilometraje > 0 && this.kilometraje < 1000) {
            mensaje = "El aunto es nuevo";
        } else if (this.kilometraje > 1000 && this.kilometraje < 20000) {
            mensaje = "El auto es casi nuevo";
        } else if (this.kilometraje > 20000 && this.kilometraje < 100000) {
            mensaje = "el auto es usado";
        }else {
            mensaje = "El auto es muy usados";
        }

        return mensaje;
    }
    

    /**
     * Se calcula en total de años desde la fabricacion hasta la fecha actual para
     * darle una categoria al auto
     * - ultimo modelo: 0 años
     * - nuevo: entre 1-5:
     * - intermedio: entre 6-10
     * -viejo: mayor a 10
     * @return 
    */
    
    public String consultarEstado() {
        String mensaje = "";
        try {

            Date fechaActual = sdf.parse(sdf.format(new Date()));

            long d = Math.abs(fechaActual.getTime() - getFechaFabricacion().getTime());
            long g = TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);
            int years = (int) g / 365;

            if (years == 0) {
                mensaje = "El automovil se encuentra en la categoria último modelo";
            } else if (years > 0 && years <= 5) {
                mensaje = "El automovil se encuentra en la categoria nuevo";
            } else if (years > 5 && years <= 10) {
                mensaje = "El automovil se encuentra en la categoria intermedio";
            } else if (years > 10) {
                mensaje = "El automovil se encuentra en la categoria viejo";
            }

            return mensaje;
        } catch (ParseException ex) {
            Logger.getLogger(Automovil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
}
