<%@include file="/header.jspf" %>

<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Login</h1>
				<form class="form" method="post" action="efetuarLogin">
					<div class="form-group" style="width: 500px">
						<label>Usuario:</label> <input type="text" class="form-control"
							id="usuario" placeholder="Digite seu usuário" required> 
						<label>Senha:</label>
						<input type="password" class="form-control" id="senha" placeholder="Digite sua senha" required>
						<a href=novoUsuario>Não tem cadastro ? Click aqui</a>
						<br>
						<div class="form-group container">
							<a href=index><button type="reset" class="btn btn-danger">Cancelar</button></a>
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<%@ include file="/footer.jspf"%>