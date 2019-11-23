/* ======================================
 * JFreeChart : a free Java chart library
 * ======================================
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 * Project Lead:  David Gilbert (david.gilbert@object-refinery.com);
 *
 * (C) Copyright 2000-2003, by Simba Management Limited and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * ----------------------
 * PieDatasetHandler.java
 * ----------------------
 * (C) Copyright 2003, by Simba Management Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Simba Management Limited);
 * Contributor(s):   -;
 *
 * $Id: PieDatasetHandler.java,v 1.1 2003/04/23 16:57:04 mungady Exp $
 *
 * Changes (from 21-Jun-2001)
 * --------------------------
 * 23-Jan-2003 : Version 1 (DG);
 *
 */

package org.jfree.data.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.jfree.data.PieDataset;
import org.jfree.data.DefaultPieDataset;

/**
 * A SAX handler for reading a {@link PieDataset} from an XML file.
 *
 * @author David Gilbert
 */
public class PieDatasetHandler extends RootHandler implements DatasetTags {

    /** The pie dataset under construction. */
    private DefaultPieDataset dataset;

    /**
     * Default constructor. 
     */
    public PieDatasetHandler() {
        this.dataset = null;
    }

    /**
     * Returns the dataset.
     * 
     * @return The dataset.
     */
    public PieDataset getDataset() {
        return this.dataset;
    }

    /**
     * Adds an item to the dataset under construction.
     * 
     * @param key  the key.
     * @param value  the value.
     */
    public void addItem(Comparable key, Number value) {
        this.dataset.setValue(key, value);
    }

    /**
     * Starts an element.
     * 
     * @param namespaceURI  the namespace.
     * @param localName  the element name.
     * @param qName  the element name.
     * @param atts  the element attributes.
     * 
     * @throws SAXException for errors.
     */
    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts) throws SAXException {

        DefaultHandler current = getCurrentHandler();
        if (current != this) {
            current.startElement(namespaceURI, localName, qName, atts);
        }
        else if (qName.equals(PIEDATASET_TAG)) {
            this.dataset = new DefaultPieDataset();
        }
        else if (qName.equals(ITEM_TAG)) {
            ItemHandler subhandler = new ItemHandler(this, this);
            getSubHandlers().push(subhandler);
            subhandler.startElement(namespaceURI, localName, qName, atts);
        }

    }

    /**
     * The end of an element.
     * 
     * @param namespaceURI  the namespace.
     * @param localName  the element name.
     * @param qName  the element name.
     * 
     * @throws SAXException for errors.
     */
    public void endElement(String namespaceURI,
                           String localName,
                           String qName) throws SAXException {

        DefaultHandler current = getCurrentHandler();
        if (current != this) {
            current.endElement(namespaceURI, localName, qName);
        }

    }

}