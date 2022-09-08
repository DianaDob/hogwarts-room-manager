let renovateButtons = document.getElementsByClassName('renovate-button');
let deleteButtons = document.getElementsByClassName('delete-button');
let addRoomButton = document.getElementById("add-room");
let table = document.getElementsByTagName('tbody')[0];


addRoomButton.addEventListener('click', addRoom)

for(let button of renovateButtons){
    button.addEventListener('click', (event)=>renovateRoom(event))
}


for(let button of deleteButtons){
    button.addEventListener('click', (event)=>deleteRoom(event))
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
    let houseType = lastTableRow.children[1];
    let students = lastTableRow.children[2];
    let renovatedStatus = "Not yet";
    let renovateButton = `<td><button id="renovate + ${newRoomId}" class="renovate-button">Renovate</button></td>`;
    let deleteButton = `<td><button th:id="delete + ${newRoomId}" class="delete-button">Delete</button></td>`;
    houseType.innerHTML = selectedOption;
    students.innerHTML = "";
    lastTableRow.insertAdjacentHTML('beforeend', `<td>${renovatedStatus}</td>`);
    lastTableRow.insertAdjacentHTML('beforeend', renovateButton);
    lastTableRow.insertAdjacentHTML('beforeend', deleteButton);

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