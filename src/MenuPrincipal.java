import java.util.Scanner;
public class MenuPrincipal
{

	Scanner intsc = new Scanner(System.in);
	Scanner strsc = new Scanner(System.in);
	Contact carnet = new Contact();

	public void menu()
	{
		System.out.println("Choisissez une action à executer :");

		System.out.println("1) Ajouter un contact");
		System.out.println("2) Modifier un contact");
		System.out.println("3) Supprimer un contact");
		System.out.println("4) Rechercher un contact");
		System.out.println("5) Afficher la liste des contacts");
		System.out.println("6) Afficher un groupe");

		System.out.print("Choix : ");
		int k = intsc.nextInt();
		System.out.println("---------------------");

		switch (k)
		{
			case 1 : carnet.ajouterContact();
				break;
			case 2 : carnet.modifierContact();
				break;
			case 3 : carnet.supprimerContact();
				break;
			case 4 : carnet.chercherContact();
				break;
			case 5 : carnet.afficherListe();
				break;
			case 6 :
				{
					String g;
					do
					{
						System.out.println("Nom du groupe : ");
						g = strsc.next();
					}while ( !(g.equals("Amis")) && !(g.equals("Famille")) && !(g.equals("Collegues")) && !(g.equals("Favoris")));

					switch (g)
					{
						case "Amis" : carnet.afficherGroupe("Amis");
							break;
						case "Famille" : carnet.afficherGroupe("Famille");
							break;
						case "Collegues" : carnet.afficherGroupe("Collegues");
							break;
						case "Favoris" : carnet.afficherGroupe("Favoris");
							break;
					}
				}
				break;
			default : menu();
		}

		System.out.println();
		menu();
	}
}
