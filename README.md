# Study Week simulator

Notre projet consiste à créer un jeu de simulation d’une vie étudiante. L’utilisateur sera l’étudiant. L’étudiant aura ses propres statistiques (faim, attention, fatigue) qui évolueront tout au long du jeu. Puis, il aura des statistiques liées à chaque matière et chaque professeur. En effet, tout au long de la simulation il devra faire des choix sur les éventements auxquels il va (ou non) assister. Les éventements possibles sont : Pause/Révision/Cours.

Un bilan de sa semaine sera alors donné à la fin du jeu. L’objectif de l’utilisateur est de la réussir, c’est à dire d’avoir les statistiques les plus élevés.



## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Nous avons utilisé Maven pour faciliter la compilation et l'exécution du jeu.

Pour compiler et exécuter le projet dans le terminal, d'abord faut se positionner dans le répertoire POO22_384J_C.  
Saisir la commande qui installera Maven:
```
mvn install
```
Puis utiliser la commande suivante pour lancer le jeu:
```
mvn -q exec:java
```

Bien sûr il est aussi possible de l'exécuter à l'aide d'un IDE comme IntelliJ ou VSC.  
Pour cela après l'ouverture du projet l'IDE va vous proposer d'installer les dépendances Maven.  
Après les avoir installé(e), vous pouvez lancer le jeu en exécutant la classe Main.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
[Amerkhanova Aida](https://gitlab.univ-nantes.fr/E204135L)  
[Diop Maty](https://gitlab.univ-nantes.fr/E204018J)  
[Aymen El Ouagouti](https://gitlab.univ-nantes.fr/E21B584U)  
[Enzo Mantzoutsos](https://gitlab.univ-nantes.fr/E201789L)  

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
