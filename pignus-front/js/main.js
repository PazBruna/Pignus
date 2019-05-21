/*
 * Barra de Progresso Superior
 */
var progressBar = document.getElementById('progress-bar')

/*
 * Botões de Retorno do Formulário
 */
var prevButton_1 = document.getElementById('prev-form-1');
var prevButton_2 = document.getElementById('prev-form-2');
var prevButton_3 = document.getElementById('prev-form-3');
var prevButton_4 = document.getElementById('prev-form-4');
var prevButton_5 = document.getElementById('prev-form-5');
var prevButton_6 = document.getElementById('prev-form-6');
var prevButton_7 = document.getElementById('prev-form-7');

/*
 * Botões de Avanço do Formulário
 */
var nextButton_1 = document.getElementById('next-form-1');
var nextButton_2 = document.getElementById('next-form-2');
var nextButton_3 = document.getElementById('next-form-3');
var nextButton_4 = document.getElementById('next-form-4');
var nextButton_5 = document.getElementById('next-form-5');
var nextButton_6 = document.getElementById('next-form-6');
var nextButton_7 = document.getElementById('next-form-7');
var nextButton_8 = document.getElementById('next-form-8');

/*
 * Formulários 
 */
var page1 = document.getElementById('sign-up-1');
var page2 = document.getElementById('sign-up-2');
var page3 = document.getElementById('sign-up-3');
var page4 = document.getElementById('sign-up-4');
var page5 = document.getElementById('sign-up-5');
var page6 = document.getElementById('sign-up-6');
var page7 = document.getElementById('sign-up-7');
var page8 = document.getElementById('sign-up-8');

/*
 * Inserindo o valor digitado nos texto superior
 */

var nomeEmpresa, textNomeEmpresa;
var containerNomeEmpresa_1 = document.getElementById('textEmpresa-1');
var empty = document.createTextNode('')
function getName() {
  nomeEmpresa = document.getElementById('nome-empresa');
  textNomeEmpresa = document.createTextNode(nomeEmpresa.value);
  containerNomeEmpresa_1.appendChild(textNomeEmpresa);
}

/*
 * Funções dos Botões
 */
nextButton_1.onclick = function() {
  getName();
  page1.style.display = 'none';
  page2.style.display = 'block';
  progressBar.style.width = '25%';
}
prevButton_1.onclick = function() {
  containerNomeEmpresa_1.removeChild(textNomeEmpresa);
  page2.style.display = 'none';
  page1.style.display = 'block'
  progressBar.style.width = '12.5%';
}

nextButton_2.onclick = function() {
  page2.style.display = 'none';
  page3.style.display = 'block';
  progressBar.style.width = '37.5%';
}
prevButton_2.onclick = function() {
  progressBar.style.width = '25%';
  page3.style.display = 'none';
  page2.style.display = 'block';
}

nextButton_3.onclick = function() {
  page3.style.display = 'none';
  page4.style.display = 'block';
  progressBar.style.width = '50%';
}
prevButton_3.onclick = function() {
  page4.style.display = 'none';
  page3.style.display = 'block';
  progressBar.style.width = '37.5%';
}

nextButton_4.onclick = function() {
  page4.style.display = 'none';
  page5.style.display = 'block';
  progressBar.style.width = '62.5%';
}
prevButton_4.onclick = function() {
  page5.style.display = 'none';
  page4.style.display = 'block';
  progressBar.style.width = '50%';
}

nextButton_5.onclick = function() {
  page5.style.display = 'none';
  page6.style.display = 'block';
  progressBar.style.width = '75%';
}
prevButton_5.onclick = function() {
  page6.style.display = 'none';
  page5.style.display = 'block';
  progressBar.style.width = '50%';
}

nextButton_6.onclick = function() {
  page6.style.display = 'none';
  page7.style.display = 'block';
  progressBar.style.width = '87.5%';
}
prevButton_6.onclick = function() {
  page7.style.display = 'none';
  page6.style.display = 'block';
  progressBar.style.width = '75%';
}

nextButton_7.onclick = function() {
  page7.style.display = 'none';
  page8.style.display = 'block';
  progressBar.style.width = '100%';
}
prevButton_7.onclick = function() {
  page8.style.display = 'none';
  page7.style.display = 'block';
  progressBar.style.width = '87.5%';
}


function flipGeneral() {
  var cardContainer = document.getElementById('card');
  cardContainer.style.transform = "rotateY(0deg)"
}

function flipManager() {
  var cardContainer = document.getElementById('card');
  cardContainer.style.transform = "rotateY(180deg)";
}


function openMenu() {
  var root = document.getElementById('body');
  var closeMenu = document.getElementById('containerMenu');
  var ulElement = document.getElementById('ulElement');
  ulElement.style.visibility = 'visible';
  closeMenu.style.display = 'block';
  root.style.overflowY = 'hidden';
}

function closeMenu() {
  var root = document.getElementById('body');
  var ulElement = document.getElementById('ulElement');
  var closeMenu = document.getElementById('containerMenu');
  ulElement.style.visibility = 'hidden';
  
  setTimeout(function(){ 
    root.style.overflowY = 'scroll';
    closeMenu.style.display = 'none';
  }, 100);
}