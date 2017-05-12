/*
 * Pagina.java
 * Contiene la definicion de una entrada de pagina en la tabla de paginas 
 * de los procesos
 */
package memsimu;

/**
 *
 * @author Ivan Arno y Ricardo Alustiza
 */
public class Pagina {
    int nMarco;
    boolean disponible; // disponible=1 para memoria principal, 0 para secundaria

    public boolean isDisponible() {
        return disponible;
    }

    public int getnMarco() {
        return nMarco;
    }
    
    public Pagina(int nMarco,boolean disponible)
    {
        this.nMarco=nMarco;
        this.disponible=disponible;
    }    
}
