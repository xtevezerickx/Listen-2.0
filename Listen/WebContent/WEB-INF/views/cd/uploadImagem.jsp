<%@include file="/header.jspf"%>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Upload de Imagem</h1>
				<form class="form" method="POST" action="upload?cdId=${cdId}"
					enctype="multipart/form-data">

					<label>Escolha um arquivo</label> <input type="file" name="file" />
				<br>
				
					<button type="submit" class="btn btn-primary" value="upload">Fazer Upload</button>
			
				</form>
			</div>
		</div>
	</div>

</body>

<%@include file="/footer.jspf"%>