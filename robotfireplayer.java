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

//Clase Robot Fire Player, hereda los métodos de la clase robotplayer
class robotfireplayer extends robotplayer{
	//Método que retorna el valor del ataque uno				
	public int attackone(){
		return 80;
	}
	//Método que retorna el valor del ataque dos
	public int attacktwo(){
		return 120;
	}
	//Método que retorna el valor del ataque tres
	public int attackthree(){
		return 50;
	}
	//Método que retorna el valor de la defensa
	public int defense(){
		return 100;
	}
	//Método que retorna el valor del nombre
	public String getname(){
		return "Fleast";
	}
	//Método que retorna el valor del tipo
	public String gettype(){
		return "Fire";
	}
	//Método que retorna el String del ataque uno
	public String getattackone(){
		return "Fire Ball:\n  Damage = ";
	}	
	//Método que retorna el String del ataque dos
	public String getattacktwo(){
		return "Volcano:\n   Damage = ";
	}
	//Método que retorna el String del ataque tres
	public String getattackthree(){
		return "Burn:\n   Damage = ";
	}
	//Método que retorna el String de la defensa
	public String getdefense(){
		return "Flame Shield: \n   Defense = ";
	}
}