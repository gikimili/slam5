

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;


public class gestionArticle implements Serializable {
	public void Article() {
		Hashtable<String,Article> colArticles = new Hashtable<String, Article>() ;
		int saisie ;
		
		try{
			FileInputStream fichier = new FileInputStream("Articles.txt");
			ObjectInputStream ois = new ObjectInputStream(fichier);
			colArticles = (Hashtable<String, Article>) ois.readObject();
			ois.close();
			}
		catch (java.io.IOException| ClassNotFoundException e) {
				System.out.println("Impossible de charger le fichier, création d'un nouveau...");
		     	 colArticles = new Hashtable<String,Article>();
		    }
		
		do{
				System.out.println("Menu :");
			
				System.out.println("0 quitter");/* Permet de quitter le programme */
			
			 	System.out.println("1 ajouter");/* Permet d'ajouter un client dans le arraylist */
			
			 	System.out.println("2 supprimer");/* Permet de supprimer un client dans le arraylist */
			 
			 	System.out.println("3 Recherche d'un article"); /*Permet de rechercher un client */
			 
			 	System.out.println("4 Modifier prix unitaire article"); /*Permet de modifier un client */
			 
			 	System.out.println("5 liste des articles"); /*Permet d'afficher tout les clients */
			 	
			 	System.out.println("6 Réapprovisonné un article");
			 	
			 	System.out.println("7 Liste des articles à réapprovisionner");
			saisie = Lire.i();
			
		switch(saisie){
			
			case 1: 
																																		/**
																																		 * \brief	Permet d'ajouter un article 
																																		 */
						Article a = new Article(); 
							a.saisirArticle();
							colArticles.put(a.getNomArticle(),a);
						break;
						
			case 2: 	
																																		/**
																																		 * \brief	Permet de supprimer un article
																																		 */
						System.out.println("Saisir nom article à supprimer");
							Article artis = new Article();
							artis.suppresionArticle(Lire.S(), colArticles);
						break;
						
		
			
			case 3: 
																																		/**
																																		 * \brief	Permet de chercher un article
																																		 */
						System.out.println("Saisir nom :");
							Article artr = new Article();
							artr = artr.rechercheArticle(Lire.S(), colArticles);
						
							if(artr==null) 
								System.out.println("Pas trouvé");
							else 
								artr.afficherArticle();
						
						break;
						
			case 4:
																																		/**
																																		 * \brief	Permet de modifier un article
																																		 */
						System.out.println("Saisir nom article à modifier");
			
							Article artm = new Article();
							artm = artm.rechercheArticle(Lire.S(), colArticles);
			
								if(artm==null) 
									System.out.println("Article introuvable");
								else{ 	
									System.out.println("Saisir nouveau prix:"); artm.setPrixArt(Lire.f()); 
									System.out.println("Prix modifié");
								}
			
						break;
			
			case 5: 	
																																		/**
																																		 * \brief	Permet de modifier un article
																																		 */
						Enumeration enumArt = colArticles.elements(); 
							while(enumArt.hasMoreElements()) 
							{ 
								((Article) enumArt.nextElement()).afficherArticle(); 
							} 
						break;
				//Castaing : Question 1 Enregistrer les arrivées en stock		
			case 6: 
				System.out.println("Veuillez saisir le produit à réapprovisionnés :");
				Article reap = new Article();
				reap = reap.rechercheArticle(Lire.S(), colArticles);
			
				if(reap==null) 
					System.out.println("Pas trouvé");
				else 
					System.out.println("Veuilelz saisir la quantité :");
					reap.setQutArt(Lire.i());
				
				break;
			
				//Castaing : Question 2 Afficher article devant être réapprovisionnés
			case 7:
						
				Collection<String> colKeys= colArticles.keySet();
				
				for (String k:colKeys){
					Article reaprovi= colArticles.get(k);
					if(((Article) reaprovi).comparaison()==true)
								((Article) reaprovi).afficherArticle(); 
							}	
				
					
			
			break;
					
			
			default:  System.out.println(". . .");break;
			}
			
		}while(saisie!=0);
	

		
		
		try{
			FileOutputStream fichierO = new FileOutputStream("Articles.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fichierO);
			oos.writeObject(colArticles);
			oos.flush();
			oos.close();
			}
		catch(java.io.IOException e){
			e.printStackTrace();
			}
	
	}
}
