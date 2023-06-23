
package carlitos.tech;

import java.time.Period;

/**
 *
 * @author Licha
 */
public class Caja {
    private double valorInicial;
    private double valorFinal;
    private Period fechaApertura;
    private Period fechaCierre;

    public Caja(float valorInicial, float valorFinal, Period fechaApertura, Period fechaCierre) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public Period getFechaApertura() {
        return fechaApertura;
    }

    public Period getFechaCierre() {
        return fechaCierre;
    }
    
    public double abrirCaja(double valorInicial){
        return valorInicial;
    }
    
    public double cerrarCaja(double valorFinal){
        //se deberia pasar las ganacias del dia asi se suma al valor inicial y devuelve el cierre de caja
        return valorFinal;
    }
    //como implementar y si son necesarias los ultimos dos metodos
    
}
