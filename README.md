# Rendu de projet

# JakartaEE


- Rendu de projet
- JakartaEE
- Introduction
   - Problématique
      - Rôle fonctionnel du projet
- Hypothèses
- Organisation du projet
- Diagramme de classe du métier
- Technologies Utilisées
- Architecture de l’application
- Sécurité
   - Stockage des mots de passe
   - Authentification
   - Autorisation
- Difficultés rencontrées
- Bilan


# Introduction

Le tournois de Rolland Garos est un tournoi de tennis international.

## Problématique

Développer une application web de gestion des matchs dans le tournoi Rolland Garos.

Rôle fonctionnel du projet
L’application doit permettre de planifier les matchs et prévoir quels joueurs vont y participer, quel
arbitre va le superviser. Ensuite, il faut pouvoir renseigner les résultats du match (les scores de chaque
équipe). Les visiteurs devront pouvoir consulter les résultats des matchs terminés.


# Hypothèses

Lors de la réalisation de notre projet, nous avons fait plusieurs hypothèses quant au fonctionnement
que nous avons imaginé pour notre application, et afin de garantir la cohérence de cette dernière :

Hypothèse 1 :

Un organisateur définit lui-même si les matchs doubles sont des matchs masculins, féminins ou mixtes
lorsqu’il inscrit les joueurs à un match. C’est à dire que s’il inscrit lors d’un match double un homme et
une femme dans la même équipe, le match est mixte. Pour les matches simples il n’est pas possible
qu’un homme affronte une femme, cependant il n’est pas interdit pour des doubles qu’une équipe de
deux hommes affronte une équipe de deux femmes.

Hypothèse 2 :

Nous avons une seule application pour les journalistes et les organisateurs et non pas deux applications
distinctes. Ainsi nous avons une page d’accueil ainsi qu’une page qui permet de voir les matches
terminés, et les autres actions (comme ajouter des joueurs, planifier des matches, etc) ne sont
accessibles qu’après une connexion (pour en savoir plus sur la sécurité utilisée, référez-vous à la partie
Sécurité du rapport).

Hypothèse 3 :

Nous avons fait l’hypothèse que les matchs pouvaient durer au maximum 4 heures. Nous avons ajouté
une fonctionnalité qui vérifie qu’un cours est libre avant de pouvoir le sélectionner pour un nouveau
match. On peut donc s’assurer que deux matchs différents ne pourront pas être joués aux mêmes
moments sur le même cours. La durée maximale des 4 heures nous permet de mettre une limite afin
de pouvoir sélectionner un cours, même si un match est planifié, mais pas encore terminé 4 heures
avant le début du nouveau match.


# Organisation du projet

Pour réaliser ce projet, nous nous sommes organisés en utilisant la méthode agile.

Au début du projet, nous avons rédiger des récits utilisateurs de l’application suivant :

- En tant que visiteur, je peux consulter les matchs terminés
- En tant qu’organisateur, je peux m’authentifier
- En tant qu’organisateur, je peux ajouter des joueurs
- En tant qu’organisateur, je peux ajouter des arbitres
- En tant qu’organisateur, je peux consulter tous les matchs
- En tant qu’organisateur, je peux créer un cours
- En tant qu’organisateur, je peux planifier un match (assigner une date et un court)
- En tant qu’organisateur, je peux préparer un match (assigner des jours et un arbitre)
- En tant qu’organisateur, je peux résoudre un match (assigner un score aux équipes et une
    durée)

Cela correspond au diagramme de cas d’utilisation suivant :

Nous avons ensuite divisé ces récits utilisateurs en tâches de développement.

Chaque séance correspondait à un sprint : nous faisions une réunion au début de la séance pour
déterminer quelles tâches devraient faire partie du projet. Pour nous faciliter la tâche nous avons
utilisé les outils de gestion de projet intégrés à Github : les Issues, les Pull Request et le tableau Kanban.


Les tâches étaient représentées par des issues, qui peuvent être assignés à un collaborateur.
L’avancement des tâches était suivi en disposant les issues sur le tableau kanban. Lorsqu’un
collaborateur avait terminé une tâche, ils créaient un Pull Request associée, et la soumettait pour une
revue de code.

