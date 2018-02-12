
class Projectile{
  /* ======== Attributs ======== */
  Dessin dessinpro;
	double PositionX, PositionY;
  int numpro;
  boolean boss;


  	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté

  Projectile(double posx,double posy, int numpro){
    this.dessinpro = new Dessin();
    this.PositionX = posx;
    this.PositionY = posy;
    this.numpro = numpro;
    boss = false;
    }

	double positionCanon(){
    return PositionX;
  }
	/* ======== Méthodes ======== */
	void evolue(){
    this.PositionY+=0.5;
	}
  void evoluealien(){
    this.PositionY-=0.5;
  }
	Dessin getDessin(){
    this.dessinpro.vider();
    if(this.numpro == 0){this.dessinpro.ajouteChaine(PositionX, PositionY,"▲" );}
    else if(this.numpro == 1){
      this.dessinpro.ajouteChaine(PositionX, PositionY,"█" );
      this.dessinpro.ajouteChaine(PositionX, PositionY+1,"▲" );
    }
    else if(this.numpro == 4){
      this.dessinpro.ajouteChaine(PositionX, PositionY,"{" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-1,"}" );
    }
    else if(this.numpro == 5){
      this.dessinpro.ajouteChaine(PositionX, PositionY,   "  ▒  " );
      this.dessinpro.ajouteChaine(PositionX, PositionY-1, " ▒▒▒ " );
      this.dessinpro.ajouteChaine(PositionX, PositionY-2, "▒▒▒▒▒" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-3, "█████" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-4, "█████" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-5, "█████" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-6,"\\███/" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-7," \\█/" );
      this.dessinpro.ajouteChaine(PositionX, PositionY-8,"  V  " );
    }
    else{
      this.dessinpro.ajouteChaine(PositionX, PositionY-1,"▒▒▒" );
      this.dessinpro.ajouteChaine(PositionX, PositionY,"███" );
      this.dessinpro.ajouteChaine(PositionX, PositionY+1,".Λ." );
    }
    this.PositionX = PositionX;
    return this.dessinpro;
    // A COMPLETER
	}


}
