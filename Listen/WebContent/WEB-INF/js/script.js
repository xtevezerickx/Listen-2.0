

var i = 1;

$(document).ready(function() {
	$('.cd-info').hide();
	$(document).on('click', ".menu-fonte", function(){
		var x = $(this).parent().parent();
		$(x).children().fadeOut().delay(1000);
		$(x).children('.cd-info').fadeIn();
	});
	$(document).on('click', ".container > img", function(){
		var x = $(this).parent();
		$(x).children().fadeOut().delay(1000);
		$(x).children('.cd-info').fadeIn();
	});
	$(document).on('click', '.icone-info-fechar', function(){
		var x = $(this).parent().parent().parent();
		$(x).children().fadeOut().delay(1000);
		$(x).children('img, .descricao, .cd-menu').fadeIn();
    });
	$('.cabecalho-item, .cabecalho-item-direita').mouseenter(function(){
		$(this).css("background-color", "#47D");
	});
	$('.cabecalho-item, .cabecalho-item-direita').mouseleave(function(){
		$(this).css("background-color", "#36C");
	});
	$(document).on('mouseenter', "td", function(){
		$(this).parent().children().addClass("tr-selected");
	});
	$(document).on('mouseleave', "td", function(){
		$(this).parent().children().removeClass("tr-selected");
	});
	$(document).on('click', "#adicionar-faixa", function(){
		$('#form-adicionar-faixa').submit();
	});
	$(document).on('click', "#adicionar-faixa-cadastro", function(){
		$('#painel-faixas').append("<p>Faixa "+ i + " - " + document.getElementById("faixa-nova-cadastro").value + "</p>");
		$('#painel-faixas').append('<input type="hidden" name="faixa" id="faixa-nova-cadastro' + i + '" />');
		document.getElementById("faixa-nova-cadastro" + i).value = document.getElementById("faixa-nova-cadastro").value;
		$('#faixa-nova-cadastro').val('');
		$('#faixa-nova-cadastro').focus();
		i++;
	});
	$(document).on('click', "#adicionar-cd", function(){
		$('#painel-faixas').append('<input type="hidden" name="qtd" value="' + i + '}"/>');
		$('#form-cadastrar-cd').submit();
	});
	
	document.getElementById("file-input").onchange = function () {
	    var reader = new FileReader();

	    reader.onload = function (e) {
	        // get loaded data and render thumbnail.
	    	document.getElementById("preview").src = e.target.result;
	    };

	    // read the image file as a data URL.
	    reader.readAsDataURL(this.files[0]);
	};
});