Le workflow était le suivant :

- S’assigner une tâche depuis le sprint backlog
- La déplacer dans la colonne « en cours » sur le kanban
- Créer une branche pour la tâche
- Ecrire le code nécessaire
- Pousser sa branche et effectue un Pull Request
- Passer la tâche dans la colonne « Fait en attente de Pull Request » sur le kanban
- La personne assignée à la revue de code l’effectue
- La personne assignée à la revue de code accepte la Pull Request ou demande des changements
- Si changement demandés la tâche est replacée dans la colonne « en cours », sinon dans la
    colonne « terminé »


# Diagramme de classe du métier et de Cas d’utilisation

## Use cases analysis

![Use Cases](readme/Use%20Case%20Diagram.png)

## Data Model Analysis

![Data Model](readme/Projet%20JakartaEE%20DC.png)

# Technologies Utilisées

JSTL : Un composant de la plate-forme JEE permettant d’étendre la
spécification JSP en ajoutant une bibliothèque de balises pour les tâches
courantes, comme le travail sur l'exécution conditionnelle, les boucles et
l'internationalisation.

```
MariaDB : Implémentation Open Source du Système de Gestion de
Base de Données Relationnel MySQL.
```
JakartaEE : spécification Open source de Java EE. Nous utilisons notamment JSP, les
conteneurs de servlets, les EJB et JPA.

```
Bootstrap est un framework CSS permettant de facilement implémenter des styles
prédéfinis
```
Wildfly (anciennement JBoss) est un serveur d’application Open source
implémentant la spécification Java EE / Jakarta EE.

```
EJB / Enterprise JavaBeans est une API de composants logiciels coté serveur
permettant d’encapsuler la logique métier des applications d’entreprise.
```
JPA (spécification) / Hibernate (implémentation) est un ORM qui permet de sérialiser
et désérialiser des objets Java (EJB Entity) dans une système de gestion de base de
données relationnel.


# Architecture de l’application

Nous avons utilisé l’architecture dites « Clean Architecture » aussi appelée architecture « en oignon »,
constituée de différentes couches, découplées les unes des autres par des contrats de services décrits
par des interfaces. Quand une requête arrive, elle est d'abord traitée par le contrôleur, pour construire
des objets à partir des données, elle passe ensuite à travers la couche service qui contient la logique
métiers. La couche service fait appelle à la couche repository qui contient les interactions avec la base
de données. La couche repository utilise les classes des Entités du modèle de donnée.

Dans notre nôtre application, chaque couche correspond aux composants suivants :

- Couche présentation : Templates JSP / JSTL
- Couche contrôleurs : Servlets JavaEE
- Couche Service : EJB Sessions implémentant de la logique
- Couche Repository : EJB Session implémentant les interactions base de données
- Couche Domaine / Entité : EJB Entity

Nous avons utilisé la programmation par interface ainsi que le mécanisme d’injection de dépendances
permis par les Entreprise Java Beans afin d’avoir un couplage faible entre les composants de
l’application.


# Sécurité

## Stockage des mots de passe

Nous avons bien fait attention à ne pas stocker les mots de passe utilisateur en clair dans la base de
données. Ainsi, si cette dernière venait à être piraté, les attaquants n’auraient pas accès aux mots de
passes. Nous avons choisi de hacher les mots de passe avec l’algorithme de hachage salée BCrypt, car
il s’agit du standard en la matière. Pour ce faire nous avons importé dans notre projet (via Maven) la
bibliothèque JBCrypt qui implémente l’algorithme en Java.

## Authentification

Dans l’application, la plupart des routes ne doivent être accessibles que par un utilisateur authentifié.
Nous avons donc mis en place une page d’authentification pour authentifier l’utilisateur. Nous utilisons
la session HTTP pour stocker le profil de l’utilisateur authentifié.

## Autorisation

Pour autoriser un utilisateur sur les routes protégé, nous avons mis en place un Filtre HTTP
d’autorisation, qui vérifie si la session HTTP courante contient bien un profile d’utilisateur authentifié.
Si oui, le filtre autorise l’utilisateur, sinon il le redirige vers la page de connexion.


