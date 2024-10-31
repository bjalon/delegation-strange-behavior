// Interface de formatage
interface Formatage {
    fun formater(texte: String): String
}

// Stratégie : Formatage en majuscules
object FormatageMajuscule : Formatage {
    override fun formater(texte: String): String {
        return texte.uppercase()
    }
}

// Stratégie : Formatage en minuscules
object FormatageMinuscule : Formatage {
    override fun formater(texte: String): String {
        return texte.lowercase()
    }
}

// Stratégie : Censure d'un mot spécifique
class FormatageCensure(private val motCensure: String) : Formatage {
    override fun formater(texte: String): String {
        return texte.replace(motCensure, "****")
    }
}

// Classe Editeur utilisant un délégué pour le formatage
class Editeur(private var formatage: Formatage) : Formatage by formatage {

    // Méthode pour changer la stratégie de formatage
    fun setFormatage(nouveauFormatage: Formatage) {
        formatage = nouveauFormatage
    }

    // Appliquer le formatage en utilisant le délégué actuel
    fun appliquerFormatage(texte: String): String {
        return formater(texte)
    }
}

// Fonction principale pour tester
fun main() {
    val editeur = Editeur(FormatageMajuscule)
    println(editeur.appliquerFormatage("Bonjour le Monde"))  // BONJOUR LE MONDE

    editeur.setFormatage(FormatageMinuscule)
    println(editeur.appliquerFormatage("Bonjour le Monde"))  // bonjour le monde

    editeur.setFormatage(FormatageCensure("Monde"))
    println(editeur.appliquerFormatage("Bonjour le Monde"))  // Bonjour le ****
}
