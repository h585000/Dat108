// check form validility and enable button if valid
const form = document.getElementById('form')
form.querySelectorAll('input').forEach(input => {
    input.addEventListener('input', () => {
        if (input.checkValidity()) {
            input.classList.remove('is-invalid')
            input.classList.add('is-valid')
        } else {
            input.classList.remove('is-valid')
            input.classList.add('is-invalid')
        }

        var is_valid =
            $('.form-control').length === $('.form-control.is-valid').length &&
            isPasswordsEqual() &&
            form.querySelector('input[type="radio"]:checked') != null

        form.querySelector('*[data-toggle="modal"]').disabled = !is_valid
    })
})

const passord = form.querySelector('*[data-passord1]')
const passord2 = form.querySelector('*[data-passord2]')
const passordStyrke = form.querySelector('*[data-passord-strength]')
const passordError = form.querySelector('*[data-passord-error]')

// oninput to check password strength
const checkpasswordstrength = () => {
    let length = passord.value.length
    if (length > 8) {
        passordStyrke.innerHTML = 'Sterkt passord'
        passordStyrke.classList = 'text-success'
    } else if (length >= 5) {
        passordStyrke.innerHTML = 'Middels sterkt passord'
        passordStyrke.classList = 'text-warning'
    } else if (length < 3) {
        passordStyrke.innerHTML = 'Svakt passord'
        passordStyrke.classList = 'text-danger'
    }
}

// onchange to check if passwords is equal
const checkpassword = () => {
    if (!isPasswordsEqual()) {
        passordError.classList.add('display')
        passordError.classList.remove('hide')
    } else {
        passordError.classList.add('hide')
        passordError.classList.remove('display')
    }
}

const isPasswordsEqual = () => {
    return passord !== '' && passord2 !== '' && passord.value === passord2.value
}

// enable tooltip for passsword info
$(document).ready(function() {
    $('[data-toggle="tooltip"]').tooltip({
        container: 'body'
    })
})