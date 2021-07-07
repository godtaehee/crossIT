const form = document.getElementById('form');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');


//show input error message
function showError(input,message) {
    const formControl = input.parentElement;
    formControl.className = 'form-control error';
    const small = formControl.querySelector('small');
    small.innerText = message;
}

//show success outline
function showSuccess(input){
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

//Check emial is valid
function isValidEmail(email){
    const re = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    return re.test(String(email).toLowerCase());
}



//Event listeners
form.addEventListener('submit',function(e){
    e.preventDefault();
    console.log(username.value);

    if(username.value ===''){
        showError(username,'아이디를 입력 해주세요');
    }
    else{
        showSuccess(username);
    }

    if(email.value ===''){
        showError(email,'이메일을 입력해주세요');
    }else if(!isValidEmail(email.value)){
        showError(email,'이메일형식이 올바르지 않습니다.')
    }
     else{
        showSuccess(email);
        console.log(email.value);
    }

    if(password.value === ''){
        showError(password,'비밀번호를 입력해주세요');
    } else {
        showSuccess(password);
    }

    if(password2.value ===''){
        showError(password2,'비밀번호가 맞지 않습니다.');
    } else{
        showSuccess(password2);
    }
});