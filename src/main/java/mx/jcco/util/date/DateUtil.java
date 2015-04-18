package mx.jcco.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Esta clase  ajusta las propiedades de las fechas
 * @author Carlos Cortés
 */
public class DateUtil{
	
    /**
     * Ajusta los segundos, minutos y horas a 0
     * @param since - la fecha que sera ajustada
     * @return Date - la fecha ajustada
     */
    public static Date prepareSinceDate(final Date since){
	final Date date;
	if(since == null){
	    final Calendar calendar = Calendar.getInstance();
	    calendar.set(1900, 01, 01);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    date = calendar.getTime();
	}else{
	    final Calendar calendar = Calendar.getInstance();
	    calendar.setTime(since);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    date = calendar.getTime();
	}
	return date;
    }

    /**
     * Ajusta los segundos y minutos a 59 y la hora a 23
     * @param until - la fecha que será ajustada
     * @return Date - la fecha ajustada
     */
    public static Date prepareUntilDate(final Date until){
	final Date date;
	if(until == null){
	    final Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    date = calendar.getTime();
	}else{
	    final Calendar calendar = Calendar.getInstance();
	    calendar.setTime(until);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    date = calendar.getTime();
	}
	return date;
    }

}