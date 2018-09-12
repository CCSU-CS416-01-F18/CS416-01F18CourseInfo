function CheckNumber(){
  var enteredNum = parseInt(document.getElementById('input').value);
  if (enteredNum % 2 == 0){
    document.getElementById('emotion').src='smile.png';
  }else{
    document.getElementById('emotion').src='sad.png';
  }
}
