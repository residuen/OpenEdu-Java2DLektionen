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

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	private MainPanel mp = new MainPanel();
	
	public MainFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.setLocation(100, 100);
		this.setTitle("Grafikprogrammierung mit Java - Lektion 2");
		
		this.add(mp);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new MainFrame();
	}

}
