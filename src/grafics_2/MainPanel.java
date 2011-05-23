/*
Education-project: Java2D-Basics - lection 2

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

package grafics_2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class MainPanel extends JPanel
{
	ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
//	Rectangle2D.Double rechteck = null;
//	Rectangle2D.Double rechteck2 = null;
	
	public MainPanel()
	{
		
		initPanel();
	}
	
	/**
	 * Initialisierung der Paneleigenschaften
	 * und erzeugen von 2 Rechtecken
	 */
	private void initPanel()
	{
		this.setLayout(new GridLayout(1,1));	// Gridlayout festlegen
		
		// 2 Grafikobjekte als Shapes erzeugen
//		rechteck = new Rectangle2D.Double(50, 50, 100, 120);
//		rechteck2 = new Rectangle2D.Double(110, 200, 120, 80);
		
		// 2 Grafikobjekte als Shapes erzeugen und in Liste abspeichern
		shapeList.add( new Rectangle2D.Double(50, 50, 100, 120) );
		shapeList.add( new Rectangle2D.Double(110, 200, 120, 80) );
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		/**
		 * Zeichen von zwei Shape-Objekten, direkt ueber Objektvariablen
		 **/
//		g2.setColor(Color.BLUE);	// Setzen der Zeichenlinienfarbe
//		g2.fill(rechteck);			// Zeichnen des Shapes (Ausgefuellt)
//		g2.fill(rechteck2);			// Zeichnen des Shapes (Ausgefuellt)
//		
//		g2.setColor(Color.BLACK);	// Setzen der Zeichenlinienfarbe
//		g2.setStroke(new BasicStroke(4.0f));	// festlegen der Linienstaerke
//		g2.draw(rechteck);
//		g2.draw(rechteck2);
		
		/**
		 * Zeichen von zwei Shape-Objekten, aus einer Shape-Liste heraus
		 **/
		for(Shape s : shapeList)
		{
			g2.setColor(Color.BLUE);	// Setzen der Zeichenlinienfarbe
			g2.fill(s);					// Zeichnen des Shapes (Rahmen)
			
			g2.setColor(Color.BLACK);	// Setzen der Zeichenlinienfarbe
			g2.setStroke(new BasicStroke(4.0f));	// festlegen der Linienstaerke
			g2.draw(s);					// Zeichnen des Shapes (Rahmen)
		}
		
	}
}
