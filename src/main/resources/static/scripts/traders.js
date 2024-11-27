document.addEventListener('DOMContentLoaded', onLoad);

async function onLoad() {
    let traders = await getTraders();
    document.getElementById('trader-list').innerHTML = await drawTraderList(traders);
}

async function getTraders() {
    const response = await fetch('/trader/all');

    if (!response.ok)
        return undefined

    return await response.json();
}

async function drawTraderList(traders) {
    return `
    <ul>
        ${traders.map(trader => `<li key="${trader.id}">
            <span>${trader.nom}</span>
            <a href="/trader/${trader.id}">actions</a>
        </li>`).join('')}
    </ul>
    `
}


// console.log("coucou")