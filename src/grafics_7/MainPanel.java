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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseMotionListener, MouseListener
{
	ArrayList<Shape> shapeList = null;
	
	RectangleMover rm = null;
	
	int clickedShape = -1;
	
	double dx, dy;
	
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
				
		ShapeBuilder sb = new ShapeBuilder();	// Shapebuilder-Objekt erzeugen
		
		shapeList = sb.buildShapes(50);			// 50 gelbe Rechtecke erzeugen lassen und an shapeList zurueckgeben 

		rm = new RectangleMover(shapeList, this);	// Initialisierung des Rectangle-Movers
		rm.start();									// Starten des Mover-Threads
		
		this.addMouseMotionListener(this); // Einen Listener zufuegen, um Mausbewegungen zu erfassen
		this.addMouseListener(this); // Einen Listener zufuegen, um Maustasten-Ereignisse zu erfassen
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g; // Erzeugen eines Graphics2D Grafikobjektes
		
		g2.setColor(Color.WHITE);		// Zeichnungsfarbe festlegen
		g2.fillRect(0, 0, getWidth(), getHeight()); // Bildschirmfuellendes  Rechteck zeichnen
		
		for(int i=0; i < shapeList.size(); i++)		// Liste der Shapes durchlaufen
		{
			g2.setColor((i==0) ?  Color.BLUE : Color.YELLOW);	// Zeichnungsfarbe festlegen: Wenn i=0 ist dann blau, ansonsten immer gelb
			g2.fill(shapeList.get(i));	// Ausgefuellten Shape zeichnen
			
			g2.setColor(Color.BLACK);	// Zeichnungsfarbe festlegen
			g2.draw(shapeList.get(i));	// Objektlinien zeichnen
		}	
	}

	/**
	 * Kollisionsabfrage, ob die Maus in eines der Rechtecke klickt.
	 * Speicherung der Listennummer des angeklickten Shapes.
	 * @param xClicked
	 * @param yClicked
	 */
	private void testPosition(int xClicked, int yClicked)
	{
		Shape s = null;		// speichert ein Shape-Objekt
		
		for(int i=0; i<shapeList.size(); i++)	// Schleife zum Durchlaufen aller Shape-Objekte
		{
			s = shapeList.get(i); // Zwischenspeichern des aktuellen Shapes

			if(s.contains(xClicked, yClicked))	// Auf Kollision abfragen und melden wenn erfolgreich
			{
				clickedShape = i;	// Speichern der Nummer des Shapes aus der Shape-Liste (shapeList) 
				System.out.println("Objekt Nummer "+ clickedShape + " erfasst!");
//				break;	// 'break' wird hier NICHT ausgefuehrt um sicher zu stellen, das das oberste Rechteck erfasst wird
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		System.out.println("mouseDragged: "+ arg0.getX() + " " +arg0.getY() + " clickedShape="+clickedShape);

		double w, h;
		
		if(clickedShape > -1)	// Sicher stellen, das ein Shape erfasst wurde
		{
			w = shapeList.get(clickedShape).getBounds2D().getWidth();	// Breite des Shapes
			h = shapeList.get(clickedShape).getBounds2D().getHeight();	// Hoehe des Shapes
			
			((Rectangle2D.Double)shapeList.get(clickedShape)).setRect(arg0.getX() - dx, arg0.getY() - dy, w, h);	// Typ-Casting zu Rectangle2D und anschliessend setzen der neuen Position des Rechtecks
	
			repaint();	// Panel neu zeichnen
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		System.out.println("mousePressed: (Taste gedrueckt)");
//		System.out.println("clickedShape="+this.clickedShape);

		testPosition(arg0.getX(), arg0.getY());	// Kollisionsabfrage aufrufen
		
		if(this.clickedShape > -1)	// Wenn ein Shape angeklickt ist, berechnen der Verscheinung durch den Klickpunktes in diesem Rechteck 
		{
			Shape s = shapeList.get(this.clickedShape);
			
			this.dx = arg0.getX() - s.getBounds2D().getX();	// x-Verschiebung berechnen
			this.dy = arg0.getY() - s.getBounds2D().getY();	// y-Verschiebung berechnen
		}
	}

	/**
	 * Zurueck-Setzen der clicked-ID 
	 */
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		clickedShape = -1;
		
//		System.out.println("mouseReleased: (Taste wieder losgelassen)");
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
//		System.out.println("mouseMoved: " + arg0.getX() + " " + arg0.getY());
//		testPosition(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
//		System.out.println("mouseClicked: (Druecken und loslassen)");
		
//		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
//		System.out.println("mouseEntered: (Das Objekt \"betreten\")");
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
//		System.out.println("mouseExited: (Verlassen des Objektes)");
	}

}
