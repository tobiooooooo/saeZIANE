package commandes;


import joueur.Joueur;
import plateau.Plateau;
import verification.VerifierVictoire;

public class GenMoveCommande implements Commande {
    private final Plateau plateau;
    private final Joueur joueur;
    private final char symboleIA;
    private final char symboleAdversaire;

    public GenMoveCommande(Plateau plateau, Joueur joueur, char symboleIA, char symboleAdversaire) {
        this.plateau = plateau;
        this.joueur = joueur;
        this.symboleIA = symboleIA;
        this.symboleAdversaire = symboleAdversaire;
    }

    @Override
    public String executer() {
        try {

            if (!(symboleIA == 'X' || symboleIA == 'O')) {
                return "? invalid color"; }

            String coup = joueur.jouer(plateau, symboleIA, symboleAdversaire);

            if (coup == null || coup.isEmpty()) {
                return "? no valid moves";
            }
            return " "+coup;
        } catch (Exception e) {
            return "? " + e.getMessage();
        }
    }
}
