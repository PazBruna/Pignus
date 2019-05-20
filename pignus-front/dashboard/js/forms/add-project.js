var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
buttonSubmit.style.display = 'none';

var containerElement = document.getElementById('app');

var suppArrSoftwares = [];
var arrSoftwares = [];

var suppArrPersons = [];
var arrPersons = [];

var softwaresSelecionados = document.getElementById('select-softwares');
var pessoasSelecionadas = document.getElementById('select-persons');

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

buttonElement.onclick = function() {
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