import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;



public class Commande implements Serializable{
	private int numCom;
	private Client leClient;
	private Article lArticle;
	private ArrayList<Article> laCommande;

	public Commande(int id, Client cl, Article arti){
		this.numCom = id;
		this.leClient = cl;
		laCommande = new ArrayList<Article>();
		laCommande.add(arti);
	}
	
																																										/**
																																										*	\brief Permet de créer une commande avec un id, un nom client et un article
																																										*/

	public Commande() {
		// TODO Auto-generated constructor stub
	}



	public void afficherCommande(){
		System.out.print("La commande numéro : " + this.getNum()+" a pour client : <<" + this.leClient.getNomClient()+">> et pour produit: "+this.getArticle()+"\n");
	}
																																										/**
																																										*	\brief Permet d'afficher le récapitulatif de la commande
																																										*/

	public int getNum(){
		return this.numCom;
	}
	
																																										/**
																																										*	\brief Permet de retourner l'id
																																										*/
	public void setNum(int nouveauNum){
		this.numCom = nouveauNum;
	}
																																										/**
																																										*	\brief Permet de donner un id à une commande existant
																																										*/

	public Client getClient(){
		return this.leClient;
	}
																																										/**
																																										*	\brief Permet de retourner un client
																																										*/
	public void setClient(Client nouvClient){
		this.leClient = nouvClient;
	}
																																										/**
																																										*	\brief Permet de donner un nouveau nom à un client existant
																																										*/
	public void setArticle(Article nouvArticle){
		this.lArticle = nouvArticle;
	}
	
																																										/**
																																										*	\brief Permet de donner un nouveau nom à un article existant
																																										*/
	public Article getArticle(){
		return this.lArticle;
	}
																																										/**
																																										*	\brief Permet de retourner le nom d'un article
																																										*/
	public Commande rechercheCommande(String numComm, Hashtable<String, Commande> leHash)
	{
		if(leHash.containsKey(numComm)){
			Commande d = leHash.get(numComm);
			return d;
		}
		return null;
	}
	
																																										/**
																																										*	\brief Permet de rechercher une commande par rapport à son id
																																										*/
	public void suppresionCommande(String numComm, Hashtable<String, Commande> leHash){
		try
		{
			leHash.remove(numComm);
			System.out.println("Suppression de la commande numéro "+numComm);
		}
		catch(Exception e)
		{
			System.out.println("Erreur, il nous est impossible de supprimer la commande");
		}
		
	}					
	
																																										/**
																																										*	\brief Permet de supprimer une commande par rapport à son id
																																										*/
	public void ajouterArticle(Article unArticle)
	{
		laCommande.add(unArticle);
	}
																																										/**
																																										*	\brief Permet de rajouter un article dans une commande
																																										*/
}
