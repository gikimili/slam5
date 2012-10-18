
import java.util.Hashtable;


public class ArticleProduit extends Article {
	private float coutFabrication;
	static float tauxMax = (float) 0.5;
	
	public void saisirArticle(){
		super.saisirArticle();
		System.out.println("Saisir le cout de Fabrication");
		this.coutFabrication = Lire.f();
	}
	
	public void suppresionArticle(String nomArticle, Hashtable<String, Article> leHash){
		super.suppresionArticle(nomArticle, leHash);
	}
	
	public void modifierPrix(float lePrix)
	{
		super.modifierPrix(lePrix);
	}
	
	public void afficherArticle(){
		super.afficherArticle();
		System.out.println("Cout de Fabrication :"+this.getCoutFabri());
	}
	
	public String getNomArticle(){
		return super.getNomArticle();
	}
	
	public float getCoutFabri(){
		return this.coutFabrication;
	}
	
	public void setCoutFabri(float cF){
		coutFabrication = cF;
	}
	
	public float getPrixArt(){
		return super.getPrixArt();
	}
	
	public int getQnt(){
		return super.getQnt();
	}
	
	public void setNomArticle(String nomArticle2){
		super.setNomArticle(nomArticle2);		
	}
	
	public void setPrixArt(float prixAtr){
		super.setPrixArt(prixAtr);	
	}
	
	public void setQutArt(int QutArt){
		super.setQutArt(QutArt);	
	}
	
	public Article rechercheArticle(String nomArticle, Hashtable<String, Article> leHash)
	{
		return super.rechercheArticle(nomArticle, leHash);
	}
	
	//Castaing :Question 3 Coût fabrication inférieur à 50%
	
	public boolean verif(){
		boolean rep=false;
		
		if(coutFabrication<(super.getPrixArt()*tauxMax))
			rep=true;
		
		return rep;
	}
}
