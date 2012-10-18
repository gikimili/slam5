public class Main {

	public static void main(String[] args) {	
		int saisie;
		do{
																				/**
																				 * \brief On va demander de choisir quel action va être effectué
																				 */
			System.out.println("Que voulez vous faire ?");
			System.out.println(	"-> 1 Clients");
			System.out.println(	"-> 2 Articles");
			System.out.println(	"-> 3 Commandes");
			System.out.println(	"-> 0 Quitter");
			saisie  = Lire.i();
			switch(saisie){
			
			case 1: 	
																				/**
																				 * \brief En appuyant sur 1, cela va permettre d'accéder à gestion des clients
																				 */
				gestionClient cli = new gestionClient();
						cli.Client();
						break;
						
			case 2: 	
																				/**
																				 * \brief En appuyant sur 2, cela va permettre d'accéder à gestion des articles
																				 */
				gestionArticle art = new gestionArticle();
						art.Article();
						break;
						
			case 3:	
																				/**
																				 * \brief En appuyant sur 3, cela va permettre d'accéder à gestion des commandes
																				 */
				gestionCommande com = new gestionCommande();
						com.Commande();
						break;
	
						
			case 0: 
																				/**
																				 * \brief En appuyant sur 0, cela va permettre de fermer le programme
																				 */
				System.out.println("Enrevoir");
						break;
			
			default:  System.out.println("Erreur dans le choix");break;
																				/**
																				 * \brief Marque erreur si la saisie du nombre n'est pas bon
																				 */
			}
		}while(saisie!=0);
	}
		
}