# Difficultés rencontrées

Nous avons commencé l’implémentation du projet en créant les classes métiers (package entities de
notre projet) comme nous les avions définies lors de la modélisation. Nous avons ensuite créé les
classes, et les interfaces, nous permettant d’accéder à la base de données (packages repositories).
Nous avons enfin implémenté la possibilité de s’identifier à notre application tous ensembles afin de
nous mettre d’accord sur certaines conventions pour garder notre projet cohérent.
Une fois ces étapes terminées, nous nous sommes réparti le travail, en donnant à chacun un certain
nombre d’user stories à réaliser, le travail s’est fait ainsi jusqu’à ce que toutes les user stories soient
réalisées.

La plupart des user stories ont pu être réalisées facilement, à l’exception de l’user story : préparer un
match. Lors de notre modélisation initiale de l’application, nous avions mal représenté les liens “many
to many” reliant les joueurs aux matchs, nous ne passions pas par une classe représentant les équipes
(classes participations dans notre projet). Ainsi, lorsque que nous essayions d’ajouter des joueurs à des
matchs lors de la phase de préparation, une exception était lancée et la préparation de match ne se
faisait pas. Après avoir regardé plus en détails le fonctionnement des relation “many to many” nous
avons réalisé qu’il était impossible de faire deux relations de ce type entre les deux mêmes classes (ici
deux relations reliant les joueurs aux matchs, car il y toujours deux équipes) sans passer par une classe
intermédiaire (ici participation) afin de pouvoir associer correctement les joueurs aux matchs. Nous
avons donc dû modifier notre diagramme de classe afin de pouvoir modéliser correctement notre
nouvelle implémentation, ainsi que modifier les classes métiers Matchs et Players et ajouter la classe
participation afin de faire fonctionner parfaitement notre application.

La deuxième difficulté rencontrée ne concernait pas une user story en particulier, mais un problème
d’encodage des données. Après avoir terminé toutes nos user stories, lors de nos différents tests, et
au cours de nos améliorations nous avons remarqué que les accents, normalement supportés par
l’UTF8, n’étaient pas correctement stockés dans la base de données. En effet, tous les caractères à
accent dans la base étaient remplacés sous un autre format. Après avoir regardé sur internet, nous
avons compris que le problème venait de wildfly, et pour le régler nous avons donc dû simplement
changer l’encodage du conteneur de servlet dans la configuration wildfly. Pour ce faire nous avons
simplement dû aller dans la configuration wildfly et modifier les paramètres d’encodage par défaut du
containeur de servlet par UTF-8.

Nous avons aussi rencontré des problèmes avec la gestion du format des dates. Nous utilisons le type
LocalDate (API de date la plus récente en java) dans nos classe métiers, pour stocker la date prévue
d’un match par exemple. Or JSTL ne dispose pas de fonction pour formater ce type de dates, car il
utilise encore l’ancienne API Date de Java. Nous avons donc dû réaliser un formatage à la main dans
les pages JSP qui affichaient des dates (vous pouvez aller voir ce formatage dans la page
consultMatches.jsp par exemple).

Une fois ces difficultés surmontées, nous avons pu nous concentrer sur l’amélioration de notre
application et régler des bugs mineurs.


# Bilan

Pendant ce projet, nous avons été initiés au développement d’application d’entreprise avec Jakarta
EE. Bien que certains d’entre avaient déjà de l’expérience sur du développement côté serveur, ce
projet a été pour l’occasion de nous approprier les standards de développement de la plateforme

## JakartaEE

Nous avons notamment pu monter en compétence sur la technologie ORM JPA qui offre une API très
riche est puissante. Certains mécanismes comme les relations « many to many » nous ont donné des
difficultés mais nous avons sur les surmonter.

Enfin, l’aspect collaboratif de ce projet fait partie de ses points forts. En effet, la motivation mutuelle
est un moteur puissant qui permet de surmonter tout type de difficulté. Cela nous a également donné
l’occasion d’appliquer les compétences de gestion de projet agiles acquises dans d’autres modules,
afin de collaborer de la façon la plus efficace possible.


