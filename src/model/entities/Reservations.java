package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservations {
    private Integer numQuarto;
    private Date checkin;
    private Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservations() {}

    public Reservations(Integer numQuarto, Date checkin, Date checkout) {
        this.numQuarto = numQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duracao() {
        long dif = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }
    
    public String updateDates(Date checkin, Date checkout) {
        Date now = new Date();

         if(checkin.before(now) || checkout.before(now)) {
            return "as datas nao podem ser anteriores a data atual";
        }
        if(!checkout.after(checkin)) {
            return "a data de checkout nao pode ser anterior a data de checkin";
        }
        
        this.checkin = checkin;
        this.checkout = checkout;
        
        return null;
    }

    @Override
    public String toString() {
        return "Reserva: Quarto: " + numQuarto + ", checkin: " + sdf.format(checkin) + ", checkout: " + sdf.format(checkout) + ", " + duracao() + " noites.";
    }
    
}
