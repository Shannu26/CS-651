/**
 * 
 */

 const formElement = document.getElementById("event-form")
 const eventNameElement = document.getElementById("name")
 const eventTimeElement = document.getElementById("time")
 const eventDateElement = document.getElementById("date")
 const eventLocationElement = document.getElementById("location")
 const eventDescriptionElement = document.getElementById("description")
 
 formElement.addEventListener("submit", event => {
	 event.preventDefault()
	 console.log(typeof eventDateElement.value)
	 console.log(eventDateElement.value)
	 const eventDate = new Date(eventDateElement.value + " " + eventTimeElement.value)
	 console.log(eventDate)
	 const currentDate = new Date()
	 console.log(currentDate)
	 console.log(eventDate - currentDate)
	 
	 if(eventNameElement.value == "") alert("Please specify the Event Name")
	 else if(eventDateElement.value == "") alert("Please select the Event Date")
	 else if(eventTimeElement.value == "") alert("Please select the Event Time")
	 else if(eventLocationElement.value == "") alert("Please specify the Event Location")
	 else if(eventDescriptionElement.value == "") alert("Please describe about the Event in a few words")
	 else{
		 const eventDate = new Date(eventDateElement.value + " " + eventTimeElement.value)
		 console.log(eventDate)
		 const currentDate = new Date()
		 console.log(currentDate)
		 eventNameElement.value = ""
		 eventDateElement.value = ""
		 eventTimeElement.value = ""
		 eventLocationElement.value = ""
		 eventDescriptionElement.value = ""
		 alert("Event has been successfully registered")
	 }
 })