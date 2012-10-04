import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class testClient {
	/**
	 * \brief       Declaration test client
	 * \details    Permet de déclarer la classe test client
	 * \param   ArrayList Permet de rentrer chacun des clients dans un array
	 * \param   nbClients  Permet de créer un compteur pour le nombre des clients
	 */
	
	private static ArrayList<Client>colClients=new ArrayList<Client>();
	
	private static int nbClients;
	
	
	
	public static void ajouterClient(){
		
		colClients.add(null);
		
		nbClients ++;
		
		System.out.println("Ajout ce client réussi");
		
	}/**
	 * \brief       ajouterclient
	 * \details    Permet d ajouter un client dans un arraylist
	 * \param   colClient.Add Permet de rajouter les dernieres données des clients dans un arraylist
	 * \return    Permet de d afficher si le client a bien été rentré
	 */
	
	
	public static void suppressionClient(String n, ArrayList<Client> cl){
	
		System.out.println("Veuillez rentrer le clients à supprimer");
		
		String saisie=Lire.S();
		
		for(int i=0; i<nbClients;i++)
			
			
			if(saisie==colClients.get(i).getnomClient())
				colClients.remove(i);
		
	}	/**
	 * \brief       supression client
	 * \details    Permet de supprimmer un client
	 * \param   Saisie permet de lire quel client l on souhaite supprimer.
	 * \return    Permet de supprimer un client
	 */
	
	public static void modifAdresse(){
	
		System.out.println("Veuillez rentrer le nom du client dont l'addresse est à modifier");
		
		String adresse=Lire.S();
		
		for(int i=0; i<nbClients;i++)
			
			if(adresse==colClients.get(i).getnomClient())
				
				{System.out.println("Veuillez saisir la nouvelle adresse :");
				
				adresse=Lire.S();
				
				}
			else
				
				System.out.println("Erreur");
	
	}	/**
	 * \brief       ModifAdresse
	 * \details    Permet de modifier l adresse  du client
	 * \param   adresse Permet de lire le nom du client que l on souhaite modifier
	 * \param   adresse Permet de lire la nouvelle adresse du client
	 * \return    Permet de modifier si le client est trouvé son adresse
	 */
	
	public static Client rechercheClient(String n, ArrayList<Client> cl){
		
	
		System.out.println("Saisir le nom du client à rechercher : ");
		
		String unNom=Lire.S();
		
		Client cli = rechercheClient(unNom, cl);
		if(cli==null) System.out.println("Client non trouvé");
		else cli.afficherClient();
		return cli;
	}/**
	 * \brief      recherche client
	 * \details   Permet de rechercher un client et afficher les données qui lui son propre
	 * \param  unNom  Permet de lire le nom du client a chercher
	 * \return   Permet d afficher les informations du clients voulu
	 */
	
	public static void listeClient(){
		
		for(Client x:colClients){
		
			x.afficherClient();
			
		}
	}/**
	 * \brief       liste client
	 * \details    Permet d afficher la liste des clients
	 */
	
	
	
	
	public static void main(String[] args)
	{
		Client Client1=new Client("toto","toto");
		
		
		Client1.saisirClient();
		
		Client1.getnomClient();
		
		Client1.getadrClient();
		
		Client1.afficherClient();
		
		int action = 0;
		do{/**
			 * \brief      boucle tant que
			 * \details   Permet de demander à l'utilisateur de rentrer un client ou bien de le supprimer
			 */
			
			 System.out.println("0 quitter");/* Permet de quitter le programme */
			
			 System.out.println("1 ajouter");/* Permet d'ajouter un client dans le arraylist */
			
			 System.out.println("2 supprimer");/* Permet de supprimer un client dans le arraylist */
			
			 
			 switch (action){
			
			 case 1 :  ajouterClient();
			
			 break;
			 case 2: suppressionClient(null, colClients);
			
			 break;
			 }/**
				 * \brief      switch
				 * \details    Permet de proposer des choix au client
				 * \param Case 1  Permet d'appeller l ajout du client
				 * \param Case 2  Permet d'appeller la suppression du client 
				 * \return   Permet de retourner le choix du client
				 */
		}while(action!=0);
	
		
	
		
	
	
	try{
		
		FileOutputStream fichier = new FileOutputStream("client.txt");
	
		ObjectOutputStream oos = new ObjectOutputStream(fichier);
		
		oos.writeObject(Client1);
		
		oos.flush();
		oos.close();
		
	}
	catch(java.io.IOException e){
		
		e.printStackTrace();
	}
	
}
}
