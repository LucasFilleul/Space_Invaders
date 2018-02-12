// CLASSE DONNEE AUX ETUDIANTS
// A COMPLETER
import java.util.ArrayList;
import javafx.scene.media.AudioClip;
import java.nio.file.Paths;
import java.util.Random;




class GestionJeu{
	/* ======== Attributs ======== */
	Vaisseau monvai;
	ArrayList<Explosion> listeex;
	double PositionX;
	double PositionY;
	ArrayList<Projectile> listeproj;
  Score monscore;
	ArrayList<Alien> listeal;
	Dessin GENERALE;
	int i;
	Hud monhud;
	boolean continuer;
	Dessin perdu;
	double posx;
	double posy;
	boolean pause;
	Dessin unepause;
	double vitessex;
	double vitessey;
	ArrayList<Projectile> listeasupr;
	ArrayList<Projectile> listeprojalien;
	ArrayList<Alien> listeasupprimeralien;
	int phase;
	boolean droite;
	boolean gagner;
	int phasealien;
	int compteur;
	int comptson ;
	AudioClip dalekcourt;
	AudioClip tir;
	AudioClip mamusique;
	AudioClip musiquepause;
	AudioClip clap;
	AudioClip hue;
	int compteurphase1;

	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	GestionJeu(){
		compteurphase1 = 0;
		int comptson = 0;
		clap = new AudioClip(Paths.get("clap.wav").toUri().toString());
		hue = new AudioClip(Paths.get("hue.wav").toUri().toString());
		hue.setVolume(0.5);
		hue.setCycleCount(1);
		clap.setCycleCount(1);
		mamusique = new AudioClip(Paths.get("Tetris_Official_Theme_song_converted.wav").toUri().toString());
		mamusique.setVolume(0.5);
		dalekcourt = new AudioClip(Paths.get("courte.wav").toUri().toString());
		tir = new AudioClip(Paths.get("tir.wav").toUri().toString());
		musiquepause = new AudioClip(Paths.get("musiqueattente.wav").toUri().toString());
		tir.setVolume(0.1);
		dalekcourt.setVolume(2);
		compteur = 0;
		phasealien = 0;
		droite = true;
		gagner = false;
		listeex = new ArrayList<Explosion>();
		phase = 0;
		listeasupr = new ArrayList<Projectile>();
		listeprojalien = new ArrayList<Projectile>();
		vitessex = 1;
		vitessey = 0.75;
		unepause = new Dessin();
		pause = false;
		continuer = true;
		monhud = new Hud();
		i = 0;
		GENERALE = new Dessin();
		listeproj = new ArrayList<Projectile>();
		listeal = new ArrayList<Alien>();
		monvai = new Vaisseau();
		monscore = new Score();
		PositionX = 2;
		PositionY = 0;
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
		if(pause){
			this.unepause = this.GENERALE;
			this.GENERALE.vider();
			this.GENERALE.ajouteChaine(posx, posy+17, "PPPPPPPPPPPPPPPPP                                                                         ");
			this.GENERALE.ajouteChaine(posx, posy+16, "P::::::::::::::::P                                                                        ");
			this.GENERALE.ajouteChaine(posx, posy+15, "P::::::PPPPPP:::::P                                                                       ");
			this.GENERALE.ajouteChaine(posx, posy+14, "PP:::::P     P:::::P                                                                      ");
			this.GENERALE.ajouteChaine(posx, posy+13, "  P::::P     P:::::Paaaaaaaaaaaaa  uuuuuu    uuuuuu      ssssssssss       eeeeeeeeeeee    ");
			this.GENERALE.ajouteChaine(posx, posy+12, "  P::::P     P:::::Pa::::::::::::a u::::u    u::::u    ss::::::::::s    ee::::::::::::ee  ");
			this.GENERALE.ajouteChaine(posx, posy+11, "  P::::PPPPPP:::::P aaaaaaaaa:::::au::::u    u::::u  ss:::::::::::::s  e::::::eeeee:::::ee");
			this.GENERALE.ajouteChaine(posx, posy+10, "  P:::::::::::::PP           a::::au::::u    u::::u  s::::::ssss:::::se::::::e     e:::::e");
			this.GENERALE.ajouteChaine(posx, posy+9, "  P::::PPPPPPPPP      aaaaaaa:::::au::::u    u::::u   s:::::s  ssssss e:::::::eeeee::::::e");
			this.GENERALE.ajouteChaine(posx, posy+8, "  P::::P            aa::::::::::::au::::u    u::::u     s::::::s      e:::::::::::::::::e ");
			this.GENERALE.ajouteChaine(posx, posy+7, "  P::::P           a::::aaaa::::::au::::u    u::::u        s::::::s   e::::::eeeeeeeeeee");
			this.GENERALE.ajouteChaine(posx, posy+6, "  P::::P          a::::a    a:::::au:::::uuuu:::::u  ssssss   s:::::s e:::::::e           ");
			this.GENERALE.ajouteChaine(posx, posy+5, "PP::::::PP        a::::a    a:::::au:::::::::::::::uus:::::ssss::::::se::::::::e          ");
			this.GENERALE.ajouteChaine(posx, posy+4, "P::::::::P        a:::::aaaa::::::a u:::::::::::::::us::::::::::::::s  e::::::::eeeeeeee  ");
			this.GENERALE.ajouteChaine(posx, posy+3, "P::::::::P         a::::::::::aa:::a uu::::::::uu:::u s:::::::::::ss    ee:::::::::::::e  ");
			this.GENERALE.ajouteChaine(posx, posy+2, "PPPPPPPPPP          aaaaaaaaaa  aaaa   uuuuuuuu  uuuu  sssssssssss        eeeeeeeeeeeeee  ");
			return this.GENERALE;
		}
		if(gagner){
			if(this.mamusique.isPlaying()){mamusique.stop();}
			if(this.dalekcourt.isPlaying()){dalekcourt.stop();}
			if(!this.clap.isPlaying()){clap.play();}
			this.unepause = this.GENERALE;
			this.GENERALE.vider();
			this.GENERALE.ajouteChaine(posx+16, posy+9, " .d8888b.         d8888  .d8888b.  888b    888 8888888888 ");
			this.GENERALE.ajouteChaine(posx+16, posy+8, "d88P  Y88b       d88888 d88P  Y88b 8888b   888 888        ");
			this.GENERALE.ajouteChaine(posx+16, posy+7, "888    888      d88P888 888    888 88888b  888 888        ");
			this.GENERALE.ajouteChaine(posx+16, posy+6, "888            d88P 888 888        888Y88b 888 8888888    ");
			this.GENERALE.ajouteChaine(posx+16, posy+5, "888  88888    d88P  888 888  88888 888 Y88b888 888        ");
			this.GENERALE.ajouteChaine(posx+16, posy+4, "888    888   d88P   888 888    888 888  Y88888 888        ");
			this.GENERALE.ajouteChaine(posx+16, posy+3, "Y88b  d88P  d8888888888 Y88b  d88P 888   Y8888 888        ");
			this.GENERALE.ajouteChaine(posx+16, posy+2, " \"Y8888P88 d88P     888  \"Y8888P88 888    Y888 8888888888 ");
			this.GENERALE.ajouteChaine(posx+36, posy,"Ton score : " + this.monscore.score);
			return this.GENERALE;
		}

		else if(continuer){
			if(!this.unepause.listeChaines.isEmpty()){this.GENERALE = this.unepause;}
			this.GENERALE.vider();
			this.GENERALE.ajouteDessin(this.monvai.getDessin());
			this.GENERALE.ajouteDessin(this.monscore.getDessin());
			this.GENERALE.ajouteDessin(this.monhud.getDessin());
			if(!this.listeproj.isEmpty()){
				for(Projectile proj:listeproj){
					this.GENERALE.ajouteDessin(proj.getDessin());
				}
			}
			if(!this.listeprojalien.isEmpty()){
				for(Projectile proj:listeprojalien){
					this.GENERALE.ajouteDessin(proj.getDessin());
			  }
			}
			if(!this.listeal.isEmpty()){
				for(Alien al:listeal){
					this.GENERALE.ajouteDessin(al.getDessin());
				}
			}
			return this.GENERALE;
	 }
	 else{
		 if(this.mamusique.isPlaying()){mamusique.stop();}
		 if(this.dalekcourt.isPlaying()){dalekcourt.stop();}
		 if(!this.hue.isPlaying()){hue.play();}
		 this.posx=38.5;
		 this.posy=35;
		 this.GENERALE.vider();
		 this.GENERALE.ajouteChaine(posx, posy+5, "         _              _                  _   _         _                   _      _          _       _            _      ");
		 this.GENERALE.ajouteChaine(posx, posy+4, "        /\\ \\           / /\\               /\\_\\/\\_\\ _    /\\ \\                /\\ \\   /\\ \\    _ / /\\     /\\ \\         /\\ \\    ");
		 this.GENERALE.ajouteChaine(posx, posy+3, "       /  \\ \\         / /  \\             / / / / //\\_\\ /  \\ \\              /  \\ \\  \\ \\ \\  /_/ / /    /  \\ \\       /  \\ \\   ");
		 this.GENERALE.ajouteChaine(posx, posy+2, "      / /\\ \\_\\       / / /\\ \\           /\\ \\/ \\ \\/ / // /\\ \\ \\            / /\\ \\ \\  \\ \\ \\ \\___\\/    / /\\ \\ \\     / /\\ \\ \\  ");
		 this.GENERALE.ajouteChaine(posx, posy+1, "     / / /\\/_/      / / /\\ \\ \\         /  \\____\\__/ // / /\\ \\_\\  ____    / / /\\ \\ \\ / / /  \\ \\ \\   / / /\\ \\_\\   / / /\\ \\_\\ ");
		 this.GENERALE.ajouteChaine(posx, posy, "    / / / ______   / / /  \\ \\ \\       / /\\/________// /_/_ \\/_//\\____/\\ / / /  \\ \\_\\\\ \\ \\   \\_\\ \\ / /_/_ \\/_/  / / /_/ / / ");
		 this.GENERALE.ajouteChaine(posx, posy-1, "   / / / /\\_____\\ / / /___/ /\\ \\     / / /\\/_// / // /____/\\   \\/____\\// / /   / / / \\ \\ \\  / / // /____/\\    / / /__\\/ /  ");
		 this.GENERALE.ajouteChaine(posx, posy-2, "  / / /  \\/____ // / /_____/ /\\ \\   / / /    / / // /\\____\\/          / / /   / / /   \\ \\ \\/ / // /\\____\\/   / / /_____/   ");
		 this.GENERALE.ajouteChaine(posx, posy-3, " / / /_____/ / // /_________/\\ \\ \\ / / /    / / // / /______         / / /___/ / /     \\ \\ \\/ // / /______  / / /\\ \\ \\     ");
		 this.GENERALE.ajouteChaine(posx, posy-4, "/ / /______\\/ // / /_       __\\ \\_\\\\/_/    / / // / /_______\\       / / /____\\/ /       \\ \\  // / /_______\\/ / /  \\ \\ \\    ");
		 this.GENERALE.ajouteChaine(posx, posy-5, "\\/___________/ \\_\\___\\     /____/_/        \\/_/ \\/__________/       \\/_________/         \\_\\/ \\/__________/\\/_/    \\_\\/    ");
		 this.GENERALE.ajouteChaine(posx+51.5, posy-7,"Ton score : " + this.monscore.score);
		 return this.GENERALE;
	 }
  }
	/* ======== Autres méthodes ======== */


