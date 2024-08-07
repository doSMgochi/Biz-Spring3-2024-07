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
    "* 이메일 형식이 올바르지 않습니다",
    "* 전화번호 형식이 올바르지 않습니다",
  ];
  const join_form = document.querySelector("form.user.join");
  const join_inputs = join_form.querySelectorAll("input");
  const error_inputs = join_form.querySelectorAll("span");

  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  const phoneRegex = /^\d{10,11}$/;

  const emptyValid = (index) => {
    const text = join_inputs[index].value;
    if (!text) {
      error_inputs[index].textContent = ERROR_MESSAGE[index];
      error_inputs[index].style.display = "inline-block";
      join_inputs[index].select();
      return false;
    }
    if (index === INPUT_INDEX.EMAIL && !emailRegex.test(text)) {
      error_inputs[index].textContent = ERROR_MESSAGE[6];
      error_inputs[index].style.display = "inline-block";
      join_inputs[index].select();
      return false;
    }
    if (index === INPUT_INDEX.TEL) {
      text = text.split("-").join("");
      if (!phoneRegex.test(text)) {
        error_inputs[index].textContent = ERROR_MESSAGE[7];
        error_inputs[index].style.display = "inline-block";
        join_inputs[index].select();
        return false;
      }
    }
    return true;
  };
  // 비밀번호 유효성 검사는 일단 throws 하고, 아이디 중복검사와 닉네임 중복검사 처리, 생년월일은 1900년생부터 현재 날짜까지 처리
  // 이메일은 이메일을 발송해서 확인하는 절차를 만들면 이메일의 유효성을 더 증가시킬 수 있을 것 같은데 일단은 뒤로 미루자
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
