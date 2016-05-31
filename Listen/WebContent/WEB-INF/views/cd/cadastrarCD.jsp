<%@include file="/header.jspf" %>

<script>

</script>

<div class="secao">
	<div class="painel">
		<p class="titulo">Cadastrar CD</p>
		<form id="form-cadastrar-cd" action="adicionarCd" method="post" enctype="multipart/form-data"><br>
		<div class="painel-cd">
			<div class="painel-imagem">
				<input id="file-input" style="display:none" type="file" name="file"/>
				<label for="file-input">
					<img id="preview" src="imagens/CD${cd.idCD}.png"/>
				</label>
			</div>
			<div id="painel-faixas" class="painel-info">
			<label>Nome:</label><input class="input-cadastro" name="nomeCD"><br>
			<label>Artista:</label><input class="input-cadastro" name="nomeArtista"><br>
			<hr>
			<label>Gravadora:</label><input class="input-cadastro" name="gravadora"><br>
			<label>Gênero: </label><select class="form-control" name=dscGenero>
				<c:forEach items="${listaGeneros}" var="generos">
					<option>${generos}</option>
				</c:forEach>
			</select><br>
			<label>Ano:</label><input class="input-cadastro" name="dataLancamento"><br>
			<hr>
			<label>Preço: R$</label><input class="input-cadastro" name="preco"><br>
			<hr>
			<c:set var="numFaixa" value="${1}" scope="session"/>
			<input id="faixa-nova-cadastro" placeholder="Digite o Título da Música"><span id="adicionar-faixa-cadastro" class="glyphicon glyphicon-plus icone-painel-adicionar"> </span>
			<hr>
			</div>			
		</div>		
			<div class="painel-confirmar">
				<button type="reset">Cancelar</button>
				<button id="adicionar-cd" type="submit" >Cadastrar</button>
			</div>
		</form>
	</div>
</div>


<%@ include file="/footer.jspf"%>