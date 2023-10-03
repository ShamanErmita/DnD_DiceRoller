import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollingDiceGUI extends JFrame {
    public RollingDiceGUI(){
        super("DnD Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        pack();
        setResizable(true);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    private void addGUIComponents() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        // Credit text
        JLabel text = new JLabel();
        text.setText("Made with ❤ by Bruno Duarte");
        text.setForeground(Color.white);
        text.setFont(new Font("Roboto", Font.PLAIN, 16));
        text.setBounds(700,700,300,300);

        //Assign Images
        Image exitImage = new ImageIcon(this.getClass().getResource("resources/button_exit.png")).getImage();
        Image d4Image = new ImageIcon(this.getClass().getResource("resources/button_d4.png")).getImage();
        Image d6Image = new ImageIcon(this.getClass().getResource("resources/button_d6.png")).getImage();
        Image d8Image = new ImageIcon(this.getClass().getResource("resources/button_d8.png")).getImage();
        Image d10Image = new ImageIcon(this.getClass().getResource("resources/button_d10.png")).getImage();
        Image d12Image = new ImageIcon(this.getClass().getResource("resources/button_d12.png")).getImage();
        Image d20Image = new ImageIcon(this.getClass().getResource("resources/button_d20.png")).getImage();

        //Exit Button
        JButton quitButton = new JButton();
        quitButton.addActionListener((event) -> System.exit(0));
        quitButton.setText("Exit");

        quitButton.setIcon(new ImageIcon(exitImage));
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.setBorderPainted(false);
        quitButton.setBounds(1450,815,100,50);

        //Dices
        JLabel diceOneImg = ImageService.loadImage("resources/dnd.png");
        diceOneImg.setBounds(700,100,200,200);
        jPanel.add(diceOneImg);

        //Background
        JLabel backgroundImg = ImageService.loadImage("resources/background.jpg");
        backgroundImg.setBounds(0,0,1750,1100);
        jPanel.add(backgroundImg);

        Random random = new Random();

        //Create all Buttons
        JButton roll_d4 = new JButton("Roll D4");
        roll_d4.setBounds(150,400,200,100);
        roll_d4.setIcon(new ImageIcon(d4Image));
        roll_d4.setContentAreaFilled(false);
        roll_d4.setFocusPainted(false);
        roll_d4.setBorderPainted(false);

        JButton roll_d6 = new JButton("Roll D6");
        roll_d6.setBounds(350,400,200,100);
        roll_d6.setIcon(new ImageIcon(d6Image));
        roll_d6.setContentAreaFilled(false);
        roll_d6.setFocusPainted(false);
        roll_d6.setBorderPainted(false);

        JButton roll_d8 = new JButton("Roll D8");
        roll_d8.setBounds(550,400,200,100);
        roll_d8.setIcon(new ImageIcon(d8Image));
        roll_d8.setContentAreaFilled(false);
        roll_d8.setFocusPainted(false);
        roll_d8.setBorderPainted(false);

        JButton roll_d10 = new JButton("Roll D10");
        roll_d10.setBounds(750,400,200,100);
        roll_d10.setIcon(new ImageIcon(d10Image));
        roll_d10.setContentAreaFilled(false);
        roll_d10.setFocusPainted(false);
        roll_d10.setBorderPainted(false);

        JButton roll_d12 = new JButton("Roll D12");
        roll_d12.setBounds(950,400,200,100);
        roll_d12.setIcon(new ImageIcon(d12Image));
        roll_d12.setContentAreaFilled(false);
        roll_d12.setFocusPainted(false);
        roll_d12.setBorderPainted(false);

        JButton roll_d20 = new JButton("Roll D20");
        roll_d20.setBounds(1150,400,200,100);
        roll_d20.setIcon(new ImageIcon(d20Image));
        roll_d20.setContentAreaFilled(false);
        roll_d20.setFocusPainted(false);
        roll_d20.setBorderPainted(false);

        //Roll Dice4
        roll_d4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOffButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);

                //roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime-startTime)/1000F < 3){
                                //roll the dice
                                int dice = random.nextInt(1,5);

                                //update dice images
                                ImageService.updateImage(diceOneImg,"resources/dice4_" + dice + ".png");

                                repaint();
                                revalidate();

                                //sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                            }

                            TurnOnButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);
                        }catch (InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });

        //Roll Dice6
        roll_d6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOffButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);

                //roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime-startTime)/1000F < 3){
                                //roll the dice
                                int dice = random.nextInt(1,7);

                                //update dice images
                                ImageService.updateImage(diceOneImg,"resources/dice6_" + dice + ".png");

                                repaint();
                                revalidate();

                                //sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                            }

                            TurnOnButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);
                        }catch (InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });

        //Roll Dice8
        roll_d8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOffButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);

                //roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime-startTime)/1000F < 3){
                                //roll the dice
                                int dice = random.nextInt(1,9);

                                //update dice images
                                ImageService.updateImage(diceOneImg,"resources/dice8_" + dice + ".png");

                                repaint();
                                revalidate();

                                //sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                            }

                            TurnOnButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);
                        }catch (InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });

        //Roll Dice10
        roll_d10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOffButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);

                //roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime-startTime)/1000F < 3){
                                //roll the dice
                                int dice = random.nextInt(0,10);

                                //update dice images
                                ImageService.updateImage(diceOneImg,"resources/dice10_" + dice + ".png");

                                repaint();
                                revalidate();

                                //sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                            }

                            TurnOnButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);
                        }catch (InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });

        //Roll Dice12
        roll_d12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOffButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);

                //roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime-startTime)/1000F < 3){
                                //roll the dice
                                int dice = random.nextInt(1,13);

                                //update dice images
                                ImageService.updateImage(diceOneImg,"resources/dice12_" + dice + ".png");

                                repaint();
                                revalidate();

                                //sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                            }

                            TurnOnButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);
                        }catch (InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });

        //Roll Dice20
        roll_d20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOffButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);

                //roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime-startTime)/1000F < 3){
                                //roll the dice
                                int dice = random.nextInt(1,21);

                                //update dice images
                                ImageService.updateImage(diceOneImg,"resources/dice20_" + dice + ".png");

                                repaint();
                                revalidate();

                                //sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                            }

                            TurnOnButtons(roll_d4,roll_d6,roll_d8,roll_d10,roll_d12,roll_d20);
                        }catch (InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });

        backgroundImg.add(roll_d4);
        backgroundImg.add(roll_d6);
        backgroundImg.add(roll_d8);
        backgroundImg.add(roll_d10);
        backgroundImg.add(roll_d12);
        backgroundImg.add(roll_d20);
        backgroundImg.add(text);
        backgroundImg.add(quitButton);

        this.getContentPane().add(jPanel);
    }

    private void TurnOnButtons(JButton roll_d4,JButton roll_d6,JButton roll_d8,JButton roll_d10,JButton roll_d12,JButton roll_d20){
        roll_d4.setEnabled(true);
        roll_d6.setEnabled(true);
        roll_d8.setEnabled(true);
        roll_d10.setEnabled(true);
        roll_d12.setEnabled(true);
        roll_d20.setEnabled(true);
    }
    private void TurnOffButtons(JButton roll_d4,JButton roll_d6,JButton roll_d8,JButton roll_d10,JButton roll_d12,JButton roll_d20){
        roll_d4.setEnabled(false);
        roll_d6.setEnabled(false);
        roll_d8.setEnabled(false);
        roll_d10.setEnabled(false);
        roll_d12.setEnabled(false);
        roll_d20.setEnabled(false);
    }
}
