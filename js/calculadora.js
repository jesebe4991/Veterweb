function descuento(){
    var pD=0,vD=0, valorPago=0, vPr=0;
    var estrato=parseInt(document.getElementById("TiEstr").value);
    var NombreDueño=parseInt(document.getElementById("IdUser").value);
    var procedimiento=parseInt(document.getElementById("TiPro").value);

    switch (estrato) {
        case 1:
            pD=0.50;
            break;
        case 2:
            pD=0.40;
            break;
        case 3:
            pD=0.30;
            break;
        case 4:
            pD=0.10;
            break;
        case 5:
            pD=0.5;
            break;
    }

    vD=procedimiento * pD;
    valorPago=procedimiento - vD;
    vPr = pD * 100;
    alert("Señor/a con identificacion "+NombreDueño+" Su valor de descuento es "+vPr+"% "+" por pertenecer al estrato "+estrato+" el valor a pagar es: "+ valorPago);

}