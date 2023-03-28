/**
 *
 */

const formElement = document.getElementById("event-form");
const eventNameElement = document.getElementById("name");
const eventTimeElement = document.getElementById("time");
const eventDateElement = document.getElementById("date");
const eventLocationElement = document.getElementById("location");
const eventDescriptionElement = document.getElementById("description");
const eventAttendElements = document.getElementsByName("attending");
var eventAttendanceStatus = "";

formElement.addEventListener("submit", (event) => {
  event.preventDefault();
  for (var i = 0; i < eventAttendElements.length; i++) {
    if (eventAttendElements[i].checked) {
      eventAttendanceStatus = eventAttendElements[i].value;
    }
  }
  validateForm();
});

const validateForm = () => {
  if (eventNameElement.value == "") alert("Please specify the Event Name");
  else if (eventDateElement.value == "") alert("Please select the Event Date");
  else if (eventTimeElement.value == "") alert("Please select the Event Time");
  else if (eventLocationElement.value == "")
    alert("Please specify the Event Location");
  else if (eventDescriptionElement.value == "")
    alert("Please describe about the Event in a few words");
  else if (eventAttendanceStatus == "")
    alert("Please select whether you want to attend the event or not");
  else if (validateEventDateAndTime() < 0)
    alert(
      "Time and Date of the Event should be in Future Date and Time but not in Past"
    );
  else {
    eventNameElement.value = "";
    eventDateElement.value = "";
    eventTimeElement.value = "";
    eventLocationElement.value = "";
    eventDescriptionElement.value = "";
    for (var i = 0; i < eventAttendElements.length; i++) {
      eventAttendElements[i].checked = false;
    }
    alert("Event has been successfully registered");
  }
};

const validateEventDateAndTime = () => {
  const eventDate = new Date(
    eventDateElement.value + " " + eventTimeElement.value
  );
  const currentDate = new Date();
  return eventDate - currentDate;
};
