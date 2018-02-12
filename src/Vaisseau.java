
class Vaisseau{
  /* ======== Attributs ======== */
  Dessin dessinvaisseau;
	double PositionX;
  int i;
  int numvais;
  	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	Vaisseau(){
    int vaisseau = 1;
    this.dessinvaisseau = new Dessin();
    PositionX = 0;
    i= 0;
    }

	double positionCanon(){
    return PositionX;
  }
	/* ======== Méthodes ======== */
	void deplace(double dx){
    this.PositionX+=dx;
	}

  boolean contient(double posx, double posy){
      if(posx > this.PositionX && posx < this.PositionX+21 && posy < 3){
        return true;
      }
      return false;
  }
	Dessin getDessin(){
    this.dessinvaisseau.vider();
    if(numvais == 0){
      if(this.i==0){
        this.dessinvaisseau.ajouteChaine(PositionX, 0,"◥☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲◤");}
      else{
        this.dessinvaisseau.ajouteChaine(PositionX, 0,"◥☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲◤");}
      this.dessinvaisseau.ajouteChaine(PositionX, 1,"I███████████████████]" );
      this.dessinvaisseau.ajouteChaine(PositionX, 2,"▂▄▅█████████▅▄▃▂" );
      this.dessinvaisseau.ajouteChaine(PositionX, 3,"    ███████  " );
      this.dessinvaisseau.ajouteChaine(PositionX, 4,"       █      " );
      this.dessinvaisseau.ajouteChaine(PositionX, 5,"       █      " );
      this.dessinvaisseau.ajouteChaine(PositionX, 6,"       ▃      " );
      this.PositionX = PositionX;
      return this.dessinvaisseau;
    }
    else if(numvais == 1){
      if(this.i==0){
        this.dessinvaisseau.ajouteChaine(PositionX, 0,"◥☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲◤");}
      else{
        this.dessinvaisseau.ajouteChaine(PositionX, 0,"◥☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲◤");}
      this.dessinvaisseau.ajouteChaine(PositionX, 1,"I███████████████████]" );
      this.dessinvaisseau.ajouteChaine(PositionX, 2,"▂▄▅█████████▅▄▃▂" );
      this.dessinvaisseau.ajouteChaine(PositionX, 3,"    ███████  " );
      this.dessinvaisseau.ajouteChaine(PositionX, 4,"     █   █     " );
      this.dessinvaisseau.ajouteChaine(PositionX, 5,"     █   █     " );
      this.dessinvaisseau.ajouteChaine(PositionX, 6,"     ▃   ▃     " );
      this.PositionX = PositionX;
      return this.dessinvaisseau;
    }
    else{
      if(this.i==0){
        this.dessinvaisseau.ajouteChaine(PositionX, 0,"◥☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲◤");}
      else{
        this.dessinvaisseau.ajouteChaine(PositionX, 0,"◥☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲◤");}
      this.dessinvaisseau.ajouteChaine(PositionX, 1,"I███████████████████]" );
      this.dessinvaisseau.ajouteChaine(PositionX, 2,"▂▄▅█████████▅▄▃▂" );
      this.dessinvaisseau.ajouteChaine(PositionX, 3,"    |█████|   " );
      this.dessinvaisseau.ajouteChaine(PositionX, 4,"     |███|     " );
      this.dessinvaisseau.ajouteChaine(PositionX, 5,"     |███|     " );
      this.dessinvaisseau.ajouteChaine(PositionX, 6,"      _ _     " );
      this.PositionX = PositionX;
      return this.dessinvaisseau;
    }
	}
}
