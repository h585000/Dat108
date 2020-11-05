
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Paamelding</title>
</head>
<body>
	<h2>Paamelding</h2>
	<p style="color: red">${feilmelding}</p>
	<form action = "PaameldingServlet" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" value=""  placeholder ="Fornavn" 
					required minlength="2" maxlength="20"
					pattern="[A-Z][A-z]*"/> 
					
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value=""
					Placeholder="Etternavn" required minlength="2" maxlength="20"
					pattern="[A-Z][A-z]*" /> 
					
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" value="" 
					Placeholder="mobilnummer" required minlength="8" maxlength="8"" 
					/> 
					
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="" 
					Placeholder = "passord"
					required minlength="3" maxlength="16"/> 
					
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					value=""  Placeholder = "Skriv passord igjen" required minlength="3" maxlength="16" /> 
					
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" 
					 />mann
				<input type="radio" name="kjonn" value="kvinne" required
					 />kvinne
				
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>