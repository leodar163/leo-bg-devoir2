document.addEventListener('DOMContentLoaded', onLoad);

async function onLoad() {
    let traderId = new URL(window.location).searchParams.get('id');
    let trader = await getTrader(traderId);
    if (trader === undefined) {
        console.error(`impossible de récupérer un trader avec l'id ${traderId}`)
        return
    }

    let actions = await getActions(trader);

    console.table(actions);

    document.getElementById("titre").innerText = `Actions achetées par ${trader.nom}`

    document.getElementById("action-list").innerHTML = await drawActionList(actions);
}

async function getTrader(id) {
    let response = await fetch(`trader/${id}`);

    if (!response.ok)
        return undefined

    return  await response.json();
}

async function getActions(trader) {
    let response = await fetch(`acheter/of-trader/${trader.id}`)

    if (!response.ok)
        return undefined

    return await response.json();
}

async function drawActionList(traderActions) {
    return `
        <ul>
            ${traderActions.map((action, index) => `
                <li key=${index}>
                    <span>${action.action.nom}</span>
                    <span>${action.quantite}</span>
                    <span>${action.prix}€</span>
                    <button class="button">vendre</button>
                </li>
            `).join('')}    
        </ul>
    `
}