tinymce.init({
  selector: "#mytextarea",
  plugins: "image code",
  toolbar: "undo redo | image code",
  images_upload_url: `${rootPath}/upload-image`,
  images_upload_handler: function (blobInfo, success, failure) {
    let xhr, formData;

    xhr = new XMLHttpRequest();
    xhr.withCredentials = false;
    xhr.open("POST", `${rootPath}/upload-image`);

    xhr.onload = function () {
      let json;

      if (xhr.status != 200) {
        failure("HTTP Error: " + xhr.status);
        return;
      }

      json = JSON.parse(xhr.responseText);

      if (!json || typeof json.location != "string") {
        failure("Invalid JSON: " + xhr.responseText);
        return;
      }

      success(json.location);
    };

    formData = new FormData();
    formData.append("file", blobInfo.blob(), blobInfo.filename());

    xhr.send(formData);
  },
});
