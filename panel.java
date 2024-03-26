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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//Codigo para reproducir audio, recuperado de:
//www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;


public class panel extends JFrame{
//--------------------------VARIABLES------------------------------------//
	//MENU
	static private JLayeredPane window;
	static private JButton buttonplay, buttoncredits, buttonexit;
	static private JLabel labelscenemenu, labelgame;
	//SELECTION
	static private JLabel labelsceneselect, labelselect, labelrobotone, labelrobottwo, labelrobotthree;
	static private JButton buttonrobotone, buttonrobottwo, buttonrobotthree;
	//INTERFACE
	static private JLabel labeldialog, labelinformationplayer, 
				labelinformationboot, labelmenu;
	static private JTextArea textdialog;
	static private JButton buttona, buttonb, buttonc, buttond, buttonitem, buttonactions;
	static private boolean modeitem;
		//INFORMATION BOOT
		static private JLabel labelnameboot, labeltypeboot,
							 labellifeboot, labellifebarboot, labellifebarbboot;
		//INFORMATION PLAYER
		static private JLabel labelnameplayer, labeltypeplayer,
							 labellifeplayer, labellifebarplayer, labellifebarbplayer;
	//CREDITS
	static private JLabel labelcredits;
	static private JTextArea textcredits;
	static private JLabel labelscenecredits;

	//SCENE A
	static private JLabel labelscenea;

	//SCENE B
	static private JLabel labelsceneb;

	//SCENE C
	static private JLabel labelscenec;

	//SCENE GAME OVER
	static private JLabel labelscenegameover, labelgameover;

	//PLAYER
	static private robotplayer Player;
	static private String [] playerimages;
	static private JLabel [] arrayplayeranimation;
	static private JLabel labelavatarplayer;
	static private Clip [] arrayplayermusic;
	static private String [] playermusic;
	static private int playerattack, playerdefense;
	static private int playerfullife=750;
	static private double playerlifebar, bootlifebar;

	//BOOT
	static private int bootaction, bootfulllife, bootattack, bootdefense;

	//PROGRAM
	static private int sceneon=1, roboton, booton=0;
	static private int cont=1;
	static private Timer t;

	//MUSIC
	static private Clip clip0, clip1, clip2, clip3, clip4, clipover;

	// BOOT & ITEMS
	static private robot [] Boot;
	static private String [][] bootimages;
	static private JLabel [][] arraybootanimation;
	static private items Item;


//-----------------------------------------------------------------------//

