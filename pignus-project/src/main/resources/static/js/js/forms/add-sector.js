// Geradores de ID
var counterDiv = 0;
var counterIcon = 0;

var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
var containerElement = document.getElementById('app');
buttonSubmit.style.display = 'none';


var suppArrContributors = [];
var arrContributors = [];
var constribuidoresSelecionados = document.getElementById('select-contributors');

var suppArrSoftwares = [];
var arrSoftwares = [];
var softwaresSelecionados = document.getElementById('select-softwares');

var gestorSelecionado = document.getElementById('select-manager')
var managerSelected = '';

// Validando os valores dos selects
function validaSelecoes() {
  for( var i = 0; i < constribuidoresSelecionados.length; i++ )  {
    if( constribuidoresSelecionados.options[i].selected == true ) {
      suppArrContributors.push(constribuidoresSelecionados[i]);
    }
  }
  arrContributors.push(suppArrContributors);

  for( var i = 0; i < softwaresSelecionados.length; i++ )  {
    if( softwaresSelecionados.options[i].selected == true ) {
      suppArrSoftwares.push(softwaresSelecionados[i]);
    }
  }
  arrSoftwares.push(suppArrSoftwares);

  for( var i = 0; i < gestorSelecionado.length; i++ )  {
    if( gestorSelecionado.options[i].selected == true ) {
      managerSelected = gestorSelecionado[i].value;
      break;
    }
  }
}

// Array para captura de informação ao Java
var arrToJava = [];
buttonElement.onclick = function() {

  // Cria uma variável de suporte quee sempre reseta quando clicar no botão
  var suppArrToJava = [];
  buttonSubmit.style.display = 'block';

  validaSelecoes();

  var divider = document.createElement('div');
  
  var nomeSetor = document.createElement('h3');
  var nomeGestor = document.createElement('p');
  var listaColaboradores = document.createElement('p');
  var listaSoftwares = document.createElement('p');

  var inputNomeSetor = document.querySelector('input[name=nome-setor]');

  var nomeSetorText = document.createTextNode(inputNomeSetor.value);
  nomeSetor.appendChild(nomeSetorText);
  divider.appendChild(nomeSetor);

  var nomeGestorText = document.createTextNode("Gestor: " + managerSelected);
  nomeGestor.appendChild(nomeGestorText);
  divider.appendChild(nomeGestor);

  var contributorsValues = [];
  for( var i = 0; i < suppArrContributors.length; i++ ) {
    contributorsValues.push(suppArrContributors[i].text);
  }
  var contributorsText = document.createTextNode('Colaboradores: ' + contributorsValues.join(', '));
  listaColaboradores.appendChild(contributorsText);
  divider.appendChild(listaColaboradores);

  var softwaresValues = [];
  for( var i = 0; i < suppArrSoftwares.length; i++ ) {
    softwaresValues.push(suppArrSoftwares[i].text);
  }
  var softwaresText = document.createTextNode('Softwares Utilizados: ' + softwaresValues.join(', '));
  listaSoftwares.appendChild(softwaresText);
  divider.appendChild(listaSoftwares);

  // Remoção de Itens do DOM
  var iconContainer = document.createElement('div');
  var iconElement = document.createElement('i');
  iconContainer.setAttribute('id', 'remove');
  iconContainer.setAttribute('class', 'remove')
  iconContainer.appendChild(iconElement);

  iconElement.setAttribute('class', 'fas fa-trash-alt');
  iconElement.setAttribute('id', counterIcon++);
  divider.appendChild(iconContainer);
  divider.setAttribute('id', `element${counterDiv++}`)

  // Segurando elementos para o Java
  suppArrToJava.push(nomeSetorText);
  suppArrToJava.push(nomeGestorText);
  suppArrToJava.push(suppArrContributors);
  suppArrToJava.push(suppArrSoftwares);
  arrToJava.push(suppArrToJava);

  // Escutando quando ocorrerá um evento de click no ícone
  iconContainer.addEventListener('click', function (e) {
    if (window.confirm('Realmente deseja remover este elemento?')) {
      var el = document.getElementById(`element${iconElement.id}`);
      el.parentNode.removeChild(el);
      arrToJava.pop(iconElement.id);
    }
  })

  // Jogando os elementos para a div
  containerElement.appendChild(divider);

  
  // Reseting Form
  suppArrContributors = [];
  suppArrSoftwares = [];
  inputNomeSetor.value = '';
  for( var i = 0; i < constribuidoresSelecionados.length; i++ )  {
    constribuidoresSelecionados.options[i].selected = false;
  }
  for( var i = 0; i < softwaresSelecionados.length; i++ )  {
    softwaresSelecionados.options[i].selected = false;
  }
  gestorSelecionado.selectedIndex = 0;
  
}