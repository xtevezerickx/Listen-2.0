<%@include file="/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<div class="secao">
	<div class="painel">
		<c:forEach items="${cds}" var="cd">
			<div class="container">
				<img src="imagens/CD${cd.idCD}.png" />
				<div class="descricao">
					<p class="cd-fonte">${cd.nomeCD}</p>
					<p class="artista-fonte">${cd.nomeArtista}</p>
					<p class="preco-fonte">R$ ${cd.preco}0</p>
				</div>
				<div class="cd-menu">
					<p class="menu-fonte"><a href="adicionarCarrinho?idCd=${cd.idCD}">Comprar<span class="glyphicon glyphicon-shopping-cart icone"	aria-hidden="true"></span></a></p>
					<p class="menu-fonte">|</p>
					<p id="mais-informacoes" class="menu-fonte">Mais Informações<span class="glyphicon glyphicon-info-sign icone black" aria-hidden="true"></span></p>
				</div>
				<div class="cd-info">
					<div>
						<span class="glyphicon glyphicon-remove icone-info-fechar" aria-hidden="true"></span>
						<img class="imagem-miniatura" src="imagens/CD${cd.idCD}.png">
						<p class="cd-fonte">${cd.nomeCD}</p>
						<p>${cd.nomeArtista}</p>
					</div>
					<hr>
					<div>
						<p class="faixa-fonte">Gravadora: ${cd.gravadora}</p>
						<p class="faixa-fonte">Gênero: ${cd.dscGenero}</p>
						<p class="faixa-fonte">Lançamento: ${cd.dataLancamento}</p>
					</div>
					<hr>
					<div>
						<p class="faixa-fonte">Preço: R$${cd.preco}0</p>
					</div>
					<hr>
					<div>
						<c:forEach items="${listaDeFaixas}" var="faixa">
							<c:if test="${cd.idCD eq faixa.idCd }">
								<p class="faixa-fonte">Faixa ${faixa.numFaixa } -
									${faixa.dscFaixa}</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@include file="/footer.jspf"%>