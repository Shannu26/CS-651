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
	         Element rootElement = doc.createElement("events");
	         doc.appendChild(rootElement);
	         
	         for(int i = 0;i < eventsData.size();i++) {
	        	 HashMap<String, Object> eventData = eventsData.get(i);
	        	 Element event = doc.createElement("event");
	        	 rootElement.appendChild(event);
	        	 
	        	 Element eventIndex = doc.createElement("event-index");
	        	 eventIndex.appendChild(doc.createTextNode((String) eventData.get("event-index")));
	        	 event.appendChild(eventIndex);
	        	 
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
	        	 eventAttendCount.appendChild(doc.createTextNode((String) eventData.get("attend-count")));
	        	 event.appendChild(eventAttendCount);
	        	 
	        	 Element eventNotAttendCount = doc.createElement("event-not-attend-count");
	        	 eventNotAttendCount.appendChild(doc.createTextNode((String) eventData.get("not-attend-count")));
	        	 event.appendChild(eventNotAttendCount);
	         }

	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("Data.xml"));
	         transformer.transform(source, result);
	         
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	public static ArrayList<HashMap<String, Object>> readFromXMLFile() {
		try   {  
			ArrayList<HashMap<String, Object>> eventsData = new ArrayList<HashMap<String, Object>>();
			
			//creating a constructor of file class and parsing an XML file  
			File file = new File("Data.xml");  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();    
			NodeList nodeList = doc.getElementsByTagName("event");  
			// nodeList is not iterable, so we are using for loop  
			for (int i = 0; i < nodeList.getLength(); i++){  
					HashMap<String, Object> eventData = new HashMap<String, Object>();
					Node node = nodeList.item(i);  
					System.out.println("\n");  
					if ((node).getNodeType() == Node.ELEMENT_NODE){  
						Element element = (Element) node;  
						
						eventData.put("event-index", element.getElementsByTagName("event-index").item(0).getTextContent());
						eventData.put("event-name", element.getElementsByTagName("event-name").item(0).getTextContent());
						eventData.put("event-creator", element.getElementsByTagName("event-creator").item(0).getTextContent());
						eventData.put("event-date", element.getElementsByTagName("event-date").item(0).getTextContent());
						eventData.put("event-time", element.getElementsByTagName("event-time").item(0).getTextContent());
						eventData.put("event-location", element.getElementsByTagName("event-location").item(0).getTextContent());
						eventData.put("event-description", element.getElementsByTagName("event-description").item(0).getTextContent());
						eventData.put("attend-count", element.getElementsByTagName("event-attend-count").item(0).getTextContent());
						eventData.put("not-attend-count", element.getElementsByTagName("event-not-attend-count").item(0).getTextContent());
					}  
					eventsData.add(eventData);
			}  
			return eventsData;
		}   
		catch (Exception e){  
			e.printStackTrace(); 
			return null;
		}  
	}
}