	//PANEL
	public panel(){

//------------------------------WINDOW-----------------------------------//
		//WINDOW
		setTitle("ArmageBot");
		setSize(960, 660);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		window = getLayeredPane();
//-----------------------------------------------------------------------//

//-------------------------------MENU------------------------------------//
		//MENU
		labelscenemenu = new JLabel(new ImageIcon("Content/Scenes/scenemenu.jpg"));
		labelscenemenu.setBounds(0, 0, 960, 640);
		window.add(labelscenemenu);
			//LISTENER
			MenuListener menulistener = new MenuListener();
			//LABELGAME
			labelgame = new JLabel(new ImageIcon("Content/Scenes/title.png"));
			labelgame.setBounds(190, 200, 600, 100);
			//BUTTONPLAY
			buttonplay = new JButton(new ImageIcon("Content/Scenes/play.jpg"));
			buttonplay.setBounds(400, 320, 160, 50);
			buttonplay.addActionListener(menulistener);
			//BUTTON CREDITS
			buttoncredits = new JButton(new ImageIcon("Content/Scenes/credits.jpg"));
			buttoncredits.setBounds(400, 380, 160, 50);
			buttoncredits.setFont(new Font("Arial", Font.BOLD, 20));
			buttoncredits.addActionListener(menulistener);
			//BUTTON EXIT
			buttonexit = new JButton(new ImageIcon("Content/Scenes/exit.jpg"));
			buttonexit.setBounds(400, 440, 160, 50);
			buttonexit.setFont(new Font("Arial", Font.BOLD, 20));
			buttonexit.addActionListener(menulistener);
			//ADD COMPONENTS
			window.add(labelgame, new Integer(1));
			window.add(buttonplay, new Integer(1));
			window.add(buttoncredits, new Integer(1));
			window.add(buttonexit, new Integer(1));
			//MUSIC CLIP
			try {
		        clip0 = AudioSystem.getClip();
		        clip0.open(AudioSystem.getAudioInputStream(new File("Content/Music/Track0.wav")));
		        clip0.loop(5);     
			} 
			catch(Exception e){
			}
//-----------------------------------------------------------------------//

//------------------------------SELECT-----------------------------------//
	//MENU
	labelsceneselect = new JLabel(new ImageIcon("Content/Scenes/sceneselect.jpg"));
	labelsceneselect.setBounds(0, 0, 960, 640);
		//LISTENER
		SelectListener selectlistener = new SelectListener();
		//LABEL ROBOT ONE (IMAGE)
		labelrobotone = new JLabel(new ImageIcon("Content/Scenes/fire.png"));
		labelrobotone.setBounds(0, 100, 360, 480);
		//BUTTON ROBOT ONE
		buttonrobotone = new JButton("Fleast");
		buttonrobotone.setBounds(110, 550, 120, 50);
		buttonrobotone.setFont(new Font("Arial", Font.BOLD, 18));
		buttonrobotone.addActionListener(selectlistener);
		//LABEL ROBOT TWO (IMAGE)
		labelrobottwo = new JLabel(new ImageIcon("Content/Scenes/water.png"));
		labelrobottwo.setBounds(310, 100, 360, 480);
		//BUTTON ROBOT TWO
		buttonrobottwo = new JButton("Hydro");
		buttonrobottwo.setBounds(430, 550, 120, 50);
		buttonrobottwo.setFont(new Font("Arial", Font.BOLD, 18));
		buttonrobottwo.addActionListener(selectlistener);
		//LABEL ROBOT THREE
		labelrobotthree = new JLabel(new ImageIcon("Content/Scenes/plant.png"));
		labelrobotthree.setBounds(600, 100, 360, 480);
		//BUTTON ROBOT THREE
		buttonrobotthree = new JButton("Weedo");
		buttonrobotthree.setBounds(740, 550, 120, 50);
		buttonrobotthree.setFont(new Font("Arial", Font.BOLD, 18));
		buttonrobotthree.addActionListener(selectlistener);
		//LABEL SELECT
		labelselect = new JLabel("Select your player:");
		labelselect.setFont(new Font("Arial", Font.BOLD, 36));
		labelselect.setForeground(Color.white);
		labelselect.setBounds(320, 50, 680, 40);

		//ADD COMPONENTS
		window.add(labelsceneselect);
		window.add(labelrobotone, new Integer(1));
		window.add(buttonrobotone, new Integer(2));
		window.add(labelrobottwo, new Integer(1));
		window.add(buttonrobottwo, new Integer(2));
		window.add(labelrobotthree, new Integer(1));
		window.add(buttonrobotthree, new Integer(2));
		window.add(labelselect, new Integer(2));

		//COMPONENTS VISIBLE(FALSE)
		selectenabled(false);
//-----------------------------------------------------------------------//

//-----------------------------INTERFACE---------------------------------//

		//INTERFACE
			//LABEL DIALOG (IMAGE)
			labeldialog = new JLabel(new ImageIcon("Content/Components/dialog.jpg"));
			labeldialog.setBounds(0, 480, 640, 160);
			//TEXT DIALOG
			textdialog = new JTextArea("Choose your move");
			textdialog.setBounds(20, 500, 640, 160);
			textdialog.setEditable(false);
			textdialog.setOpaque(false);
			textdialog.setFont(new Font("SansSerif", Font.PLAIN, 20));
			//LABEL INFORMATION BOOT (IMAGE)
			labelinformationboot = new JLabel(new ImageIcon("Content/Components/informationboot.jpg"));
			labelinformationboot.setBounds(640, 0, 320, 240);
				//LABEL NAME BOOT
				labelnameboot = new JLabel("Enemy");
				labelnameboot.setBounds(675, 30, 150, 30);
				labelnameboot.setFont(new Font("Arial", Font.BOLD, 30));
				//LABEL TYPE BOOT
				labeltypeboot = new JLabel("Type");
				labeltypeboot.setBounds(675, 60, 100, 20);
				labeltypeboot.setFont(new Font("Arial", Font.ITALIC, 20));
				//LABEL LIFE BOOT
				labellifeboot = new JLabel("Life");
				labellifeboot.setBounds(675, 120, 100, 20);
				labellifeboot.setFont(new Font("Arial", Font.PLAIN, 15));
				//LABEL LIFEBAR BOOT (IMAGE)
				labellifebarboot = new JLabel(new ImageIcon("Content/Components/health.png"));
				labellifebarboot.setBounds(675, 140, 250, 20);
				//LABEL LIFEBAR B BOOT (IMAGE)
				labellifebarbboot = new JLabel(new ImageIcon("Content/Components/healthb.png"));
				labellifebarbboot.setBounds(675, 140, 250, 20);

			//LABEL INFORMATION PLAYER (IMAGE)
			labelinformationplayer = new JLabel(new ImageIcon("Content/Components/informationplayer.jpg"));
			labelinformationplayer.setBounds(640, 240, 320, 240);
				//LABEL NAME PLAYER
				labelnameplayer = new JLabel("Player");
				labelnameplayer.setBounds(675, 270, 150, 30);
				labelnameplayer.setFont(new Font("Arial", Font.BOLD, 30));
				//LABEL TYPE PLAYER
				labeltypeplayer = new JLabel("Type");
				labeltypeplayer.setBounds(675, 300, 100, 20);
				labeltypeplayer.setFont(new Font("Arial", Font.ITALIC, 20));
				//LABEL LIFE PLAYER
				labellifeplayer = new JLabel("Life");
				labellifeplayer.setBounds(675, 360, 100, 20);
				labellifeplayer.setFont(new Font("Arial", Font.PLAIN, 15));
				//LABEL LIFEBAR PLAYER (IMAGE)
				labellifebarplayer = new JLabel(new ImageIcon("Content/Components/health.png"));
				labellifebarplayer.setBounds(675, 380, 250, 20);
				//LABEL LIFEBAR B PLAYER (IMAGE)
				labellifebarbplayer = new JLabel(new ImageIcon("Content/Components/healthb.png"));
				labellifebarbplayer.setBounds(675, 380, 250, 20);

			//LABEL MENU (IMAGE)
			labelmenu = new JLabel(new ImageIcon("Content/Components/menu.jpg"));
			labelmenu.setBounds(640, 480, 320, 160);
			//MOUSE LISTENER
			mouselistener mouse = new mouselistener();
			//BUTTON A
			buttona = new JButton(new ImageIcon("Content/Components/buttona.jpg"));
			buttona.setBounds(645, 490, 140, 70);
			buttona.addMouseListener(mouse);
			//BUTON B
			buttonb = new JButton(new ImageIcon("Content/Components/buttonb.jpg"));
			buttonb.setBounds(815, 490, 140, 70);
			buttonb.addMouseListener(mouse);
			//BUTON C
			buttonc = new JButton(new ImageIcon("Content/Components/buttonc.jpg"));
			buttonc.setBounds(645, 560, 140, 70);
			buttonc.addMouseListener(mouse);
			//BUTTON D
			buttond = new JButton(new ImageIcon("Content/Components/buttond.jpg"));
			buttond.setBounds(815, 560, 140, 70);
			buttond.addMouseListener(mouse);
			//BUTTON ITEM
			buttonitem = new JButton(new ImageIcon("Content/Components/items.jpg"));
			buttonitem.setBounds(780, 490, 40, 140);
			buttonitem.addMouseListener(mouse);
			modeitem=false;
			//BUTTON ACTIONS
			buttonactions = new JButton(new ImageIcon("Content/Components/actions.jpg"));
			buttonactions.setBounds(780, 490, 40, 140);
			buttonactions.addMouseListener(mouse);
			//TEXT DIALOG CHEATCODE
			textdialog.addMouseListener(mouse);
			//ADD COMPONENTS
			//INTERFACE
			window.add(labeldialog); 
			window.add(labelinformationboot);
			window.add(labelinformationplayer);
			window.add(labelmenu);
			window.add(textdialog, new Integer(1)); 
			window.add(buttona, new Integer(1));
			window.add(buttonb, new Integer(1));
			window.add(buttonc, new Integer(1));
			window.add(buttond, new Integer(1));
			window.add(buttonitem, new Integer(2));
			window.add(buttonactions, new Integer(2));
			//INFORMATION BOOT
			window.add(labelnameboot, new Integer(3));
			window.add(labeltypeboot, new Integer(3));
			window.add(labellifeboot, new Integer(3));
			window.add(labellifebarboot, new Integer(4));
			window.add(labellifebarbboot, new Integer(3));

			//INFORMATION PLAYER
			window.add(labelnameplayer, new Integer(3));
			window.add(labeltypeplayer, new Integer(3));
			window.add(labellifeplayer, new Integer(3));
			window.add(labellifebarplayer, new Integer(4));
			window.add(labellifebarbplayer, new Integer(3));

			//COMPONENTS VISIBLE(FALSE)
			interfaceenabled(false);
			buttonactions.setVisible(false);
//-----------------------------------------------------------------------//

//-----------------------------ANIMATION---------------------------------//

	//TIMER 
	TimerListener timerlistener = new TimerListener();
	t = new Timer(1000, timerlistener);
	t.setInitialDelay(0);

	//ANIMATION PLAYER
	playerimages = new String[6];
	arrayplayeranimation = new JLabel[5];

	//MUSIC PLAYER
	playermusic = new String[4];
	arrayplayermusic = new Clip[4];

//------------------------------CREDITS----------------------------------//
	//CREDITS
	labelscenecredits = new JLabel(new ImageIcon("Content/Scenes/scenecredits.jpg"));
	labelscenecredits.setBounds(0, 0, 960, 640);

	
	//LABEL CREDITS 
	labelcredits = new JLabel("Credits");
	labelcredits.setBounds(400, 50, 300, 40);
	labelcredits.setFont(new Font("Arial", Font.BOLD, 36));
	labelcredits.setForeground(Color.white);
	//TEXT AREA TEXT CREDITS
	textcredits = new JTextArea("Game Director		Diego Morales"+
								"\nProgram Director	Diego Morales"+
								"\nArt Director		Diego Morales"+
								"\nRobot Modeling Director	Diego Morales"+
								"\nRobot Modeler		Diego Morales"+
								"\nSound Director		Diego Morales"+
								"\nLead GamePlay Animator	Diego Morales"+
								"\nRobots Voice		Diego Morales"+
								"\nRecording Engineer	Diego Morales"+

								"\nGame Designer		Diego Morales"+
								"\nBattle Scene Programmer	Diego Morales"+
								"\nEffects Programmer 	Diego Morales"+
								"\nAI Programmer		Diego Morales"+
								"\nMusic		Kenji Kawai"+
								"\nTesting		JD Benitez"+							
								"\n		Gabriela Osorio"+
								"\n		Maisha Osorio"+
								"\nProducer		Diego Morales"+
								"\nSpecial Thanks		Bernardita"+
								"\n    		Shava");
	textcredits.setForeground(Color.white);
	textcredits.setBounds(250, 100, 640, 500);
	textcredits.setEditable(false);
	textcredits.setOpaque(false);
	textcredits.setFont(new Font("SansSerif", Font.ITALIC, 20));	
	
	window.add(labelscenecredits);
	window.add(labelcredits, new Integer(3));
	window.add(textcredits, new Integer(3));

	labelscenecredits.setVisible(false);
	labelcredits.setVisible(false);
	textcredits.setVisible(false);

			//MUSIC CLIP 4
			try {
		        clip4 = AudioSystem.getClip();
		        clip4.open(AudioSystem.getAudioInputStream(new File("Content/Music/Track4.wav"))); 
			} 
			catch(Exception e){
			}
//-----------------------------------------------------------------------//

//------------------------------SCENE A----------------------------------//

		//SCENE A
		labelscenea = new JLabel(new ImageIcon("Content/Scenes/sceneone.jpg")); 
		labelscenea.setBounds(0, 0, 640, 480);
		window.add(labelscenea, new Integer(0));
		labelscenea.setVisible(false);

			//MUSIC CLIP 1
			try {
		        clip1 = AudioSystem.getClip();
		        clip1.open(AudioSystem.getAudioInputStream(new File("Content/Music/Track1.wav")));
			} 
			catch(Exception e){
			}
		
//-----------------------------------------------------------------------//

//------------------------------SCENE B----------------------------------//

		//SCENE B
		labelsceneb = new JLabel(new ImageIcon("Content/Scenes/scenetwo.jpg")); 
		labelsceneb.setBounds(0, 0, 640, 480);
		window.add(labelsceneb, new Integer(0));
		labelsceneb.setVisible(false);

			//MUSIC CLIP 2
			try {
		        clip2 = AudioSystem.getClip();
		        clip2.open(AudioSystem.getAudioInputStream(new File("Content/Music/Track2.wav")));   ;
			} 
			catch(Exception e){
			}

//-----------------------------------------------------------------------//

//------------------------------SCENE C----------------------------------//

		//SCENE C
		labelscenec = new JLabel(new ImageIcon("Content/Scenes/scenethree.jpg")); 
		labelscenec.setBounds(0, 0, 640, 480);
		window.add(labelscenec, new Integer(0));
		labelscenec.setVisible(false);

			//MUSIC CLIP 3
			try {
		        clip3 = AudioSystem.getClip();
		        clip3.open(AudioSystem.getAudioInputStream(new File("Content/Music/Track3.wav")));  
			} 
			catch(Exception e){
			}

//-----------------------------------------------------------------------//

//---------------------------SCENE GAME OVER------------------------------//

		//GAME OVER
		labelscenegameover = new JLabel(new ImageIcon("Content/Scenes/scenegameover.jpg"));
		labelscenegameover.setBounds(0, 0, 960, 640);
		window.add(labelscenegameover);
		//LABEL GAME OVER
		labelgameover = new JLabel("Game over");
		labelgameover.setForeground(Color.white);
		labelgameover.setFont(new Font("Arial", Font.BOLD, 48));
		labelgameover.setBounds(340, 200, 320, 60);
		window.add(labelgameover, new Integer(1));

		//MUSIC CLIP OVER
			try {
		        clipover = AudioSystem.getClip();
		        clipover.open(AudioSystem.getAudioInputStream(new File("Content/Music/Track5.wav")));  
			} 
			catch(Exception e){
			}
		labelscenegameover.setVisible(false);
		labelgameover.setVisible(false);
//-----------------------------------------------------------------------//


	//BOOTS
	Boot = new robot [3];
	Boot[0] = new robotplantboot();
	Boot[1] = new robotwaterboot();
	Boot[2] = new robotfireboot();

	//ADDING STRING TO BOOTIMAGES ARRAY
	bootimages = new String [3][6];
		bootimages [0][0] = "Content/boot/robotplantboot/robotplantbootfront.gif";
		bootimages [0][1] = "Content/boot/robotplantboot/robotplantbootattackone.gif";
		bootimages [0][2] = "Content/boot/robotplantboot/robotplantbootattacktwo.gif";
		bootimages [0][3] = "Content/boot/robotplantboot/robotplantbootattackthree.gif";
		bootimages [0][4] = "Content/boot/robotplantboot/robotplantbootdefense.gif";
		bootimages [0][5] = "Content/boot/robotplantboot/robotplantbootavatar.png";
		bootimages [1][0] = "Content/boot/robotwaterboot/robotwaterbootfront.gif";
		bootimages [1][1] = "Content/boot/robotwaterboot/robotwaterbootattackone.gif";
		bootimages [1][2] = "Content/boot/robotwaterboot/robotwaterbootattacktwo.gif";
		bootimages [1][3] = "Content/boot/robotwaterboot/robotwaterbootattackthree.gif";
		bootimages [1][4] = "Content/boot/robotwaterboot/robotwaterbootdefense.gif";
		bootimages [1][5] = "Content/boot/robotwaterboot/robotwaterbootavatar.png";
		bootimages [2][0] = "Content/boot/robotfireboot/robotfirebootfront.gif";
		bootimages [2][1] = "Content/boot/robotfireboot/robotfirebootattackone.gif";
		bootimages [2][2] = "Content/boot/robotfireboot/robotfirebootattacktwo.gif";
		bootimages [2][3] = "Content/boot/robotfireboot/robotfirebootattackthree.gif";
		bootimages [2][4] = "Content/boot/robotfireboot/robotfirebootdefense.gif";
		bootimages [2][5] = "Content/boot/robotfireboot/robotfirebootavatar.png";

	//ADDING IMAGEICON TO ARRAYBOOTANIMATION
	arraybootanimation = new JLabel [3][6];
		for(int m = 0; m<=2; m++){
			for(int n = 0; n<5; n++){
				arraybootanimation[m][n] = new JLabel(new ImageIcon(bootimages[m][n]));
				arraybootanimation[m][n].setBounds(320, 0, 320, 240);
				arraybootanimation[m][n].setVisible(false);
				window.add(arraybootanimation[m][n], new Integer(3));
			}
		}
		for(int i = 0; i<=2; i++){
			arraybootanimation[i][5] = new JLabel( new ImageIcon(bootimages[i][5]) );
			arraybootanimation[i][5].setBounds(830, 30, 100, 100);
			window.add(arraybootanimation[i][5], new Integer(3));
			arraybootanimation[i][5].setVisible(false);
		}
	//ITEMS
	Item = new items();
	//Se settea la variable bootfulllife del enemigo numero 1
	bootfulllife = Boot [0].getlife();

	//-------------------------------------------------------------//

	}

	

//************************************************************************//

//------------------------------LISTENERS--------------------------------//

