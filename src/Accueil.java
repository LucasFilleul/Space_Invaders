// CLASSE DONNEE AUX ETUDIANTS
// A COMPLETER
import java.util.ArrayList;


class Accueil{
	/* ======== Attributs ======== */
	Dessin acc;
  int posx;
  int posy;

	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	Accueil(){
		acc = new Dessin();
    posx = 55;
		posy = 30;
		}

	/* ======== Getteurs ======== */
	int getLargeur(){ return 200; } /* MODIF PERSO*/
	int getHauteur(){ return 70; } /* MODIF PERSO*/


	// ATTENTION - la méthode getDessin() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette
	// méthode au risque de saturer rapidement la mémoire
	Dessin getDessin(){
		// A COMPLETER
		this.acc.vider();
		this.acc.ajouteChaine(posx+26, posy+1, "            Space invaders            ");
		this.acc.ajouteChaine(posx+26, posy,   "  Pour commencer à jouer appuiez sur  ");
		this.acc.ajouteChaine(posx+26, posy-1, "               Entrée !               ");
		this.acc.ajouteChaine(180, 2,          "             © Lukasplop!             ");
		return this.acc;
		}

    // public static void main(String[] args) {
    //     Application.launch(Vue.class,args);
    //   }


}
