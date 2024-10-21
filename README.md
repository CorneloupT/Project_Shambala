<H1>BIENVENUE À SHAMBALA</H1>

Le Projet Shambala est un projet de création et de numérisation d'un jeu de rôle papier portant le même nom, dont je suis l'auteur.
L'objectif est double : améliorer mon savoir-faire technique et coder une application pour mes joueurs, qui leur fournira, dans un premier temps, une fiche de personnage numérique.
Oui, je sais, les puristes préfèrent le crayon et le papier... et moi aussi :)
Mais c'est aussi un défi technique et pratique pour mon métier de développeur JAVA, alliant l'utile à l'agréable.

Voici donc les objectifs que je souhaite atteindre dans ce projet (version 1.0) :
<br> 
<br> 
<h2>----------------------- 1ère PARTIE : Éléments de la fiche personnage ----------------------- </h2> 
<br>

Création des différentes parties de la fiche personnage :
<p>-> Les informations d'un utilisateur : nom, prénom, mail, pseudo, mot de passe, liste de personnages.</p> 
<p>-> Les informations civiles du personnage : portrait, nom, prénom, âge, ethnie, classe, niveau, expérience globale, expérience de classe et histoire. Lié à des caractéristiques personnelles et à un équipement.</p> 
<p>-> Les caractéristiques initiales : points de vie / points de vie max, points d'EN* / points d'EN max, points de chance, protection.</p> 
<p>-> Les caractéristiques principales : physique, adresse, psychique, volonté et combat.</p> 
<p>-> Les sous-caractéristiques : une liste des différentes capacités liées à une caractéristique principale.</p> 
<p>-> L'équipement : le casque, les brassards, la cuirasse, les jambières, les bottes, main gauche et main droite.</p> 
<p>-> Les compétences : les joueurs peuvent en choisir 3 parmi une liste.</p> 
<p>-> L'inventaire : une liste d'objets divers que possède le joueur.</p> 
<p>-> Le lancé de dés : type de dé (D20, D100, D6...) et sa valeur obtenue.</p> 
<br> 
<br> 
*EN = Ethernano, comparable aux points de magie dans mon univers. 

<h2>----------------------- 2ème PARTIE : La logique ----------------------- </h2> 
<br>

La création d'un personnage nécessite de respecter certaines règles inhérentes au jeu lui-même et à l'application :

Utilisateur :
<li>Chaque champ doit être rempli obligatoirement.</li> 
<li>L'adresse mail doit être valide.</li> 
<li>Le pseudonyme ne doit pas être déjà utilisé.</li> 
<li>Mot de passe de 8 caractères minimum, caractères spéciaux acceptés.</li> 
<li>Récupération de leurs personnages.</li> 
<br>

Informations du personnage : 
<br>
<li>Le personnage a forcément un nom, écrit avec des caractères alphabétiques.</li> 
<li>Le personnage a un niveau global et un niveau de classe de 0 au minimum, sans maximum défini.</li> 
<li>Le personnage a une expérience globale et une expérience de classe de 0 au minimum, sans maximum défini.</li>
<br>

Caractéristiques et sous-caractéristiques du personnage :

<li>Les caractéristiques principales (physique, adresse, psychique, volonté et combat) ont des valeurs comprises entre 10 et 50, divisibles par 5 (15, 20, 25...).</li> 
<li>Il y a 150 points à répartir entre les 5 caractéristiques principales.</li> 
<li>Chaque caractéristique principale possède 4 sous-caractéristiques choisies à partir d'une liste.</li> 
<li>Les sous-caractéristiques ont des valeurs comprises entre 5 et 30, divisibles par 5 (15, 20, 25...).</li> 
<li>Il y a 300 points à répartir entre les 20 sous-caractéristiques principales.</li> 
<li>Les sous-caractéristiques comportent un type qui les relie à une caractéristique principale spécifique (ex : endurance = physique, érudition = psychique).</li> 
<br>

Équipement :
<li>Le personnage possède un équipement modifiable.</li> 
<li>Quand une arme à deux mains est équipée, on ne peut pas équiper d'autres armes.</li> 
<li>Un seul équipement par emplacement.</li> 
<br>

Compétences :
<li>3 compétences au choix parmi une liste.</li> 
<li>Pas de compétence en double.</li> 
<br>

Inventaire :
<li>Accès à la liste d'objets du sac.</li> 
<br>

Lancé de dés :
<li>Le lancé de dé est un événement au résultat aléatoire en fonction du dé (ex : 1D100 = chiffre entre 1 et 100).</li> 
<li>Lancé de dé réussi : valeur du dé inférieure à la caractéristique principale + sous-caractéristique.</li> 
<li>Lancé de dé réussi avec bonus : valeur du dé inférieure à la caractéristique principale + sous-caractéristique, et la valeur est en dessous ou égale à 5.</li> 
<li>Lancé de dé échoué : valeur du dé supérieure à la caractéristique principale + sous-caractéristique.</li> 
<li>Lancé de dé échoué avec malus : valeur du dé supérieure à la caractéristique principale + sous-caractéristique, et la valeur est en dessous ou égale à 96.</li> 
<br> 
<br> 
<h2>----------------------- 3ème PARTIE : Intégration de la base de données ----------------------- </h2> 
<br>
