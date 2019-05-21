// Geradores de ID
var counterDiv = 0;
var counterIcon = 0;

var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
var containerElement = document.getElementById('app');
buttonSubmit.style.display = 'none';


var suppArrSoftwares = [];
var arrSoftwares = [];

var suppArrPersons = [];
var arrPersons = [];

var softwaresSelecionados = document.getElementById('select-softwares');
var pessoasSelecionadas = document.getElementById('select-persons');

// Validando os valores dos selects
function validaSelecoes() {
  for( var i = 0; i < softwaresSelecionados.length; i++ )  {
    if( softwaresSelecionados.options[i].selected == true ) {
      suppArrSoftwares.push(softwaresSelecionados[i]);
    }
  }
  arrSoftwares.push(suppArrSoftwares);

  for( var i = 0; i < pessoasSelecionadas.length; i++ )  {
    if( pessoasSelecionadas.options[i].selected == true ) {
      suppArrPersons.push(pessoasSelecionadas[i]);
    }
  }
  arrPersons.push(suppArrPersons);
}

// Array para captura de informação ao Java
var arrToJava = [];
buttonElement.onclick = function() {

  // Cria uma variável de suporte quee sempre reseta quando clicar no botão
  var suppArrToJava = [];
  buttonSubmit.style.display = 'block';

  validaSelecoes();

  var divider = document.createElement('div');
  
  var nomeProjeto = document.createElement('h3');
  var clienteBeneficiado = document.createElement('p');
  var descricaoProjeto = document.createElement('p');
  var listaSoftwares = document.createElement('p');
  var listaIntegrantes = document.createElement('p');

  var inputNomeProjeto = document.querySelector('input[name=nome-projeto]');
  var inputClienteBeneficiado = document.querySelector('input[name=cliente-beneficiado]');
  var inputDescricaoProjeto = document.querySelector('input[name=descricao-projeto]');

  var nomeProjetoText = document.createTextNode(inputNomeProjeto.value);
  nomeProjeto.appendChild(nomeProjetoText);
  divider.appendChild(nomeProjeto);

  var clienteBeneficiadoText = document.createTextNode('Cliente: ' + inputClienteBeneficiado.value);
  clienteBeneficiado.appendChild(clienteBeneficiadoText);
  divider.appendChild(clienteBeneficiado);

  var descricaoProjetoText = document.createTextNode('Descrição: ' + inputDescricaoProjeto.value);
  descricaoProjeto.appendChild(descricaoProjetoText);
  divider.appendChild(descricaoProjeto);

  var personsValues = [];
  var softwaresValues = [];
  for( var i = 0; i < suppArrPersons.length; i++ ) {
    personsValues.push(suppArrPersons[i].text);
  }
  var personsTexts = document.createTextNode('Colaboradores: ' + personsValues.join(', '));
  listaIntegrantes.appendChild(personsTexts);
  divider.appendChild(listaIntegrantes);

  for( var i = 0; i < suppArrSoftwares.length; i++ ) {
    softwaresValues.push(suppArrSoftwares[i].text);
  }
  var softwaresTexts = document.createTextNode('Softwares: ' + softwaresValues.join(', '));
  listaSoftwares.appendChild(softwaresTexts)
  divider.appendChild(listaSoftwares)


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
  suppArrToJava.push(nomeProjetoText);
  suppArrToJava.push(clienteBeneficiadoText);
  suppArrToJava.push(descricaoProjetoText);
  suppArrToJava.push(suppArrPersons);
  suppArrToJava.push(suppArrSoftwares);
  arrToJava.push(suppArrToJava);
  console.log(arrToJava);


  // Escutando quando ocorrerá um evento de click no ícone
  iconContainer.addEventListener('click', function (e) {
    if (window.confirm('Realmente deseja remover este elemento?')) {
      var el = document.getElementById(`element${iconElement.id}`);
      el.parentNode.removeChild(el);
      arrToJava.pop(iconElement.id);
    }
  })


  containerElement.appendChild(divider);

  
  // Reseting Form
  suppArrPersons = [];
  suppArrSoftwares = [];
  inputNomeProjeto.value = '';
  inputClienteBeneficiado.value = '';
  inputDescricaoProjeto.value = '';
  for( var i = 0; i < pessoasSelecionadas.length; i++ )  {
    pessoasSelecionadas.options[i].selected = false;
  }
  for( var i = 0; i < softwaresSelecionados.length; i++ )  {
    softwaresSelecionados.options[i].selected = false;
  }
  
}