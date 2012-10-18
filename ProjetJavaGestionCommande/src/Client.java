
import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
private String nomClient;
private String adrClient;

	public void saisirClient(){
		System.out.println("Saisir nom du Client:");
		nomClient = Lire.S();
		System.out.println("Saisir adresse du Client:");
		adrClient = Lire.S();
	}																						/**
																							*	\brief Permet de saisir  un nouveau client c'est à dire son nom ainsi et son adresse
																							*/
	
	public void suppresionClient(String nomClient, ArrayList<Client> list){
		boolean supp = false;
		for(int i=0; i<list.size();i++){
			if(list.get(i).getNomClient().equalsIgnoreCase(nomClient)){
				list.remove(i);
				supp = true;
				System.out.println("Suppression du client "+nomClient);
			}
		}
		if(supp == false)
			System.out.println("Erreur, suppression impossible");
	}																						/**
	 																						* \brief Permet la suppression d'un client en recherchant son nom
	 																						* \param nomClient 	Trouver le client a supprimer
	 																						* \param list 		Liste ou se situe le client
	 																						*/
	
	
	public void modifierClient(String lAdresse)
	{
		this.setAdrClient(lAdresse);
	}																						/** Modifier l'adresse d'un client 
																							* \param lAdresse La nouvelle adresse
	 																						*/
	
	public void afficherClient(){
		System.out.println("Client :"+this.getNomClient() + "\n Adresse: "+this.getAdrClient());
	}																						/** 
																							* \brief Affiche le nom et l'adresse du client 
																							*/ 
	
	public String getNomClient(){
		return this.nomClient;		
	}																						/** 
	 																						* \return Un \e String representant le nom du client.
																							*/  
																							
	public String getAdrClient(){
		return this.adrClient;
	}																						/** 
																							* \return Un \e String representant l'adresse du Client
																							*/  
	
	public void setNomClient(String nomClient){
		this.nomClient = nomClient;		
	}																						/** 
																							* \brief Modifier le nom du Client 
																							* \param nomClient Le nouveau nom du client
																							*/ 
	
	public void setAdrClient(String adrClient){
		this.adrClient = adrClient;		
	}																						/**
																							* \brief Modifier l'adresse du Client
																							* \param adrClient La nouvelle adresse du client 
																							*/ 
	
	public Client rechercheClient(String unNom, ArrayList<Client> list)
	{
		for(int i=0; i<list.size();i++){
			if(list.get(i).getNomClient().equalsIgnoreCase(unNom)){
				return list.get(i);
			}
		}
		return null;
	}																						/** 
																							* \brief Permet de rechercher un client en lui precisant un nom et un ArrayList 
																							* \param unNom Nom du client a rechercher
																							* \param list Liste ou se situe le client
	 																						*/
}
