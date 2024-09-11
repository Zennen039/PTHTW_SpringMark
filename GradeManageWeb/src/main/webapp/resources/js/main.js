function deleteSubject(endpoint, subjectId) {
    if (confirm("Are you sure?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let ds = document.getElementById(`subject${subjectId}`);

                ds.style.display = "none";

                location.reload();
            } else
                alert("Something wrong! Please try again!");
        });
    }
}

function deleteUser(endpoint, userId) {
    if (confirm("Are you sure?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let ds = document.getElementById(`user${userId}`);

                ds.style.display = "none";

                location.reload();
            } else
                alert("Something wrong! Please try again!");
        });
    }
}