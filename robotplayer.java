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

//Clase madre robotplayer que hereda a las subclases
//de los personajes que pueden ser elegidos por el usuario
abstract class robotplayer extends robot{
	private int resattackone = 4,
	 	resattacktwo = 2, 
	 	resattackthree = 40, 
	 	resdefense = 8,
	 	life = 750;

	//Método que retorna el valor de la vida
	public int getlife(){
		return life;
	}
	//Método que settea el valor de la vida
	public void setlife(int x){
		life=x;
	}

	//Método que retorna el número restante de ataque uno
	public int getresattackone(){
		return resattackone;
	}
	//Método que retorna el número restante de ataque dos
	public int getresattacktwo(){
		return resattacktwo;
	}
	//Método que retorna el número restante de ataque tres
	public int getresattackthree(){
		return resattackthree;
	}
	//Método que retorna el número restante de defensa
	public int getresdefense(){
		return resdefense;
	}
	//Método que resta uno al número de acción seleccionada
	public void setresattacks(int a){
		if(a==1)
			resattackone--;
		if(a==2)
			resattacktwo--;
		if(a==3)
			resattackthree--;
		if(a==4)
			resdefense--;
	}
	//Método item que aumenta el número de acciones
	public void itemresattacks(){
		resattackone+=5;
		resattacktwo+=3;
		resattackthree+=40;
		resdefense+=6;
	}
}