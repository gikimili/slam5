
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class gestionClient  implements Serializable{
	public void Client() {
		ArrayList<Client> colClients = new ArrayList<Client>();
		int saisie ;
		
		try {
		      FileInputStream fichier = new FileInputStream("Clients.txt");
		      ObjectInputStream ois = new ObjectInputStream(fichier);
		      colClients = (ArrayList<Client>) ois.readObject();
		    } 
		    catch (java.io.IOException|ClassNotFoundException e) {
		    	System.out.println("Impossible de charger le fichier, création d'un nouveau...");
		    	colClients = new ArrayList<Client>();
		    }

		
		do{
			System.out.println("Menu :");
			
			 System.out.println("0 quitter");/* Permet de quitter le programme */
			
			 System.out.println("1 ajouter");/* Permet d'ajouter un client dans le arraylist */
			
			 System.out.println("2 supprimer");/* Permet de supprimer un client dans le arraylist */
			 
			 System.out.println("3 Recherche client"); /*Permet de rechercher un client */
			 
			 System.out.println("4 Modifier client"); /*Permet de modifier un client */
			 
			 System.out.println("5 liste clients"); /*Permet d'afficher tout les clients */
			
			saisie = Lire.i();
			
		switch(saisie){
			
			case 1: 	
																																/**
																																 * \brief Permet d'ajouter un nouveau client
																																 */
				Client cli = new Client(); 
						cli.saisirClient();
						colClients.add(cli);
				break;
						
			case 2: 	
																																/**
																																 * \brief Permet de supprimer un client
																																 */
				System.out.println("Saisir nom client à supprimer");
						Client clis = new Client();
						clis = clis.rechercheClient(Lire.S(), colClients);
						
						if(clis==null) 
							System.out.println("Client non trouvé");
						else 
							{ 
							colClients.remove(clis); System.out.println("Suppression du client ");
							}
						
						break;
						
			case 3: 	
																																/**
																																 * \brief Permet de chercher un client
																																 */
				System.out.println("Saisir nom :");
				
				Client clir = new Client();
				clir = clir.rechercheClient(Lire.S(), colClients);
				
					if(clir==null) System.out.println("Client non trouvé");
					else clir.afficherClient();
				break;			
				
				
			case 4:
																																/**
																																 * \brief Permet de modifier un client
																																 */
				System.out.println("Saisir nom cient à modifier");
					Client clim = new Client();
					clim = clim.rechercheClient(Lire.S(), colClients);
					
						if(clim==null) System.out.println("Client introuvable");
						else{ System.out.println("Saisir nouvelle adresse:"); clim.modifierClient(Lire.S()); System.out.println("Adresse modifiée");}
						
				break;
			
			
			
			case 5: 	
																																/**
																																 * \brief Permet d'afficher les clients
																																 */
					for(Client x: colClients)
						x.afficherClient();
					
				break;
						
			
			
			default:  System.out.println(". . .");break;
			}
		}while(saisie!=0);
	
		try{
			FileOutputStream fichier = new FileOutputStream("Clients.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(colClients);
			oos.flush();
			oos.close();
		}
		catch(java.io.IOException e){
			e.printStackTrace();
		}
}
}
