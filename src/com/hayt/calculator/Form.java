package com.hayt.calculator;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Author: Haytham Teng
 * Date: 13-12-1
 * Time: 09:39
 * Email: hevlhayt@foxmail.com
 */
public class Form {
    private JPanel Calculator;
    private JTextField screen;
    private JButton sqrtButton;
    private JButton decButton;
    private JButton sinButton;
    private JPanel input;
    private JButton sixButton;
    private JButton threeButton;
    private JButton equalButton;
    private JButton binButton;
    private JButton hexButton;
    private JButton nineButton;
    private JButton cosButton;
    private JButton sevenButton;
    private JButton fourButton;
    private JButton oneButton;
    private JButton tanButton;
    private JButton powerButton;
    private JButton dotButton;
    private JButton eightButton;
    private JButton fiveButton;
    private JButton twoButton;
    private JButton zeroButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton cButton;
    private JButton mButton;
    private JButton lnButton;
    private JButton octButton;
    private JPanel output;
    private JTextField symbol;
    //private JMenuBar menu;

    private int caltype = 0;
    private double a = 0;
    private double b = 0;
    private double m = 0;
    private StringBuilder sb = new StringBuilder();

    public Form() {

        screen.setBorder(null);
        symbol.setBorder(null);

        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("0");
                screen.setText(sb.toString());
            }
        });
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("1");
                screen.setText(sb.toString());
            }
        });
        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("2");
                screen.setText(sb.toString());
            }
        });
        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("3");
                screen.setText(sb.toString());
            }
        });
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("4");
                screen.setText(sb.toString());
            }
        });
        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("5");
                screen.setText(sb.toString());
            }
        });
        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("6");
                screen.setText(sb.toString());
            }
        });
        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("7");
                screen.setText(sb.toString());
            }
        });
        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("8");
                screen.setText(sb.toString());
            }
        });
        nineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append("9");
                screen.setText(sb.toString());
            }
        });
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                sb.append(".");
                screen.setText(sb.toString());
            }
        });
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = s2n(sb);
                clear();
                switch (caltype) {
                    case 0:
                        break;
                    case 1:
                        m = a + b;
                        setScreen(m);
                        caltype = 0;
                        break;
                    case 2:
                        m = a - b;
                        setScreen(m);
                        caltype = 0;
                        break;
                    case 3:
                        m = a * b;
                        setScreen(m);
                        caltype = 0;
                        break;
                    case 4:
                        if (b == 0) {
                            screen.setText("ERROR");
                            caltype = 0;
                        }
                        else {
                            m = a / b;
                            setScreen(m);
                            caltype = 0;
                        }
                        break;
                    case 5:
                        m = a;
                        for (int i = 1; i < b; i++) {
                            m = m * a;
                        }
                        setScreen(m);
                        caltype = 0;
                        break;
                }
                setScreen("=");
            }
        });
        mButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sb.append(m);
                setScreen(m);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = s2n(sb);
                clear();
                caltype = 1;
                setScreen("+");
            }
        });
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = s2n(sb);
                clear();
                caltype = 2;
                setScreen("-");
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = s2n(sb);
                clear();
                caltype = 3;
                setScreen("*");
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = s2n(sb);
                clear();
                caltype = 4;
                setScreen("÷");
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
                setScreen(0);
                setScreen("");
            }
        });
        sqrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                if (a < 0) screen.setText("ERROR");
                else {
                    clear();
                    m = Math.sqrt(a);
                    setScreen(m);
                    setScreen("sqrt");
                }
            }
        });
        powerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = s2n(sb);
                clear();
                caltype = 5;
                setScreen("pow");
            }
        });
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                m = Math.sin(a);
                setScreen(m);
                setScreen("sin");
            }
        });
        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                m = Math.cos(a);
                setScreen(m);
                setScreen("cos");
            }
        });
        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                m = Math.tan(a);
                setScreen(m);
                setScreen("tan");
            }
        });
        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                if (a < 0) screen.setText("ERROR");
                else {
                    m = Math.log(a);
                    setScreen(m);
                    setScreen("ln");
                }
            }
        });
        binButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                m = a;
                screen.setText(Integer.toBinaryString((int) m));
                setScreen("bin");
            }
        });
        octButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                m = a;
                screen.setText(Integer.toOctalString((int) m));
                setScreen("oct");
            }
        });
        hexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                a = s2n(sb);
                clear();
                m = a;
                screen.setText(Integer.toHexString((int) m));
                setScreen("hex");
            }
        });
        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caltype == 0) setScreen("");
                setScreen(m);
                setScreen("dec");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private double s2n(StringBuilder sb) {
        if (sb.length() != 0) return Double.parseDouble(sb.toString());
        else return m;
    }

    private void setScreen(double i) {
        if (String.valueOf(i).length() > 10) {
            String t = String.valueOf(i).substring(0,9)+"...";
            screen.setText(t);
        }
        else
            screen.setText(String.valueOf(i));
    }
    private void setScreen(String c) {
        symbol.setText(c);
    }

    private void clear() {
        sb.delete(0, sb.length());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator by HevLfreis");

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setContentPane(new Form().Calculator);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(size.width/2-frame.getWidth()/2, size.height/2-frame.getHeight()/2);
        frame.setResizable(false);

//        JMenuBar jb = new JMenuBar();
//        jb.setBorderPainted(false);
//        //jb.setLayout(new FlowLayout());
//        jb.add(new JMenu("File"));
//        jb.add(new JMenu("Edit"));
//        frame.setJMenuBar(jb);
    }

}
