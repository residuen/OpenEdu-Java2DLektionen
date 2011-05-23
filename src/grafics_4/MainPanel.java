/*
Education-project: Java2D-Basics - lection 4

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


package grafics_4;

import java.awt.BasicStroke;
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
		this.addMouseListener(this); // Einen Listener zufuegen, um Maustasten-Ereignisse zu erfassen
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

/* 	// Derzeit nicht benutzt
	private void testPosition(int xClicked, int yClicked)
	{
		...
	}
 */
	
	/**
	 * Wenn die Maus betaetigt wird, wird die Positon des 
	 * Mausklicks gespeichert und das 2. Rechteckt an diese
	 * Position versetzt.
	 */
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		System.out.println("mousePressed: (Taste gedrueckt bei ("+arg0.getX()+" "+arg0.getY()+")");
		
		double w = shapeList.get(1).getBounds2D().getWidth();	// Zwischenspeichern der Rechtecksbreite
		double h = shapeList.get(1).getBounds2D().getHeight();	//  Zwischenspeichern der Rechteckshoehe
		
		((Rectangle2D.Double)shapeList.get(1)).setRect(arg0.getX(), arg0.getY(), w, h);	// Festlegen der neuen Rechteck-Eigenschaften
		
		repaint();	// Panel neu zeichnen
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
//		System.out.println("mouseClicked: (Druecken und loslassen)");

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

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
//		System.out.println("mouseReleased: (Taste wieder losgelassen)");
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
//		System.out.println("mouseDragged:" + arg0.getX() + " " +arg0.getY());
//		testPosition(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
//		System.out.println("mouseMoved: " + arg0.getX() + " " + arg0.getY());
//		testPosition(arg0.getX(), arg0.getY());
	}


}
