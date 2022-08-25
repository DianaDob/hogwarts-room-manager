let renovateButtons = document.getElementsByClassName('renovate-button');
let deleteButtons = document.getElementsByClassName('delete-button');

for(let button of renovateButtons){
    button.addEventListener('click', (event)=>renovateRoom(event))
}


for(let button of deleteButtons){
    button.addEventListener('click', (event)=>deleteRoom(event))
}

function renovateRoom(event) {
    let roomIdIndex = event.target.id.search(/\d/);
    let roomId = event.target.id[roomIdIndex];
    fetch(`/rooms/${roomId}`, {method: 'PUT'})
        .then(() => {
        window.location.reload();
    })
}

function deleteRoom(event) {
    let roomIdIndex = event.target.id.search(/\d/);
    let roomId = event.target.id[roomIdIndex];
    console.log(roomId);
    fetch(`/rooms/${roomId}`, {method: 'DELETE'})
        .then(() => {
            window.location.reload();
        })
}