function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateForm() {
    var name = document.storeForm.name.value;
    var description = document.storeForm.description.value;
    var email = document.storeForm.email.value;
    var mobile = document.storeForm.mobile.value;

    var nameErr = emailErr = mobileErr = true;
    if (name === "") {
        printError("nameErr", "Please enter Store name");
    } else {
        var regex1 = /^[a-zA-Z\s]+$/;
        if (regex1.test(name) === false) {
            printError("nameErr", "Please enter a valid Store name");
        } else {
            printError("nameErr", "");
            nameErr = false;
        }
    }

    if (description === "") {
        printError("descriptionErr", "Please enter Store description");
    } else {
        var regex2 = /^[a-zA-Z\s]+$/;
        if (regex2.test(description) === false) {
            printError("descriptionErr", "Please enter a valid Store description");
        } else {
            printError("descriptionErr", "");
            descriptionErr = false;
        }
    }

    if (email === "") {
        printError("emailErr", "Please enter your email address");
    } else {
        var regex3 = /^\S+@\S+\.\S+$/;
        if (regex3.test(email) === false) {
            printError("emailErr", "Please enter a valid email address");
        } else {
            printError("emailErr", "");
            emailErr = false;
        }
    }

    if (mobile === "") {
        printError("mobileErr", "Please enter your mobile number");
    } else {
        var regex4 = /^[1-9]\d{11}$/;
        if (regex4.test(mobile) === false) {
            printError("mobileErr", "Please enter a valid 12 digit mobile number");
        } else {
            printError("mobileErr", "");
            mobileErr = false;
        }
    }

    if ((nameErr || emailErr || mobileErr) === true) {
        return false;
    } else {
        var dataPreview = "You've entered the following details: \n" +
            "Store Name: " + name + "\n" +
            "Store Description: " + description + "\n" +
            "Email Address: " + email + "\n" +
            "Mobile Number: " + mobile + "\n";
        alert(dataPreview);
    }
}