	// ATTENTION - la méthode jouerUnTour() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette
	// méthode au risque de saturer rapidement la mémoire
	void jouerUnTour(){
		if(!this.mamusique.isPlaying() && !pause){mamusique.play();}
		if (phasealien==2){
			if(!listeal.get(0).invisible){
				if(compteur == 40 ||  compteur == 0 || compteur ==80){
					this.listeprojalien.add(new Projectile(listeal.get(0).PositionX + 17 ,listeal.get(0).PositionY, 4));
				}
			  else if(compteur > 80){compteur= 0;}
			  ++compteur;
		  }
			else{
				if(listeprojalien.size() < 8 ){
					this.listeprojalien.add(new Projectile( 194  ,80, 5));
					this.listeprojalien.add(new Projectile( 2 + 13.2 ,100, 5));
					this.listeprojalien.add(new Projectile( 109 + 19.8 ,120, 5));
					this.listeprojalien.add(new Projectile( 80 + 26.4 ,140, 5));
					this.listeprojalien.add(new Projectile( 127 + 26.4 ,160, 5));
					this.listeprojalien.add(new Projectile( 58 + 26.4 ,180, 5));
					this.listeprojalien.add(new Projectile( 160 + 26.4 ,200, 5));
					this.listeprojalien.add(new Projectile( 25 + 26.4 ,220, 5));
				}
			}
			if(comptson == 0 || comptson == 160){dalekcourt.play();}
			else if(comptson > 160){comptson = 0;}
			++comptson;
		}
		int animation = 0;
		if(!gagner){
	/* !!!!! Supprime un Projectile qui sort de l'ecran !!!!! */
			if(this.monscore.score >= 3600){
				this.monvai.numvais = 1;
			}
			if(this.monscore.score >= 7800){
				this.monvai.numvais = 2;
			}
			for(int i = 0; i<listeproj.size();++i){
				if(listeproj.get(i).PositionY > 70){listeproj.remove(listeproj.get(i));this.monhud.ajoute();}
			}
			for(int i = 0; i<listeprojalien.size();++i){
				if(listeprojalien.get(i).PositionY < 0){listeprojalien.remove(listeprojalien.get(i));}
			}
			for(int nb = 0; nb < listeasupr.size(); ++nb){
				  this.listeproj.remove(listeasupr.get(nb));
					this.listeasupr.remove(listeasupr.get(nb));
					this.monhud.ajoute();
					--nb;
			}

	/* !!!!! Lancer un Projectile !!!!! */
			if(!pause){
				for(Projectile projalien:listeprojalien){
					projalien.evoluealien();
				}
				if(!this.listeproj.isEmpty()){
					for(Projectile proj:listeproj){
						proj.evolue();
					}
				}
			}
			if(!pause){
				if (phase>10){
					this.gagner = true;
				}
				else{
					if(this.listeal.isEmpty()){
						if(phase <= 4){
							for(int i=0; i<12; ++i){
								Alien al = new Alien(2 + i*13,60);
								al.phase = 0;
								phasealien = 0;
								this.listeal.add(al);
							}
							for(int i=0; i<12; ++i){
								Alien al = new Alien(2 + i*13,53);
								this.listeal.add(al);
								al.phase = 0;
								phasealien = 0;
							}
						}
						else if(phase >= 4 && phase <= 7 ){
							for(int i=0; i<10; ++i){
								Alien al = new Alien(2 + i*17,60);
								al.phase = 1;
								phasealien = 1;
								this.listeal.add(al);
							}
							for(int i=0; i<10; ++i){
								Alien al = new Alien(2 + i*17,53);
								al.phase = 1;
								phasealien = 1;
								this.listeal.add(al);
							}
						}
						else{
							Alien al = new Alien(84 , 55);
							al.phase = 2;
							phasealien = 2;
							monhud.boss = true;
							this.listeal.add(al);
							this.vitessex=0.2;
							this.vitessey=1.5;
							this.droite = false;
						}
						i = 0;
						this.phase+=1;
						this.vitessex+=0.1;
						this.vitessey+=0.25;
				  }
			  }
		  }
		/* !!!!! Deplacement Aliens !!!!! */
			if(!pause){
				if (adroite() <= getLargeur()-17 && this.droite){
					for (int i=0; i<this.listeal.size(); ++i){
						this.listeal.get(i).evoluehory(this.vitessex);
					}
					if (adroite()>getLargeur()-17){
						this.droite = false;
					}
				}
				else if(adroite()>=getLargeur()-17){
					for (int i=0; i<this.listeal.size(); ++i){
						this.listeal.get(i).evoluevert(-this.vitessey);
						this.listeal.get(i).evoluehory(-this.vitessex);
						this.droite = false;
					}
				}
				else if(adroite()<getLargeur()-17 && !droite){
					for (int i=0; i<this.listeal.size(); ++i){
						this.listeal.get(i).evoluehory(-this.vitessex);
					}
					if (agauche()<=2){
						for (int i=0; i<this.listeal.size(); ++i){
							this.listeal.get(i).evoluevert(-this.vitessey);
						}
					  this.droite = true;
					}
				}
			}
			if (this.droite ==true){for(Alien al:listeal){al.invisible = true;}}
			if(this.droite == false){for(Alien al:listeal){al.invisible = false;}}
		/* COLISIONS ALIEN */
		if(phasealien < 2){
				for(int nb = 0; nb<listeal.size(); ++nb){
					for(int bis= 0; bis<listeproj.size(); ++bis){
						if(listeal.get(nb).contient(listeproj.get(bis).PositionX, listeproj.get(bis).PositionY)){
							listeal.remove(listeal.get(nb));
							listeproj.remove(listeproj.get(bis));
							--nb;
							--bis;
							this.monscore.ajoute(50);
							this.monhud.ajoute();
						}
					}
				}
			}
			else{
				for(int i=0; i<listeproj.size(); ++i){
					if(listeal.get(0).contient(listeproj.get(i).PositionX, listeproj.get(i).PositionY)){
						listeproj.remove(listeproj.get(i));
						--monhud.vieboss;
						--i;
						this.monhud.ajoute();
					}
				}
			for(int nb = 0; nb <listeprojalien.size(); ++nb){
				if(monvai.contient(listeprojalien.get(nb).PositionX, listeprojalien.get(nb).PositionY)){
					listeprojalien.remove(listeprojalien.get(nb));
					monhud.mavie-=1;
					--nb;
			  }
			}
		}
			for(Alien al:listeal){
				if(phasealien ==0){if(al.PositionY < 3){this.continuer = false;}}
				else if(phasealien == 1){if(al.PositionY < 3){this.continuer = false;}}
				else{if(al.PositionY < 13){this.continuer = false;}}
			}
		}
	if(monhud.vieboss == 0){this.gagner = true;this.continuer = false;}
	if(monhud.mavie == 0){this.continuer = false;}
	}


