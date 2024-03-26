/*
||-------------------------------------||
	Programacion Orientada a Objetos   
	Tomás Galves y Luis Furlan
	Proyecto: Fase 2
	Grupo: 11
	Diego Alberto Morales Ibanez
	Seccion: 10-11
	Carne: 14012
	27/10/2014
||-------------------------------------||
*/

//Clase Robot Water Player, hereda los métodos de la clase robotplayer
class robotwaterplayer extends robotplayer{
	//Atributos
		//Variables que describen el nombre y el tipo del robot
	private String name = "Hydro",
				   type = "Water";
		//Variables que definen los valores de vida, ataque y defensa del usuario
	private int valattackone=80,
				valattacktwo=120, 
				valattackthree=50, 
				valdefense=100;
	
	//Método que retorna el valor del ataque uno
	public int attackone(){
		return valattackone;
	}
	//Método que retorna el valor del ataque dos
	public int attacktwo(){
		return valattacktwo;
	}
	//Método que retorna el valor del ataque tres
	public int attackthree(){
		return valattackthree;
	}
	//Método que retorna el valor de la defensa
	public int defense(){
		return valdefense;
	}
	//Método que retorna el valor del nombre
	public String getname(){
		return name;
	}
	//Método que retorna el valor del tipo
	public String gettype(){
		return type;
	}
	//Método que retorna el String del ataque uno
	public String getattackone(){
		return "Surf:\n  Damage = ";
	}	
	//Método que retorna el String del ataque dos
	public String getattacktwo(){
		return "Water Pump:\n   Damage = ";
	}
	//Método que retorna el String del ataque tres
	public String getattackthree(){
		return "Rain fall:\n   Damage = ";
	}
	//Método que retorna el String de la defensa
	public String getdefense(){
		return "Bubble shield: \n   Defense = ";
	}
}