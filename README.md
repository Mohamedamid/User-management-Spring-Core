1️. Spring Core
Spring Core est le noyau du framework Spring.
Il fournit les fonctionnalités de base comme l’Inversion de Contrôle (IoC) et l’Injection de Dépendances (DI)
pour gérer les objets de manière automatique, au lieu que le développeur les crée manuellement.

2️. IoC (Inversion de Contrôle)
L’IoC est un principe selon lequel le contrôle de la création et de la gestion des objets est inversé :
ce n’est plus le développeur qui crée les objets, mais le conteneur Spring.

3️. DI (Dependency Injection)
La DI est le mécanisme par lequel l’IoC est réalisé.
Autrement dit : IoC = principe, DI = mise en œuvre.
Spring injecte les dépendances dans les classes de trois façons :
par constructeur,
par setter,
ou par champ (avec @Autowired).

4️. Bean
Un bean est tout objet géré par le conteneur Spring.
Il est créé, initialisé et détruit par Spring.

5️. Conteneur IoC
Le conteneur IoC est le cœur de Spring, responsable de créer, gérer et fournir les beans.
Il lit la configuration (XML, annotations, Java Config) pour savoir quels objets créer.

6️. BeanFactory vs ApplicationContext
BeanFactory → conteneur de base, crée les beans à la demande (lazy loading).
ApplicationContext → version améliorée, crée les beans au démarrage (eager loading) et ajoute des fonctionnalités comme i18n, événements, AOP, etc.

7️. Les 3 approches de configuration
XML → ancienne méthode, configuration déclarative dans un fichier XML.
Annotations → approche moderne (@Component, @Service, @Repository, …).
Java Config → configuration via des classes Java annotées avec @Configuration.

8️. Les annotations principales
@Configuration → indique qu’une classe contient des définitions de beans.
@ComponentScan → dit à Spring où chercher les composants.
@Bean → déclare un bean à partir d’une méthode.
@Component, @Service, @Repository, @Controller → déclarent une classe comme bean Spring.
@Autowired → injection automatique de dépendances.
@Qualifier → précise quelle implémentation injecter quand il y en a plusieurs.

9️. Détection automatique
Spring détecte les classes annotées avec @Component, @Service, @Repository, @Controller
grâce à @ComponentScan, et les enregistre automatiquement dans le conteneur IoC.

10. Cycle de vie d’un bean
Instanciation
Injection des dépendances
Initialisation (@PostConstruct ou init-method)
Utilisation
Destruction (@PreDestroy ou destroy-method)

11. Scopes des beans
singleton → un seul bean partagé dans toute l’application.
prototype → un nouveau bean à chaque demande.
(autres : request, session… pour les applications web)

12️. Importance de la configuration manuelle
Avant Spring Boot, il fallait configurer manuellement les beans, le DataSource, etc.
Comprendre cette configuration aide à comprendre le fonctionnement interne de Spring Boot,
qui effectue ces configurations automatiquement.



1️. Spring Data JPA
Spring Data JPA est un module du framework Spring qui facilite l’accès aux bases de données.
Il réduit la quantité de code à écrire pour les opérations CRUD (Create, Read, Update, Delete)
et permet de se concentrer sur la logique métier plutôt que sur le code de persistance.

2️. Différence entre JPA et Hibernate
JPA (Java Persistence API) → est une spécification, c’est-à-dire un ensemble de règles à suivre.
Hibernate → est une implémentation concrète de cette spécification.

3️. Entité JPA
Une entité JPA est une classe Java mappée à une table de base de données.
Elle est annotée avec @Entity, et ses attributs représentent les colonnes de la table.

4️. DataSource
Le DataSource contient les informations de connexion à la base de données :
URL
Nom d’utilisateur
Mot de passe
Driver


5️. EntityManager
L’EntityManager est l’interface principale de JPA.
Il permet de :
Créer, modifier, supprimer, ou rechercher des entités.
Gérer la communication entre l’application et la base de données.

6️. TransactionManager
Le TransactionManager gère les transactions :
il peut démarrer, valider (commit) ou annuler (rollback) une transaction.
en cas d’erreur, il garantit la cohérence des données.

7️. @EnableJpaRepositories
L’annotation @EnableJpaRepositories indique à Spring où chercher les interfaces Repository.
Elle permet d’activer automatiquement la création des implémentations pour les interfaces
qui héritent de JpaRepository.

8️. Repository Spring Data
Un Repository est une interface qui fait le lien entre l’application et la base de données.
Spring Data fournit déjà des implémentations prêtes pour les opérations CRUD via JpaRepository.


