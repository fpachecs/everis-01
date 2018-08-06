// Nos dice cuantos radio buttons están seguidos, que normalmente
// pertenecen a una categoría.
var numInputRadio = 0;
// Si existe más de una categoría de radio button, este es el indice
// que nos hará validar por categoría.
var indGrupoRadio = 0;

function validaFormulario(form) {
	// No hace falta buscarlo, ya lo tenemos.
	//var form = document.getElementById(idForm);
	var msg = "";
	var error = false;

	for (i = 0; i < form.childNodes.length; i++) {
		var itemForm = form.childNodes[i];
		var value;
		var field
		
		// Capturar etiqueta: <input>
		if (itemForm.tagName != null && itemForm.tagName == "INPUT") {
			value = itemForm.value;
			field = itemForm.name;

			if (itemForm.type == "text"
					&& (value == null || value.length == 0 || /^\s+$/.test(value))) {
				error = true;
				msg += "El campo " + field +" est\u00E1 vac\u00CDo.\n\n";
			}
			if (itemForm.type == "password"
				&& (value == null || value.length == 0 || /^\s+$/.test(value))) {
				error = true;
				msg += "El campo " + field +" debe contener una contrase\u00F1a.\n\n";
			}
			if (itemForm.type == "number"
					&& (value == null || value.length == 0 || isNaN(value))) {
				error = true;
				msg += "El campo " + field + " debe contener n\u00FAmeros.\n\n";
			}
		// Capturar etiqueta <div> que dentro tendrá opciones (Checks, Radios, Etc).
		} else if (itemForm.tagName != null && itemForm.tagName == "DIV") {
			clase = itemForm.value;
			field = itemForm.name;
			
			if (itemForm.type = "radio" && !validaRadioButton(indGrupoRadio)) {
				error = true;
				msg += "Debe seleccionar una opci\u00F3n correspondiente a "
						+ field + ".\n\n";
				i += numInputRadio;
				indGrupoRadio++;
			}
		}
	}
	// Verificar se han dado errores.
	if (error) {
		alert(msg);
		return false;
	} else {
		return true;
	}
}

function validaRadioButton(indice) {
	var opciones = document.getElementsByClassName('opcionesRadio')[indice];
	var radioSeleccionado = false;

	for (var i = 0; i < opciones.children.length; i++) {
		var itemOpcion = opciones.children[i];
		
		// Capturar etiqueta: <input>
		if (itemOpcion.tagName != null && itemOpcion.tagName == "INPUT") {
			if (itemOpcion.checked) {
				radioSeleccionado = true;
			}
			numInputRadio++;
		}
	}
	
	return radioSeleccionado;
}