/*
Education-project: Java2D-Basics - lection 8

Copyright (C) 2011 Karsten Bettray

This program is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License
as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with this library;
if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110, USA
or look at <http://www.gnu.org/licenses/>.
*/

package grafics_8;

import java.awt.Component;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class RectangleMover extends Thread
{
	private ArrayList<Shape> shapeList = null;
	
	private Component mainPanel = null;
	
	private Shape temp = null;

	/**
	 * Uebergeben der Referenzen auf Shape-Liste und das Darstellungs-Panel
	 * @param shapeList
	 * @param mainPanel
	 */
	public RectangleMover(ArrayList<Shape> shapeList, Component mainPanel)
	{
		this.shapeList = shapeList;
		this.mainPanel = mainPanel;
		
		temp = shapeList.get(0);
	}
	
	/**
	 * Id des zu bewegenden Shapes setzen
	 * @param shapeId
	 */
	public void setShapeId(int shapeId)
	{
		temp = shapeList.get(shapeId);
	}

	/**
	 * Verschieben des 1. Rechtecks in positive x- und y-Richtung im 50ms Takt
	 */
	public void run()
	{
		double x, y, w, h;
		
		while(true)	// Endlos-Schleife
		{
			// Ermitteln der aktuellen Rechtecks-Eigenschaften (Position, Breite und Hoehe)
			x = temp.getBounds2D().getX();
			y = temp.getBounds2D().getY();
			w = temp.getBounds2D().getWidth();
			h = temp.getBounds2D().getHeight();
			
			// Wenn Rechteck recht aus dem Bild rausgelaufen ist, die x-Koordinaten zuruecksetzen
			if(x > mainPanel.getWidth())
				x = -w;
			
			// Wenn Rechteck unten aus dem Bild rausgelaufen ist, die y-Koordinaten zuruecksetzen
			if(y > mainPanel.getHeight())
				y = -h;
			
			((Rectangle2D.Double)temp).setRect(x+1, y+1, w, h);		// Typ-Casting zu Rectangle2D und anschliessend setzen der neuen Position des Rechtecks
			
			try
			{
				mainPanel.repaint();	// Panel neu zeichnen
				
				Thread.sleep(25);		// Pause von 50ms einlegen
			}
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
