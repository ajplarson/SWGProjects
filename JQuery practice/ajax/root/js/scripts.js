
$.ajax({
    type: 'GET',
    url: 'http://tsg-random-things.herokuapp.com/randomCompliment',
    success: function (compliment) {
        console.log(compliment);
    },
    error: function () {
        alert('FAILURE!');
    }
});





$("#frm").submit(function (evt) {

    $.ajax({
        type: "POST",
        url: "http://tsg-random-things.herokuapp.com/randomCompliment",
        data: JSON.stringify({
            name: $("#yourName").val()
        }),
        headers: {
            "Content-Type": "application/json"
        },
        success: function (compliment) {
            $("#output").val(compliment);
        },
        error: function () {
            alert("FAILURE!");
        }
    });

    return false;
});

$("#frmcolor").submit(function (evt) {

    $.ajax({
        type: "GET",
        url: "http://tsg-random-things.herokuapp.com/randomColor",

        success: function (color) {

            $("#background").css({ 'background-color': color.background });
            $("#colorme").css({ 'color': color.font });
        },
        error: function () {
            alert("FAILURE!");
        }
    });

    return false;
});

$("#frmmath").submit(function (evt) {
    var operator = $("#operator").val();
    var operand1 = $("#operand1").val();
    var operand2 = $("#operand2").val();
    $.ajax({
        type: "GET",
        url: `http://tsg-random-things.herokuapp.com/maths/${operand1}/${operator}/${operand2}`,

        success: function (resultOfOperation) {

            $("#result").val(resultOfOperation.answer);

        },
        error: function () {
            alert("FAILURE!");
        }
    });

    return false;
});



$("#frmanimal").submit(function (evt) {

    $.ajax({
        type: "GET",
        url: "http://tsg-random-things.herokuapp.com/randomAnimal",

        success: function (animal) {

            var html = `<div class="card">
                <img src="${animal.pic}" class="card-img-top" alt="${animal.name}">
                <div class="card-body">
                <h5 class="card-title">${animal.name}</h5>
                ${animal.description}
                </div>
            </div>`;
            $("#aminals").html(html);

        },
        error: function () {
            alert("FAILURE!");
        }
    });

    return false;
});
