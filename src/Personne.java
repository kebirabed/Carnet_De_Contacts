public class Personne
{
	private String nom;
	private String tel;
	private String email;
	private String groupe;

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setGroupe(String groupe)
	{
		if (( (groupe.equals("Amis"))) || (groupe.equals("Famille")) || (groupe.equals("Collegues")) || (groupe.equals("Favoris")))
		{
			this.groupe = groupe;
		}
		else
		{
			this.groupe = null;
		}
	}

	public String getNom()
	{
		return nom;
	}

	public String getTel()
	{
		return tel;
	}

	public String getEmail()
	{
		return email;
	}

	public String getGroupe()
	{
		return groupe;
	}

	public void afficherInformations()
	{
		if (getNom() == null & getTel() == null & getEmail() == null & getGroupe() == null)
			System.out.println("Aucune information");
		else
		{
			System.out.println("Nom : " + getNom());
			System.out.println("Téléphone : " + getTel());
			System.out.println("Email : " + getEmail());
			System.out.println("Groupe : " + getGroupe());
		}


	}

	public String toString()
	{
		return ("" + getNom());
	}
}