	void toucheEspace(){
		if(pause && continuer){
		  this.pause = false;
			this.musiquepause.stop();
	  	this.mamusique.play();
  	}
		if(continuer){
			if(this.monvai.numvais == 0){
				if(listeproj.size() <10){
					this.listeproj.add(new Projectile(this.monvai.positionCanon() + 7,this.PositionY + 5, 0));
					this.monhud.retire();
					tir.play();
				}
			}
			else if(this.monvai.numvais == 1){
				if(listeproj.size() <20){
					this.listeproj.add(new Projectile(this.monvai.positionCanon() + 5,this.PositionY + 5, 1));
					this.listeproj.add(new Projectile(this.monvai.positionCanon() + 9,this.PositionY + 5, 1));
					this.monhud.retire();
					tir.play();
				}
		  }
			else{
				if(listeproj.size() <10){
					this.listeproj.add(new Projectile(this.monvai.positionCanon() + 6,this.PositionY + 5, 6));
					this.monhud.retire();
					tir.play();
				}
			}
		}
	}
	void toucheDroite(){
		if(pause && continuer){
		  this.pause = false;
			this.musiquepause.stop();
	  	this.mamusique.play();
  	}
		if(this.monvai.i == 0){
			this.monvai.i = 1;}
		else{
			this.monvai.i = 0;}
		if(monvai.PositionX <= 180){
			this.monvai.deplace(3);
		}
	}
	void toucheGauche(){
		if(pause && continuer){
		  this.pause = false;
			this.musiquepause.stop();
	  	this.mamusique.play();
  	}
		if(this.monvai.i == 0){
			this.monvai.i = 1;}
		else{
			this.monvai.i = 0;}
		if(monvai.PositionX >= 1){
			this.monvai.deplace(-3);
		}
	}
	void touchePause(){
	if(!pause && continuer){this.pause = true;this.mamusique.stop();this.musiquepause.play();}
else{this.pause = false;this.mamusique.play();this.musiquepause.stop();}
	}
	double adroite(){
		double max = this.listeal.get(0).PositionX;
		for(int i=0; i<this.listeal.size(); ++i){
			if(this.listeal.get(i).PositionX > max){max = this.listeal.get(i).PositionX;}
	  }
	return max;
  }
	double agauche(){
		double min = this.listeal.get(0).PositionX;
		for(int i=0; i<this.listeal.size(); ++i){
			if(this.listeal.get(i).PositionX < min){min = this.listeal.get(i).PositionX;}
	  }
	return min;
  }
}
