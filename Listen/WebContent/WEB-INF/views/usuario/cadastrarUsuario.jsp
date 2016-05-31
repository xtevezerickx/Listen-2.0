
<%@include file="/header.jspf" %>

<body>


	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de Usuário</h1>
				<form class="form" method="post" action="adicionarUsuario">
					<div class="form-group" style="width: 400px">
						<label>Nome:</label> <input type="text" class="form-control" name="nome">
						<label>RG:</label> <input type="text" class="form-control" name="rg">
						<label>CPF:</label> <input type="text" class="form-control" name="cpf">
						<label>Rua:</label> <input type="text" class="form-control" name="rua">
						<label>CEP:</label> <input type="text" class="form-control" name="cep">
						<label>Cidade:</label> <input type="text" class="form-control" name="cidade">
						<label>Estado:</label> <input type="text" class="form-control" name="estado">
						<label>Data de Nascimento:</label> <input type="text" class="form-control" name="dataNascimento">
						<label>Email:</label> <input type="text" class="form-control" name="email">
						<label>Telefone:</label> <input type="text" class="form-control" name="telefone">
						<label>Login:</label> <input type="text" class="form-control" name="login">
						<label>Senha:</label> <input type="text" class="form-control" name="senha">
						<div class="form-group container">
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

<%@ include file="/footer.jspf"%>