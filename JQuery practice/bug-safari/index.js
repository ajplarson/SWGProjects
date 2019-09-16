var bugContainer = $("#bugContainer");
var bugs = [];

function render() {
    bugContainer.empty();

    var html = "";
    bugs.forEach(function(bug) {
        html += `<div class="card col-4">
                <img src="${bug.imageUrl}" class="card-img-top" alt="${bug.name}">
                <div class="card-body">
                <h5 class="card-title">${bug.name}</h5>
                ${bug.description}
                </div>
            </div>`;
    });
    bugContainer.append(html);
}

$("#frm").submit(function (evt) {
    evt.preventDefault();

    var bug = {
        name: $("#bugName").val(),
        imageUrl: $("#bugImage").val(),
        description: $("#bugDescription").val()
    };

    this.reset();

    bugs.push(bug);
    render();

    //console.log(bugs);

    $("#modalAdd").modal("hide");

    return false;
});