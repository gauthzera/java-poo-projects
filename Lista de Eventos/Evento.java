package estudos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
   private String titulo;
   private LocalDateTime dataHora;
   private DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Evento(){}//construtor padrão para lista

    public Evento(String titulo, LocalDateTime dataHora){
       this.titulo=titulo;
       this.dataHora=dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public long calcDuration(){
        LocalDateTime hoje=LocalDateTime.now();
        long min= Duration.between(hoje,dataHora).toMinutes();
        return min;
    }
    //outra opção para verificar se o evento é passado ou não
    public boolean eEventoPassado(){
        return dataHora.isAfter(LocalDateTime.now());
    }
    public boolean eEventoFuturo(){
        return dataHora.isBefore(LocalDateTime.now());
    }

    public String toString(){
       return String.format("Título do evento: %s; Data: %s",titulo,dataHora.format(fmt));
    }
}