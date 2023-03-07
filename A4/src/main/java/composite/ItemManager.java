//Baischer, Johannes
//Krall, Daniel

package composite;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Class for managing items.
 * 
 */
 
public class ItemManager {
	private List root;

	public ItemManager() {
		root = null;
	}

	/**
	 * Reads the xml data from the input stream or throws an Exception if anything
	 * goes wrong (e.g., the xml code is invalid or some price attribute cannot be converted to type double).
	 * Items are assumed to have a unique name.
	 * The input stream is allowed to have empty lists.
	 * This is the only method where xml is handled in this assignment. No other method in this class should contain (or call)
	 * xml-specific code.
	 */
	public void readXml(InputStream xmlData) throws Exception{
		//some basic code to read an xml stream. 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlData);
		Element docRoot = doc.getDocumentElement();
		
		List rootList = new List(docRoot.getAttribute("name"));
		root = rootList;

		try{
			addXMLChildrenToList(rootList, docRoot.getChildNodes());
		}
		catch(Exception e){
			//proberbly parseExeption
			System.out.println("Exeption while parsing XML");
			throw e;
		}
		
	}

	/**
	 * Recursive methode for parsing XML structure into internal object tree
	 * @param list list to be added to
	 * @param children node to add to list
	 */
	private void addXMLChildrenToList(List list, NodeList nodes) throws Exception{
		for (int i = 0; i < nodes.getLength(); i++){
			Node n = nodes.item(i);

			if(n.getNodeType() == Node.ELEMENT_NODE){
				Element e = (Element) n;
				String name;
				Double price;
				int isbn;

				switch (e.getTagName()){
					case "list":
						name = e.getAttribute("name");

						List subList = new List(name);
						addXMLChildrenToList(subList, e.getChildNodes());		//recursive call to addXMLChildrenToList

						list.addItems(subList);
						break;

					case "book":
						name = e.getAttribute("name");
						price = Double.parseDouble(e.getAttribute("price"));
						isbn = Integer.parseInt(e.getAttribute("isbn"));

						list.addItems(new Book(name, price, isbn));
						break;

					case "cd":
						name = e.getAttribute("name");
						price = Double.parseDouble(e.getAttribute("price"));

						list.addItems(new CD(name, price));
						break;
	
					default:
						//xml node not supported
				}
			}
		}
	}

	/**
	 * Returns an {@code Optional} instance representing the price of the item (cd,
	 * book, or list) with the given name; the {@code Optional} is empty, if
	 * no such item exists
	 */
	public Optional<Double> getPrice(String item){
		Item[] result = getParentListAndItem(item);

		return result != null ? Optional.of(result[1].getPrice()) : Optional.empty();
	}

	/**
	 * removes the item with the given name, unless it's the root
	 * returns true if the operation succeeded (item found and removed)
	 * returns false if item is the root, or it is not found, or it cannot be removed due to some other error
	 */
	public boolean removeItem(String item) {
		Item[] result = getParentListAndItem(item);

		if(result == null || result[0] == null){
			//item not found or found item is root
			return false;
		}

		return result[0].getItems().remove(result[1]);
	}

	/**
	 * changes the price of the item with the given name; 
	 * returns false if item is not found or it is a list, or if the price is smaller than or equal to 0,
	 * returns false if the price could not be changed for any other reason;
	 * returns true if the price was changed successfully (i.e., the item had a different price before); 
	 */
	public boolean changePrice(String item, double price) {
		Item[] result = getParentListAndItem(item);

		if(result == null){
			//item not found or found item is root
			return false;
		}

		return result[1].setPrice(price);
	}

	/**
	 * Method for finding a element and its parent list in a BFS way
	 * @param name of the item to be searched
	 * @return Array with 0: ParentList & 1: item; or 0: null & 1: root if found item is root
	 */
	private Item[] getParentListAndItem(String name){
		Item[] result = new Item[2];
		Queue<List> listsToCheck = new LinkedList<List>();

		if(root.getName().equals(name)){
			//special case for root
			result[0] = null;
			result[1] = root;
			return result;
		}

		List parent = root;
		while(parent != null){
			for(Item i : parent.getItems()){
				if(i.name.equals(name)){
					result[0] = parent;
					result[1] = i;
					return result;
				}

				if(i.getItems().size() != 0){
					//only List can have children
					listsToCheck.add((List)i);
				}
			}

			//get next list to be checked
			parent = listsToCheck.poll();
		}
		
		return null; 	//item not found
	}
}