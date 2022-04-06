function ValidateEmail(inputText)
{
    let mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(!inputText.value.match(mailFormat))
    {
        alert("You have entered an invalid email address!");
        document.form.email.focus();
        return false;
    }

    return true;
}

function IsNumber(evt) {
    evt = (evt) ? evt : window.event;
    let charCode = (evt.which) ? evt.which : evt.keyCode;
    return !(charCode > 31 && (charCode < 48 || charCode > 57));

}