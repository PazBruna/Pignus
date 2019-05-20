var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
buttonSubmit.style.display = 'none';

var containerElement = document.getElementById('app');

var suppArrContributors = [];
var arrContributors = [];
var constribuidoresSelecionados = document.getElementById('select-contributors');

var suppArrSoftwares = [];
var arrSoftwares = [];
var softwaresSelecionados = document.getElementById('select-softwares');

var gestorSelecionado = document.getElementById('select-manager')
var managerSelected = '';

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

buttonElement.onclick = function() {
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