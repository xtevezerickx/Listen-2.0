<%@include file="/header.jspf"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<div class="secao">
	<div class="painel">
		<p class="titulo">Adicionar Faixas</p>
		<div class="painel-cd">
			<c:forEach items="${faixas}" var="faixa">
					<p>${faixas.dscFaixa}</p>
			</c:forEach>
		</div>
	</div>
</div>
<!-- 
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de Faixas</h1>
				<form class="form" method="post" action="adicionarFaixa?cdId=${cdId}">
					<div id="faixas" >
						<c:forEach begin="1" end="10">
						<input type="text" class="form-control" id="faixa"
							name="faixa" placeholder="Digite a faixa do cd" style="width: 400px">
						<br>
						</c:forEach>
				
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-success">Finalizar</button>
				
					</div>
						
				</form>
			</div>
		</div>
	</div>
</body>
-->

<%@include file="/footer.jspf"%>