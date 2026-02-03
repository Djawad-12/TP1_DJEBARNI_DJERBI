# Réponses aux questions - TP1 : Inversion de Contrôle


## Partie 1 : 

**1. Où est le couplage fort ?**

Le couplage fort se trouve à la ligne 

`private EmailSender sender = new EmailSender();`.

En utilisant `new`, la classe`NotificationService` 
est obligée d'utiliser `EmailSender` et dépend directement de son code source.

**2. Peut-on facilement remplacer EmailSender ?**

Non. Pour le remplacer (par exemple par un SMS), il faut modifier le code de `NotificationService` 

**3. Ce code respecte-t-il l'IoC ?**

Non, car c'est le service lui-même qui contrôle la création de sa dépendance au lieu de la recevoir de l'extérieur

## Partie 2 : IoC avec Spring et XML

**1. Qui crée les objets ?**

C'est le conteneur Spring (via l'`ApplicationContext`) qui crée les objets définis dans le fichier XML

**2. Où est l'IoC ?**

L'IoC se trouve dans le fichier de configuration (`applicationContext.xml`). On a laissé le framework s'occuper de tout

**3. Comment changer le canal de notification ?**

Il suffit de changer la balise `<constructor-arg ref="emailSender"/>` en mettant `smsSender` dans le fichier XML. On n'a pas besoin de toucher au code Java.

## Partie 4 : Comparaison XML vs Annotations

| Critère | XML                                                       | Annotations                                     |
| :--- |:----------------------------------------------------------|:------------------------------------------------|
| **Lisibilité** | Moins lisible à cause du XML                              | Plus clair, directement dans le code            |
| **Couplage** | Faible                                                    | Dépend des imports Spring donc plus intéressant |
| **Refactoring** | Il faut changer le fichier XML (ce qui n'est pas intuitif | Facile car on on peut tout faire grâce à l'IDE  |
| **Dynamisme** | Oui, il n'y a pas besoin de compiler                      | Non car il faut recompiler                      |


## Partie 6 : Questions de réflexion 

**1. En quoi Spring implémente-t-il l'IoC ?**

Spring agit comme un conteneur qui gère tout le cycle de vie des objets (création, destruction...)

**2. Quelle différence entre IoC et DI ?**

L'IoC est le principe général ("ne m'appelez pas, je vous appellerai"). La DI (Injection de Dépendance) est la méthode technique utilisée par Spring pour appliquer ce principe

**3. Quel pattern GoF est utilisé implicitement ?**

Le pattern Factory (Fabrique) est utilisé pour créer les beans

**4. Pourquoi Spring favorise-t-il l'injection par constructeur ?**

Cela garantit que l'objet est toujours créé dans un état valide (toutes ses dépendances sont là) et permet de rendre les champs `final` 