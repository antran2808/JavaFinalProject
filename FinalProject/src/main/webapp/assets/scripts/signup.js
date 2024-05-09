const form = document.querySelector("form");
form.addEventListener("submit", event => {
    event.preventDefault();
    const password = document.querySelector("#password");
    const repassword = document.querySelector("#repassword");
    if (password.value !== repassword.value) {
        document.querySelector(".form-err").innerHTML = "Password does not match";
    } else {
        form.submit();
    }
});