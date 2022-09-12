let renovateButtons = document.getElementsByClassName('renovate-button');
let deleteButtons = document.getElementsByClassName('delete-button');
let roomIdButtons = document.getElementsByClassName('room');
let addRoomButton = document.getElementById("add-room");
let table = document.getElementsByTagName('tbody')[0];


addRoomButton.addEventListener('click', addRoom)

for(let button of renovateButtons){
    button.addEventListener('click', (event)=>renovateRoom(event))
}

for(let button of deleteButtons){
    button.addEventListener('click', (event)=>deleteRoom(event))
}

for(let button of roomIdButtons){
    button.addEventListener('click', (event)=>goToRoom(event))
}

function addRoom() {
    const lastTableRow = table.rows.item(table.rows.length-1);
    const lastRoomId = parseInt(lastTableRow.id);
    const newRoomId = lastRoomId + 1;
    table.insertAdjacentHTML('beforeend',
        `<tr id="${newRoomId}">
                    <td>${newRoomId}</td>
                    <td>
                        <select id="select">
                            <option value="GRYFFINDOR">GRYFFINDOR</option>
                            <option value="HUFFLEPUFF">HUFFLEPUFF</option>
                            <option value="RAVENCLAW">RAVENCLAW</option>
                            <option value="SLYTHERIN">SLYTHERIN</option>                        
                        </select>
                    </td>
                    <td><button id="create">Create room!</button></td>
                </tr>`
    )
    const createButton = document.getElementById('create');
    const selectMenu = document.getElementById('select');
    createButton.addEventListener('click', function() {postNewRoom(newRoomId, selectMenu)})
}


async function postNewRoom(newRoomId, selectMenu){
    const selectedOption = selectMenu[selectMenu.selectedIndex].innerText;
    const response = await fetch(`/rooms`,
                    {   method: 'POST',
                            headers: {
                            'Content-Type': 'application/json'
                        },
                            body: JSON.stringify({roomId: newRoomId,
                                                    students: null,
                                                    houseType: selectedOption,
                                                    renovated: false,
                                                    full: false}),

                    })
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    else{
        updateAddedTableRow(selectedOption, newRoomId);

    }

}

function updateAddedTableRow(selectedOption, newRoomId) {
    const lastTableRow = table.rows.item(table.rows.length-1);
    lastTableRow.children[0].innerHTML = `<button id="room${newRoomId}" class="room">${newRoomId}</button>`;
    lastTableRow.children[1].innerHTML = selectedOption; // houseType
    lastTableRow.children[2].innerHTML = ""; // students
    lastTableRow.insertAdjacentHTML('beforeend', `<td id="notrenovated${newRoomId}">Not yet</td>`);
    lastTableRow.insertAdjacentHTML('beforeend', `<td><button id="renovate${newRoomId}" class="renovate-button">Renovate</button></td>`);
    lastTableRow.insertAdjacentHTML('beforeend', `<td><button id="delete${newRoomId}" class="delete-button">Delete</button></td>`);
    document.getElementById("room" + newRoomId).addEventListener('click', (event)=>goToRoom(event));
    document.getElementById("renovate" + newRoomId).addEventListener('click', (event)=>renovateRoom(event));
    document.getElementById("delete" + newRoomId).addEventListener('click', (event)=>deleteRoom(event));

}

function goToRoom(event){
    let roomIdIndex = event.target.id.search(/\d+/);
    let roomId = event.target.id.slice(roomIdIndex);
    window.location.href = `/rooms/${roomId}`;
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