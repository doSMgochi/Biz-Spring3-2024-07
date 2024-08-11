document.addEventListener("DOMContentLoaded", () => {
  initializeJoinForm();
});

function initializeJoinForm() {
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
    "* 아이디가 이미 사용 중입니다",
  ];

  const form = document.querySelector("form.user.join-form");
  if (!form) {
    console.error("Form not found!");
    return;
  }

  const inputs = form.querySelectorAll("input");
  const errorMessages = form.querySelectorAll("span");

  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  const phoneRegex = /^\d{10,11}$/;

  const checkIdDuplicate = (callback) => {
    const userId = inputs[INPUT_INDEX.ID].value;
    if (userId) {
      fetch(`${rootPath}/user/check_id?user_id=${encodeURIComponent(userId)}`)
        .then((response) => response.text())
        .then((result) => {
          if (result === "EXISTS") {
            errorMessages[INPUT_INDEX.ID].textContent = ERROR_MESSAGE[8];
            errorMessages[INPUT_INDEX.ID].style.display = "inline-block";
            callback(false);
          } else {
            callback(true);
          }
        })
        .catch((error) => {
          console.error("Error:", error);
          callback(false);
        });
    } else {
      callback(true);
    }
  };

  const validateInput = (index) => {
    let value = inputs[index].value;
    if (!value) {
      errorMessages[index].textContent = ERROR_MESSAGE[index];
      errorMessages[index].style.display = "inline-block";
      inputs[index].focus();
      return false;
    }
    if (index === INPUT_INDEX.EMAIL && !emailRegex.test(value)) {
      errorMessages[index].textContent = ERROR_MESSAGE[6];
      errorMessages[index].style.display = "inline-block";
      inputs[index].focus();
      return false;
    }
    if (index === INPUT_INDEX.TEL) {
      value = value.replace(/-/g, "");
      if (!phoneRegex.test(value)) {
        errorMessages[index].textContent = ERROR_MESSAGE[7];
        errorMessages[index].style.display = "inline-block";
        inputs[index].focus();
        return false;
      }
    }
    return true;
  };

  const onSubmit = () => {
    console.log("Submit button clicked");
    let valid = true;
    errorMessages.forEach((span) => (span.style.display = "none"));

    checkIdDuplicate((isAvailable) => {
      if (isAvailable) {
        for (let i = 0; i < inputs.length; i++) {
          if (!validateInput(i)) {
            valid = false;
            break;
          }
        }
        if (valid) {
          console.log("Form is valid, submitting...");
          inputs[INPUT_INDEX.BUTTON].disabled = true;
          form.submit();
        }
      }
    });
  };

  inputs[INPUT_INDEX.BUTTON].addEventListener("click", onSubmit);

  inputs[INPUT_INDEX.ID].addEventListener("blur", () => {
    checkIdDuplicate((isAvailable) => {
      if (!isAvailable) {
        inputs[INPUT_INDEX.ID].focus();
      }
    });
  });
}
