
class Score{
  /* ======== Attributs ======== */
  Dessin dessinscore;
  double score;
  	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	Score(){
    this.score = 0;
    this.dessinscore = new Dessin();
    }

    Dessin getDessin(){
      this.dessinscore.vider();
      this.dessinscore.ajouteChaine(2, 68,"Score : " + this.score );
      return this.dessinscore;
  	}
    void ajoute(double nb){
      this.score+=nb;
    }
}
