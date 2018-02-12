
class Explosion{
  /* ======== Attributs ======== */
  Dessin dessinex;
	double PositionX, PositionY;
  int phase;

  	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	Explosion(double posx,double posy){
    this.dessinex = new Dessin();
    this.PositionX = posx;
    this.PositionY = posy;
    phase = 0;
    }

	/* ======== Méthodes ======== */
	Dessin getDessin(){
    this.dessinex.vider();
    if(phase == 0){
      this.dessinex.ajouteChaine(PositionX, PositionY,  "   ▄    ▄   ▄▄ " );
      this.dessinex.ajouteChaine(PositionX, PositionY+1," ▄   ▄     █   " );
      this.dessinex.ajouteChaine(PositionX, PositionY+2,"  █    ▄▄    ▄  " );
      this.dessinex.ajouteChaine(PositionX, PositionY+3," ▄  ▄   ▄    ▄▄" );
      this.dessinex.ajouteChaine(PositionX, PositionY+4,"▄   ▄       ▄  " );
    }
    else{
      this.dessinex.ajouteChaine(PositionX, PositionY,  "Pas encore fait casse pas les couilles" );
    }
    this.PositionX = PositionX;
    return this.dessinex;
    // A COMPLETER
	}

}
