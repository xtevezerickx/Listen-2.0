<%@include file="/header.jspf" %>

<div class="secao">
	<div class="painel">
		
		<p class="titulo">Adicionar Faixas</p>
		<div class="painel-cd">
			<div class="painel-imagem">
				<img src="imagens/CD${cd.idCD}.png"/>
			</div>
			<div id="painel-faixas" class="painel-info">
			<p class="cd-fonte">${cd.nomeCD}</p>
			<p>${cd.nomeArtista}</p>
			<hr>
			<p>${cd.gravadora}</p>
			<p>${cd.dscGenero}</p>
			<p>${cd.dataLancamento}</p>
			<hr>
			<p class="faixa-fonte">Preço: R$${cd.preco}0</p>
			<hr>
			<form id="form-adicionar-faixa" action="adicionarFaixa" method="post">
			<input id="faixa-nova" name="faixa" placeholder="Digite o Título da Música"><span id="adicionar-faixa" class="glyphicon glyphicon-plus icone-painel-adicionar"> </span>
			<input type="hidden" name="cdId" value="${cd.idCD}" />
			</form>
			<hr>
				<c:forEach items="${listaFaixas}" var="listaFaixa">
						<input type="text" id="faixa" value="${listaFaixa.dscFaixa}"
							name="faixa" placeholder="Digite a faixa do cd" style="width:300 px;">
						<br>
				</c:forEach>
				<br>
				<br>
				<hr>
				<c:if test="${! empty listaFaixas}">

					<p style="text-align:center;">
					<button type="reset" class="btn btn-danger">Cancelar</button>
					<button type="submit" class="btn btn-primary">Atualizar</button>
					</p>
				</c:if>
	
				<c:if test="${empty listaFaixas}">
					<p style="text-align:center;">
						<button type="reset" class="btn btn-danger">Cancelar</button>
						<button type="button" class="btn btn-primary disabled">Atualizar</button>
						</p>
					</c:if>		
									
			<hr>
			</div>
		</div>
	</div>
</div>

<%@ include file="/footer.jspf"%>