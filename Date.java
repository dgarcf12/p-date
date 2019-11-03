package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	// Constructor mal programado: Permite crear fechas no validas
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getYear(){
		return this.year;
	}

	boolean isSameYear(Date another){
		if (this.year == another.getYear()){
			return true;
		}
		return false;
	}
	public int getMonth(){
		return this.month;
	}
	boolean isSameMonth(Date another){
		if (this.month == another.getMonth()){
			return true;
		}
		return false;
	}
	public int getDay(){
		return this.day;
	}
	boolean isSameDay(Date another){
		if (this.day == another.getDay()){
			return true;
		}
		return false;
	}
	boolean isSame(Date another){
		if((isSameDay(another)==true)&&(isSameMonth(another)==true)&&(isSameYear(another)==true) ){
			   return true;
			}
		return false;
	}
	public String getMonthName(){
		String name = new String();
		switch(this.month){
			case 1:
			name = "Enero";
			break;
			case 2:
			name = "Febrero";
			break;
			case 3:
			name = "Marzo";
			break;
			case 4:
			name = "Abril";
			break;
			case 5:
			name = "Mayo";
			break;
			case 6:
			name = "Junio";
			break;
			case 7:
			name = "Julio";
			break;
			case 8:
			name = "Agosto";
			break;
			case 9:
			name = "Septiembre";
			break;
			case 10:
			name = "Octubre";
			break;
			case 11:
			name = "Noviembre";
			break;
			case 12:
			name = "Diciembre";
			break;
			}
		return name;
	}
	public boolean isDayOfMonthRight(){
		boolean correcto = false;
		switch(this.month){
			case 1:
				if(this.day<=31)
					correcto = true;
				break;
			case 3:
				if(this.day<=31)
					correcto = true;
				break;
			case 5:
				if(this.day<=31)
					correcto = true;
				break;
			case 7:
				if(this.day<=31)
					correcto = true;
				break;
			case 8:
				if(this.day<=31)
					correcto = true;
				break;
			case 10:
				if(this.day<=31)
					correcto = true;
				break;
			case 12:
				if(this.day<=31)
					correcto = true;
				break;
			case 2:
				if(this.day<=28)
					correcto = true;
				break;
			case 4:
				if(this.day<=30)
					correcto = true;
				break;
			case 6:
				if(this.day<=30)
					correcto = true;
				break;
			case 9:
				if(this.day<=30)
					correcto = true;
				break;
			case 11:
				if(this.day<=30)
					correcto = true;
				break;
		}
		return correcto;
	}
	public String seasonOfTheMonth(){
		String season = new String();
		switch(this.month){
			case 1:
			case 2:
			case 3:
				season = "Invierno";
				break;
			case 4:
			case 5:
			case 6:
				season = "Primavera";
				break;
			case 7:
			case 8:
			case 9:
				season = "Verano";
				break;
			case 10:
			case 11:
			case 12:
				season = "Otoño";
				break;
			}
		return season;
	}
	public String monthsLeft(){

 	 StringBuilder months = new StringBuilder();

 	for(int i=this.month+1;i<=12;i++){
		Date monthsLeftDate = new Date(this.day,i,this.year);

    		months.append(monthsLeftDate.getMonthName() + "\t"); }

 	return months.toString();
	}
public int numDays(int month) {
		int numMonth = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numMonth = 31;
			break;
		case 2:
			if ( ((this.year % 400)==0) || ( (this.year %4==0) && !((this.year%100)==0)))
				numMonth = 29;
			else
				numMonth = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numMonth = 30;
			break;
		}
		
		return numMonth;
	}
	public String daysOfTheMonthLeft() {
		int numMonth = numDays(this.month);
		// Hacemos un bucle hasta el numero calculado antes
		
		StringBuilder daysLeft = new StringBuilder();
		for (int i = this.day+1; i <= numMonth; i++) {
			Date daysLeftDate = new Date(i, this.month, this.year);

			if (daysLeftDate.isDayOfMonthRight() == true) {

				daysLeft.append(daysLeftDate + "\t");

			}
		}

		return daysLeft.toString();
	}
	public String monthsWithSameDays() {
		String months = new String();
		switch (numDays(this.month)){
		case 31:
			months = "Months with 31 days: Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre";
			break;
		case 28:
		case 29:
			months = "Febrero";
			break;
		case 30:
			months = "Months with 30 days: Abril, Junio, Septiembre, Noviembre";
			break;
		}
		return months;
	}
	public int numDaysFrom11(Date date) {
		int num = 0;
		int month = date.getMonth();
		
		for(int i=0;i<month;i++) {
			num = num + numDays(i);
		}
		num = num + date.getDay();
		return num-1;
	}
	public int numAttempsRand() {
		int count = 0;
		boolean off = false;
		while(!off) {
			Date random = new Date((int)Math.random()*31+1,(int)Math.random()*12+1,(int)Math.random()*2019+1);
			count++;
			off = isSame(random);
		}
		return count;
	}
	public String dayOfWeek() {
		//El primer dia del año 2019 fue martes
		String[] diasSemana = {"Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", "Lunes"};
		//Primero vemos cuantos dias han pasado desde ese dia
		String day = new String();
		Date today = new Date (this.day, this.month, this.year);
		int weekDay = numDaysFrom11(today)%7;
		day = diasSemana[weekDay];
		return day;
	}
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
