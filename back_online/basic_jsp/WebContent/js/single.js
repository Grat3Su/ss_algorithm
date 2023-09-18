window.onload = function() {
    const existingData = sessionStorage.getItem("curID");
    console.log(existingData);
    const curID = JSON.parse(existingData);
    if (existingData) {
      document.querySelector("#name").value= curID.username;
      document.querySelector("#userId").value = curID.id;
    }
}
  

document.getElementById("submitButton").addEventListener("click", function(){  
  let comment = document.querySelector("#commnet-comment");
  comment.innerHTML += 
  ' <li class="comment"> ' +
      '<div class="vcard">' +
          '<img src="https://images.emojiterra.com/google/android-10/512px/1f9d1.png" alt="Image placeholder">' +
      
      '</div>' +
      '<div class="comment-body">' +
          '<h3>' + document.querySelector("#name").value + '</h3>' +
          '<div class="meta">' + new Date() + '</div>' +
          '<p>' + document.querySelector("#message").value +'</p>' +
          '<p><a href="#" class="reply rounded">Reply</a></p>' +
      '</div>' +
  '</li>';
  document.querySelector("#message").value = "";
  
})