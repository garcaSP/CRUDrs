ATIVIDADE AVALIATIVA – 3º BIMESTRELP VI – JavaAplicação de SOLID em MVC com FXML
Nesta atividade avaliativa, você deverá aplicar os conceitos de Orientação a Objetos, SOLID, MVC, FXML, interfaces, generics, validação e injeção de dependência estudados em sala de aula.
A atividade deverá ser desenvolvida com base no material disponibilizado durante as aulas.
Você deverá implementar um sistema de cadastro relacionado a um assunto de sua escolha, utilizando uma solução estruturada em MVC + FXML e aplicando os princípios SOLID.
O assunto do sistema deverá ser definido pelo aluno. Exemplos: cadastro de alunos, produtos, livros, clientes, filmes, funcionários, veículos etc.REQUISITOS OBRIGATÓRIOS
A solução deverá atender a TODOS os requisitos abaixo.1. Interface Validador
Crie uma interface genérica chamada:
Validador<T>
A interface deverá possuir obrigatoriamente os três métodos:
validar
getMensagemErro
getValor
A interface deverá utilizar tipo genérico, permitindo que diferentes tipos de dados possam ser validados.2. Classes de validação
Crie AO MENOS duas classes de validação diferentes.
As classes deverão implementar a interface:
Validador<T>
Uma das classes deverá obrigatoriamente ser:
CamposObrigatoriosValidador
A segunda classe deverá realizar uma regra de validação diferente.
Exemplos:
EmailValidador
CpfValidador
NumeroValidador
SenhaValidador
DataValidador
ou outra validação relacionada ao seu sistema.
Você poderá criar mais classes de validação além das duas obrigatórias.3. Classe SeuAssuntoValidador
Crie uma classe chamada:
SeuAssuntoValidador
Substitua "SeuAssunto" pelo assunto escolhido para o sistema.
Exemplos:
AlunoValidador
ProdutoValidador
ClienteValidador
LivroValidador
Essa classe deverá ser responsável por reunir e executar as validações necessárias para os campos do cadastro.
Ela deverá:
possuir uma lista genérica contendo os validadores;
armazenar as validações dos diferentes campos;
executar as validações percorrendo essa lista;
utilizar obrigatoriamente uma estrutura foreach para percorrer os validadores;
utilizar os métodos definidos pela interface Validador.
O objetivo é que a classe SeuAssuntoValidador não precise conhecer detalhadamente a implementação de cada tipo de validação.4. Interface ISeuAssuntoValidador
Crie uma interface chamada:
ISeuAssuntoValidador
Essa interface deverá definir o comportamento necessário para que a aplicação possa realizar as validações do cadastro.
A classe:
SeuAssuntoValidador
deverá implementar essa interface.5. Utilização da interface no cadastro e na atualização
No Controller responsável pelo cadastro/atualização, a validação deverá ser realizada utilizando um objeto do tipo da interface:
ISeuAssuntoValidador
O Controller NÃO deverá depender diretamente da classe concreta SeuAssuntoValidador para realizar as validações.
A validação deverá ser utilizada tanto:
no cadastro;
quanto na atualização.
6. Injeção de dependência
A instância de SeuAssuntoValidador deverá ser fornecida ao Controller por meio de injeção de dependência.
A criação dessa dependência deverá ser realizada utilizando uma:
Fábrica de Controladores
A fábrica deverá ser utilizada para fornecer ao Controller o objeto necessário para realizar as validações.7. Fábrica de controladores no Main
A configuração da aplicação deverá ser realizada no main.
O main deverá utilizar a fábrica de controladores para criar os Controllers e fornecer suas dependências.
A instância concreta de:
SeuAssuntoValidador
deverá ser criada fora do Controller e injetada nele por meio da fábrica.
O Controller não deverá ser responsável por criar diretamente seu próprio validador.8. Aplicação de SOLID
A solução deverá demonstrar a aplicação dos princípios SOLID estudados em sala de aula.
Durante a avaliação, você deverá ser capaz de explicar, no seu próprio código, como a solução contribui para:
separação de responsabilidades;
baixo acoplamento;
utilização de interfaces;
utilização de abstrações;
facilidade de substituição ou inclusão de novos validadores;
injeção de dependência.
Não será suficiente apenas criar as classes e interfaces. A estrutura deverá fazer sentido dentro da aplicação.9. MVC + FXML
O sistema deverá utilizar a estrutura MVC com interface gráfica desenvolvida em FXML.
A aplicação deverá possuir, no mínimo:
Model;
View em FXML;
Controller;
mecanismo de validação;
fábrica de Controllers;
classe principal (main).
Os dados deverão ser recebidos pela interface gráfica e processados pelo sistema.10. Funcionamento
A aplicação deverá estar funcionando corretamente no momento da avaliação.
O projeto deverá:
abrir normalmente;
carregar as telas FXML;
permitir realizar o cadastro;
permitir realizar a atualização;
executar as validações;
apresentar mensagens de erro quando os dados forem inválidos;
não apresentar erros de execução;
não apresentar erros de compilação.
APRESENTAÇÃO E DEFESA DO CÓDIGO
Durante a avaliação, poderão ser realizadas perguntas sobre o código desenvolvido.
O aluno deverá ser capaz de:
explicar a função de cada classe criada;
explicar a função da interface Validador<T>;
explicar por que a interface utiliza Generics;
explicar o funcionamento dos métodos validar, getMensagemErro e getValor;
explicar como os validadores são armazenados na lista;
explicar o funcionamento do foreach utilizado em SeuAssuntoValidador;
explicar a função da interface ISeuAssuntoValidador;
explicar por que o Controller utiliza a interface em vez da classe concreta;
explicar como ocorre a injeção de dependência;
explicar a função da fábrica de Controllers;
explicar onde o SeuAssuntoValidador é instanciado;
explicar como o main participa da configuração das dependências;
identificar quais princípios SOLID foram aplicados e justificar sua utilização.
O professor poderá solicitar alterações simples no código durante a avaliação para verificar se o aluno compreende a solução desenvolvida.CRITÉRIOS DE AVALIAÇÃO
Serão considerados:
Implementação correta da interface genérica Validador<T>;
Implementação dos métodos obrigatórios;
Criação e utilização de pelo menos dois validadores;
Implementação de CamposObrigatoriosValidador;
Implementação correta de SeuAssuntoValidador;
Utilização de lista genérica e foreach;
Criação e utilização de ISeuAssuntoValidador;
Utilização da interface no Controller;
Implementação da injeção de dependência;
Utilização da fábrica de Controllers;
Configuração das dependências no main;
Aplicação adequada dos princípios SOLID;
Funcionamento completo da aplicação;
Organização e qualidade do código;
Capacidade de explicar e defender a própria implementação.
ENTREGA
Entregue o projeto completo da aplicação desenvolvida.
Antes da entrega, verifique se:
[ ] O projeto compila sem erros.
[ ] A aplicação inicia corretamente.
[ ] A interface FXML funciona corretamente.
[ ] O cadastro funciona.
[ ] A atualização funciona.
[ ] As validações funcionam.
[ ] Existe a interface Validador<T>.
[ ] Validador<T> possui os três métodos obrigatórios.
[ ] Existe CamposObrigatoriosValidador.
[ ] Existe pelo menos mais um Validador.
[ ] Existe SeuAssuntoValidador.
[ ] SeuAssuntoValidador utiliza uma lista genérica de validadores.
[ ] SeuAssuntoValidador percorre os validadores utilizando foreach.
[ ] Existe ISeuAssuntoValidador.
[ ] SeuAssuntoValidador implementa ISeuAssuntoValidador.
[ ] O Controller utiliza ISeuAssuntoValidador.
[ ] A instância de SeuAssuntoValidador é injetada no Controller.
[ ] Existe uma fábrica de Controllers.
[ ] A fábrica é utilizada pelo main.
[ ] O Controller não cria diretamente seu próprio SeuAssuntoValidador.
[ ] A aplicação não apresenta erros de execução.
[ ] O aluno consegue explicar o código desenvolvido.IMPORTANTE
O código deverá ser de autoria do próprio aluno.
Durante a avaliação, o professor poderá solicitar que o aluno explique, altere ou complemente partes do código. Portanto, não será avaliado apenas o funcionamento da aplicação, mas também o domínio da solução implementada.