import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import estudos.Evento;

public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);

        List<Evento> list= new ArrayList<>();   //criação da lista

        String titulo;  //titulo do evento
        String d;       //string para a data-hora
        LocalDateTime data;     //data-hora
        DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  //formato de data-hora formatado

        for(int i=0;i<5;i++){
            System.out.printf("Adicionar %d evento:\n",i+1);
            System.out.print("Digite o título do evento: ");
            titulo=sc.nextLine();
            System.out.print("Digite a data e horário (dd/MM/yyyy HH:mm): ");
            d=sc.nextLine();

            data=LocalDateTime.parse(d,fmt); //instancia data-hora;
            list.add(new Evento(titulo,data));  //cria evento e adiciona na lista;
        }

        List<Evento> eventosFuturos= list.stream().filter(x-> x.calcDuration()>0).toList();
        List<Evento> eventosPassados= list.stream().filter(x-> x.calcDuration()<=0).toList();

        System.out.println("Listagem de eventos: ");
        for(Evento x: list){
            System.out.println(x);
        }

        System.out.println("Eventos futuros: ");
        if(!eventosFuturos.isEmpty()) {
            for (Evento x : eventosFuturos){
                System.out.println(x);
            }
        }
        System.out.println();
        System.out.println("Eventos passados: ");
        if(!eventosPassados.isEmpty()) {
            for (Evento x : eventosPassados){
                System.out.println(x);
            }
        }

        sc.close();
    }
}
