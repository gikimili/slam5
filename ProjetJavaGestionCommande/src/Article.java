

import java.io.Serializable;
import java.util.Hashtable;


public class Article implements Serializable {
	
	private String nomArticle;
	private float prixUnitaire;
	private int qteStock;
	static int  seuilReap = 10;

		public void saisirArticle(){
			System.out.println("Saisir nom Article:");
			nomArticle = Lire.S();
			System.out.println("Saisir prix:");
			prixUnitaire = Lire.f();
			System.out.println("Saisir quantite:");
			qteStock = Lire.i();
}																								/**
																								*	\brief Permet d'ajouter un article
																								*   \param nomArticle Permet de définir le nom d'un article
																								*   \param prixUnitaire Permet de définir le prix pour l'article
																								*   \param qteStock Permet de définir la quantité pour l'article
																								*/
		
		public void suppresionArticle(String nomArticle, Hashtable<String, Article> leHash){
			try
			{
				
				leHash.remove(nomArticle);
				System.out.println("Suppression de l'article "+nomArticle);
			}
			catch(Exception e)
			{
				System.out.println("Erreur, il nous est impossible de supprimer l'article ");
			}
			
		}																						/**
																								* \brief Permet la suppression d'un article en le recherchant par son nom
																								* \brief Le remove permet de supprimer l'article en question
																								* \brief Si il n'est pas possible de supprimer l'article, un message apparait
																								* \param nomArticle permet de chercher l article
																								* \param leHash 	HashTable ou se situe l'article
																								*/
		
		public void modifierPrix(float lePrix)
		{
			this.setPrixArt(lePrix);
		}																						/** 
		 																						* \brief Permet de modifier le prix d'un article
																								* \param lePrix Le nouveau prix de l'article
																								*/ 
		
		public void afficherArticle(){
			System.out.println("L article : "+this.getNomArticle() + " a pour prix: "+this.getPrixArt()+" Euros et est en quantités :"+this.getQnt());
		}																						/** 
																								* \brief Affiche le nom, le prix et la quantité de l'article
																								*/ 
		
		public String getNomArticle(){
			return this.nomArticle;
		}																						/** 
																								* \return String correspondant au nom d'article
																								*/
		
		public float getPrixArt(){
			return this.prixUnitaire;
		}																						/** 
																								* \return float correspondant au prix d'article
																								*/
		
		public int getQnt(){
			return this.qteStock;
		}																						/** 
																								* \return int correspondant à la quantité d'article.
																								*/
																								
		public void setNomArticle(String nomArticle2){
			this.nomArticle = nomArticle2;		
		}																						/** 
																								* \brief Modifier le nom de l'article 
																								* \param nomArticle2 Le nouveau nom de l'article
																								*/ 
		
		public void setPrixArt(float prixAtr){
			this.prixUnitaire = prixAtr;		
		}																						/** 
																								* \brief Modifier le prix de l'article 
																								* \param prixAtr Le nouveau prix de l'article
																								*/																		
		
		public void setQutArt(int QutArt){
			this.qteStock = QutArt;		
		}																						/** 
																								* \brief Modifier le stock de l'article 
																								* \param QutArt Le nouveau stock de l'article
																								*/	
		
		public Article rechercheArticle(String nomArticle, Hashtable<String, Article> leHash)
		{
			if(leHash.containsKey(nomArticle)){
				Article d = leHash.get(nomArticle);
				return d;
			}
			return null;
		}																						/** 
																								* \brief Permet de rechercher un article en lui precisant un nom et un HashTable 
																								* \param nomArticle Nom de l'article a rechercher
																								* \param leHash Liste ou se situe l'article
																								*/
		
		
		//Castaing : Question 2 Afficher article devant être réapprovisionnés
public boolean comparaison(){
		boolean rep=false;
			
			if(this.getQnt()<seuilReap){
					System.out.println("L'article "+this.getNomArticle()+" a besoin d être réapprovisionné");
			return rep;
			}
			
			return rep;	
}		
			
	}
