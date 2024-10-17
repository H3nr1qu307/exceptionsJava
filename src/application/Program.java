package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservations;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Nunero do quarto: ");
        int quarto = sc.nextInt();
        System.out.print("Data de checkin: ");
        Date in = sdf.parse(sc.next());
        System.out.print("Data de checkout: ");
        Date out = sdf.parse(sc.next());
        
        if(!out.after(in)) {
            System.out.println("Erro: a data de checkout nao pode ser anterior a data de checkin");
        }
        else {
            Reservations reserva = new Reservations(quarto, in, out);
            System.out.println(reserva);
            
            System.out.println("");
            System.out.println("Entre com as datas para atualizar a reserva");
            
            System.out.print("Data de checkin: ");
            in = sdf.parse(sc.next());
            System.out.print("Data de checkout: ");
            out = sdf.parse(sc.next()); 
           
            String error = reserva.updateDates(in, out);
            
            if(error != null) {
                System.out.println("Erro na reserva: " + error);
            } else {
                System.out.println(reserva);
            }
        }
        
        sc.close();
                
    }
}
