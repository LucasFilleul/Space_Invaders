
class Hud{
  /* ======== Attributs ======== */
  Dessin dessinnombreballe;
  double nombreballe;
  boolean boss;
  int vieboss;
  int mavie;
  	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	Hud(){
    boss = false;
    this.nombreballe = 10;
    this.dessinnombreballe = new Dessin();
    vieboss = 100;
    mavie = 5;
    }

    Dessin getDessin(){
      this.dessinnombreballe.vider();
      if(boss){
        this.dessinnombreballe.ajouteChaine(20, 68,"Balles restantes :");
        for(int nbba=0; nbba < this.nombreballe; ++ nbba){
          this.dessinnombreballe.ajouteChaine(40 + 2 * nbba, 68, " █");
        }
        this.dessinnombreballe.ajouteChaine(2, 66,"Vie Vaisseau :");
        for(int nb = 0; nb < this.mavie; ++nb){
          this.dessinnombreballe.ajouteChaine(16 + 2*nb , 66," █");
        }
        this.dessinnombreballe.ajouteChaine(70, 68,"Pause : 'P'");
        this.dessinnombreballe.ajouteChaine(90, 68,"Vie Boss: (");
        for(int i=0; i<=vieboss;++i){
          this.dessinnombreballe.ajouteChaine(101+ i, 68,"█");
        }
        this.dessinnombreballe.ajouteChaine(200, 68,")");
        return this.dessinnombreballe;
      }
      else{
        this.dessinnombreballe.ajouteChaine(20, 68,"Balles restantes :");
        for(int nbba=0; nbba < this.nombreballe; ++ nbba){
          this.dessinnombreballe.ajouteChaine(40 + 2*nbba, 68, " █");
        }
        this.dessinnombreballe.ajouteChaine(2, 66,"Vie Vaisseau :");
        for(int nb = 0; nb < this.mavie; ++nb){
          this.dessinnombreballe.ajouteChaine(16 + 2*nb, 66," █");
        }
        this.dessinnombreballe.ajouteChaine(70, 68,"Pause : 'P'");
        return this.dessinnombreballe;
  	  }
    }
    void ajoute(){
      if(this.nombreballe < 10){++this.nombreballe;}
    }
    void retire(){
      if(this.nombreballe > 0){--this.nombreballe;}
    }
}
