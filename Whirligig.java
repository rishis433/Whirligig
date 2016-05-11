/*
 * Whirligig.java
 *
 * Copyright 2016  <>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.event.*;
public class Whirligig extends JFrame { //extends jframe
    private Image image;
    public static void main (String args[]) {
        Whirligig c = new Whirligig(); //instantiate pajamas
    }
    
    public Whirligig() { //constructor method
        super("Dangers of sharing food!"); //title
        setSize(1500, 1000); //size
        setLocation(0, 0); //location
        setResizable(false); //allow for resizability
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //allows jframe to close program when closed
        try {
		    File pathToFile = new File("image.gif");
		    image = ImageIO.read(pathToFile);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		setIconImage(image);
        Holder p = new Holder(); //panel
        setContentPane(p); //adds to container
        setVisible(true); //sets the frame visible
    } //close constructor
} //close class
class Holder extends JPanel implements ChangeListener{ //pan is the jpanel
    private JTextArea p5TextArea2;
    private JTextArea p5TextArea1;
    private JTextArea p5TextArea3;
    private JTextField dangers;
    private JTextArea directions;
    private JSlider peopleSharing, amountSharing;
    private String[] funFacts = {"You are likely to spill when you 'waterfall'.", "People are likely to have not washed their hands, and may touch food after.", "People, when they are in a rush, often don't act in a hygenic manner with food.", "Food tends to get bacterialized very easily.", "Even cooked food cam be infested with bacteria very easily.", "Tiny traces of bacteria that get into your food can be noxious and harmful", "Especially at home, people tend to not wash their hands before food consumption", "Bacteria reproduces even within the food, possibly infesting the food really fast after the food\nis intoxicated with bacteria", "When one dips in a shared sauce, one often forgets they double dipped", "Dust tends to often get on people's hands, and can affect them sharing food.", "Using a shared set of chips, and not individual packets often creates a large mess in the\nbag/bowl of chips", "Drinking from the same cap outside of a family can result in contact with unfamiliar bacteria"};
    private int funFactsIndex = 0;
    private int peopleShared = 3;
    private int amountShared = 3;
    private int energy;
    private int protein;
    private int oxygen;
    private int efficiency;
    private int muscle;
    private int strength;
    private int stress;
    private int sickness;
    private int chipsBacterialization;
    private int sodaBacterialization;
    private Panel1 p1;
    private Panel2 p2;
    private Panel3 p3;
    private Panel4 p4;
    private Panel5 p5;
    private TopHolder th;
    private BottomHolder bh;
   
    private JButton displayGraphicsSoda;
    private JButton displayGraphicsChips;
    private JButton startOver;
    
    private JLabel peopleSharingLabel;
    private JLabel amountSharingLabel;
    
    private boolean lifeDone;
    private boolean displaySodaCircle;
    private boolean displayChips;
    private JButton shareChips;
    private JButton shareSoda;
    private JButton doubleDip;
    private JButton useSameUtensils;
    private JButton waterFall;
    private JButton noUseTongs;
    private JButton notShare;
    
    public Holder() { //constructor
        setLayout(new GridLayout(2, 1, 0, 0));
        th = new TopHolder();
        bh = new BottomHolder();
        add(th);
        add(bh);
    }
    
    public void stateChanged(ChangeEvent e) {
        
    }
    
    class Panel1 extends JPanel{
        //private AdjustButtonHandler abh;
        public Panel1() {
            setLayout(new GridLayout(6, 1, 5, 5));
            dangers = new JTextField("DANGERS OF SHARING FOOD/DRINK!", 30);
            dangers.setEditable(false);
            dangers.setBackground(Color.RED);
            dangers.setForeground(Color.ORANGE);
            add(dangers);
            directions = new JTextArea("Directions: Ever Planning to share food? Adjust the sliders below and the buttons to the side to find out how sharing food can be bad\nfor you. Wait till all of the necessary bars or all of the harmful bars are at zero or maximum to see what happens. To see a bacterial\nrepresentation of your food, use the buttons near the images below. For fun facts and more, please see the bottom-right area.");
            directions.setEditable(false);
            directions.setBackground(Color.CYAN);
            add(directions);
            peopleSharingLabel = new JLabel("Amount of people you want to share with");
            add(peopleSharingLabel);
            peopleSharing = new JSlider(1, 5);
            peopleSharing.setBackground(Color.PINK);
            peopleSharing.setForeground(Color.RED);
            peopleSharing.setPaintTicks(true);
            peopleSharing.setPaintLabels(true);
            peopleSharing.setMajorTickSpacing(1);
            add(peopleSharing);
            amountSharingLabel = new JLabel("How much food/drink are you planning to share?");
            add(amountSharingLabel);
            amountSharing = new JSlider(1, 5);
            amountSharing.setPaintTicks(true);
            amountSharing.setMajorTickSpacing(1);
            amountSharing.setPaintLabels(true);
            amountSharing.setBackground(Color.BLUE);
            amountSharing.setForeground(Color.ORANGE);
            add(amountSharing);
        }
        
    }
    
    class Panel2 extends JPanel implements ActionListener {
        public Panel2() {
            setLayout(new GridLayout(7, 1, 10, 15));
            setBackground(Color.GREEN);
            shareChips = new JButton("Share Chips");
            shareChips.setBackground(Color.YELLOW);
            add(shareChips);
            shareChips.addActionListener(this);
            shareSoda = new JButton("Share Soda from same opening");
            shareSoda.setBackground(Color.ORANGE);
            add(shareSoda);
            shareSoda.addActionListener(this);
            doubleDip = new JButton("Double dip using the same sauce");
            doubleDip.setForeground(Color.WHITE);
            add(doubleDip);
            doubleDip.setBackground(Color.RED);
            doubleDip.addActionListener(this);
            useSameUtensils = new JButton("Use same utensils previously used by someone else without washing");
            add(useSameUtensils);
            useSameUtensils.setBackground(Color.GRAY);
            useSameUtensils.addActionListener(this);
            waterFall = new JButton("Waterfall soda");
            waterFall.setBackground(Color.CYAN);
            add(waterFall);
            waterFall.addActionListener(this);
            noUseTongs = new JButton("Use hands and not tongs/clean utensils for eating chips");
            noUseTongs.addActionListener(this);
            noUseTongs.setBackground(Color.PINK);
            add(noUseTongs);
            notShare = new JButton("Do not share the food at all");
            notShare.addActionListener(this);
            notShare.setBackground(Color.WHITE);
            add(notShare);
            //don't share food button
        }
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if(command.equalsIgnoreCase("Share Chips") && lifeDone == false){
                energy+=1*amountShared - peopleShared;
                protein-=2*amountShared - peopleShared;
                strength-=peopleShared - (int)(0.5*amountShared);
                oxygen-=2;
                efficiency-=10;
                muscle-=15;
                stress+=2*peopleShared + (amountShared/2);
                sickness+=3*((peopleShared + amountShared)/2);
                chipsBacterialization+=3*peopleShared;
                p3.repaint();
            }
            else if (command.equalsIgnoreCase("Share Soda from same opening") && lifeDone == false){
                energy+=(-3*amountShared) - peopleShared;
                protein-=4*amountShared - peopleShared;
                strength-=peopleShared + (int)(2*amountShared);
                oxygen-=2*peopleShared;
                efficiency-=5*amountShared;
                muscle-= 6*peopleShared;
                stress+= 2*peopleShared + (amountShared*3);
                sickness+=4*((peopleShared + amountShared));
                sodaBacterialization+= peopleShared + amountShared;
                p3.repaint();
            }
            
            else if (command.equalsIgnoreCase("Use same utensils previously used by someone else without washing") && lifeDone == false) {
                energy-=1*amountShared+(int)(0.7*peopleShared);
                protein -=4*amountShared + peopleShared;
                strength-=(int)(2.5*peopleShared) + (int)(1.5*amountShared);
                oxygen -= 2*amountShared + peopleShared*(peopleShared-1);
                efficiency -= (int)(0.5*amountShared) + peopleShared*(peopleShared-1);
                muscle -= 3 + amountShared;
                sickness += 20 + peopleShared;
                stress += 15 + peopleShared + amountShared*2;
                chipsBacterialization += 2*peopleShared;
                sodaBacterialization+= 2*peopleShared + amountShared;
                p3.repaint();
            }
            
            else if (command.equalsIgnoreCase("Double dip using the same sauce") && lifeDone == false) {
                energy -= 3 *peopleShared + amountShared;
                protein -= 2*amountShared + (int)(0.5*peopleShared);
                strength -=4*peopleShared;
                oxygen -=5;
                efficiency -= 7;
                muscle -= 2*peopleShared;
                sickness += 2*amountShared + peopleShared;
                stress += (int)(peopleShared*1.5) + amountShared;
                chipsBacterialization+=2*amountShared + peopleShared - 2;
                p3.repaint();
            }
            
            else if (command.equalsIgnoreCase("Waterfall soda") && lifeDone == false) {
                strength -= 3 *peopleShared + amountShared;
                protein -= 7;
                energy -=4*peopleShared;
                muscle -=5;
                efficiency -= 2*amountShared + (int)(0.5*peopleShared);
                oxygen -= 2*peopleShared;
                stress += 2*amountShared + peopleShared;
                sickness += (int)(peopleShared*1.5) + amountShared;
                sodaBacterialization+=peopleShared + 2*amountShared - 2;               
                p3.repaint();
            }
            
            else if (command.equalsIgnoreCase("Use hands and not tongs/clean utensils for eating chips") && lifeDone == false) {
                strength -= 2*(amountShared + peopleShared);
                energy -= 10 + peopleShared + amountShared*2;
                protein-=10 + amountShared;
                muscle-= amountShared;
                efficiency-= 3*(peopleShared + amountShared) - 3;
                oxygen-= 2 + amountShared + (0.8*peopleShared);
                stress+=peopleShared + 2*amountShared;
                sickness+= (int)(2.5*amountShared) - 1;
                chipsBacterialization+=amountShared + 2*peopleShared + 3;
                p3.repaint();
            }
            
            else if (command.equalsIgnoreCase("Do not share the food at all") && lifeDone == false) {
                strength += 10*(int)(Math.random()*6);
                energy += 10*(int)(Math.random()*5);
                protein += 10*(int)(Math.random()*4);
                muscle += 10*(int)(Math.random()*4);
                efficiency += 12*(int)(Math.random()*3);
                oxygen += 10 + (int)(Math.random()*10);
                stress -= 10*(int)(Math.random()*3);
                sickness -= 8*(int)(Math.random()*4);
                chipsBacterialization -= (int)(Math.random()*2)*peopleShared + 3;
                sodaBacterialization -= (int)(Math.random() *peopleShared) + amountShared;
                p3.repaint();
            }
            p4.repaint();
            addFunFact();
        }
    }
    
    class TopHolder extends JPanel {
        
        public TopHolder() {
            setLayout(new GridLayout(1, 2, 0, 0));
            p1 = new Panel1();
            add(p1);
            p2 = new Panel2();
            add(p2);
        }
        
    }
    
    class BottomHolder extends JPanel {
        
        public BottomHolder() {
            setLayout(new GridLayout(1, 3, 0, 0));
            p3 = new Panel3();
            p4 = new Panel4();
            p5 = new Panel5();
            add(p3);
            add(p4);
            add(p5);
        }
    
    }
    
    class Panel3 extends JPanel implements ActionListener{
        Font font;
        
          public Panel3() {
              setLayout(new FlowLayout());
            setBackground(Color.PINK);
            startOver=new JButton("Start Over");
            add(startOver);
            startOver.addActionListener(this);
            energy = 150;
            oxygen = 150;
            strength = 150;
            muscle = 150;
            efficiency = 150;
            protein = 150;
            stress = 75;
            sickness = 75;
        }
        
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
              
           if((energy < 0 && protein < 0 && oxygen < 0 && efficiency < 0 && muscle < 0 && strength < 0) || (stress > 300 && sickness > 300)) {
               g.drawString("You have died from sharing too much chips and soda!", 20, 200);
               g.drawString("Press the start over button to reincarnate.", 20, 220);
               lifeDone = true;
           }
           else if ((energy > 300 && protein > 300 && oxygen > 300 && efficiency > 300 && muscle > 300 && strength >300) || (stress < 0 && sickness < 0)) {
               g.drawString("You have lived a very successful life, but one day, you run into death by an accident.", 20, 200);
               g.drawString("Press the start over button to reincarnate.", 20, 220);
               lifeDone = true;
           }
           else {     
                g.drawString("Health Bars Here", 200, 70);
                 
                g.drawString("Energy", 30, 100);
                g.drawString("Protein", 30, 130);
                g.drawString("Oxygen", 30, 160);
                g.drawString("Efficiency", 30, 190);
                g.drawString("Muscle", 30, 220);
                g.drawString("Strength", 30, 250);
                g.drawString("Stress", 30, 280);
                g.drawString("Sickness", 30, 310);
                
                g.drawRect(100,90,300,15);
                g.drawRect(100,120,300,15);
                g.drawRect(100,150,300,15);
                g.drawRect(100,180,300,15);
                g.drawRect(100,210,300,15);
                g.drawRect(100,240,300,15);
                g.drawRect(100,270,300,15);
                g.drawRect(100,300,300,15);
                
                g.setColor(Color.RED);
                
                p5TextArea2.setText("Warnings:");
                p5TextArea3.setText("Full/empty bars:");
                
                if (energy >= 0 && energy <= 300) {
                    g.fillRect(100,90,energy,15);
                    if (energy <15) {
                        p5TextArea2.setText("Warnings:\nEnergy is almost out.");
                    }
                }
                else if (energy < 0) {
                    g.fillRect(100,90,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nEnergy bar is empty.");
                }
                else if (energy >= 300) {
                    g.fillRect(100,90,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nEnergy bar is full (a good thing).");
                }
                
                if (protein >= 0 && protein <= 300) {
                    g.fillRect(100,120,protein,15);
                    if(protein < 15) {
                        p5TextArea2.setText(p5TextArea2.getText() + "\nProtein is almost out.");
                    }
                }
                else if (protein < 0) {
                    g.fillRect(100,120,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nProtein bar is empty.");
                }
                else if (protein >= 300) {
                    g.fillRect(100,120,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nProtein bar is full (a good thing).");
                }
                
                if (oxygen >= 0 && oxygen <= 300) {
                    g.fillRect(100,150,oxygen,15);
                    if(oxygen < 15) {
                        p5TextArea2.setText(p5TextArea2.getText() + "\nOxygen is almost out.");
                    }
                }
                else if (oxygen < 0) {
                    g.fillRect(100,150,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nOxygen bar is empty");
                }
                else if (oxygen >= 300) {
                    g.fillRect(100,150,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nOxygen bar is full (a good thing).");
                }
                
                if (efficiency >= 0 && efficiency <= 300) {
                    g.fillRect(100,180,efficiency,15);
                    if(efficiency < 15) {
                        p5TextArea2.setText(p5TextArea2.getText() + "\nEfficiency is almost out.");
                    }
                }
                else if (efficiency < 0) {
                    g.fillRect(100,180,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nEfficiency bar is empty");
                }
                else if (efficiency >= 300) {
                    g.fillRect(100,180,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nEfficiency bar is full (a good thing).");
                }
                
                if (muscle >= 0 && muscle <= 300) {
                    g.fillRect(100,210,muscle,15);
                    if(muscle < 15) {
                        p5TextArea2.setText(p5TextArea2.getText() + "\nMuscle is almost out.");
                    }
                }
                else if (muscle < 0) {
                    g.fillRect(100,210,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nMuscle bar is empty");
                }
                else if (muscle >= 300) {
                    g.fillRect(100,210,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nMuscle bar is full (a good thing).");
                }
                
                if (strength >= 0 && strength <= 300) {
                    g.fillRect(100,240,strength,15);
                    if(strength < 15) {
                        p5TextArea2.setText(p5TextArea2.getText() + "\nStrength is almost out.");
                    }
                }
                else if (strength < 0) {
                    g.fillRect(100,240,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nStrength bar is empty");
                }
                else if (strength >= 300) {
                    g.fillRect(100,240,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nStrength bar is full (a good thing).");
                }
                
                if (stress >= 0 && stress <= 300) {
                    g.fillRect(100,270,stress,15);
                    if(stress > 285)
                        p5TextArea2.setText(p5TextArea2.getText() + "\nYou're nearly entirely stressed.");
                }
                else if (stress < 0) {
                    g.fillRect(100,270,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nStress bar is empty (a good thing).");
                }
                else if (stress > 300) {
                    g.fillRect(100,270,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nYou're stressed maximally.");
                }
                
                if (sickness >= 0 && sickness <= 300) {
                    g.fillRect(100,300,sickness,15);
                    if (sickness >= 285)
                        p5TextArea2.setText(p5TextArea2.getText() + "\nYou're nearly entirely sick.");
                }
                else if (sickness < 0) {
                    g.fillRect(100,300,0,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nSickness bar is empty (a good thing).");
                }
                else if (sickness > 300) {
                    g.fillRect(100,300,300,15);
                    p5TextArea3.setText(p5TextArea3.getText() + "\nYou're sick maximally.");
                }
                
        }
  }
        
  public void actionPerformed(ActionEvent e) {
    
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Start over")) {
            energy = 150;
            oxygen = 150;
            strength = 150;
            muscle = 150;
            efficiency = 150;
            protein = 150;
            stress = 75;
            sickness = 75;
            lifeDone = false;
            chipsBacterialization = 0;
            sodaBacterialization = 0;
            repaint();
        }
        p4.repaint();
        addFunFact();
  }           
}
    
    class Panel5 extends JPanel {
        public Panel5()
        {
            setLayout(new GridLayout(3, 1, 0, 0));
            setBackground(Color.YELLOW);
            
            p5TextArea1 = new JTextArea("Fun Facts:\n" + funFacts[funFacts.length-1]);
            p5TextArea1.setForeground(Color.YELLOW);
            p5TextArea2 = new JTextArea("Warnings: ");
            p5TextArea3 = new JTextArea ("Full/empty bars:");
            
            p5TextArea1.setEditable(false);
            p5TextArea2.setEditable(false);
            
            p5TextArea1.setBackground(Color.BLUE);
            p5TextArea2.setBackground(Color.GREEN);
            p5TextArea3.setBackground(Color.YELLOW);
            
            
            add(p5TextArea1);
            add(p5TextArea2);
            add(p5TextArea3);
        }
        
        
    }
    
    class Panel4 extends JPanel implements ActionListener
    {
        public Panel4()
        {
            setBackground(Color.CYAN);
            setLayout(new FlowLayout());
            displayGraphicsSoda = new JButton("Display or turn off soda bacteria concentration");
            displayGraphicsSoda.addActionListener(this);
            add(displayGraphicsSoda);
            displayGraphicsChips = new JButton("Display or turn off chips bacteria concentration");
            displayGraphicsChips.addActionListener(this);
            add(displayGraphicsChips);
            displaySodaCircle = true;
            displayChips = true;
        }
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (displaySodaCircle) {
                g.setColor(Color.PINK);
                g.fillOval(75, 100, 100, 100);
                g.setColor(new Color (120, 120, 100));
                int x;
                int y;
                if(sodaBacterialization > 0) {
                x = 70;
                y = 150;
             for(int i=0;i<6;i++) {
                x+=15;
                g.fillOval(x, y, 10, 10);
              
              }
          }
          if(sodaBacterialization > 10) {
              x = 90;
              y = 150;
              for(int w=0;w<2;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
             
             }
            }
            if(sodaBacterialization > 20) {
            x = 100;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(sodaBacterialization > 30) {
            x = 110;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
           }
           if(sodaBacterialization > 40) {
            x = 120;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(sodaBacterialization > 50) {
            x = 100;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(sodaBacterialization > 60) {
             x = 130;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(sodaBacterialization > 70) {
             x = 140;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
           }
           if(sodaBacterialization > 80) {
             x = 150;
            y = 150;
            for(int w=0;w<2;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
           }
           if(sodaBacterialization > 90) {
            x = 100;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(sodaBacterialization > 100) {
            x = 110;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(sodaBacterialization > 110) {
             x = 120;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(sodaBacterialization > 120) {
             x = 130;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(sodaBacterialization > 130) {
             x = 140;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
            }
            if(sodaBacterialization > 150) {
             x = 150;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
            }
        }
            g.setColor(Color.ORANGE);
            g.fillRect(100, 200, 50, 200);
            g.setColor(Color.BLACK);
            g.drawString("Soda",110, 250);
        }
        
        if (displayChips) {
            g.setColor(Color.GREEN);
                g.fillOval(275, 100, 100, 100);
                g.setColor(new Color(120, 120, 100));
                int x;
                int y;
                if(chipsBacterialization > 0) {
                x = 270;
                y = 150;
                for(int i=0;i<6;i++) {
                x+=15;
                g.fillOval(x, y, 10, 10);
              
              }
              
              x = 290;
              y = 150;
              for(int w=0;w<2;w++) {
                y-=15;
                g.fillOval(x, y, 10, 10);
             
             }
         }
         if(chipsBacterialization > 20) {
            x = 300;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 30) {
            x = 310;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 40) {
            x = 320;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 50) {
            x = 300;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 60) {
             x = 330;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 70) {
             x = 340;
            y = 150;
            for(int w=0;w<3;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 80) {
             x = 350;
            y = 150;
            for(int w=0;w<2;w++) {
              y-=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 90) {
            x = 300;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
            }
        }
        if(chipsBacterialization > 100) {
            x = 310;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(chipsBacterialization > 110) {
             x = 320;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(chipsBacterialization > 120) {
            x = 330;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(chipsBacterialization > 135) {
             x = 340;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
             }
         }
         if(chipsBacterialization > 150) {
            x = 350;
            y = 150;
            for(int w=0;w<2;w++) {
              y+=15;
              g.fillOval(x, y, 10, 10);
            }
        }
            g.setColor(Color.YELLOW);
            g.fillRect(300, 200, 50, 200);
            g.setColor(Color.RED);
            g.drawString("Chips",310, 250);
        }
    }
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equalsIgnoreCase("Display or turn off soda bacteria concentration")) {
                if (displaySodaCircle) {
                    displaySodaCircle = false;
                }
                else {
                    displaySodaCircle = true;
                }
            }
            if(command.equalsIgnoreCase("Display or turn off chips bacteria concentration")) {
                if (displayChips) {
                    displayChips = false;
                }
                else {
                    displayChips = true;
                }
            }
            //else if (command.equalsIgnoreCase("Display or turn off food concentration"))
            repaint();
            addFunFact();
        }
    }
    
    public void addFunFact() {
        p5TextArea1.setText("Fun facts:\n" + funFacts[funFactsIndex]);
        if (funFactsIndex < funFacts.length-1)
            funFactsIndex+=1;
        else
            funFactsIndex = 0;
    }
    
}
