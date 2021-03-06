<%@include file="/header.jspf" %>

<div class="secao">
	<div class="painel">
		
		<p class="titulo">Adicionar Faixas</p>
		<div class="painel-cd">
			<div class="painel-imagem">
				<img src="imagens/CD${cd.idCD}.png"/>
			</div>
			
			<div id="painel-faixas" class="painel-info">
			<input type="hidden" name=idCD value="${cd.idCD}">
			<label>Nome:</label><input type="text" value="${cd.nomeCD }"name="nomeCD"> 
			<label>Artista:</label><input type="text"  value="${cd.nomeArtista }" name="nomeArtista">
			<hr>
			<label>Gravadora:</label>	<input type="text"  value="${cd.gravadora }" name="gravadora">
			<br><br>
			<label>Genero:</label>
						<select name=dscGenero >
					
							<c:forEach items="${listaGeneros}" var="genero">
								<c:choose>
									<c:when test="${cd.dscGenero eq genero }">
									<option selected="selected">${cd.dscGenero }</option>
									</c:when>
								<c:otherwise>
									<option>${genero}</option>
								</c:otherwise>
								
								</c:choose>
					
							</c:forEach>
						</select>
			<br>
			<hr>
			<label>Pre�o: R$$</label>	<input type="text" value="${cd.preco}" name="preco">
			<hr>
			
			<c:set var="numFaixa" value="${1}" scope="session"/>
			<input id="faixa-nova-cadastro" placeholder="Digite o T�tulo da M�sica"><span id="adicionar-faixa-cadastro" class="glyphicon glyphicon-plus icone-painel-adicionar"> </span>
				
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