	//LISTENER MENU DE INICIO	
		//Listener de la pantalla principal, dependiendo del botón que se elija se ejecuta una acicón
	private class MenuListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			//Button play inicia el juego
			if(event.getSource()==buttonplay){
				//MENU Disabled
				menuenabled(false);
				//SELECT ENABLED
				selectenabled(true);
			}	
			//Button credits muestra los créditos del juego
			if(event.getSource()==buttoncredits){
				//MENU Disabled
				menuenabled(false);
				//CREDITS ENABLED
				creditsenabled(true);
			}
			//Button exit cierra el juego
			if(event.getSource()==buttonexit){
				System.exit(0);
			}
		}
	}
	//LISTENER MENU DE SELECCION
		//Aparece luego de dar click en el boton Play (o de que eliminen a un personaje anteriormente seleccionado)
		//Dependiendo del robot que se elija con el botón, entonces se instancia su respectiva subclase
		//de tipo Player y se agregan las imágenes y clip correspondientes a los arrays
	private class SelectListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource()==buttonrobotone){
				Player = new robotfireplayer();
				roboton=1;
				playerimages[0] = "Content/player/robotfireplayer/robotfireplayerfront.gif";
				playerimages[1] = "Content/player/robotfireplayer/robotfireplayerattackone.gif";
				playerimages[2] = "Content/player/robotfireplayer/robotfireplayerattacktwo.gif";
				playerimages[3] = "Content/player/robotfireplayer/robotfireplayerattackthree.gif";
				playerimages[4] = "Content/player/robotfireplayer/robotfireplayerdefense.gif";
				playerimages[5] = "Content/player/robotfireplayer/robotfireplayeravatar.png";

				playermusic[0] = "Content/player/robotfireplayer/attackone.wav";
				playermusic[1] = "Content/player/robotfireplayer/attacktwo.wav";
				playermusic[2] = "Content/player/robotfireplayer/attackthree.wav";
				playermusic[3] = "Content/player/robotfireplayer/defense.wav";
			}	
			if(event.getSource()==buttonrobottwo){
				Player = new robotwaterplayer();
				roboton=2;
				playerimages[0] = "Content/player/robotwaterplayer/robotwaterplayerfront.gif";
				playerimages[1] = "Content/player/robotwaterplayer/robotwaterplayerattackone.gif";
				playerimages[2] = "Content/player/robotwaterplayer/robotwaterplayerattacktwo.gif";
				playerimages[3] = "Content/player/robotwaterplayer/robotwaterplayerattackthree.gif";
				playerimages[4] = "Content/player/robotwaterplayer/robotwaterplayerdefense.gif";
				playerimages[5] = "Content/player/robotwaterplayer/robotwaterplayeravatar.png";

				playermusic[0] = "Content/player/robotwaterplayer/attackone.wav";
				playermusic[1] = "Content/player/robotwaterplayer/attacktwo.wav";
				playermusic[2] = "Content/player/robotwaterplayer/attackthree.wav";
				playermusic[3] = "Content/player/robotwaterplayer/defense.wav";
			}
			if(event.getSource()==buttonrobotthree){
				Player = new robotplantplayer();
				roboton=3;
				playerimages[0] = "Content/player/robotplantplayer/robotplantplayerfront.gif";
				playerimages[1] = "Content/player/robotplantplayer/robotplantplayerattackone.gif";
				playerimages[2] = "Content/player/robotplantplayer/robotplantplayerattacktwo.gif";
				playerimages[3] = "Content/player/robotplantplayer/robotplantplayerattackthree.gif";
				playerimages[4] = "Content/player/robotplantplayer/robotplantplayerdefense.gif";
				playerimages[5] = "Content/player/robotplantplayer/robotplantplayeravatar.png";

				playermusic[0] = "Content/player/robotplantplayer/attackone.wav";
				playermusic[1] = "Content/player/robotplantplayer/attacktwo.wav";
				playermusic[2] = "Content/player/robotplantplayer/attackthree.wav";
				playermusic[3] = "Content/player/robotplantplayer/defense.wav";
			}
			//ADDING IMAGES (LABELS) TO "ARRAYPLAYERANIMATION"
			for(int i=0; i<5; i++){
				arrayplayeranimation[i] = new JLabel(new ImageIcon(playerimages[i]));
				arrayplayeranimation[i].setBounds(0, 240, 320, 240);
				arrayplayeranimation[i].setVisible(false);
				window.add(arrayplayeranimation[i], new Integer(3));
			}
			//ADDING MUSIC TO PLAYER
			try {
				for(int i =0; i<4; i++){
					arrayplayermusic[i] = AudioSystem.getClip();
		        	arrayplayermusic[i].open(AudioSystem.getAudioInputStream(new File(playermusic[i]))); 
				}      
			} 
			catch(Exception e){
			}
			//CREATE AVATAR
				//LABEL AVATAR PLAYER (IMAGE)
				labelavatarplayer = new JLabel(new ImageIcon(playerimages[5]));
				labelavatarplayer.setBounds(830, 270, 100, 100);
							window.add(labelavatarplayer, new Integer(3));
							labelavatarplayer.setVisible(false);
			//SETTING LIFE BAR 
			labellifebarplayer.setSize(250, 20);
			//SELECT Disabled
			selectenabled(false);
			//INTERFACE Enabled
			interfaceenabled(true);
			//Dependiendo de la escena seleccionada entonces se activa
			if(sceneon==1){
				sceneaenabled(true);
			}
			if(sceneon==2){
				scenebenabled(true);
			}
			if(sceneon==3){
				scenecenabled(true);
			}
		}
	}

	//LISTENER ANIMACIÓN ESCENAS
		//TimerListener Principal, es el motor de todas las batallas
			//Se activa cuando el usuario ejecuta una acción de ataque o defensa
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			//ANIMATION
			//If Player Wins... go to default
				//Si la vida del enemigo es menor o igual a cero
				//El jugador ha ganado la batalla, se settea el contador a 7 para
				//dirigirse al default
				if(Boot[booton].getlife()<=0){
					cont=7;
				}
        		switch(cont){
        	//Attack Animation
        		//Se muestra en el dialogo el ataque elegido por el usuario 
        			//Si se eligió una defensa entonces muestra que el jugador no atacó
        			//Para saberlo se analiza si la variable playerdefense es mayor que cero
        		case 1:
        			if(playerdefense==0){
        		  		textdialog.setText(Player.getname()+" attacked.");		
        			}
        			else{
        				textdialog.setText(Player.getname()+" didn´t attacked");
        			}
        			break;
        	//Life Boot Animation
        		case 2:
        			//Si el jugador atacó
        			if(playerdefense==0){
        				//Si el ataque del jugador es mayor que la defensa del enemigo, se hizo daño
	        			if( (bootdefense - playerattack)<0){
	        				//Se muestra en el dialogo que el enemigo recibió daño
	    					textdialog.setText(Boot[booton].getname()+" is damaged");
	    					//Se settea la vida del enemigo restando el ataque del jugador a la vida.
	    						//Además se suma la defensa del robot (si elije una defensa antes)
	    						//Y se utiliza el método Advantage para proporcionar ventaja o desventaja
	    						//dependiendo de los tipos de robots que se enfrenten.
	    					Boot[booton].setlife(Boot[booton].getlife() - playerattack + bootdefense - Player.advantage(Player.gettype(), Boot[booton].gettype()));
	    					//Se settea la variable de la barra de vida enemigo
	    					bootlifebar = (250.00/ (double) bootfulllife)* Boot[booton].getlife();
	    					//Se settea el tamaño de la barra de vida enemigo
	        				labellifebarboot.setSize( (int) bootlifebar, 20 );
	        				//Se settea el texto de la vida del enemigo
							labellifeboot.setText(Integer.toString(Boot[booton].getlife()));
	    				}
	    				//Si el ataque del jugador es menor que la defensa del enemigo, no se hizo daño
	    				else{
	    					textdialog.setText(Boot[booton].getname()+" didn´t receive damaged");
	    				}
	    				//Se reinicia el valor de la defensa del robot  del ataque del jugador
	    				bootdefense=0;
						playerattack=0;

        			}
        			//Si el jugador se defendió
        			else{
        				textdialog.setText(Boot[booton].getname()+" isn´t damaged");
        			}
        			//Se quitan las animaciones y se regresa a la imágen inicial
        			arrayplayeranimation[1].setVisible(false);
        			arrayplayeranimation[2].setVisible(false);
        			arrayplayeranimation[3].setVisible(false);
        			arrayplayeranimation[4].setVisible(false);
        			arrayplayeranimation[0].setVisible(true);
        			break;
        	//Boot Choose Attack Animation
    			case 3:
    				//Se utiliza el método aiboot para determinar un ataque para el enemigo
    					//Este método depende de la vida del enemigo 
    				bootaction = Boot[booton].aiboot( Boot[booton].getlife() );
    				//Dependiendo de la acción que se haya seleccionado, ésta se ejecuta.
    					//Se muestra el dialogo del ataque seleccionado
    					//Se suma el valor del ataque o defensa a su respectiva variable (bootattack || bootdefense)
    				if(bootaction==1){
    					textdialog.setText(Boot[booton].getname()+" selected "+Boot[booton].getattackone());	
    					bootattack = Boot[booton].attackone();
    				}
    				if(bootaction==2){
    					textdialog.setText(Boot[booton].getname()+" selected "+Boot[booton].getattacktwo());
    					bootattack = Boot[booton].attacktwo();
    				}
    				if(bootaction==3){
    					textdialog.setText(Boot[booton].getname()+" selected "+Boot[booton].getattackthree());
    					bootattack = Boot[booton].attackthree();
    				}
    				if(bootaction==4){
    					textdialog.setText(Boot[booton].getname()+" selected "+Boot[booton].getdefense());
    					bootdefense = Boot[booton].defense();
    				}
    				break;
    		//Boot Attack Animation
    			case 4:
    				//Si el enemigo atacó
    				if(bootaction==1 || bootaction==2 || bootaction==3){
    					//Muestra el dialogo que el enemigo atacó
    					textdialog.setText(Boot[booton].getname()+" attacked");
    					//Se agrega a la variable de ataque la ventaja o desventaja del enemigo sobre el jugador
    					bootattack = bootattack + Boot[booton].advantage(Player.gettype(), Boot[booton].gettype());	
    				}
    				//Si el enemigo se defendió
    				if(bootaction==4){
    					//Muestra el dialogo que el enemigo se defendió
    					textdialog.setText(Boot[booton].getname()+" decided to defend");
    				}
    				//Se quita la animación actual y se muestra la animación de acción
    				arraybootanimation[booton][0].setVisible(false);
    				arraybootanimation[booton][bootaction].setVisible(true);
    				break;
    		//Life Player Animation
    			case 5:
    				//Si la defensa del jugador menos el ataque del enemigo es menor que cero
    				if( (playerdefense- bootattack)<0){
    					//Significa que el jugador recibió daño
    					textdialog.setText(Player.getname()+" is damaged");
    					//Se settea la vida del jugador restando el ataque del enemigo más la defensa del jugador
    					Player.setlife(Player.getlife() - bootattack + playerdefense);
    					//Se settea el texto de la vida del jugador
    					labellifeplayer.setText(Integer.toString(Player.getlife()));
    					//Se settea la variable de la barra de vida del jugador
    					playerlifebar = 250.00/(double)playerfullife* Player.getlife();
    					//Se settea la barra de vida del jugador (ImageIcon-JLabel)
    					if(playerlifebar>=250){
							labellifebarplayer.setSize(250, 20);
						}
						else{
							labellifebarplayer.setSize( (int) playerlifebar, 20);
						}
    				}
    				//Si la defensa del jugador menos el ataque del enemigo no son menores a cero
    				else{
    					//Significa que el jugador no recibió daño
    					textdialog.setText(Player.getname()+" didn´t receive damaged");
    				}
    				//Se quita la animación de acción del enemigo y se activa la inicial
    				arraybootanimation[booton][bootaction].setVisible(false);
    				arraybootanimation[booton][0].setVisible(true);
    				//Se reinicia la variable de ataque del enemigo y de defensa del jugador
    				bootattack=0;
    				playerdefense=0;

    		//Return to Normal
    			case 6:
    				//Se resetea el TImer y se detiene
    				t.restart();
    				t.stop();
    				//La variable contadora del Timer se settea a cero
    				cont=0;
    				//Se activan los componentes de entrada
    				inputenabled(true);
    				//Si la vida del usuario luego del ataque es menor a cero
    				if(Player.getlife()<=0){
    					//Se quitan las animaciones del jugador
	          			arrayplayeranimation[1].setVisible(false);
	        			arrayplayeranimation[2].setVisible(false);
	        			arrayplayeranimation[3].setVisible(false);
	        			arrayplayeranimation[4].setVisible(false);
	        			//Dependiendo de la escena actual, se quita la visibilidad
						if(sceneon==1)
							sceneaenabled(false);
						if(sceneon==2)
							scenebenabled(false);
						if(sceneon==3)
							scenecenabled(false);
						//Se desactivan los componentes de entrada y la interfaz
						interfaceenabled(false);
						inputenabled(false);
						//Se activa el menú de selección de personaje
						selectenabled(true);
						//Se retorna la vida inicial del enemigo 
						Boot[booton].setlife(bootfulllife);
						//Dependiendo de la escena actual entonces se detiene su clip de música
						if(sceneon==1)
							clip1.stop();
						if(sceneon==2)
							clip2.stop();
						if(sceneon==3)
							clip3.stop();
						//Se inicia el clip del menú de selección
						clip0.loop(10);
						//Se inicia el método ChangePlayer (explicado al final) y se envía la
						//variable del robot actual.
						changeplayer(roboton);
					}
    				break;
    		//If Player Wins
    			//Si el jugador gana la batalla
    			default:
    				//Se resetea y detiene el timer
    				t.restart();
    				t.stop();
    				//Se settea el contador a cero
    				cont=0;
    				//Se muestra el dialogo de que se ha derrotado al enemigo actual
    				textdialog.setText("You have defeated "+Boot[booton].getname());
    				//Se quitan las animaciones del jugador
          			arrayplayeranimation[1].setVisible(false);
        			arrayplayeranimation[2].setVisible(false);
        			arrayplayeranimation[3].setVisible(false);
        			arrayplayeranimation[4].setVisible(false);
        			arrayplayeranimation[0].setVisible(true);
        			//Se activan los componentes de entrada del usuario
					interfaceenabled(true);
					//Dependiendo de la escena actual, se quita su visibilidad
					//Se suma uno a la variable booton (enemigo actual) y se activa
					//la visibilidad de la escena siguiente.
					if(sceneon==1){
						sceneaenabled(false);
						booton++;
						scenebenabled(true);
					}
					if(sceneon==2){
						scenebenabled(false);
						booton++;
						scenecenabled(true);
					}
					if(sceneon==3){
						scenecenabled(false);
						interfaceenabled(false);
						creditsenabled(true);
					}
					//Se adquiere el valor de vida completa del siguiente enemigo
					bootfulllife = Boot[booton].getlife();
					//Se suma uno al contadoro de escenas (para saber el nivel actual)
					sceneon++;
    				}
    			cont++;
        }
	}

	//LISTENER MOUSE (ACTIONS BUTTONS INTERFACE)
	private class mouselistener implements MouseListener{	
		//Listener del menú de acciones de la interfaz, ejecuta la acción que el usuario elija	
		public void mouseClicked(MouseEvent event){
			//Si el modeitem es false entonces se ejecutan las acciones de ataque o defensa
			if(modeitem==false){
			//Dependiendo del ataque o defensa que elija el usuario:
				//Se determina si quedan ataques disponibles (son limitados) sino muestra Empty
					//Se desactiva la visibilidad del input (para evitar ingresos)
					//Se inicia la animación (se quita la imagen inicial y se coloca la animacion)
					//Se inicia el clip de sonido correspondiente a la accción
						//Si es ataque se agrega el valor del ataque a la variable playerattack
						//Si es defensa se agrega el valor de la defensa a la variable playerdefense
						//Se inicia el Timer
						//Se resta uno al valor de la acción (ya que son limitadas)
				if(buttona==event.getSource()){
					if(Player.getresattackone()>0){
						inputenabled(false);
						arrayplayeranimation[0].setVisible(false);
						arrayplayermusic[0].setFramePosition(0);
						arrayplayermusic[0].start();
						playerattack = playerattack + Player.attackone();						
						t.start();
						Player.setresattacks(1);
						arrayplayeranimation[1].setVisible(true);
					}
					else{
						textdialog.setText("Empty");
					}
				
				}
				if(buttonb==event.getSource()){	
					if(Player.getresattacktwo()>0){
						inputenabled(false);
						arrayplayeranimation[0].setVisible(false);
						arrayplayermusic[1].setFramePosition(0);
						arrayplayermusic[1].start();
						playerattack = playerattack + Player.attacktwo();		
						t.start();
						Player.setresattacks(2);
						arrayplayeranimation[2].setVisible(true);
					}
					else{
						textdialog.setText("Empty");
					}
				}
				if(buttonc==event.getSource()){
					if(Player.getresattackthree()>0){
						inputenabled(false);
						arrayplayeranimation[0].setVisible(false);
						arrayplayermusic[2].setFramePosition(0);
						arrayplayermusic[2].start();
						playerattack = playerattack + Player.attackthree();
						t.start();
						Player.setresattacks(3);
						arrayplayeranimation[3].setVisible(true);
					}
					else{
						textdialog.setText("Empty");
					}
				}
				if(buttond==event.getSource()){
					if(Player.getresdefense()>0){
						inputenabled(false);
						arrayplayeranimation[0].setVisible(false);
						arrayplayermusic[3].setFramePosition(0);
						arrayplayermusic[3].start();
						playerdefense = Player.defense();
						t.start();
						Player.setresattacks(4);
						arrayplayeranimation[4].setVisible(true);
					}
					else{
						textdialog.setText("Empty");
					}
				}
				if(buttonitem==event.getSource()){
					inputenabled(true);
					buttonitem.setVisible(false);
					arrayplayeranimation[0].setVisible(true);
					buttonactions.setVisible(true);
					modeitem=true;
				}
				//CHEAT CODE: Haciendo click en el area del dialogo donde inicia el texto
				//se activa este truco que aumenta el ataque en 1000 puntos
				if(textdialog==event.getSource() && event.getX()<=20 && event.getX()<=20)
					playerattack = 1000;
			}
			//Si el modeitem es verdadero se ejecutan las acciones de los items
				//Si el item está disponible (es limitado) se ejecuta sino muestra Empty
			else{
				if(buttona==event.getSource()){
					//El item 1 incrementa 150 a la vida del Player
					//Luego settea la barra de vida
					if(Item.getvalitem(1)==true){
						textdialog.setText("Life has increased");
						Player.setlife(Player.getlife()+150);
						labellifeplayer.setText(Integer.toString(Player.getlife()));
						playerlifebar = 250.00/(double)playerfullife*Player.getlife();
						if(playerlifebar>=250){
							labellifebarplayer.setSize(250, 20);
						}
						else{
							labellifebarplayer.setSize( (int) playerlifebar, 20);
						}
						Item.setitemone();
					}
					else{
						textdialog.setText("Empty");
					}
				}
				//El item 2 incrementa el valor del ataque del player por un turno (playerattack)
				if(buttonb==event.getSource()){
					if(Item.getvalitem(2)==true){
						textdialog.setText("Your attack has increased by 100 for one turn");
						playerattack = playerattack + 100;
						Item.setitemtwo();
					}
					else{
						textdialog.setText("Empty");
					}
				}
				//El item 3 incrementa el número de ataques disponibles (utiliza un método de items)
				if(buttonc==event.getSource()){
					if(Item.getvalitem(3)==true){
						textdialog.setText("Your PP for each action has increased");
						Player.itemresattacks();
						Item.setitemthree();
					}
					else{
						textdialog.setText("Empty");
					}
				}
				//El item 4 quita 50 de la vida del boot y las agrega al usuario
					//Se quita la vida, se muestra la animación de la barra de vida gráfica del boot
					//Se agrega la vida, se muestra la animaión de la barra de vida gráfica del player
				if(buttond==event.getSource()){
					if(Item.getvalitem(4)==true){
						textdialog.setText("You have absorved life from the enemy");
							Boot[booton].setlife(Boot[booton].getlife() - 50);
							bootlifebar = (250.00/ (double) bootfulllife)* Boot[booton].getlife();
							labellifeboot.setText(Integer.toString(Boot[booton].getlife()));
	        			labellifebarboot.setSize( (int) bootlifebar, 20 );
						Player.setlife(Player.getlife()+50);
						labellifeplayer.setText(Integer.toString(Player.getlife()));
						playerlifebar = 250.00/(double)playerfullife*Player.getlife();
						if(playerlifebar>=250){
							labellifebarplayer.setSize(250, 20);
						}
						else{
							labellifebarplayer.setSize( (int) playerlifebar, 20);
						}
						Item.setitemfour();
					}
					else{
						textdialog.setText("Empty");
					}
				}
				if(buttonactions==event.getSource()){
					inputenabled(true);
					buttonactions.setVisible(false);
					buttonitem.setVisible(true);
					modeitem=false;
				}
			}
		}
		//Listener del menú de acciones de la interfaz, muestra información sobre la acción
		//que se ejecutará si se hace click	
		public void mouseEntered(MouseEvent event){
			//Si el modeitem es falso entonces se muestra información de las acciones (ataques y defensa)
			if(modeitem==false){
				if(buttona==event.getSource()){
					textdialog.setText(Player.getattackone()+(Player.attackone() + Player.advantage(Player.gettype(),Boot[booton].gettype()))+"\n  PP = "+Player.getresattackone());
				}
				if(buttonb==event.getSource()){
					textdialog.setText(Player.getattacktwo()+(Player.attacktwo() + Player.advantage(Player.gettype(),Boot[booton].gettype()))+"\n   PP = "+Player.getresattacktwo());
				}
				if(buttonc==event.getSource()){
					textdialog.setText(Player.getattackthree()+(Player.attackthree() + Player.advantage(Player.gettype(),Boot[booton].gettype()))+"\n   PP = "+Player.getresattackthree());
				}
				if(buttond==event.getSource()){
					textdialog.setText(Player.getdefense()+Player.defense()+"\n   PP = "+Player.getresdefense());
				}
				if(buttonitem==event.getSource()){
					textdialog.setText("Show your items");
				}
			}
			//Si el modeitem es verdadero entonces se muestra información sobre los items disponibles
			else{
				if(buttona==event.getSource()){
					textdialog.setText(Item.getitemone());
				}
				if(buttonb==event.getSource()){
					textdialog.setText(Item.getitemtwo());
				}
				if(buttonc==event.getSource()){
					textdialog.setText(Item.getitemthree());
				}
				if(buttond==event.getSource()){
					textdialog.setText(Item.getitemfour());
				}
				if(buttonitem==event.getSource()){
					textdialog.setText("Show your actions");
				}
			}
		}
		public void mouseExited(MouseEvent event){
		}
		public void mousePressed(MouseEvent event){
		}
		public void mouseReleased(MouseEvent event){
		}
	}
