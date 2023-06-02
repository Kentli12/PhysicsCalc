import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicsCalculatorGUI {
    private JFrame frame;
    private JButton motionButton;
    private JButton exitButton;
    private JButton optionButton1;
    private JButton optionButton2;
//ADD BUTTONS HERE


    public PhysicsCalculatorGUI() {
        frame = new JFrame("Physics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
//change names of button on main screen or add more


        motionButton = new JButton("Motion");
        motionButton.addActionListener(new MotionButtonListener());
        frame.add(motionButton);

        optionButton1 = new JButton("Waves");
        optionButton1.addActionListener(new WavesButtonListener());
        frame.add(optionButton1);

        optionButton2 = new JButton("Electricity");
        optionButton2.addActionListener(new ElectricButtonListener());
        frame.add(optionButton2);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonListener());
        frame.add(exitButton);


        //change dimensions of box
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(new Dimension(screenSize.width, screenSize.height));


        frame.pack();
        frame.setVisible(true);
    }


    //MOTION
    private class MotionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.setLayout(new GridLayout(4, 2));

            JLabel titleLabel = new JLabel("Motion");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(titleLabel);

            JLabel choiceLabel = new JLabel("Select an option:");
            choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(choiceLabel);

            JButton velocityButton = new JButton("Calculate Velocity");
            velocityButton.addActionListener(new CalculateVelocityListener());
            frame.add(velocityButton);

            JButton timeButton = new JButton("Calculate Time");
            timeButton.addActionListener(new CalculateTimeListener());
            frame.add(timeButton);

            JButton distanceButton = new JButton("Calculate Distance");
            distanceButton.addActionListener(new CalculateDistanceListener());
            frame.add(distanceButton);

            JButton backButton = new JButton("Back");
            backButton.addActionListener(new BackButtonListener());
            frame.add(backButton);

            frame.revalidate();
            frame.repaint();
        }
    }


    // Velocity Calc implemented in Motion
    private class CalculateVelocityListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double distance = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter distance unit:"));
            double time = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter time unit:"));
            double velocity = PhysicsCalculator.calculateVelocity(distance, time);
            JOptionPane.showMessageDialog(frame, "Velocity = " + velocity + " units of distance per unit of time.");
        }
    }


    // Time Calc implemented in Motion
    private class CalculateTimeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double velocity = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter velocity unit:"));
            double distance = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter distance unit:"));
            double time = PhysicsCalculator.calculateTime(velocity, distance);
            JOptionPane.showMessageDialog(frame, "Time = " + time + " units long.");
        }
    }


    // Distance Calc implemented in Motion
    private class CalculateDistanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double velocity = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter velocity unit:"));
            double time = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter time unit:"));
            double distance = PhysicsCalculator.calculateDistance(velocity, time);
            JOptionPane.showMessageDialog(frame, "Distance = " + distance + " units of distance.");
        }
    }


    // Back Button
    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.setLayout(new FlowLayout());
            frame.add(motionButton);
            frame.add(optionButton1);
            frame.add(optionButton2);
            frame.add(exitButton);
            frame.revalidate();
            frame.repaint();
        }
    }


    //Construction button
    private class OptionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "This option is under construction.");
        }
    }


    //exits from main page
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


    // Frequency Calc implemented in Waves
    private class CalculateFrequencyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double period = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter period:"));

            double Frequency = PhysicsCalculator.calculateFrequency(period);
            JOptionPane.showMessageDialog(frame, "Frequency = " + Frequency + "Hz.");
        }
    }


    // Period Calc implemented in Waves
    private class CalculatePeriodListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double Frequency = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Frequency:"));

            double Period = PhysicsCalculator.calculatePeriod(Frequency);
            JOptionPane.showMessageDialog(frame, "Period = " + Period + "s.");
        }
    }


    // Wavelength Calc implemented in Waves
    private class CalculateWaveLengthListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double Frequency = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Frequency:"));
            double Velocity = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter velocity:"));

            double WaveLength = PhysicsCalculator.calculateWaveLength(Frequency,Velocity);
            JOptionPane.showMessageDialog(frame, "Wave Length = " + WaveLength + "unit of measurement.");
        }
    }


    // frequency with velocity
    private class CalculatefrequencyvelocityListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double WaveLength = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Wavelength:"));
            double Velocity = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter velocity:"));

            double Frequency = PhysicsCalculator.calculateFrequencyvelocity(WaveLength,Velocity);
            JOptionPane.showMessageDialog(frame, "Frequency With velocity = " + Frequency + "unit of measurement.");
        }
    }


    //Current calc
    private class currentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double potentialDiff = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Potential Difference:"));
            double resistance = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Resistance:"));

            double current = PhysicsCalculator.calculateCurrent(resistance,potentialDiff);
            JOptionPane.showMessageDialog(frame, "Current = " + current + " Amps");
        }
    }

    //Resistance calc
    private class resistanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double resistivity = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Resistivity:"));
            double length1 = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Length:"));
            double cSA = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Cross Sectional Area:"));

            double current = PhysicsCalculator.calculateResistance(resistivity,length1,cSA);
            JOptionPane.showMessageDialog(frame, "Current = " + current + " Amps");
        }
    }
    private class eFCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double esf = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Electrostatic Force:"));
            double charge = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Charge (In Coulombs):"));

            double efc = PhysicsCalculator.calculateEFS(esf,charge);
            JOptionPane.showMessageDialog(frame, "Electric Field Strength = " + efc + " V/M");
        }
    }

    //frequency options
    private class FrequencyoptionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.setLayout(new GridLayout(4, 2));

            JLabel titleLabel = new JLabel("Frequency options");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(titleLabel);

            JLabel choiceLabel = new JLabel("Select an option:");
            choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(choiceLabel);

            JButton velocityButton = new JButton("One with velocity");
            velocityButton.addActionListener(new CalculatefrequencyvelocityListener());
            frame.add(velocityButton);

            JButton timeButton = new JButton("Without Velocity");
            timeButton.addActionListener(new CalculateFrequencyListener());
            frame.add(timeButton);

            JButton backButton = new JButton("Back");
            backButton.addActionListener(new WavesButtonListener());
            frame.add(backButton);

            frame.revalidate();
            frame.repaint();
        }
    }


    // Waves
    private class WavesButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.setLayout(new GridLayout(4, 2));

            JLabel titleLabel = new JLabel("Waves");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(titleLabel);

            JLabel choiceLabel = new JLabel("Select an option:");
            choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(choiceLabel);

            JButton velocityButton = new JButton("Calculate Frequency");
            velocityButton.addActionListener(new FrequencyoptionListener());
            frame.add(velocityButton);

            JButton timeButton = new JButton("Calculate Period");
            timeButton.addActionListener(new CalculatePeriodListener());
            frame.add(timeButton);

            JButton distanceButton = new JButton("Calculate Wavelength");
            distanceButton.addActionListener(new CalculateWaveLengthListener());
            frame.add(distanceButton);

            JButton backButton = new JButton("Back");
            backButton.addActionListener(new BackButtonListener());
            frame.add(backButton);

            frame.revalidate();
            frame.repaint();
        }
    }

    // Electricity
    private class ElectricButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.setLayout(new GridLayout(4, 2));

            JLabel titleLabel = new JLabel("Electricity");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(titleLabel);

            JLabel choiceLabel = new JLabel("Select an option:");
            choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(choiceLabel);

            JButton velocityButton = new JButton("Calculate Current");
            velocityButton.addActionListener(new currentListener());
            frame.add(velocityButton);

            JButton timeButton = new JButton("Calculate Resistance");
            timeButton.addActionListener(new resistanceListener());
            frame.add(timeButton);

            JButton distanceButton = new JButton("Calculate Electric Field Strength");
            distanceButton.addActionListener(new eFCListener());
            frame.add(distanceButton);

            JButton backButton = new JButton("Back");
            backButton.addActionListener(new BackButtonListener());
            frame.add(backButton);

            frame.revalidate();
            frame.repaint();
        }
    }



    // Internal runner-don't change in case if we get rid of normal non-GUI
    public void showGUI() {
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PhysicsCalculatorGUI gui = new PhysicsCalculatorGUI();
                gui.showGUI();
            }
        });
    }
}






