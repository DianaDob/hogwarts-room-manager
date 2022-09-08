let renovateButtons = document.getElementsByClassName('renovate-button');
let deleteButtons = document.getElementsByClassName('delete-button');

for(let button of renovateButtons){
    button.addEventListener('click', (event)=>renovateRoom(event))
}


for(let button of deleteButtons){
    button.addEventListener('click', (event)=>deleteRoom(event))
}

async function renovateRoom(event) {
    let roomIdIndex = event.target.id.search(/\d+/);
    let roomId = event.target.id.slice(roomIdIndex);
    const response = await fetch(`/rooms/${roomId}`, {method: 'PUT'});
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    const data = await response.json();
    updateRenovatedInfo(data, roomId);
}

async function deleteRoom(event) {
    let roomIdIndex = event.target.id.search(/\d+/);
    let roomId = event.target.id.slice(roomIdIndex);
    const response =  await fetch(`/rooms/${roomId}`, {method: 'DELETE'});
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    removeRowFromTable(roomId);
}

function updateRenovatedInfo(renovated, roomId){
    const constructedId = "notrenovated" + roomId;
    if(renovated){
        document.getElementById(constructedId).innerText = "Yes!";
    }
    else{
        console.log(`Something happened, the renovation status of the room is ${renovated}`);
    }
}

function removeRowFromTable(roomId) {
    document.getElementById(roomId).remove();
}