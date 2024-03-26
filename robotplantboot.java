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

//Clase Robot Plant Boot, hereda los métodos de la clase robotboot
class robotplantboot extends robot{
	//Atributos
		//Variables que describen el nombre y el tipo del robot
	private String name = "Threep",
				   type = "Plant";
		//Variables que definen los valores de vida, ataque y defensa del usuario
	private int life=500,
				attack=1, 
				defense=1, 
				valattackone=90,
				valattacktwo=110, 
				valattackthree=30, 
				valdefense=190;

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
	//Método que retorna el valor de la vida
	public int getlife(){
		return life;
	}
	//Método que retorna el String del ataque uno
	public String getattackone(){
		return "Wood hammer";
	}	
	//Método que retorna el String del ataque dos
	public String getattacktwo(){
		return "Giga forest";
	}
	//Método que retorna el String del ataque tres
	public String getattackthree(){
		return "Green seed";
	}
	//Método que retorna el String de la defensa
	public String getdefense(){
		return "Three Shield";
	}
	//Método que settea el valor de la vida
	public void setlife(int x){
		this.life=x;
	}
}