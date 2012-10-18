import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


public class gestionCommande implements Serializable {

	



	public void Commande() {
		
			Hashtable<String,Article> colArticles = new Hashtable<String, Article>();
			Hashtable<String,Commande> colCommande = new Hashtable<String, Commande>();
			ArrayList<Client> colClients = new ArrayList<Client>();
			int saisie ;
			
			try {
			      FileInputStream fichier = new FileInputStream("Clients.txt");
			      ObjectInputStream ois = new ObjectInputStream(fichier);
			      colClients = (ArrayList<Client>) ois.readObject();
			    } 
			    catch (java.io.IOException| ClassNotFoundException e) {
			      e.printStackTrace();
			      colClients = new ArrayList<Client>();
			      
			    }
			
			try{
				FileInputStream fichier = new FileInputStream("Articles.txt");
				ObjectInputStream ois = new ObjectInputStream(fichier);
				colArticles = (Hashtable<String, Article>) ois.readObject();
				ois.close();
				}
			catch (java.io.IOException| ClassNotFoundException e) {
			      e.printStackTrace();
			      colArticles = new Hashtable<String,Article>();
			    }
			
		/*	try{
				FileInputStream fichier = new FileInputStream("Commandes.txt");
				ObjectInputStream ois = new ObjectInputStream(fichier);
				colCommande = (Hashtable<String, Commande>) ois.readObject();
				ois.close();
				}
			catch (java.io.IOException| ClassNotFoundException e) {
			      System.out.println("Pas de commandes ...");
			      colCommande = new Hashtable<String,Commande>();
			    }*/
		
			do{
				System.out.println("Menu :");
				
				 System.out.println("0 quitter");
				
				 System.out.println("1 ajouter");
				
				 System.out.println("2 ajouter article");
				 
				 System.out.println("3 supprimer");
				 
				 System.out.println("4 Recherche commande"); 
				 
				 System.out.println("5 Modifier commande"); 
				 
				 System.out.println("6 liste commande"); 
				 
				
			
				saisie = Lire.i();
				switch(saisie){
				
				case 1: 	
																															/**
																															 * \brief	Permet la création d'une commande
																															 */
				
						System.out.println("Saisissez le nom du client : ");
						
						String nomCl = Lire.S();
						Client cli = null;
						Article art = null;
						
						boolean trouve = false;
						
							for (int i=0; i < colClients.size() && !trouve ; i++){
									if (colClients.get(i).getNomClient().equals(nomCl)){
											cli = colClients.get(i); 
											trouve = true;
									}
							}
							
							
							if (trouve){
								
								System.out.println("Saisissez le nom de l'article :");
								String nomArt = Lire.S();
								
									if (colArticles.containsKey(nomArt)){
										
										art = colArticles.get(nomArt);
										
										System.out.println("Entrez le n° de la commande : ");
										int numCom = Lire.i();
										
										Commande c = new Commande( numCom , cli , art );
										colCommande.put(String.valueOf(c.getNum()),c);
									}
									
									else
										System.out.println("Article non trouvé");
							}
							
							else
					
								System.out.println("Client non trouvé");
							
						break;
				
			
			
							
				case 2: 	
																														/**
																														 * \brief	Permet de modifier une commande
																														 */
					System.out.println("Saisir id commande à modifier");
					Commande commandeajout = new Commande();
					commandeajout = commandeajout.rechercheCommande(Lire.S(), colCommande);
					
					System.out.println("Saisir un autre article:");
					String nomArt = Lire.S();
					
						if (colArticles.containsKey(nomArt)){
							Article leNew = new Article();
							leNew = colArticles.get(nomArt);
							commandeajout.ajouterArticle(leNew);
						}
						
						else
							
							System.out.println("Article non trouvé");
						
				break;
							
				
				
				case 3: 	
																														/**
																														 * \brief	Permet la suppression d'une commande
																														 */
						System.out.println("Saisir id commande à supprimer");
					
						Commande commandesupp = new Commande();
						commandesupp.suppresionCommande(Lire.S(), colCommande);
					break;
				
				
							
							
				case 4:
																														/**
																														 * \brief Permet de modifier une commande
																														 */
					
					System.out.println("Saisir id commande à modifier");
					
					Commande commandemodif = new Commande();
					commandemodif = commandemodif.rechercheCommande(Lire.S(), colCommande);
				
						if(commandemodif==null) 
							System.out.println("Commande introuvable");
						
						else{ 	
							System.out.println("Saisir nouveau id:"); 
							commandemodif.setNum(Lire.i());
							System.out.println("Saisir nouveau Client:");
							Client leClient2 = new Client();
							leClient2 = leClient2.rechercheClient(Lire.S(), colClients);
							commandemodif.setClient(leClient2);
							System.out.println("Modifier Article:");
							Article lArticleChoisi2 = new Article();
							lArticleChoisi2 = lArticleChoisi2.rechercheArticle(Lire.S(), colArticles);
							commandemodif.setArticle(lArticleChoisi2);
							System.out.println("Modification finish");
							}
				
				break;
				
				
				
				case 5: 	
																														/**
																														 * \brief Permet de chercher une commande
																														 */
					System.out.println("Saisir id :");
					Commande idCom = new Commande();
					idCom = idCom.rechercheCommande(Lire.S(), colCommande);
				
						if(idCom==null) 
							System.out.println("Commande non trouvé");
						else 
							idCom.afficherCommande();
				
				break;
				
				
				
				case 6:
																														/**
																														 * \brief Permet d'afficher les commandes																														 */
					Enumeration enumCom = colCommande.elements(); 
						while(enumCom.hasMoreElements()) 
						{ 
							((Commande) enumCom.nextElement()).afficherCommande(); 
						} 
				
				break;
							
				
				
				default:  System.out.println(". . .");
				try{
					FileOutputStream fichierO = new FileOutputStream("Commandes.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fichierO);
					oos.writeObject(colCommande);
					oos.flush();
					oos.close();
					}
				catch(java.io.IOException e){
					e.printStackTrace();
					}
				break;
				}
			}while(saisie!=0);
			
			
			
			
		}
	
	
	
	

	}
