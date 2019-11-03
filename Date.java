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
	
