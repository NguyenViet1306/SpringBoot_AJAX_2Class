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
            // displayTable(data)
        }
    })
}

// function displayTable(data) {
//     let result = ""
//     for (let i = 0; i < data.length; i++) {
//         result += "<tr>"
//         result += "<td>" + (++i) + "</td>"
//         result += "<td>" + data[i].name + "</td>"
//         result += "<td>" + data[i].price + "</td>"
//         result += "<td>" + data[i].category.name + "</td>"
//         result += "<td>" + data[i].category.name + "</td>"
//         result += "</tr>"
//     }
//     document.getElementById("tbody").innerHTML = result
// }


function setFormCreate() {
    document.getElementById("name").value = ""
    document.getElementById("price").value = ""
}

function formCreate() {
    $.ajax({
        type: "GET",
        url: "https://localhost:8080/categories",
        success: function (data) {
            let  result = ""
            for (let i = 0; i<data.length; i++) {
                result = "<option value=' " + data[i].id + "'>" + data[i].name + "</option>"
            }
            document.getElementById("category").innerHTML = result
        }
    })``\
    setFormCreate()
    document.getElementById("titleFrom").innerHTML = "Tạo sản phẩm mới"
    document.getElementById("button").innerHTML = "Tạo mới"
    document.getElementById("button").setAttribute("onclick", "createBook()")
    $('#myModal').modal("show")
}

function createBook() {
    let  name = $('#name').val()
    let price = $('#price').val()
    let category = $('#category').val()

    let book = {
        name: name,
        price: price,
        category: category,
    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "https://localhost:8080/books",
        date: JSON.stringify(book),
    })
    setFormCreate()
    document.getElementById("message").innerHTML = "Tạo mới thành công"
    getAllBook()
    event.preventDefault()


}