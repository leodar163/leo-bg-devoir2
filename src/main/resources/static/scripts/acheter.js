// document.addEventListener('DOMContentLoaded', onLoad);
window.onload = () => {
    onLoad();
}

async function onLoad() {
    let traderId = new URL(window.location).searchParams.get('id');
    let trader = await getTrader(traderId);
    if (trader === undefined) {
        console.error(`impossible de récupérer un trader avec l'id ${traderId}`)
        return
    }

    let actions = await getActions(trader);

    console.table(actions);

    document.getElementById("titre").innerText = `Actions achetées par ${trader.nom}`;

    document.getElementById("action-list").innerHTML = await drawActionList(actions);

    document.getElementById("acheter-wrapper").innerHTML = await drawAcheterForm(trader);
}

async function getTrader(id) {
    let response = await fetch(`trader/${id}`);

    if (!response.ok)
        return undefined;

    return  await response.json();
}

async function getActions(trader) {
    let response = await fetch(`acheter/of-trader/${trader.id}`)

    if (!response.ok)
        return undefined;

    return await response.json();
}

async function drawActionList(traderActions) {

    return `
        <ul class="actionlist">
            <li class="actionListRow actionListHeader">
            <span class="actionListElement">nom</span>
            <span class="actionListElement">quantité</span>
            <span class="actionListElement">prix</span>
            <span class="actionListElement">vente</span>
            </li>
            ${traderActions.map((action, index) => `
                <li class="actionListRow actionListHeader" key=${index}>
                    <span class="actionListElement">${action.action.nom}</span>
                    <span class="actionListElement">${action.quantite}</span>
                    <span class="actionListElement">${action.prix}€</span>
                    <div class="actionListElement sellSliderContainer">
                        <span class="sellSliderNumber" id="slider-${index}-feedback">${action.quantite}</span>
                        <input class="sellSlider" onchange="onSliderChange('slider-${index}')" type="range" min="0" max="${action.quantite}"
                        value="${action.quantite}"
                        id="slider-${index}">
                    </div>
                    <button onclick="sell(${action.trader.id}, ${action.action.id}, ${index})" class="button">vendre</button>
                </li>
            `).join('')}    
        </ul>
    `
}

function onSliderChange(sliderId) {
    slider = document.getElementById(sliderId);
    sliderFeedback = document.getElementById(sliderId+'-feedback');
    sliderFeedback.innerText = `${slider.value}`;
}

async function sell(traderId, actionId, sliderIndex) {
    let quantity = parseInt(document.getElementById(`slider-${sliderIndex}`).value);

    console.log(traderId, actionId, quantity);

    let response = await fetch('acheter/vendre',{
        method: 'POST',
        body: JSON.stringify({
            traderId: traderId,
            actionId: actionId,
            quantity: quantity
        }),
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }
    });

    if (!response.ok)
        return undefined;

    window.location.reload();
}


async function drawAcheterForm(trader) {
    response = await fetch(`action/not-of-trader/${trader.id}`);

    if (!response.ok)
        return undefined;

    missingActions = await response.json();

    console.table(missingActions);

    return `
        <div>
        <h2>acheter une nouvelle action</h2>
            <select id="action-select">
                ${missingActions.map((action, index) => `
                    <option value=${action.id}>${action.nom}</option>
                `)}
            </select>
            <div>
                <label>prix</label>
                <input id="action-price" type="number" min="0" value="100">
            </div>
            <div>
                <label>quantité</label>
                <input id="action-quantity" type="number" step="1" min="0" value="10">
            </div>
            <button onclick="buy(${trader.id})">acheter</button>
        </div>
    `
}

async function buy(traderId) {
    let actionId =  parseInt(document.getElementById("action-select").value);
    let price = parseInt(document.getElementById(`action-price`).value);
    let quantity = parseInt(document.getElementById(`action-quantity`).value);

    console.log(price);

    let response = await fetch('acheter/acheter',{
        method: 'POST',
        body: JSON.stringify({
            traderId: traderId,
            actionId: actionId,
            price: price,
            quantity: quantity
        }),
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }
    });

    if (!response.ok)
        return undefined;

    window.location.reload();
}