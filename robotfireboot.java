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

//Clase Robot Fire Boot, hereda los métodos de la clase robotboot
class robotfireboot extends robot{
	//Atributos
		//Variables que describen el nombre y el tipo del robot
	private String name = "Infernus",
				   type = "Fire";
		//Variables que definen los valores de vida, ataque y defensa del usuario
	private int life=1000,
				valattackone=200,
				valattacktwo=300, 
				valattackthree=100, 
				valdefense=250;

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
		return "Eruption";
	}	
	//Método que retorna el String del ataque dos
	public String getattacktwo(){
		return "Hell";
	}
	//Método que retorna el String del ataque tres
	public String getattackthree(){
		return "Fire sky";
	}
	//Método que retorna el String de la defensa
	public String getdefense(){
		return "Magma Shield";
	}
	//Método que settea el valor de la vida
	public void setlife(int x){
		this.life=x;
	}
}