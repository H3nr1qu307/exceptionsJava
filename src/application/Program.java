package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservations;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Nunero do quarto: ");
            int quarto = sc.nextInt();
            System.out.print("Data de checkin: ");
            Date in = sdf.parse(sc.next());
            System.out.print("Data de checkout: ");
            Date out = sdf.parse(sc.next());

            Reservations reserva = new Reservations(quarto, in, out);
            System.out.println(reserva);

            System.out.println("");
            System.out.println("Entre com as datas para atualizar a reserva");

            System.out.print("Data de checkin: ");
            in = sdf.parse(sc.next());
            System.out.print("Data de checkout: ");
            out = sdf.parse(sc.next()); 

            reserva.updateDates(in, out);

            System.out.println(reserva);
        }
        catch(ParseException e) {
            System.out.println("Formato de data inválido.");
        }
        catch(DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch(RuntimeException e) {
            System.out.println("Erro inesperadado: ");
        }
        
        sc.close();
                
    }
}
