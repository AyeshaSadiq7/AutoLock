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
 * ----------------------------
 * ContourToolTipGenerator.java
 * ----------------------------
 * (C) Copyright 2002, 2003, by David M. O'Donnell and Contributors.
 *
 * Original Author:  David M. O'Donnell;
 * Contributor(s):   David Gilbert (for Simba Management Limited);
 *
 * $Id: ContourToolTipGenerator.java,v 1.1 2003/04/23 23:03:48 mungady Exp $
 *
 * Changes
 * -------
 * 23-Jan-2003 : Added standard header (DG);
 *
 */
 
package org.jfree.chart.tooltips;

import org.jfree.data.ContourDataset;

/**
 * Interface for a tooltip generator for plots that use data from a {@link ContourDataset}.
 * 
 * @author David M. O'Donnell
 */
public interface ContourToolTipGenerator extends ToolTipGenerator {

    /**
     * Generates a tooltip text item for a particular item within a series.
     * 
     * @param data  the dataset.
     * @param item  the item index (zero-based).
     * 
     * @return The tooltip text.
     */
    public String generateToolTip(ContourDataset data, int item);
    
}
