getAllBook()
function getAllBook() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/books",
        success: function (data) {
            console.log(data)
            let result = ""
        for (let i = 0 ; i < data.length ; i++ ) {
            result += "<tr>"
            result += "<td>" + (i + 1) + "</td>"
            result += "<td>"+ data[i].name +"</td>"
            result += "<td>" + data[i].price + "</td>"
            result += "<td>" + data[i].category.name + "</td>"
            result += "</tr>"
        }
        document.getElementById("tbody").innerHTML = result
        }
    })
}
//
// function displayTable(data) {
//     let result = ""
//     for (let i = 0 ; i < data.length ; i++ ) {
//         result += "<tr>"
//         result += "<td>" + (++i) + "</td>"
//         result += "<td>"+ data[i].name +"</td>"
//         result += "<td>" + data[i].price + "</td>"
//         result += "<td>" + data[i].category.name + "</td>"
//         result += "</tr>"
//     }
//     document.getElementById("tbody").innerHTML = result
// }