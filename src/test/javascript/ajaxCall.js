<<<<<<< HEAD
function checkWord(word) {
    var returnValue = "";
    $(function () {


        // $('#view').click(function () {
        //     var corpusSource = $('#cSource').val();
        //     if (!corpusSource) {
        //         //message for the user to make a selection from the dropdown
        //     }

            $.ajax({
                method: "POST",
                url: "https://cherokeedictionary.net/jsonsearch/chr/"+word,
                // data: {corpusSource: corpusSource},
                success: function (data) {
                    // window.location = data;
                    alert(data);
                    returnValue = data;
                    // $("#sourceChanged").html(data);
                }
            })
        // });
    });

    // var xhttp = new XMLHttpRequest();

    // xhttp.open("GET", "https://cherokeedictionary.net/jsonsearch/chr/" + word, true);
    // xhttp.send();

    // xhttp.onreadystatechange = function() {
    //     if (this.readyState == 4 && this.status == 200) {
    //         returnValue = this.responseText;
    //         // document.getElementById("demo").innerHTML = this.responseText;
    //     }
    // };

    return returnValue;
=======
// modified example from https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Asynchronous/Async_await

async function checkWord(word) {
    var url = `http://localhost:8080/jsonlookup/${word}`;

    let response = await fetch(url);

    let content;

    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }

    content = await response.text();

    return content;
}

async function lookupWordInCED(word) {
    var content = await checkWord(word);

    let values = await Promise.all([content]);

    if (values.length > 0 && values[0] !== "null") {
        return values;
    } else {
        return [];
    }
>>>>>>> 23dbc653988dcecbebacf29bbce64cb9fc978b93
}
