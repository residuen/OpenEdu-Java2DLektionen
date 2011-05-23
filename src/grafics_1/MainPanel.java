/*
Education-project: Java2D-Basics - lection 1

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

package grafics_1;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class MainPanel extends JPanel
{
	public MainPanel()
	{
		
		initPanel();
	}
	
	/**
	 * Initialisierung der Paneleigenschaften
	 */
	private void initPanel()
	{
		this.setLayout(new GridLayout(1,1));	// Gridlayout festlegen
	}
	
	public void paint(Graphics g)
	{
		g.drawLine(0, 0, getWidth(), getHeight());	// Zeichen einer Linie: Oben-links nach unten-rechts
		g.drawLine(0, getHeight(), getWidth(), 0);	// Zeichen einer Linie: Unten-links nach oben-rechts
		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());		// Zeichen einer Linie: Vertikal durch das Rechteckszentrum
		g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);	// Zeichen einer Linie: Horizontal durch das Rechteckzentrum
		
	}
}
