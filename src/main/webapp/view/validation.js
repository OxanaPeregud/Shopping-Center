function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateForm() {
    var name = document.shopForm.name.value;
    var description = document.shopForm.description.value;
    var discount = document.shopForm.discount.value;
    var discountStartDate = document.shopForm.discountStartDate.value;
    var discountEndDate = document.shopForm.discountEndDate.value;
    var location = document.shopForm.location.value;
    var email = document.shopForm.email.value;
    var mobile = document.shopForm.mobile.value;

    var nameErr = descriptionErr = discountErr = locationErr = emailErr = mobileErr = true;

    if (name === "") {
        printError("nameErr", "Please enter Shop name");
    } else {
        var regex1 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex1.test(name) === false) {
            printError("nameErr", "Please enter a valid Shop name");
        } else {
            printError("nameErr", "");
            nameErr = false;
        }
    }

    if (description === "") {
        printError("descriptionErr", "Please enter Shop description");
    } else {
        var regex2 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex2.test(description) === false) {
            printError("descriptionErr", "Please enter a valid Shop description");
        } else {
            printError("descriptionErr", "");
            descriptionErr = false;
        }
    }

    if (discount === "") {
        printError("discountErr", "Please enter discount");
    } else {
        var regex3 = /^[0-9]+$/;
        if (regex3.test(discount) === false) {
            printError("discountErr", "Please enter a valid discount (only numeric characters allowed)");
        } else {
            printError("discountErr", "");
            discountErr = false;
        }
    }

    if (location === "") {
        printError("locationErr", "Please enter Shop location");
    } else {
        var regex4 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex4.test(location) === false) {
            printError("locationErr", "Please enter a valid Shop location");
        } else {
            printError("locationErr", "");
            locationErr = false;
        }
    }

    if (email === "") {
        printError("emailErr", "Please enter Shop email address");
    } else {
        var regex5 = /^\S+@\S+\.\S+$/;
        if (regex5.test(email) === false) {
            printError("emailErr", "Please enter a valid email address");
        } else {
            printError("emailErr", "");
            emailErr = false;
        }
    }

    if (mobile === "") {
        printError("mobileErr", "Please enter Shop mobile number");
    } else {
        var regex6 = /^[1-9]\d{11}$/;
        if (regex6.test(mobile) === false) {
            printError("mobileErr", "Please enter a valid 12 digit mobile number");
        } else {
            printError("mobileErr", "");
            mobileErr = false;
        }
    }

    if ((nameErr || descriptionErr || discountErr || locationErr || emailErr || mobileErr) === true) {
        return false;
    } else {
        var dataPreview = "You've entered the following details: \n" +
            "Shop Name: " + name + "\n" +
            "Shop Description: " + description + "\n" +
            "Discount: " + discount + "\n" +
            "Discount Start Date: " + discountStartDate + "\n" +
            "Discount End Date: " + discountEndDate + "\n" +
            "Shop Location: " + location + "\n" +
            "Email Address: " + email + "\n" +
            "Mobile Number: " + mobile + "\n";
        alert(dataPreview);
    }
}
