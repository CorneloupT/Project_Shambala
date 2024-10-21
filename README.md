<H1>BIENVENUE A SHAMBALA</H1>

Le Projet Shambala est un projet de création et de numération d'un jeu de rôle papier portant le même nom et dont je suis l'auteur.
L'objectif est double : améliorer mon savoir faire technique et coder une application pour mes joueurs qui leur donnera, dans un premier temps, une fiche de personnage numérique.
Oui je sais, les puristes préfèrent le crayon et le papier... et moi aussi :)

Mais c'est aussi un defi technique et pratique pour mon métier de développeur JAVA, alliant l'utile à l'agréable.

Voici donc les objectifs que je souhaite atteindre dans ce projet (version 1.0) :
<br>
<br>

<p>----------------------- 1ère PARTIE : Eléments de la fiche personnage ----------------------- </p>
<br>

Creation des différentes partie de la fiche personnage :
  <p>-> Les informations d'un utilisateur : nom, prenom, mail, psuedo, mot de passe, liste de personnage
  <p>-> Les informations civiles du personnage : portrait, nom, prenom, age, ethnie, classe, niveau, expérience globale, expérience de classe et histoire. Lié à des caractéristiques personnels et à un équipement</p>
  <p>-> Les caractéristiques initiales : point de vie / point de vie max, point d'EN* / point d'EN max, points de chance, protection</p>
  <p>-> Les caractéristiques principales : physique, adresse, psychique, volonté et combat</p>
  <p>-> Les sous-caractéristiques : une liste des différentes capacités liée à une caractéristique principale</p>
  <p>-> L'équipement : le casque, les brassards, la cuirrasse, les jambières, les bottes, main gauche et main droite</p>
  <p>-> Les compétences : les joueurs peuvent en choisir 3 parmis une liste</p>
  <p>-> L'inventaire : une liste d'objets divers que possède le joueur</p>
  <p>-> Le lancé de dés : type de dé (D20, D100, D6...) et sa valeur obtenu</p>
  <br>
  <br>

<p>----------------------- 2ème PARTIE : La logique ----------------------- </p>
  <br>

La création d'un personnage nécessite de respecter certaines règles inhérentes au jeu lui-même et à l'application :

Utilisateur : 
  <li>Chaque champ doit être rempli obligatoirement</li>
  <li>l'adresse mail doit être valide</li>
  <li>Le pseudonyme ne doit pas être déjà utilisé</li>
  <li>Mot de passe de 8 caractères minimum, caractères spéciaux acceptées</li>
  <li>Récupération de leur personnages</li>
  <br>
  
Informations personnage :
  <br>
  <li>Le personnage à forcément un nom, écrit avec des caractères alphabétiques</li>
  <li>Le personnage à un niveau global et un niveau de classe à 0 au minimum, il n'y a pas de maximum défini</li>
  <li>Le personnage à une expérience gobla e et une expérience de classe à 0 au minimum, il n'y a pas de maximum défini</li>
  <br>
  
Caractéristique et sous-caratéristique du personnage :
  <li>Les caractéristiques principales (physique, adresse, psychique, volonté et combat) ont des valeurs comprises entre 10 et 50, divisible par 5 (15, 20, 25...)</li>
  <li>Il y a 150 points à répartir entre les 5 caractéristiques principale</li>
  <li>Chaque caractéristiques principale possède 4 sous-caractéristiques choisies au travers d'une liste</li>
  <li>Les sous-caractéristiques ont des valeurs comprises entre 5 et 30, divisible par 5 (15, 20, 25...)</li>
  <li>Il y a 300 points à répartir entre les 20 sous-caractéristiques principale</li>
  <li>Les sous-caratéristique comportent un type qui les relie à une caratéristique principale spécifique (ex : endurance = physique, erudtion = psychique)</li>
  <br>
  
Equipement :
  <li>Le personnage possède un équipement modifiable</li>
  <li>Quand une arme à deux main est équipé, on ne peut pas équiper d'autres armes</li>
  <li>Un seul équipement par emplacement</li>
  <br>

compétences :
  <li>3 compétences aux choix parmis une liste</li>
  <li>Pas de compétence ne double</li>

inventaire :
  <li>Accès à la liste d'objet du sac</li>

Lancé de dés :
  <li>Le lancé de dé est un évènement au résultat aléatoire en fonction du dé (ex : 1D100 = chiffre entre 1 et 100)</li>
  <li>Lancé de dé réussi : valeur du dé inférieur caratéristique principale + sous-caractéristique</li>
  <li>Lancé de dé réussi : valeur du dé inférieur caratéristique principale + sous-caractéristique et la valeur est en dessous ou égale à 5</li>
  <li>Lancé de dé réussi : valeur du dé supérieur caratéristique principale + sous-caractéristique</li>
  <li>Lancé de dé réussi : valeur du dé supérieur caratéristique principale + sous-caractéristique et la valeur est en dessous ou égale à 96</li>

 <br>
  <br>

<p>----------------------- 3ème PARTIE : Intégration de la base de donnée ----------------------- </p>
  <br>

  *EN = Ethernano, comparable aux point de magie de mon univers
