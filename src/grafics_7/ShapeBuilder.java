/*
Education-project: Java2D-Basics - lection 7

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

package grafics_7;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class ShapeBuilder
{
	public ShapeBuilder()
	{
		
	}
	
	/**
	 * Erzeugen und zurueckgeben von n (Anzahl) Rechtecken
	 * @param n
	 * @return
	 */
	public ArrayList<Shape> buildShapes(int n)
	{
		ArrayList<Shape> shapeList = new ArrayList<Shape>(); // Arraylist erzeugen
		
		Random rand = new Random(System.currentTimeMillis());	// Zufallszahlengenerator erzeugen
		int x, y, w, h;	// Variablen fuer x-y-Position, briete und hoehe deklarieren
		
		for(int i=0; i<n; i++)
		{
			// Erzeugen der Reckeckseigenschaften
			x = rand.nextInt(400);
			y = rand.nextInt(400);
			w = rand.nextInt(100);
			h = rand.nextInt(100);
			
			shapeList.add( new Rectangle2D.Double(x, y, w, h) ); // Recheckts-Shape in Array-Liste zufuegen
		}
		
		return shapeList;	// Shapes zurueckgeben
	}
}
