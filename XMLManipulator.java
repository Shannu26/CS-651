import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
 
  
public class XMLManipulator {
	
	public static void writeToXMLFile(ArrayList<HashMap<String, Object>> eventsData) {
		try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("Events");
	         doc.appendChild(rootElement);
	         
	         for(int i = 0;i < eventsData.size();i++) {
	        	 HashMap<String, Object> eventData = eventsData.get(i);
	        	 Element event = doc.createElement("Event");
	        	 rootElement.appendChild(event);
	        	 
	        	 Attr id = doc.createAttribute("id");
	        	 id.setValue(Integer.toString(i));
	        	 event.setAttributeNode(id);
	        	 
	        	 Element eventName = doc.createElement("event-name");
	        	 eventName.appendChild(doc.createTextNode((String) eventData.get("event-name")));
	        	 event.appendChild(eventName);
	        	 
	        	 Element eventCreator = doc.createElement("event-creator");
	        	 eventCreator.appendChild(doc.createTextNode((String) eventData.get("event-creator")));
	        	 event.appendChild(eventCreator);
	        	 
	        	 Element eventDate = doc.createElement("event-date");
	        	 eventDate.appendChild(doc.createTextNode((String) eventData.get("event-date")));
	        	 event.appendChild(eventDate);
	        	 
	        	 Element eventTime = doc.createElement("event-time");
	        	 eventTime.appendChild(doc.createTextNode((String) eventData.get("event-time")));
	        	 event.appendChild(eventTime);
	        	 
	        	 Element eventLocation = doc.createElement("event-location");
	        	 eventLocation.appendChild(doc.createTextNode((String) eventData.get("event-location")));
	        	 event.appendChild(eventLocation);
	        	 
	        	 Element eventDescription = doc.createElement("event-description");
	        	 eventDescription.appendChild(doc.createTextNode((String) eventData.get("event-description")));
	        	 event.appendChild(eventDescription);
	        	 
	        	 Element eventAttendCount = doc.createElement("event-attend-count");
	        	 eventAttendCount.appendChild(doc.createTextNode(Integer.toString((int) eventData.get("attend-count"))));
	        	 event.appendChild(eventAttendCount);
	        	 
	        	 Element eventNotAttendCount = doc.createElement("event-not-attend-count");
	        	 eventNotAttendCount.appendChild(doc.createTextNode(Integer.toString((int) eventData.get("not-attend-count"))));
	        	 event.appendChild(eventNotAttendCount);
	         }

	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("EventsData.xml"));
	         transformer.transform(source, result);
	         
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	public static void readFromXMLFile() {
		try   {  
			//creating a constructor of file class and parsing an XML file  
			File file = new File("EventData.xml");  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();    
			NodeList nodeList = doc.getElementsByTagName("Event");  
			// nodeList is not iterable, so we are using for loop  
			for (int i = 0; i < nodeList.getLength(); i++){  
					Node node = nodeList.item(i);  
					System.out.println("\n");  
					if ((node).getNodeType() == Node.ELEMENT_NODE){  
						Element element = (Element) node;  
						System.out.println("Event Name: "+ element.getElementsByTagName("event-name").item(0).getTextContent());  
						System.out.println("Event Creator: "+ element.getElementsByTagName("event-creator").item(0).getTextContent());
						System.out.println("Event Date: "+ element.getElementsByTagName("event-date").item(0).getTextContent());
						System.out.println("Event Time: "+ element.getElementsByTagName("event-time").item(0).getTextContent());
						System.out.println("Event Location: "+ element.getElementsByTagName("event-location").item(0).getTextContent());
						System.out.println("Event Description: "+ element.getElementsByTagName("event-description").item(0).getTextContent());
						System.out.println("Event Attend Count: "+ element.getElementsByTagName("event-attend-count").item(0).getTextContent());
						System.out.println("Event Not Attend Count: "+ element.getElementsByTagName("event-not-attend-count").item(0).getTextContent());    
					}  
			}  
		}   
		catch (Exception e){  
			e.printStackTrace();  
		}  
	}

	public static void main(String args[]){
		readFromXMLFile();
	}
}