document.addEventListener("DOMContentLoaded", () => {
  const INPUT_INDEX = {
    ID: 0,
    PASSWORD: 1,
    BUTTON: 2,
  };

  const ERROR_MESSAGE = [
    "* 아이디는 필수 항목입니다",
    "* 비밀번호는 필수 항목입니다",
  ];

  const login_form = document.querySelector("form.user.join");
  const login_inputs = login_form.querySelectorAll("input");
  const error_inputs = login_form.querySelectorAll("span");

  const emptyValid = (index) => {
    const text = login_inputs[index].value;
    if (!text) {
      error_inputs[index].textContent = ERROR_MESSAGE[index];
      error_inputs[index].style.display = "inline-block";
      login_inputs[index].select();
      return false;
    }
    return true;
  };

  const onLoginSubmit = () => {
    let yesValid = true;
    for (let i = 0; i < error_inputs.length; i++) {
      const span = error_inputs[i];
      span.style.display = "none";
      if (!(yesValid = emptyValid(i))) break;
    }
    if (yesValid) login_form.submit();
  };

  login_inputs[INPUT_INDEX.BUTTON].addEventListener("click", onLoginSubmit);
});
