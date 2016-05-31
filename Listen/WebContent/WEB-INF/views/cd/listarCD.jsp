<%@include file="/header.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="secao">
	<div class="painel">
		<div class="painel-tabela">			
				<p class="titulo">Editar CDs</p>
				<table>
					<thead>
						<tr>
							<th>Capa</th>
							<th>Nome</th>
							<th>Artista</th>
							<th>Ano</th>
							<th>Genero</th>
							<th>Gravadora</th>
							<th>Preço</th>
							<th>Upload</th>
							<th>Editar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cds}" var="cd">
							<tr>
								<c:if test="${! empty cd.capa }">
								<td><img class="imagem-miniatura" src=<c:url value="imagens/CD${cd.idCD}.png"/> alt="Miniatuara da capa"></td>							
								</c:if>
								<c:if test="${empty cd.capa }">
								<td><img class="imagem-miniatura" src=<c:url value="imagens/not-found.jpg"/> alt="Miniatuara da capa"></td>
								</c:if>
								<td>${cd.nomeCD}</td>
								<td>${cd.nomeArtista}</td>
								<td>${cd.dataLancamento}</td>
								<td>${cd.dscGenero}</td>			
								<td>${cd.gravadora}</td>
								<td>${cd.preco}0</td>
								<td><fmt:formatDate value="${cd.dataCriacao}" pattern="dd/MM/yyyy" /></td>								
								<td><a href="mostrarCD?cdId=${cd.idCD}"><span class="glyphicon glyphicon-pencil icone"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</div>
<footer style= "background-color: white;" class="text-center footer">
<ul class="pager">
	<li><a href="listarCd?pag=${paginas[0]}">Primeira</a></li>


			<c:forEach items="${paginas}" var="pagina" >
	
				<li><a href="listarCd?pag=${pagina}">${pagina}</a></li>
			
			</c:forEach>
		
		
<li><a href="listarCd?pag=${fn:length(paginas)}">Ultima</a></li>
</ul>
</footer>

<%@include file="/footer.jspf"%>