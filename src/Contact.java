import java.util.Arrays;
import java.util.Scanner;

public class Contact
{
	static int nombreContact = -1;
	static Personne listeContact[] = new Personne[20];
	Scanner strsc = new Scanner(System.in);
	Scanner intsc = new Scanner(System.in);

	public void ajouterContact()
	{
		nombreContact++;
		listeContact[nombreContact] = new Personne();

		System.out.print("Nom du contact : ");
		listeContact[nombreContact].setNom(strsc.nextLine());

		System.out.print("Numéro de téléphone : ");
		listeContact[nombreContact].setTel(strsc.nextLine());

		System.out.print("Adresse email : ");
		listeContact[nombreContact].setEmail(strsc.nextLine());

		System.out.print("Groupe (Amis, Famille, Collegues, Favoris): ");
		listeContact[nombreContact].setGroupe(strsc.nextLine());
		while (listeContact[nombreContact].getGroupe()==null)
		{
			System.out.print("Le nom du groupe doit être (Amis, Famille, Collegues ou Favoris) : ");
			listeContact[nombreContact].setGroupe(strsc.nextLine());
		}

		System.out.println("-----");
	}

	public void modifierContact()
	{
		System.out.println("Quel contact voulez-vous modifier?");
		int k = intsc.nextInt();

		if ((k-1<=nombreContact) & (k>0))
		{
			System.out.print("Nouveau nom : ");
			listeContact[k-1].setNom(strsc.nextLine());

			System.out.print("Nouveau numéro : ");
			listeContact[k-1].setTel(strsc.nextLine());

			System.out.print("Nouvelle adresse email : ");
			listeContact[k-1].setEmail(strsc.nextLine());

			System.out.print("Nouveau groupe : ");
			listeContact[k-1].setGroupe(strsc.nextLine());
			while (listeContact[k-1].getGroupe()==null)
			{
				System.out.print("Le nom du groupe doit être (Amis, Famille, Collegues ou Favoris) : ");
				listeContact[k-1].setGroupe(strsc.nextLine());
			}
		}


		System.out.println("-----");
	}

	public void supprimerContact()
	{
		System.out.println("Quel contact voulez-vous supprimer?");
		int k = intsc.nextInt();

		if ((k-1<=nombreContact) & (k>0))
		{
			for (int i = k-1; i <= nombreContact; i++)
			{
				listeContact[i]=listeContact[i+1];
			}

			nombreContact--;
		}

		System.out.println("-----");
	}

	public void chercherContact()
	{
		if (nombreContact==-1)
		{
			System.out.println("La liste de contact est vide.");
		}
		else
		{
			boolean contactExiste = false;

			System.out.println("Quel contact recherchez-vous ?");
			String nomRecherche= strsc.nextLine();

			for (int i = 0; i <= nombreContact; i++)
			{
				if (listeContact[i].getNom().equals(nomRecherche))
				{
					System.out.println((i+1) + " |------------------");
					listeContact[i].afficherInformations();
					contactExiste = true;
				}
			}

			if (!contactExiste)
			{
				System.out.println("Aucun contact du nom de " + nomRecherche);
			}
		}
	}

	public void afficherListe()
	{
		if (nombreContact==-1)
			System.out.println("La liste de contact est vide.");
		else
		{
			Arrays.sort(listeContact);

			for (int i = 0; i <= nombreContact; i++)
			{
				System.out.println((i+1) + " |------------------");
				listeContact[i].afficherInformations();
			}
		}
	}

	public void afficherGroupe (String g)
	{
		boolean groupeExiste = false;

		if (nombreContact==-1 || g==null)
			System.out.println("La liste de contact est vide.");
		else
		{
			switch (g)
			{
				case "Famille" :
				{
					for (int i = 0; i <= nombreContact; i++)
					{
						System.out.println("Ma " + g);

						if (listeContact[i].getGroupe().equals(g))
						{
							System.out.println((i+1) + " |------------------");
							listeContact[i].afficherInformations();
							groupeExiste = true;
						}
					}

					if (!groupeExiste)
					{
						System.out.println("Aucun contact dans votre famille");
					}
				}	break;
				default :
				{
					for (int i = 0; i <= nombreContact; i++)
					{
						System.out.println("Mes " + g);

						if (listeContact[i].getGroupe().equals(g))
						{
							System.out.println((i+1) + " |------------------");
							listeContact[i].afficherInformations();
							groupeExiste = true;
						}
					}

					if (!groupeExiste)
					{
						System.out.println("Aucun contact ne figure parmis vos " + g.toLowerCase() + ".");
					}	break;
				}
			}
		}
	}

}
