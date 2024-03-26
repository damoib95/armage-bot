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

import java.util.Random;

abstract class robot{
	//Método de determina quien tiene ventaja o desventaja sobre quien
	//Si tiene ventaja suma 100 al ataque
	//Si tiene desventaja resta 50 al ataque
	//Si no tiene ventaja ni desventaja simplemente regresa un 0.
		//La ventaja o desventaja se define por el tipo de robot que son:
		//Agua > Fuego & Agua < Planta
		//Planta > Agua & Planta < Fuego
		//Fuego > Planta & Fuego < Agua
	public int advantage(String atype, String btype){
		if(atype.equals(btype)){
			return 0;
		}
		else{
			if(atype.equals("Fire")){
				if(btype.equals("Water")){
					return -25;
				}
				else{
					return 50;
				}
			}
			if(atype.equals("Water")){
				if(btype.equals("Fire")){
					return 50;
				}
				else{
					return -25;
				}
			}
			if(atype.equals("Plant")){
				if(btype.equals("Water")){
					return 50;
				}
				else{
					return -25;
				}
			}
			return 0;
		}
	}
	//Método Inteligencia Artificial que determina qué acción realizará el boot
	//Depende de la cantidad de vida que le queda para que la probabilidad de utilizar
	//cierta acción aumente
	public int aiboot(int life){
		Random random = new Random();
		if(life<50){
			if(random.nextInt(2)==0){
				return 2;
			}
			else{
				return 4;
			}
		}
		else{
			if(life<300){
				return 1+ random.nextInt(2);
			}
			else{
				return 1+ random.nextInt(4);
			}
		}
	}

	//Método que retorna el valor del ataque uno
	abstract public int attackone();

	//Método que retorna el valor del ataque dos
	abstract int attacktwo();

	//Método que retorna el valor del ataque tres
	abstract public int attackthree();

	//Método que retorna el valor de la defensa
	abstract public int defense();

	//Método que retorna el String del ataque uno
	abstract public String getattackone();

	//Método que retorna el String del ataque dos
	abstract public String getattacktwo();

	//Método que retorna el String del ataque tres
	abstract public String getattackthree();

	//Método que retorna el String de la defensa
	abstract public String getdefense();

	//Método que retorna el valor del nombre
	abstract public String getname(); 

	//Método que retorna el valor del tipo
	abstract public String gettype();

	//Método que retorna el valor de la vida
	abstract public int getlife();

	//Método que settea el valor de al vida
	abstract public void setlife(int x);
	
}