9️. Méthodes génériques de JpaRepository
Les principales méthodes sont :
findById() → chercher un enregistrement par ID
findAll() → récupérer tous les enregistrements
save() → ajouter ou mettre à jour un enregistrement
deleteById() → supprimer un enregistrement
count() → compter le nombre d’enregistrements

10. Gestion des transactions
Les transactions sont gérées avec l’annotation @Transactional.
Propagation → définit comment la transaction réagit si une autre existe déjà.
Rollback → permet d’annuler les changements en cas d’erreur.

11. Connexion manuelle avant Spring Boot
Avant Spring Boot, il fallait configurer manuellement :
le DataSource
l’EntityManagerFactory
le TransactionManager

-> Spring Boot fait tout cela automatiquement grâce à la configuration auto (auto-configuration).

12. Configuration de persistance complète
Une configuration JPA complète comprend :
DataSource → connexion à la base de données
EntityManagerFactory → gestion des entités
TransactionManager → gestion des transactions

13️. Validation de contrainte
La validation permet de vérifier les valeurs des champs d’une entité grâce aux annotations suivantes :
@NotNull
@Size
@Email
etc.
Dans les contrôleurs, on utilise @Valid pour activer la validation automatique.

14️. Suppression logique vs physique
Suppression logique (soft delete) → on ne supprime pas la ligne,
mais on met un champ comme deleted = true.
Suppression physique (hard delete) → on supprime réellement la ligne de la base de données.


1️. MVC (Model-View-Controller)
Le modèle MVC sépare l’application en trois couches :
Model → contient les données et la logique métier (ex : entités, services)
View → gère l’affichage à l’utilisateur (HTML, JSP, Thymeleaf…)
Controller → reçoit les requêtes HTTP, appelle le service et retourne la réponse (vue ou JSON)

2️. DispatcherServlet

Le DispatcherServlet est le cœur de Spring MVC.
Il :
reçoit toutes les requêtes HTTP
les analyse
les transmet au bon contrôleur
renvoie la réponse (vue ou JSON)

3️. Controller vs RestController
@Controller → retourne une vue (JSP, Thymeleaf…)
@RestController → retourne directement des données JSON ou XML
(En réalité : @RestController = @Controller + @ResponseBody)

4️ / 5️ / 6️ Annotations de mapping
@RequestMapping → définit le chemin général d’un contrôleur ou d’une méthode
@GetMapping → pour lire des données
@PostMapping → pour créer
@PutMapping → pour mettre à jour
@DeleteMapping → pour supprimer

7️ @Valid
@Valid permet de valider les données reçues (modèle ou requête).
On l’utilise dans les paramètres d’une méthode de contrôleur pour vérifier les contraintes des entités (@NotNull, @Email, etc.)

8️ @RequestBody et @PathVariable
@RequestBody → convertit automatiquement le JSON reçu en objet Java
@PathVariable → récupère la valeur dynamique d’une partie de l’URL
(ex : /user/{id} → id)

9️ Cycle d’une requête HTTP
L’utilisateur envoie une requête HTTP au DispatcherServlet
Le DispatcherServlet recherche le contrôleur correspondant via les annotations
Le contrôleur appelle le service, qui utilise le repository
Le résultat revient au contrôleur
Le contrôleur renvoie une vue (@Controller) ou du JSON (@RestController)

10. WebConfig
Remplace le fichier web.xml
Configure le DispatcherServlet, les view resolvers, les routes, etc.
Annotée avec @Configuration et @EnableWebMvc

11. Initialiser DispatcherServlet manuellement
Avant Spring Boot : il fallait enregistrer le DispatcherServlet manuellement (web.xml ou WebAppInitializer)
Spring Boot le fait automatiquement

12️. WebAppInitializer
Classe Java qui remplace web.xml
Initialise le DispatcherServlet et charge la configuration Spring au démarrage
Souvent, elle étend AbstractAnnotationConfigDispatcherServletInitializer

13️. Étapes d’une requête REST
Le client envoie une requête JSON
DispatcherServlet l’envoie au contrôleur
Spring convertit JSON → Objet Java (désérialisation)
Le service traite la logique
Le résultat est renvoyé Objet Java → JSON (sérialisation)

14️ Sérialisation / Désérialisation
Sérialisation → Objet Java → JSON (envoi au client)
Désérialisation → JSON → Objet Java (réception du client)
Spring utilise Jackson pour cette conversion automatiquement

15. @RestControllerAdvice
Gère globalement les exceptions et erreurs dans les contrôleurs REST
Ex : renvoyer un message d’erreur JSON au lieu d’une page d’erreur

16️. Bonnes pratiques pour organiser les packages
Structure recommandée :
com.example.project
├── controller
├── service
├── repository
├── model (ou entity)
├── config

Cela rend le projet plus clair et maintenable
