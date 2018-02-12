
class Alien{
  /* ======== Attributs ======== */
  Dessin dessinal;
	double PositionX, PositionY;
  int phase;
  int etat;
  boolean invisible;

  	/* ======== Constructeur ======== */
	Alien(double posx,double posy){
    this.dessinal = new Dessin();
    this.PositionX = posx;
    this.PositionY = posy;
    phase = 0;
    etat = 0;
    invisible = false;
    }

	/* ======== Méthodes ======== */
  void evoluehory(double dx){
    this.PositionX+=dx;
  }
  void evoluevert(double dy){
    this.PositionY+=dy;
  }
	Dessin getDessin(){
    this.dessinal.vider();
    if(phase == 0 && etat < 30){
      this.dessinal.ajouteChaine(PositionX, PositionY+4,"▄ ▀▄   ▄▀ ▄ " );
      this.dessinal.ajouteChaine(PositionX, PositionY+3,"█▄███████▄█ " );
      this.dessinal.ajouteChaine(PositionX, PositionY+2,"███▄███▄███ " );
      this.dessinal.ajouteChaine(PositionX, PositionY+1,"▀█████████▀ " );
      this.dessinal.ajouteChaine(PositionX, PositionY,  " ▄▀     ▀▄  " );
      ++etat;
    }
    else if(phase == 0 && etat >= 30){
      this.dessinal.ajouteChaine(PositionX, PositionY+4,"  ▀▄   ▄▀  " );
      this.dessinal.ajouteChaine(PositionX, PositionY+3," ▄█▀███▀█▄ " );
      this.dessinal.ajouteChaine(PositionX, PositionY+2,"█▀███████▀█" );
      this.dessinal.ajouteChaine(PositionX, PositionY+1,"█ █▀▀▀▀▀█ █" );
      this.dessinal.ajouteChaine(PositionX, PositionY,  "   ▀▀ ▀▀   " );
      if (etat == 60){etat = 0;}
      ++etat;
    }
    else if(phase == 1){
      this.dessinal.ajouteChaine(PositionX, PositionY+3,"    ▄▄████▄▄  " );
      this.dessinal.ajouteChaine(PositionX, PositionY+2,"  ▄██████████▄" );
      this.dessinal.ajouteChaine(PositionX, PositionY+1,"▄██▄██▄██▄██▄██▄" );
      this.dessinal.ajouteChaine(PositionX, PositionY,  "  ▀█▀  ▀▀  ▀█▀" );
    }
    else{
      if(invisible == false){
        this.dessinal.ajouteChaine(PositionX, PositionY+10, "          -___________-" );
        this.dessinal.ajouteChaine(PositionX, PositionY+9,  "         (/     _     \\)" );
        this.dessinal.ajouteChaine(PositionX, PositionY+8,  "         /_____(O)_____\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY+7,  "         // / / | \\ \\ \\\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY+6,  "        =================" );
        this.dessinal.ajouteChaine(PositionX, PositionY+5,  "        // / | | | | \\ \\\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY+4,  "       ===================" );
        this.dessinal.ajouteChaine(PositionX, PositionY+3,  "      //// || || || || \\\\\\\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY+2,  "      |||| || || || || ||||" );
        this.dessinal.ajouteChaine(PositionX, PositionY+1,  "     /---___-----------,---\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY,    "     |  /   \\         -o-  |" );
        this.dessinal.ajouteChaine(PositionX, PositionY-1,  "     /  \\___/          '   \\" );
        this.dessinal.ajouteChaine(PositionX, PositionY-2,  "     +---------------------+" );
        this.dessinal.ajouteChaine(PositionX, PositionY-3,  "    /_   __    ___    __   _\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY-4,  "   (__) (__)  (___)  (__) (__)" );
        this.dessinal.ajouteChaine(PositionX, PositionY-5,  "   |_    __    ___    __    _|" );
        this.dessinal.ajouteChaine(PositionX, PositionY-6,  "  (__)  (__)  (___)  (__)  (__)" );
        this.dessinal.ajouteChaine(PositionX, PositionY-7,  "  /_    ___    ___    ___    _\\" );
        this.dessinal.ajouteChaine(PositionX, PositionY-8,  " (__)  (___)  (___)  (___)  (__)" );
        this.dessinal.ajouteChaine(PositionX, PositionY-9,  " |_     ___    ___    ___     _|" );
        this.dessinal.ajouteChaine(PositionX, PositionY-10, "(__)   (___)  (___)  (___)   (__)" );
        this.dessinal.ajouteChaine(PositionX, PositionY-11, "/_______________________________\\" );
      }
      else{
        this.dessinal.ajouteChaine(PositionX, PositionY+10, "          ░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+9,  "         ░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+8,  "         ░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+7,  "         ░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+6,  "        ░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+5,  "        ░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+4,  "       ░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+3,  "      ░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+2,  "      ░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY+1,  "     ░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY,    "     ░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-1,  "     ░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-2,  "     ░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-3,  "    ░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-4,  "   ░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-5,  "   ░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-6,  "  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-7,  "  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-8,  " ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-9,  " ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-10, "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
        this.dessinal.ajouteChaine(PositionX, PositionY-11, "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" );
      }
    }
    this.PositionX = PositionX;
    return this.dessinal;
    // A COMPLETER
	}

  boolean contient(double posx, double posy){
      if(this.phase == 0){
        if(posx > PositionX && posx < PositionX+11 && posy > PositionY && posy < PositionY+4){
          return true;
        }
      }
      else if(this.phase == 1){
        if(posx > PositionX && posx < PositionX+14 && posy > PositionY && posy < PositionY+3){
          return true;
        }
      }
      else if(this.phase >= 2){
        if(!invisible){
          if (posx > PositionX && posx < PositionX+33 && posy > PositionY-11 && posy < PositionY+11 ){
            return true;
          }
        }
      }
    return false;
  }
}
/* Bug DE TYPE SALSA !!!!!

if(this.listeal != null){
  for(Alien al:listeal){
    if(this.i == 200){
      al.evoluevert(-1.5);
      this.i+=1;
    }
    else if (this.i == 400){
      al.evoluevert(-1.5);
      this.i=0;
    }
    else if(this.i>200){
      al.evoluehory(-0.3);
      this.i+=1;
    }
    else{
      al.evoluehory(0.3);
      this.i+=1;
    }
  }
}
*/
/*  DEPLACEMENT NORMAL
else if(!this.listeal.isEmpty()){
  if(this.i == 202){
    for(Alien al:listeal){
      if(this.monscore.score < 100){al.evoluevert(-1.5);}
      else{al.evoluevert(-2);}
    }
    this.i+=1;
  }
  else if (this.i == 402){
    for(Alien al:listeal){
      if(this.monscore.score < 100){al.evoluevert(-1.5);}
      else{al.evoluevert(-2);}
    }
    this.i=0;
  }
  else if(this.i>202){
    for(Alien al:listeal){
      if(this.monscore.score < 100){al.evoluehory(-0.2);}
      else{al.evoluehory(-0.5);}
    }
    this.i+=1;
  }
  else{
    for(Alien al:listeal){
      if(this.monscore.score < 100){al.evoluehory(0.2);}
      else{al.evoluehory(0.5);}
    }
    this.i+=1;
  }
}
  */