//-----------------------------------------------------------------------//

//--------------------------ENABLED SCENE--------------------------------//
	//Los siguiente métodos activan o desactivan la visibilidad de los componentes
	//de cada escena así como settear variables y otros.

	//SCENE MENU
	public static void menuenabled(boolean x){
		labelgame.setVisible(x);
		labelscenemenu.setVisible(x);
		buttonplay.setVisible(x);
		buttoncredits.setVisible(x);
		buttonexit.setVisible(x);
		labelgame.setVisible(x);
		labelscenemenu.setVisible(x);
		buttonplay.setVisible(x);
		buttoncredits.setVisible(x);
		buttonexit.setVisible(x);
	}
	//SCENE SELECT
	public static void selectenabled(boolean x){
		labelsceneselect.setVisible(x);	
		labelrobotone.setVisible(x);
		buttonrobotone.setVisible(x);
		labelrobottwo.setVisible(x);
		buttonrobottwo.setVisible(x);
		labelrobotthree.setVisible(x);
		buttonrobotthree.setVisible(x);
		labelselect.setVisible(x);
	}
	//INTERFACE
	public static void interfaceenabled(boolean x){
		labeldialog.setVisible(x);
		labelinformationboot.setVisible(x);
		labelinformationplayer.setVisible(x);
		labelmenu.setVisible(x);
		textdialog.setVisible(x);
		buttona.setVisible(x);
		buttonb.setVisible(x);
		buttonc.setVisible(x);
		buttond.setVisible(x);
		buttonitem.setVisible(x);
		labelnameboot.setVisible(x);
		labeltypeboot.setVisible(x);
		labellifeboot.setVisible(x);
		labellifebarboot.setVisible(x);
		labellifebarbboot.setVisible(x);
		labelnameplayer.setVisible(x);
		labeltypeplayer.setVisible(x);
		labellifeplayer.setVisible(x);
		labellifebarplayer.setVisible(x);
		labellifebarbplayer.setVisible(x);
	}
	//CREDITS
	public static void creditsenabled(boolean x){
		labelscenecredits.setVisible(x);
		labelcredits.setVisible(x);
		textcredits.setVisible(x);

		if(clip3.isRunning()){
			clip3.stop();
		}
		else{
			clip0.stop();
		}
		clip4.loop(10);
	}
	//SCENE A
	public static void sceneaenabled(boolean x){
		labelscenea.setVisible(x);

		textdialog.setText(Boot[booton].getname()+" is a plant robot. High shield but low damage.");

		labelnameboot.setText(Boot[booton].getname());
		labelnameplayer.setText(Player.getname());

		labeltypeboot.setText(Boot[booton].gettype());
		labeltypeplayer.setText(Player.gettype());

		labelavatarplayer.setVisible(x);
		arraybootanimation[booton][5].setVisible(x);

		labellifeplayer.setText(Integer.toString(Player.getlife()));
		labellifeboot.setText(Integer.toString(Boot[booton].getlife()));

		labellifebarboot.setSize(250, 20);

		arraybootanimation[booton][0].setVisible(x);

		arrayplayeranimation[0].setVisible(x);

		clip0.stop();
		clip1.loop(10);
	}

	//SCENE B
	public static void scenebenabled(boolean x){
		labelsceneb.setVisible(x);

		textdialog.setText(Boot[booton].getname()+" is a water robot. High damage but low shield");

		labelnameplayer.setText(Player.getname());
		labeltypeplayer.setText(Player.gettype());

		labelnameboot.setText(Boot[booton].getname());
		labeltypeboot.setText(Boot[booton].gettype());

		labelavatarplayer.setVisible(x);
		arraybootanimation[booton][5].setVisible(x);

		labellifeplayer.setText(Integer.toString(Player.getlife()));
		labellifeboot.setText(Integer.toString(Boot[booton].getlife()));

		arraybootanimation[booton][0].setVisible(x);

		arrayplayeranimation[0].setVisible(x);

		labellifebarboot.setSize(250,20);

		clip0.stop();
		clip1.stop();
		clip2.loop(10);

	}

	//SCENE C
	public static void scenecenabled(boolean x){
		labelscenec.setVisible(x);

		textdialog.setText(Boot[booton].getname()+" is a fire robot. High damage and high shield.\nNo one can stop him. He´s the leader of the War-Bots.");

		labelnameplayer.setText(Player.getname());
		labeltypeplayer.setText(Player.gettype());

		labelnameboot.setText(Boot[booton].getname());
		labeltypeboot.setText(Boot[booton].gettype());

		labelavatarplayer.setVisible(x);
		arraybootanimation[booton][5].setVisible(x);

		labellifeplayer.setText(Integer.toString(Player.getlife()));
		labellifeboot.setText(Integer.toString(Boot[booton].getlife()));

		arraybootanimation[booton][0].setVisible(x);

		arrayplayeranimation[0].setVisible(x);

		labellifebarboot.setSize(250,20);

		clip0.stop();
		clip2.stop();
		clip3.loop(10);
	}
	//SCENE GAME OVER
	public static void gameoverenabled(boolean x){
		labelscenegameover.setVisible(x);
		labelgameover.setVisible(x);
		clip0.stop();
		clip1.stop();
		clip2.stop();
		clip3.stop();
		clip4.stop();
		clipover.loop(10);
	}

	//INPUT CONTROLS
	public static void inputenabled(boolean x){
		buttona.setVisible(x);
		buttonb.setVisible(x);
		buttonc.setVisible(x);
		buttond.setVisible(x);
		buttonitem.setVisible(x);
	}

	//CHANGE PLAYER
		//Método que permite elegir a otro personaje si el jugador fuera derrotado
		//Cambia el tamaño del botón seleccionado a 0 para evitar que se elija el mismo
		//personaje.
		//Si se utilizan todos los personajes y se vuelve a perder entonces el juego termina
		//y se muestra la pantalla de Game Over.
	public static void changeplayer(int x){
		if(x==1){
			buttonrobotone.setSize(0,0);
		}
		if(x==2){
			buttonrobottwo.setSize(0,0);
		}
		if(x==3){
			buttonrobotthree.setSize(0,0);
		}
		if(buttonrobotone.getHeight()==0 && buttonrobottwo.getHeight()==0 && buttonrobotthree.getHeight()==0){
			selectenabled(false);
			gameoverenabled(true);
		}
	}
//-----------------------------------------------------------------------//
}