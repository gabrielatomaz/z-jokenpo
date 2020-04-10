# Z-JOKENPO

Jokenpo é uma brincadeira japonesa, onde dois jogadores escolhem um dentre três possíveis itens: Pedra, Papel ou Tesoura. As regras são as seguintes: 
- Pedra empata com Pedra e ganha de Tesoura.
- Tesoura empata com Tesoura e ganha de Papel.
- Papel empata com Papel e ganha de Pedra.

É possível jogar contra o computador e contra um oponente.

### Para rodar a aplicação

```sh
$ git clone https://github.com/gabrielatomaz/z-jokenpo.git
$ cd z-jokenpo/bin
$ java app.App
```
### Aplicação

![alt text](https://i.imgur.com/0xbace3.gif)

### Desenvolvimento
O jogo foi construindo utilizando a linguagem de programação Java e os conceitos de Orientação a Objetos. 
Há uma classe "Player" que representa um jogador, esse jogador possui seus atributos, sendo esses: nome, sua jogada (que é representada pelo Enum "Move"), quantidade de vitórias, derrotas e empates. Possui também seus métodos, sendo esses: getters e setters, seu placar no jogo, a ação de jogar e de definir uma jogada.

A classe "Options" possui os Enums utilizados para facilitar o desenvolvimento do jogo, sendo esses, "Move" (ROCK, PAPER e SCISSORS) e "Opponent" (COMPUTER e PERSON). O Enum "Move", representa uma jogada e possui seus elementos (pedra, papel ou tesoura) e cada um possui dois métodos, os mesmos validam qual elemento, quando posicionado contra outro, vence, perde ou empata. O Enum "Opponent" é utilizado para definir se o jogo será contra o computador ou uma pessoa real.

A classe executada é a App, na qual os jogadores são instanciados e onde suas ações (jogar, por exemplo) são realizadas. Nessa classe também são realizadas as perguntas (nome e jogada) aos jogadores.

### Testes
Os testes foram realizados utilizando **JUnit**.
* ##### Move
    * Pedra vence Tesoura (V)
    * Pedra vence Papel (F)
    * Papel vence Pedra (V)
    * Papel vence Tesoura (F)
    * Tesoura vence Papel (V)
    * Tesoura vence Pedra (F)
    
 * ##### Player
    * Jogador vence com Papel contra Pedra (V)
    * Jogador vence com Papel contra Tesoura (F)
    * Jogador vence com Pedra contra Tesoura (V)
    * Jogador vence com Pedra contra Papel (F)
    * Jogador vence com Tesoura contra Papel (V)
    * Jogador vence com Tesoura contra Pedra (n) vezes (F)
    * Jogador vence com Papel contra Pedra (n) vezes (V)
    * Jogador vence com Papel contra Tesoura (n) vezes (F)
    * Jogador vence com Pedra contra Tesoura (n) vezes (V)
    * Jogador vence com Pedra contra Papel (n) vezes (F)
    * Jogador vence com Tesoura contra Papel (n) vezes (V)
    * Jogador vence com Tesoura contra Pedra (n) vezes (F)
    * Jogador empata com Pedra vs Pedra, Tesoura vs Tesoura e Papel vs Papel (V)


