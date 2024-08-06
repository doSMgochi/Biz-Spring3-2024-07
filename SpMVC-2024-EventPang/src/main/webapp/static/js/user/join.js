document.addEventListener("DOMContentLoaded", () => {
  const INPUT_INDEX = {
    ID: 0,
    PASSWORD: 1,
    NICK: 2,
    EMAIL: 3,
    BIRTH: 4,
    TEL: 5,
    GENDER_MALE: 6,
    GENDER_FEMALE: 7,
    ROLE_ENTERPRISE: 8,
    ROLE_PERSONAL: 9,
    BUTTON: 10,
  };
  const ERROR_MESSAGE = [
    "* 아이디는 필수 항목입니다",
    "* 비밀번호는 필수 항목입니다",
    "* 닉네임은 필수 항목입니다",
    "* 이메일은 필수 항목입니다",
    "* 생년월일은 필수 항목입니다",
    "* 전화번호는 필수 항목입니다",
  ];
  const join_form = document.querySelector("form.user.join");
  const join_inputs = join_form.querySelectorAll("input");
  const error_inputs = join_form.querySelectorAll("span");

  const emptyValid = (index) => {
    const text = join_inputs[index].value;
    if (!text) {
      error_inputs[index].textContent = ERROR_MESSAGE[index];
      error_inputs[index].style.display = "inline-block";
      join_inputs[index].select();
      return false;
    }
    return true;
  };

  const onJoinSubmit = () => {
    let yesValid = true;
    for (let i = 0; i < error_inputs.length; i++) {
      const span = error_inputs[i];
      span.style.display = "none";
      if (!(yesValid = emptyValid(i))) break;
    }
    if (yesValid) join_form.submit();
  };
  join_inputs[INPUT_INDEX.BUTTON].addEventListener("click", onJoinSubmit);
});
