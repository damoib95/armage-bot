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

class items{
	//Atributos
				//Variables de los items que permiten que unicamente se pueda utilizar cada uno dos veces
	private int valitemone = 2, valitemtwo = 2, valitemthree = 2, valitemfour = 2;
				//Variables que describe el nombre del item y una descripción de su función
	private String itemone="Health\n   Increases 150HP.",
				   itemtwo="Attack\n   Increases attack by 100 (for one turn).",
				   itemthree="Attacks\n   Increases the Power Points for each of your actions",
				   itemfour="Absorve\n   You can absorb 50HP from your enemy.";
	//Método que evalua si se puede seguir utilizando un determinado item
	//Si todavía posee items retorna un true, de lo contrario un false.
	public boolean getvalitem(int x){
		if(x==1){
			if(valitemone>0){
				return true;
			}
			else{
				return false;
			}
		}
		if(x==2){
			if(valitemtwo>0){
				return true;
			}
			else{
				return false;
			}
		}
		if(x==3){
			if(valitemthree>0){
				return true;
			}
			else{
				return false;
			}
		}
		if(x==4){
			if(valitemfour>0){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	//Método que disminuye un valor del item uno
	public void setitemone(){
		this.valitemone--;
	}
	//Método que disminuye un valor del item dos
	public void setitemtwo(){
		this.valitemtwo--;
	}
	//Método que disminuye un valor del item tres
	public void setitemthree(){
		this.valitemthree--;
	}
	//Método que disminuye un valor del item cuatro
	public void setitemfour(){
		this.valitemfour--;
	}
	//Método que retorna el String del item dependiendo si se encuentra disponible
		//Para evaluar si está disponible utiliza el método getvalitem();
	public String getitemone(){
		if(getvalitem(1)==true){
			return itemone;
		}
		else{
			return "Empty";
		}
	}
	//Método que retorna el String del item dependiendo si se encuentra disponible
		//Para evaluar si está disponible utiliza el método getvalitem();
	public String getitemtwo(){
		if(getvalitem(2)==true){
			return itemtwo;
		}
		else{
			return "Empty";
		}
	}
	//Método que retorna el String del item dependiendo si se encuentra disponible
		//Para evaluar si está disponible utiliza el método getvalitem();
	public String getitemthree(){
		if(getvalitem(3)==true){
			return itemthree;
		}
		else{
			return "Empty";
		}
	}
	//Método que retorna el String del item dependiendo si se encuentra disponible
		//Para evaluar si está disponible utiliza el método getvalitem();
	public String getitemfour(){
		if(getvalitem(4)==true){
			return itemfour;
		}
		else{
			return "Empty";
		}
	}
}