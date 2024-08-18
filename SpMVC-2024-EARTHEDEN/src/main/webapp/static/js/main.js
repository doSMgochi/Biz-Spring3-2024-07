document.addEventListener("DOMContentLoaded", () => {
  const absolutePath = "/eartheden/";

  const districts = {
    서울: [
      "전체",
      "종로구",
      "중구",
      "용산구",
      "성동구",
      "광진구",
      "동대문구",
      "중랑구",
      "성북구",
      "강북구",
      "도봉구",
      "노원구",
      "은평구",
      "서대문구",
      "마포구",
      "양천구",
      "강서구",
      "구로구",
      "금천구",
      "영등포구",
      "동작구",
      "관악구",
      "서초구",
      "강남구",
      "송파구",
      "강동구",
    ],
    대구: ["전체", "동구", "달서구", "달성군", "서구", "수성구", "중구"],
    부산: [
      "전체",
      "서구",
      "수영구",
      "금정구",
      "남구",
      "사상구",
      "연제구",
      "해운대구",
    ],
    대전: ["전체", "중구", "대덕구", "서구", "동구"],
    광주: ["전체", "동구", "서구", "남구", "북구", "광산구"],
    인천: [
      "전체",
      "중구",
      "동구",
      "미추홀구",
      "연수구",
      "남동구",
      "부평구",
      "계양구",
      "서구",
      "강화군",
      "옹진군",
    ],
  };

  const citySelect = document.getElementById("citySelect");
  const districtSelect = document.getElementById("districtSelect");

  const onCityChange = () => {
    const city = citySelect.value;

    districtSelect.innerHTML = districts[city]
      .map(
        (district) => `<option value="${city}${district}">${district}</option>`
      )
      .join("");
  };

  const onRegionChange = () => {
    const region = districtSelect.value;
    window.location.href = `${absolutePath}?region=${region}`;
  };

  onCityChange();

  citySelect.addEventListener("change", onCityChange);
  districtSelect.addEventListener("change", onRegionChange);
});
