import java.util.ArrayList;

/**
 * D�claration de la classe client
 */
public class Client {
	/**
	 * \brief       Initialise la classe client
	 * \details    Permet de cr�er la classe client
	 *                  
	 * \param    nomClient  Permet de stocker le nom du client
	 * \param    adrClient Permet de stocker l adresse du client
	 
	 */
	private String nomClient;

	private String adrClient;


	public Client(String nomClient, String adrClient){
		this.nomClient=nomClient;
		this.adrClient=adrClient;
		
	}/**
	 * \brief       Ceci est le constructeur
	 * \details    Ceci permet de d�finir le constructeur du programme
	 * \param    nomClient prend la valeur du nom du client
	 * \param    adrClient prend la valeur de l'adresse du client
	 */
	
	public void saisirClient(){
		
		System.out.println("Veuillez saisir un client : ");
		
		nomClient=Lire.S();
	
		System.out.println("Veuillez saisir l'adresse du client : ");
	
		adrClient=Lire.S();
	
	}/**
	 * \brief       Permet la saisie du client
	 * \details    Permet de demander au client d ecrire le nouveau nom du client ainsi que son adresse
	 * \param   nomClient  Permet de lire le nom qui a �t� rentr� pour le nom du client
	 * \param    adrClient  Permet de lire l'adresse qui a �t� rentr� pour le client
	 */
	
	public String getnomClient(){
		
		return this.nomClient;
	
	}/**
	 * \brief       Retourne nomclient
	 * \details    Permet de retourner le nom du client
	 * \param   nomClient Permet de retourner ce qui a �t� ecrit pour le nom client
	 * \return    Permet de retourner le nom du client
	 */
	public String getadrClient(){
		/**
		 * \brief       Retourne l adresse du client
		 * \details    Permet de retourner l'adresse du client
		 * \param   adrClient Permet de retourner ce qui a �t� ecrit pour l adresse du client
		 * \return    Permet de retourner l'adresse du client
		 */
		return this.adrClient;
		
	}/**
	 * \brief       Retourne l adresse du client
	 * \details    Permet de retourner l'adresse du client
	 * \param   adrClient Permet de retourner ce qui a �t� ecrit pour l adresse du client
	 * \return    Permet de retourner l'adresse du client
	 */
	
	
	public void afficherClient(){
		
		System.out.println("Le client : "+ this.nomClient+" a pour addresse "+this.adrClient);
		
	}/**
	 * \brief       Affiche donn�es
	 * \details    Permet d afficher les dernieres donn�es qui ont �t� rentr� pour un client
	 * \return    Retourne le nom et l adresse du dernier client rentrer
	 */
	
	
	
}


