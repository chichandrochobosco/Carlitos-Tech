package Core;

import java.time.LocalDateTime;
import java.time.Period;

public class Caja {
    private float valorInicial;
    private float valorFinal;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;

    public Caja(float valorInicial, float valorFinal, LocalDateTime fechaApertura, LocalDateTime fechaCierre) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }
    
    public float abrirCaja(float valorInicial){
        return valorInicial;
    }
    
    public float cerrarCaja(float valorFinal){
        //se deberia pasar las ganacias del dia asi se suma al valor inicial y devuelve el cierre de caja
        return valorFinal;
    }
    //como implementar y si son necesarias los ultimos dos metodos
    
}
