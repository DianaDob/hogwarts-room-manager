let backButton = document.getElementById('back');

backButton.addEventListener('click', goBackToRooms);

function goBackToRooms() {
    window.location.href = "/rooms";
}