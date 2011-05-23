/*
Education-project: Java2D-Basics - lection 3

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


package grafics_3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseMotionListener
{
	ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
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
		
		// 2 Grafikobjekte als Shapes erzeugen und in Liste abspeichern
		shapeList.add( new Rectangle2D.Double(50, 50, 100, 120) );
		shapeList.add( new Rectangle2D.Double(110, 200, 120, 80) );
		
		this.addMouseMotionListener(this); // Einen Listener zufuegen, um Mausbewegungen zu erfassen
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g; // Erzeugen eines Graphics2D Grafikobjektes
		
		g2.setColor(Color.WHITE);		// Zeichnungsfarbe festlegen
		g2.fillRect(0, 0, getWidth(), getHeight()); // Bildschirmfuellendes  Rechteck zeichnen
		
		for(Shape s : shapeList)		// Liste der Shapes durchlaufen
		{
			g2.setColor(Color.BLUE);	// Zeichnungsfarbe festlegen
			g2.fill(s);					// Ausgefuellten Shape zeichnen
			
			g2.setColor(Color.BLACK);	// Zeichnungsfarbe festlegen
			g2.setStroke(new BasicStroke(4.0f));	// Linienstaerke festlegen
			g2.draw(s);					// Objektlinien zeichnen
		}	
	}

	/**
	 * Ueberprueft auf Kollision der Maus mit den Rechtecken
	 * @param xClicked
	 * @param yClicked
	 */
	private void testPosition(int xClicked, int yClicked)
	{
		Shape s = null;		// speichert ein Shape-Objekt
		
		double x, y, w, h;	// temp-Variablen fuer die Daten eines Rechtecks
		
		for(int i=0; i<shapeList.size(); i++)	// Schleife zum Durchlaufen aller Shape-Objekte
		{
			s = shapeList.get(i); // Zwischenspeichern des aktuellen Shapes
			
			// Speichern der Shape-Daten
			x = s.getBounds2D().getX();	// X-Position des Shapes
			y = s.getBounds2D().getY();	// Y-Position des Shapes
			w  = s.getBounds2D().getWidth();	// Breite des Shapes
			h  = s.getBounds2D().getHeight();	// Hoehe des Shapes
			
			if(s.contains(xClicked, yClicked))	// Auf Kollision abfragen und melden wenn erfolgreich
			{
				
				System.out.println("Objekt Nummer "+ i + "!");
						
				if(i==1) // Wenn erfolgreihe Kollision Objekt 2 betrifft, verschiebe es um 10 Pixel nach rechts
				{
					((Rectangle2D.Double)s).setRect(x + 10, y, w, h);	// Typ-Casting zu Rectangle2D und anschliessend 10 Pixel nach rechts verschieben
					
					repaint();	// Panel neu zeichnen
				}
			}	
		}
	}
	
	/**
	 * Aufruf, wenn eine Maustaste gedrueckt ist UND gleichzeitigt bewegt wird
	 */
	@Override
	public void mouseDragged(MouseEvent arg0)	
	{
		System.out.println("mouseDragged:" + arg0.getX() + " " +arg0.getY());
		
		testPosition(arg0.getX(), arg0.getY());	// Aufruf der Kollisionsabfrage
	}

	/**
	 * Aufruf, wenn die Maus bewegt wird OHNE das eine Maustaste gedrueckt ist
	 */
	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		System.out.println("mouseMoved: " + arg0.getX() + " " + arg0.getY());
		
		testPosition(arg0.getX(), arg0.getY());	// Aufruf der Kollisionsabfrage
	}
}
